package com.hjhan.aws_practice.demo;

import com.hjhan.aws_practice.common.DuplicateException;
import com.hjhan.aws_practice.common.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DemoServiceImpl implements DemoService {

    private final DemoRepository demoRepository;

    @Override
    public List<DemoResponse> getAllDemos() {
        return demoRepository.findAll()
                .stream().map(DemoResponse::from)
                .toList();
    }

    @Override
    public DemoResponse getDemo(Long id) {
        return demoRepository.findById(id)
                .map(DemoResponse::from)
                .orElseThrow(() -> new NotFoundException("Demo with ID %d not found.".formatted(id)));
    }

    @Override
    public DemoResponse createDemo(DemoCreateRequest request) {
        if (demoRepository.existsDemoByDemoCode(request.getDemoCode()))
            throw new DuplicateException("Demo code '%s' already exists.".formatted(request.getDemoCode()));
        return DemoResponse.from(demoRepository.save(Demo.create(request)));
    }

    @Override
    public DemoResponse updateDemo(Long id, DemoUpdateRequest request) {
        Demo demo = demoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Demo with ID %d not found.".formatted(id)));

        demo.update(request.getName(), request.getDescription());

        return DemoResponse.from(demo);
    }
}
