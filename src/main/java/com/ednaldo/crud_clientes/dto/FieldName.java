package com.ednaldo.crud_clientes.dto;

public class FieldName {

    private String fieldName;
    private String message;

    public FieldName(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
