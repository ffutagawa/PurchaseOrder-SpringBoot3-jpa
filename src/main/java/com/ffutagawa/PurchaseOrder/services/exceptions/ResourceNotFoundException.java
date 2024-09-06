package com.ffutagawa.PurchaseOrder.services.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException (Object id){
        super("Resource not Found. ID " + id);
    }

}
