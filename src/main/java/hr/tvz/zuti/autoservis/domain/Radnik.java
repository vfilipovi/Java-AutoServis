package hr.tvz.zuti.autoservis.domain;

import hr.tvz.zuti.autoservis.domain.base.OsobaBase;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Radnik extends OsobaBase {
    private double iznosOsnovice;
    private double koefPlace;
    @Enumerated(EnumType.STRING)
    private StatusRadnogOdnosa statusRadnogOdnosa;
    @Enumerated(EnumType.STRING)
    private VrstaRadnogOdnosa vrstaRadnogOdnosa;

    public enum StatusRadnogOdnosa {
        ZAPOSLEN, NEZAPOSLEN
    }

    public enum VrstaRadnogOdnosa {
        ODREDENO, NEODREDENO, PRAKTIKANT
    }
}
