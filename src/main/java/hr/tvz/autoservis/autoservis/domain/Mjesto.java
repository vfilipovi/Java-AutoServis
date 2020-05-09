package hr.tvz.autoservis.autoservis.domain;

import hr.tvz.autoservis.autoservis.domain.base.BaseEntity;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Mjesto extends BaseEntity {
    private String nazivMjesta;
}
