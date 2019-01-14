package com.frank.zheng.crash_process.controller;


import com.frank.zheng.crash_process.model.Response;
import com.frank.zheng.crash_process.model.SdkLogBatch;
import com.frank.zheng.crash_process.model.SdkLogItem;
import com.frank.zheng.crash_process.model.SdkLogPayloadItem;
import com.frank.zheng.crash_process.service.KafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SdkLogPublisherController {

    private static final Logger logger = LoggerFactory.getLogger(SdkLogPublisherController.class);

    private static final String AA_SDK_LOG_TYPE = "sdk-hbs-logs";

    @Autowired
    private KafkaService kafkaService;

    @RequestMapping(value = "publish",
            method = RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json")
    public Response publish(@RequestBody SdkLogBatch logBatch) {
        //publish to kafka
        //kafkaService.publishSdkLog(logItem);
        List<SdkLogPayloadItem> payload = logBatch.getPayload();
        List<SdkLogItem> logItems = new ArrayList<>(payload.size());
        for (SdkLogPayloadItem payloadItem : payload) {
            SdkLogItem logItem = payloadItem.getMetadata();
            logItem.setBatch_id(logBatch.getBatch_id());
            logItem.setType(AA_SDK_LOG_TYPE); //for advanced auction sdk
            logItems.add(logItem);
        }

        for (SdkLogItem logItem : logItems) {
            kafkaService.publishSdkLog(logItem);
        }

        return Response.success();
    }

}
