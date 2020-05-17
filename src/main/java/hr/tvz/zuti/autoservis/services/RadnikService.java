package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.domain.Radnik;
import hr.tvz.zuti.autoservis.domain.Radnik;
import hr.tvz.zuti.autoservis.exceptions.CustomException;
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
            throw new CustomException("Radnik OIB '" + radnik.getOib() + "' već postoji u sustavu.");
        }
    }

    public Optional<Radnik> findRadnikById(Integer radnikId) {
        Optional<Radnik> radnik = radnikRepository.findById(radnikId);
        if (radnik.isPresent())
            return radnik;
        else throw new CustomException("Ne postoji radnik s ID-em '" + radnikId + "'.");
    }

    public Iterable<Radnik> findAllRadniki() { return radnikRepository.findAll(); }

    public void deleteRadnikById(Integer radnikId) { radnikRepository.deleteById(radnikId); }
}
