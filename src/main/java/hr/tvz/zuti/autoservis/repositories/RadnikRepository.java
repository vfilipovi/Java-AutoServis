package hr.tvz.zuti.autoservis.repositories;

import hr.tvz.zuti.autoservis.domain.Radnik;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RadnikRepository extends CrudRepository<Radnik, Integer> {
    @Override
    <S extends Radnik> S save(S s);

    @Override
    Optional<Radnik> findById(Integer integer);

    @Override
    Iterable<Radnik> findAll();

    @Override
    void deleteById(Integer integer);
}
