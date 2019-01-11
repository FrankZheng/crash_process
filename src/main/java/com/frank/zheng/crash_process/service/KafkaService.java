package com.frank.zheng.crash_process.service;

import com.frank.zheng.crash_process.model.SdkLogItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaService.class);
    private static final String TOPIC_SDK_LOGS = "sdk_logs";

    @Autowired
    private KafkaTemplate<String, SdkLogItem> kafkaTemplateForRequestLog;

    public void publishSdkLog(@NonNull SdkLogItem logItem) {
        try {
            //Seems the kafka library will create threads for sending
            //So here won't throw exceptions immediately
            kafkaTemplateForRequestLog.send(TOPIC_SDK_LOGS, logItem);
        } catch (Exception e) {
            logger.error("Failed to send the request log to kafka, ", e);
        }
    }
}
