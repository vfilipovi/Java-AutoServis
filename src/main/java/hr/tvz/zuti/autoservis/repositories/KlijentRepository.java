package hr.tvz.zuti.autoservis.repositories;

import hr.tvz.zuti.autoservis.domain.Klijent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KlijentRepository extends CrudRepository<Klijent, Integer> {
    @Override
    <S extends Klijent> S save(S s);

    @Override
    Optional<Klijent> findById(Integer integer);

    @Override
    Iterable<Klijent> findAll();

    @Override
    void deleteById(Integer integer);
}
