package test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Collection;
import java.util.List;

public class TopicManagerSingleton {

    private static final TopicManager instance = new TopicManager();


    private TopicManagerSingleton() {

    }


    public static TopicManager get() {
        return instance;
    }


    public static class TopicManager {
        private final Map<String, Topic> topicsMap = new ConcurrentHashMap<>();


        private TopicManager() {

        }


        public Topic getTopic(String topicName)
        {

            Topic existingTopic = topicsMap.get(topicName);
            if (existingTopic != null) {
                return existingTopic;
            }


            Topic newTopic = new Topic(topicName);
            topicsMap.put(topicName,newTopic);
                return newTopic;

        }


        public Collection<Topic> getTopics() {
            return topicsMap.values();
        }


        public void clear() {
            topicsMap.clear();
        }
    }
}
