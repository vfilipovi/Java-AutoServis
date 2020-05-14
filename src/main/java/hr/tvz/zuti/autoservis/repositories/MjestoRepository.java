package hr.tvz.zuti.autoservis.repositories;

import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.domain.Mjesto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MjestoRepository extends CrudRepository<Mjesto, Integer> {

    @Override
    <S extends Mjesto> S save(S s);

    @Override
    Optional<Mjesto> findById(Integer integer);
}
