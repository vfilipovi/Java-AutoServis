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
    @NotBlank(message = "Polje 'Naziv kvara' mora biti ispunjeno.")
    private String nazivKvara;
    @NonNull
    @NotBlank(message = "Polje 'Opis kvara' mora biti ispunjeno.")
    private String opisKvara;

    @Override
    public String toString(){
        return "Naziv kvara: " + this.getNazivKvara()+ ". Opis kvara: " + this.getOpisKvara();
    }
}
