package hr.tvz.zuti.autoservis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hr.tvz.zuti.autoservis.domain.base.OsobaBase;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity(name = "Klijent")
@Getter
@Setter
@NoArgsConstructor
public class Klijent extends OsobaBase {
    @NotBlank(message = "Polje 'Broj mobitela' mora biti ispunjeno.")
    @Pattern(regexp = "^[0-9]{10}$", message = "Broj mobitela morama biti isključivo numerički niz od 10 znamenki.")
    private String brojMob;
    @NotNull
    @NotBlank(message = "Polje 'Email' mora biti ispunjeno.")
    @Email(message = "Molimo unesite ispravan format email adrese.")
    private String email;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Mjesto mjesto;
}