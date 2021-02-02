package org.msdemt.simple.exception_handler.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

public interface BaseController {
    @ExceptionHandler({NullPointerException.class, RuntimeException.class})
    default String handleException(Exception e) {
        return e.getMessage();
    }
}
