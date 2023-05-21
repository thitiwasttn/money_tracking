//package com.thitiwas.money_tracking.core.exception;
////
////import lombok.Getter;
////import lombok.Setter;
////import org.springframework.http.HttpStatus;
////
////@Setter
////@Getter
////public class CustomErrorException extends RuntimeException {
////    private String errorCode;
////    private HttpStatus httpStatus;
////    private String topicMessage;
////    private String detailMessage;
////    private String msgType;
////
////
////    public CustomErrorException() {
////        super();
////    }
////
////    public CustomErrorException(String message, String code, HttpStatus httpStatus) {
////        super(message);
////        this.errorCode = code;
////        this.httpStatus = httpStatus;
////    }
////
////    public CustomErrorException(String message) {
////        super(message);
////    }
////
////    public CustomErrorException(String message, Throwable cause) {
////        super(message, cause);
////    }
////
////    public CustomErrorException(Throwable cause) {
////        super(cause);
////    }
////
////    protected CustomErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
////        super(message, cause, enableSuppression, writableStackTrace);
////    }
////}
