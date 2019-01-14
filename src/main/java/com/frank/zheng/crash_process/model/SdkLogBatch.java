package com.frank.zheng.crash_process.model;

import java.util.ArrayList;
import java.util.List;

public class SdkLogBatch {
    private int batch_id;
    private String device_guid;
    private List<SdkLogPayloadItem> payload = new ArrayList<>();


    public int getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public String getDevice_guid() {
        return device_guid;
    }

    public void setDevice_guid(String device_guid) {
        this.device_guid = device_guid;
    }

    public List<SdkLogPayloadItem> getPayload() {
        return payload;
    }

    public void setPayload(List<SdkLogPayloadItem> payload) {
        this.payload = payload;
    }
}
