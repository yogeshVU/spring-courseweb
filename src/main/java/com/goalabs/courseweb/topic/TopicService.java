package com.goalabs.courseweb.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

    public void updateTopic(String id, Topic topic)
    {
        topics.stream().filter(t -> t.getId().equals(id)).forEach(a -> {
            a.setId(topic.getId());
            a.setDescription(topic.getDescription());
            a.setName(topic.getName());
        });
    }


    public void deleteTopic(String id)
    {
        topics.removeIf(a->a.getId().equals(id));
    }
//    public void setTopics(List<Topic> topics) {
//        this.topics = topics;
//    }

//    public static void main(String[] args){
//
//        TopicService ts  = new TopicService();
////        ts.topics.stream().forEach(a -> a.setId("test"));
//
//        ts.topics.stream().filter(a -> a.getId().equals("Java-0")).forEach(a -> {System.out.println("Setting.....");a.setId("NEW TEDT"); a.setName("New Name"); a.setDescription("Test Description");});
//
//        ts.topics.stream().forEach(a -> System.out.println(a.getId()));
//    }
}
