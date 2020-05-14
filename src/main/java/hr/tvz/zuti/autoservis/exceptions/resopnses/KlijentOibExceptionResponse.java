package hr.tvz.zuti.autoservis.exceptions.resopnses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KlijentOibExceptionResponse {

    private String errorMessage;

    public KlijentOibExceptionResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
