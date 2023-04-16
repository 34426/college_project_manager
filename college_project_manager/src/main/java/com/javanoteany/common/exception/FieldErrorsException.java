package com.javanoteany.common.exception;

import org.springframework.validation.FieldError;

import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class FieldErrorsException extends RuntimeException {
    private List<FieldError> fieldErrors;

    public FieldErrorsException(String msg, List<FieldError> fieldErrors) {
        super(msg);
        this.fieldErrors = fieldErrors;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
