package hr.tvz.zuti.autoservis.domain;

import hr.tvz.zuti.autoservis.domain.base.EntityBase;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Mjesto extends EntityBase {
    @NonNull
    @NotBlank(message = "Polje 'Naziv mjesta' mora biti ispunjeno.")
    private String nazivMjesta;
}
