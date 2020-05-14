package hr.tvz.zuti.autoservis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hr.tvz.zuti.autoservis.domain.base.EntityBase;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Mjesto")
public class Mjesto extends EntityBase {
    @NonNull
    @NotBlank(message = "Polje 'Naziv mjesta' mora biti ispunjeno.")
    private String nazivMjesta;

}
