package hr.tvz.zuti.autoservis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hr.tvz.zuti.autoservis.domain.base.EntityBase;
import hr.tvz.zuti.autoservis.domain.enumerations.Prioritet;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Nalog extends EntityBase {
    private static final String _pattern = "dd-MM-yyyy";
    private static final String _timezone = "Europe/Zagreb";

    @NonNull
    @NotBlank(message = "Polje 'Registarcija vozila' mora biti ispunjeno.")
    private String registracijaVozila;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Prioritet prioritet;
    @NonNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = _pattern, timezone = _timezone)
    private Date datumPreuzimanja;
    @NonNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = _pattern, timezone = _timezone)
    private Date datumIzdavanja;
    @PositiveOrZero(message = "Polje 'Utrošeni radni sati' mora biti ispunjeno kao pozitivan broj")
    private int utroseniRadniSatiServisa;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="radnik_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Radnik radnik;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="klijent_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Klijent klijent;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="kvar_id")
    private Kvar kvar;
}
