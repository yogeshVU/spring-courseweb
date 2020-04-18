package com.goalabs.courseweb.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    Logger logger = LoggerFactory.getLogger(TopicController.class);

    final
    TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
//        return Arrays.asList(new Topic("spring","Spring Framework","Spring  tutorials"));
        return topicService.getTopics();
    }


    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        logger.info("Request for topic id"+ id);
        return topicService.getTopic(id);

    }

    @RequestMapping(method = RequestMethod.POST,value = "/topics")
    public void addTopic(@RequestBody Topic topic){
        logger.info("adding a topic...");
        topicService.addTopic(topic);
    }
}
