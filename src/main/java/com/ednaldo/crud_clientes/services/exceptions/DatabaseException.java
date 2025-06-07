package com.ednaldo.crud_clientes.services.exceptions;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String mgs) {
        super(mgs);
    }
}
