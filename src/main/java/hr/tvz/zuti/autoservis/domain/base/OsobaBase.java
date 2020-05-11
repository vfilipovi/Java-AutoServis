package hr.tvz.zuti.autoservis.domain.base;

import lombok.*;
import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class OsobaBase extends EntityBase{
    private String ime;
    private String prezime;
    private String oib;
    private String BrojMob;

    public String getImeIPrezime() {
        return ime + " " + prezime;
    }
}
