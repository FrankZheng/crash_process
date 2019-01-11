package com.frank.zheng.crash_process.controller;


import com.frank.zheng.crash_process.model.SdkLogItem;
import com.frank.zheng.crash_process.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SdkLogPublisherController {

    @Autowired
    private KafkaService kafkaService;

    @RequestMapping(value = "publish",
            method = RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json")
    public String publish(@RequestBody SdkLogItem logItem) {
        //publish to kafka
        kafkaService.publishSdkLog(logItem);
        return "OK";
    }

}
