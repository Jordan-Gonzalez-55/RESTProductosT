package com.ibm.academia.restapi.productos.exepciones.handler;


import com.ibm.academia.restapi.productos.exepciones.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RESTProductosException {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<?> noExisteExcepcion(NotFoundException exception){
        Map<String, Object> respuesta = new HashMap<String, Object>();
        respuesta.put("error", exception.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);



    }
}
