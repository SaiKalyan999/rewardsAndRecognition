package com.astrotalk.assignment.exceptionhandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Exception handler advice.
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

  /**
   * The Logger.
   */
  private Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

  /**
   * Handle illegal argument exception response entity.
   *
   * @param req the req
   * @param ex  the ex
   * @return the response entity
   */
  @ExceptionHandler(IllegalArgumentException.class)
  public final ResponseEntity<String> handleIllegalArgumentException(final HttpServletRequest req, Exception ex) {
    LOGGER.error("Input Params: {}", req.getParameterMap());
    LOGGER.error("Error Message: {}, error: {}", ex.getMessage(), ex);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(ex.getLocalizedMessage());
  }

  /**
   * Handle exception response entity.
   *
   * @param req the req
   * @param ex  the ex
   * @return the response entity
   */
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<String> handleException(final HttpServletRequest req, Exception ex) {
    LOGGER.error("Input Params: {}", req.getParameterMap());
    LOGGER.error("Error Message: {}, error: {}", ex.getMessage(), ex);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(ex.getLocalizedMessage());
  }
}
