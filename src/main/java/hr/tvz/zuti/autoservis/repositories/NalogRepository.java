package hr.tvz.zuti.autoservis.repositories;

import hr.tvz.zuti.autoservis.domain.Nalog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NalogRepository extends CrudRepository<Nalog, Integer> { }
