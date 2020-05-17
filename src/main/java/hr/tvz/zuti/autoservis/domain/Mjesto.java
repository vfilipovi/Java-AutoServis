package hr.tvz.zuti.autoservis.domain;

import hr.tvz.zuti.autoservis.domain.base.EntityBase;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Mjesto")
public class Mjesto extends EntityBase {
    @NonNull
    @NotBlank(message = "Polje 'Naziv mjesta' mora biti ispunjeno.")
    private String nazivMjesta;

}
