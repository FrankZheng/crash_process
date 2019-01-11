package com.frank.zheng.crash_process.model;

public class SdkLogItem {
    private String device_timestamp;
    private String log_level;
    private String context;
    private String log_message;
    private String event_id;
    private String sdk_user_agent;
    private String bundle_id;
    private String time_zone;
    private String device_guid;

    public String getDevice_timestamp() {
        return device_timestamp;
    }

    public void setDevice_timestamp(String device_timestamp) {
        this.device_timestamp = device_timestamp;
    }

    public String getLog_level() {
        return log_level;
    }

    public void setLog_level(String log_level) {
        this.log_level = log_level;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getLog_message() {
        return log_message;
    }

    public void setLog_message(String log_message) {
        this.log_message = log_message;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getSdk_user_agent() {
        return sdk_user_agent;
    }

    public void setSdk_user_agent(String sdk_user_agent) {
        this.sdk_user_agent = sdk_user_agent;
    }

    public String getBundle_id() {
        return bundle_id;
    }

    public void setBundle_id(String bundle_id) {
        this.bundle_id = bundle_id;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public String getDevice_guid() {
        return device_guid;
    }

    public void setDevice_guid(String device_guid) {
        this.device_guid = device_guid;
    }
}
