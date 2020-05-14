package hr.tvz.zuti.autoservis.exceptions.resopnses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomExceptionResponse {

    private String errorMessage;

    public CustomExceptionResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
