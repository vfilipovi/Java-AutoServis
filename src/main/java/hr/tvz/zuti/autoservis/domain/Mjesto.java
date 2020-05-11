package hr.tvz.zuti.autoservis.domain;

import hr.tvz.zuti.autoservis.domain.base.BaseEntity;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Mjesto extends BaseEntity {
    private String nazivMjesta;
}
