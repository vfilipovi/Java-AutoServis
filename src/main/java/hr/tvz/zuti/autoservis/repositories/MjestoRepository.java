package hr.tvz.zuti.autoservis.repositories;

import hr.tvz.zuti.autoservis.domain.Mjesto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MjestoRepository extends CrudRepository<Mjesto, Integer> { }
