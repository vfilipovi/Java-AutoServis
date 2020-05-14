package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Mjesto;
import hr.tvz.zuti.autoservis.exceptions.CustomException;
import hr.tvz.zuti.autoservis.repositories.MjestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MjestoService {

    @Autowired
    private MjestoRepository mjestoRepository;

    public Mjesto saveOrUpdateMjesto(Mjesto mjesto) { return mjestoRepository.save(mjesto); }

    public Optional<Mjesto> findMjestoById(Integer mjestoId) {
        Optional<Mjesto> mjesto = mjestoRepository.findById(mjestoId);
        if (mjesto.isPresent())
            return mjesto;
        else throw new CustomException("Ne postoji mjesto s ID-em '" + mjestoId + "'.");
    }

    public Iterable<Mjesto> findAllMjesta() { return mjestoRepository.findAll(); }

    public void deleteMjestotById(Integer mjestoId) { mjestoRepository.deleteById(mjestoId); }

}
