package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.exceptions.OsobaOibException;
import hr.tvz.zuti.autoservis.exceptions.NotFoundException;
import hr.tvz.zuti.autoservis.repositories.KlijentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KlijentService {

    @Autowired
    private KlijentRepository klijentRepository;

    public Klijent saveOrUpdateKlijent(Klijent klijent) {
        try {
            return klijentRepository.save(klijent);
        } catch (Exception e) {
            throw new OsobaOibException("Klijent OIB '" + klijent.getOib() + "' već postoji u sustavu.");
        }
    }

    public Optional<Klijent> findKlijentById(Integer klijentId) {
        if (!klijentRepository.existsById(klijentId))
            throw new NotFoundException("Klijent s ID-em '" + klijentId + "' ne postoji.");
        return klijentRepository.findById(klijentId);
    }

    public Iterable<Klijent> findAllKlijenti() { return klijentRepository.findAll(); }

    public void deleteKlijentById(Integer klijentId) {

        if (!klijentRepository.existsById(klijentId))
            throw new NotFoundException("Klijent s ID-em '" + klijentId + "' ne postoji.");
        klijentRepository.deleteById(klijentId);
    }
}
