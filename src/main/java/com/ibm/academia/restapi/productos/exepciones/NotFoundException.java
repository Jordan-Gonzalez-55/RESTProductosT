package com.ibm.academia.restapi.productos.exepciones;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }

    private static final long serialVersionUID = -8896119241444542351L;
}
