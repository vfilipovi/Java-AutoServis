package hr.tvz.zuti.autoservis.repositories;

import hr.tvz.zuti.autoservis.domain.Nalog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NalogRepository extends CrudRepository<Nalog, Integer> {
    @Override
    <S extends Nalog> S save(S s);

    @Override
    Optional<Nalog> findById(Integer integer);

    @Override
    Iterable<Nalog> findAll();
}
