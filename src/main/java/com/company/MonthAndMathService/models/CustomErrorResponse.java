package com.company.MonthAndMathService.models;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomErrorResponse {

    String errorMessage;
    int status;
    String errorCode;

    public CustomErrorResponse() {
    }

    public CustomErrorResponse(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
