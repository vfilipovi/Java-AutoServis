package hr.tvz.zuti.autoservis.domain;

import hr.tvz.zuti.autoservis.domain.base.EntityBase;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Nalog extends EntityBase {
    private String registracijaVozila;
    @Enumerated(EnumType.STRING)
    private Prioritet prioritet;
    private Date datumPreuzimanja;
    private Date datumIzdavanja;
    private int utroseniRadniSatiServisa;

    public enum Prioritet {
        NISKI, SREDNJI, VISOKI
    }
}
