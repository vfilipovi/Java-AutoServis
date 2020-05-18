package hr.tvz.zuti.autoservis.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OsobaOibException extends RuntimeException {

    public OsobaOibException(String message) { super(message); }
}
