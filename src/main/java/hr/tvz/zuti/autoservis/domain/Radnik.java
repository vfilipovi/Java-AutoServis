package hr.tvz.zuti.autoservis.domain;

import hr.tvz.zuti.autoservis.domain.base.OsobaBase;
import hr.tvz.zuti.autoservis.domain.enumerations.StatusRadnogOdnosa;
import hr.tvz.zuti.autoservis.domain.enumerations.VrstaRadnogOdnosa;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Radnik extends OsobaBase {
    private double iznosOsnovice;
    private double koefPlace;
    @NonNull
    @Enumerated(EnumType.STRING)
    private StatusRadnogOdnosa statusRadnogOdnosa;
    @NonNull
    @Enumerated(EnumType.STRING)
    private VrstaRadnogOdnosa vrstaRadnogOdnosa;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="mjesto_id")
    private Mjesto mjesto;

}
