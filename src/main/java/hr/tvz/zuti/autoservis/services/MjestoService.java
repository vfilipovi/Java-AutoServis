package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Mjesto;
import hr.tvz.zuti.autoservis.exceptions.NotFoundException;
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
        if (!mjestoRepository.existsById(mjestoId))
            throw new NotFoundException("Mjesto s ID-em '" + mjestoId + "' ne postoji.");
        return mjestoRepository.findById(mjestoId);
    }

    public Iterable<Mjesto> findAllMjesta() { return mjestoRepository.findAll(); }

    public void deleteMjestotById(Integer mjestoId) {
        if (!mjestoRepository.existsById(mjestoId))
            throw new NotFoundException("Mjesto s ID-em '" + mjestoId + "' ne postoji.");
        mjestoRepository.deleteById(mjestoId);
    }

}
