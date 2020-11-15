package fr.polytech.iwa.covid_alert.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic topicCovidAlert() {
        return TopicBuilder.name("topic_covid_alert")
                //.config(TopicConfig.RETENTION_MS_CONFIG, "150000") //periode retention msg en ms
                .build();
    }
}
