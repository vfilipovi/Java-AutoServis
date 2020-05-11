package hr.tvz.zuti.autoservis.domain;

import hr.tvz.zuti.autoservis.domain.base.BaseEntity;
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
