package hr.tvz.zuti.autoservis.repositories;

import hr.tvz.zuti.autoservis.domain.Klijent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KlijentRepository extends CrudRepository<Klijent, Integer> { }
