package hr.tvz.autoservis.autoservis.domain;

import hr.tvz.autoservis.autoservis.domain.base.BaseEntity;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Nalog extends BaseEntity {
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
