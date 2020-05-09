package hr.tvz.autoservis.autoservis.domain;

import hr.tvz.autoservis.autoservis.domain.base.BaseEntity;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Radnik extends BaseEntity {
    private String ime;
    private String prezime;
    private String BrojMob;
    private double iznosOsnovice;
    private float koefPlace;
    @Enumerated(EnumType.STRING)
    private StatusRadnogOdnosa statusRadnogOdnosa;
    @Enumerated(EnumType.STRING)
    private VrstaRadnogOdnosa vrstaRadnogOdnosa;

    public String getImeIPrezime() {
        return ime + " " + prezime;
    }

    public enum StatusRadnogOdnosa {
        ZAPOSLEN, NEZAPOSLEN
    }

    public enum VrstaRadnogOdnosa {
        ODREDENO, NEODREDENO, PRAKTIKANT
    }
}
