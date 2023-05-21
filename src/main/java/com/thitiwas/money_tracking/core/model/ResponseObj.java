package com.thitiwas.money_tracking.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObj<T> {
    private String status;
    private String code;
    private T objectValue;
}
