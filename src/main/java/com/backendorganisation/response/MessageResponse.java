package com.backendorganisation.response;

import java.io.Serializable;

public class MessageResponse implements Serializable {
        private boolean success;
    private String message;
    private String detail;


    public MessageResponse(boolean success, String message, String detail) {
        super();
        this.success = success;
        this.message = message;
        this.detail = detail;
    }


    public MessageResponse() {
        super();
    }


    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
}
