package hr.tvz.zuti.autoservis.repositories;

import hr.tvz.zuti.autoservis.domain.Kvar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KvarRepository extends CrudRepository<Kvar, Integer> { }
