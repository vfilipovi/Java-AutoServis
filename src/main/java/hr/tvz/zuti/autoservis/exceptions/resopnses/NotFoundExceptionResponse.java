package hr.tvz.zuti.autoservis.exceptions.resopnses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundExceptionResponse {
    private String errorMessage;

    public NotFoundExceptionResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
