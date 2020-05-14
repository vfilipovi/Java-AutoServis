package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.exceptions.KlijentOibException;
import hr.tvz.zuti.autoservis.repositories.KlijentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.*;
import java.util.Optional;

@Service
public class KlijentService {

    @Autowired
    private KlijentRepository klijentRepository;

    public Klijent saveOrUpdateKlijent(Klijent klijent) {
        try {
            return klijentRepository.save(klijent);
        } catch (Exception e) {
            throw new KlijentOibException("Klijent OIB '" + klijent.getOib() + "' već postoji u sustavu.");
        }
    }

    public Optional<Klijent> findKlijentById(Integer klijentId) {
        Optional<Klijent> klijent = klijentRepository.findById(klijentId);
        if (klijent.isPresent())
            return klijent;
        else throw new KlijentOibException("Ne postoji klijent s ID-em '" + klijentId + "'.");
    }

    public Iterable<Klijent> findAllKlijenti() { return klijentRepository.findAll(); }

    public void deleteKlijentById(Integer klijentId) { klijentRepository.deleteById(klijentId); }
}
