package hr.tvz.zuti.autoservis.exceptions.handler;

import hr.tvz.zuti.autoservis.exceptions.resopnses.KlijentOibExceptionResponse;
import hr.tvz.zuti.autoservis.exceptions.KlijentOibException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class KlijentOibResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleKlijentOibException(KlijentOibException ex, WebRequest request) {
        KlijentOibExceptionResponse exceptionResponse = new KlijentOibExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
