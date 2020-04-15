package com.goalabs.courseweb.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @RequestMapping("/topics")
    public List<Topic> getTopic(){
        return Arrays.asList(new Topic("spring","Spring Framework","Spring  tutorials"));
    }
}
