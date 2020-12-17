package com.softserve.itacademy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ApplicationExceptionHandler {

    //create, update
    @ExceptionHandler(NullEntityReferenceException.class)
    public ModelAndView handlerNullEntityReferenceException(Exception exception) {
        ModelAndView modelAndView = new ModelAndView("500", HttpStatus.INTERNAL_SERVER_ERROR);
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }

    //find, delete
    @ExceptionHandler(EntityNotFoundException.class)
    public ModelAndView handlerEntityNotFoundException(Exception exception) {
        ModelAndView modelAndView = new ModelAndView("404", HttpStatus.NOT_FOUND);
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }
}
