package hr.tvz.autoservis.autoservis.domain;

import hr.tvz.autoservis.autoservis.domain.base.BaseEntity;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Kvar extends BaseEntity {
    private String nazivKvara;
    private int radniSatServisa;
}
