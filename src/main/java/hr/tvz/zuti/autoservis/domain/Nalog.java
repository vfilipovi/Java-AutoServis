package hr.tvz.zuti.autoservis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import hr.tvz.zuti.autoservis.domain.base.EntityBase;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Nalog extends EntityBase {
    private static final String _pattern = "dd-MM-yyyy";
    private static final String _timezone = "Europe/Zagreb";

    @NonNull
    @NotBlank(message = "Polje 'Broj mobitela' mora biti ispunjeno.")
    private String registracijaVozila;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Prioritet prioritet;
    @NonNull
    @NotBlank(message = "Datum preuzimanja mora biti odabran.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = _pattern, timezone = _timezone)
    private Date datumPreuzimanja;
    @NonNull
    @NotBlank(message = "Datum izdavanja mora biti odabran.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = _pattern, timezone = _timezone)
    private Date datumIzdavanja;
    @NonNull
    @Min(0)
    private int utroseniRadniSatiServisa;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Radnik radnik;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Klijent klijent;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Kvar kvar;

    public enum Prioritet {
        NISKI, SREDNJI, VISOKI
    }
}
