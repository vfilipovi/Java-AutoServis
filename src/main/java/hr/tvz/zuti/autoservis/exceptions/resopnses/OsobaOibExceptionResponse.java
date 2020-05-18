package hr.tvz.zuti.autoservis.exceptions.resopnses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OsobaOibExceptionResponse {

    private String errorMessage;

    public OsobaOibExceptionResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
