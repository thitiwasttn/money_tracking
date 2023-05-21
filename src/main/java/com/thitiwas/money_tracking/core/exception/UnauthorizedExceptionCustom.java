package com.thitiwas.money_tracking.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UnauthorizedExceptionCustom extends RuntimeException {
    private String msg;
}
