package com.hjhan.aws_practice.demo;

import com.hjhan.aws_practice.common.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/demos")
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping
    public Result<List<DemoResponse>> getAllDemos() {
        List<DemoResponse> allDemos = demoService.getAllDemos();
        return new Result<>(allDemos.size(), allDemos);
    }

    @GetMapping("/{id}")
    public DemoResponse getDemo(@PathVariable Long id) {
        return demoService.getDemo(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public DemoResponse createDemo(@RequestBody @Valid DemoCreateRequest request) {
        return demoService.createDemo(request);
    }

    @PutMapping("/{id}")
    public DemoResponse updateDemo(@PathVariable Long id, @RequestBody @Valid DemoUpdateRequest request) {
        return demoService.updateDemo(id, request);
    }


}
