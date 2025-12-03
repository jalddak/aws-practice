package com.hjhan.aws_practice.demo;

import java.util.List;

public interface DemoService {

    List<DemoResponse> getAllDemos();

    DemoResponse getDemo(Long id);

    DemoResponse createDemo(DemoCreateRequest request);

    DemoResponse updateDemo(Long id, DemoUpdateRequest request);

}
