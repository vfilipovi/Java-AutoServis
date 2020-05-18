package hr.tvz.zuti.autoservis.domain;


import hr.tvz.zuti.autoservis.domain.base.OsobaBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Klijent extends OsobaBase {
    @NotBlank(message = "Polje 'Broj mobitela' mora biti ispunjeno.")
    @Pattern(regexp = "^[0-9]{10}$", message = "Broj mobitela mora biti isključivo numerički niz od 10 znamenki.")
    private String brojMob;
    @NotNull
    @NotBlank(message = "Polje 'Email' mora biti ispunjeno.")
    @Email(message = "Molimo unesite ispravan format email adrese.")
    private String email;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="mjesto_id")
    private Mjesto mjesto;
}
