package hr.tvz.zuti.autoservis.domain;

import hr.tvz.zuti.autoservis.domain.base.EntityBase;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Kvar extends EntityBase {
    @NonNull
    @NotBlank(message = "Polje 'naziv kvara' mora biti ispunjeno.")
    private String nazivKvara;
    private String opisKvara;
}
