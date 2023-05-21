package com.thitiwas.money_tracking.core.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class CustomErrorExceptionV2 extends RuntimeException {
    private HttpStatus httpStatus;
    private Object objectValue;
    private String code;
    private String status;

    public CustomErrorExceptionV2(HttpStatus httpStatus, Object objectValue, String code, String status) {
        super(objectValue.toString());
        this.httpStatus = httpStatus;
        this.objectValue = objectValue;
        this.code = code;
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomErrorExceptionV2{" +
                "httpStatus=" + httpStatus +
                ", objectValue=" + objectValue +
                ", code='" + code + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
