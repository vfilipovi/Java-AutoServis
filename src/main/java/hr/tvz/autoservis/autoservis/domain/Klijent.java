package hr.tvz.autoservis.autoservis.domain;

import hr.tvz.autoservis.autoservis.domain.base.BaseEntity;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Klijent extends BaseEntity {
    private String ime;
    private String prezime;
    private String oib;
    private String BrojMob;

    public String getImeIPrezime() {
        return ime + " " + prezime;
    }

}
