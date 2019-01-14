package com.frank.zheng.crash_process.service;

import com.frank.zheng.crash_process.model.SdkLogItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SdkLogsKafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(SdkLogsKafkaConsumer.class);


    @KafkaListener(topics = "${kafka.topic.sdkLogs}", containerFactory = "sdkLogItemKafkaListenerContainerFactory")
    public void sdkLogItemListener(SdkLogItem logItem) {
        log.debug("got a sdk log item: " + logItem);
    }
}
