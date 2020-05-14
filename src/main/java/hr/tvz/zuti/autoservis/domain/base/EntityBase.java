package hr.tvz.zuti.autoservis.domain.base;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected Date created_At;
    protected Date updated_At;

    @PrePersist
    protected void onCreate() {
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate() { this.updated_At = new Date(); }
}
