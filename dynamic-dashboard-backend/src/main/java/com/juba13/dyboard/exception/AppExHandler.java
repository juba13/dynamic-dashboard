package com.juba13.dyboard.exception;
import com.juba13.dyboard.response.ErrorResponse;
import java.util.Calendar;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

@ControllerAdvice
@RestController
public class AppExHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, ServletWebRequest request) {
          ErrorResponse errorResponse= new ErrorResponse(Calendar.getInstance().getTime(), ex.getMessage(),  request.getDescription(false));
          return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
