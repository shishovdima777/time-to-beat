package com.timetobeat.timetobeat.util;

import java.util.Map;

public class RegistrationNotPerformedResponse {
    private Map<String, String> message;
    private long timestamp;

    public RegistrationNotPerformedResponse(Map<String, String> message, long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public Map<String, String> getMessage() {
        return message;
    }

    public void setMessage(Map<String, String> message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
