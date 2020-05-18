package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.domain.Radnik;
import hr.tvz.zuti.autoservis.exceptions.OsobaOibException;
import hr.tvz.zuti.autoservis.exceptions.NotFoundException;
import hr.tvz.zuti.autoservis.repositories.RadnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RadnikService {

    @Autowired
    private RadnikRepository radnikRepository;

    public Radnik saveOrUpdateRadnik(Radnik radnik) {
        try {
            return radnikRepository.save(radnik);
        } catch (Exception e) {
            throw new OsobaOibException("Radnik OIB '" + radnik.getOib() + "' već postoji u sustavu.");
        }
    }

    public Optional<Radnik> findRadnikById(Integer radnikId) {
       if (!radnikRepository.existsById(radnikId))
           throw new NotFoundException("Radnik s ID-em '" + radnikId + "' ne postoji.");
       return radnikRepository.findById(radnikId);
    }

    public Iterable<Radnik> findAllRadnici() { return radnikRepository.findAll(); }

    public void deleteRadnikById(Integer radnikId) {
        if (!radnikRepository.existsById(radnikId))
            throw new NotFoundException("Radnik s ID-em '" + radnikId + "' ne postoji.");
        radnikRepository.deleteById(radnikId);
    }
}
