package com.ise.RestTemplateSample;

public class RestTemplateResponse {
    String result;
    String httpStatus;

    @Override
    public String toString() {
        return "RestTemplateResponse{" +
                "result='" + result + '\'' +
                ", httpStatus='" + httpStatus + '\'' +
                '}';
    }
}
