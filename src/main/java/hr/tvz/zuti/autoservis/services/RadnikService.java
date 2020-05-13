package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.domain.Radnik;
import hr.tvz.zuti.autoservis.repositories.KlijentRepository;
import hr.tvz.zuti.autoservis.repositories.RadnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RadnikService {

    @Autowired
    private RadnikRepository radnikRepository;

    public Radnik saveOrUpdateRadnik(Radnik radnik) { return radnikRepository.save(radnik); }

    public Optional<Radnik> findRadnikById(Integer radnikId) { return radnikRepository.findById(radnikId); }

    public Iterable<Radnik> findAllRadnici() { return radnikRepository.findAll(); }

    public void deleteRadnikById(Integer radnikId) { radnikRepository.deleteById(radnikId); }
}
