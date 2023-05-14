package com.rapigrow.main.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseDTO<T> {
    @Nullable
    private T data;
    @Nullable
    private Object error;
    @NonNull
    private String message;

}
