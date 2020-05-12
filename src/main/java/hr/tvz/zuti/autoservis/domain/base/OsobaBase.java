package hr.tvz.zuti.autoservis.domain.base;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class OsobaBase extends EntityBase{
    @NotBlank(message = "Polje ime mora biti ispunjeno.")
    private String ime;
    @NotBlank(message = "Polje prezime mora biti ispunjeno.")
    private String prezime;
    @NotBlank(message = "Polje OIB mora biti ispunjeno.")
    @Pattern(regexp = "^[0-9]{11}$", message = "Oib moram biti isključivo numerički niz od 11 znamenki.")
    private String oib;
    @NotBlank(message = "Polje 'Broj mobitela' mora biti ispunjeno.")
    @Pattern(regexp = "^[0-9]{10}$", message = "Broj mobitela morama biti isključivo numerički niz od 10 znamenki.")
    private String brojMob;

    public String getImeIPrezime() { return ime + " " + prezime; }
}
