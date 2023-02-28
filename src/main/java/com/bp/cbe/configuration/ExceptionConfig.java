package com.bp.cbe.configuration;

import com.bp.cbe.domain.dto.base.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO notFoundException(Exception e, HttpServletRequest req) {
        log.error(e.getLocalizedMessage());
        return new ErrorDTO(HttpStatus.NOT_FOUND, e.getLocalizedMessage(), req.getRequestURI());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO bindException(BindException e, HttpServletRequest req) {
        log.error(e.getLocalizedMessage());
        return new ErrorDTO(HttpStatus.BAD_REQUEST, e.getLocalizedMessage(), req.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO exception(Exception e, HttpServletRequest req) {
        log.error(e.getLocalizedMessage());
        return new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), req.getRequestURI());
    }
}
