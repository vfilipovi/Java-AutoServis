package hr.tvz.zuti.autoservis.repositories;

import hr.tvz.zuti.autoservis.domain.Radnik;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadnikRepository extends CrudRepository<Radnik, Integer> { }
