package hr.tvz.zuti.autoservis.exceptions.handler;

import hr.tvz.zuti.autoservis.exceptions.NotFoundException;
import hr.tvz.zuti.autoservis.exceptions.resopnses.NotFoundExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class NotFoundExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request) {
        NotFoundExceptionResponse exceptionResponse = new NotFoundExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
