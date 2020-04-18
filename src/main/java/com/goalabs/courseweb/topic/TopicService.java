package com.goalabs.courseweb.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class TopicService {
    Logger logger = LoggerFactory.getLogger(TopicService.class);
    private List<Topic> topics;


    public TopicService(){
        logger.info("Started the Topic Service....");
        this.topics = new ArrayList<Topic>();

        for (int i = 0; i < 4; i++) {
            this.topics.add(new Topic("Java-"+Integer.toString(i),"Java course-"+Integer.toString(i), "Description of course "+Integer.toString(i) ));
        }

        for (int i = 0; i < 4; i++) {
            this.topics.add(new Topic("Spring-"+Integer.toString(i),"Javascript course-"+Integer.toString(i), "Description of course "+Integer.toString(i) ));
        }
        for (int i = 0; i < 4; i++) {
            this.topics.add(new Topic("JavaScript-"+Integer.toString(i),"Javascript course-"+Integer.toString(i), "Description of course "+Integer.toString(i) ));
        }
    }


    public List<Topic> getTopics() {
        return topics;
    }

    public Topic getTopic(String id){
        return this.topics.stream().filter(a -> a.getId().equals(id)).findFirst().get();

    }

    public void addTopic(Topic topic){
        this.topics.add(topic);
    }
//    public void setTopics(List<Topic> topics) {
//        this.topics = topics;
//    }
}
