package com.ednaldo.crud_clientes.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {

    List<FieldName> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldName> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldName(fieldName, message));
    }
}
