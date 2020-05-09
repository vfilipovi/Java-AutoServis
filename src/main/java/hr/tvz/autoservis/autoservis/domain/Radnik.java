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
    private StatusRanogOdnosa statusRanogOdnosa;
    @Enumerated(EnumType.STRING)
    private VrstaRanogOdnosa vrstaRanogOdnosa;

    public String getImeIPrezime() {
        return ime + " " + prezime;
    }

    public enum StatusRanogOdnosa {
        ZAPOSLEN, NEZAPOSLEN
    }

    public enum VrstaRanogOdnosa {
        ODREDENO, NEODREDENO, PRAKTIKANT
    }
}
