package hr.tvz.zuti.autoservis.repositories;

import hr.tvz.zuti.autoservis.domain.Kvar;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface KvarRepository extends CrudRepository<Kvar, Integer> {

    @Override
    <S extends Kvar> S save(S s);

    @Override
    Optional<Kvar> findById(Integer integer);

    @Override
    Iterable<Kvar> findAll();
}
