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
    @NonNull
    @NotBlank(message = "Polje ime mora biti ispunjeno.")
    protected String ime;
    @NonNull
    @NotBlank(message = "Polje prezime mora biti ispunjeno.")
    protected String prezime;
    @Column(unique = true)
    @NonNull
    @NotBlank(message = "Polje OIB mora biti ispunjeno.")
    @Pattern(regexp = "^[0-9]{11}$", message = "Oib moram biti isključivo numerički niz od 11 znamenki.")
    protected String oib;

    public String getImeIPrezime() { return ime + " " + prezime; }
}
