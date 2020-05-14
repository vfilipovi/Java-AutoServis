package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Radnik;
import hr.tvz.zuti.autoservis.repositories.RadnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RadnikService {

    @Autowired
    private RadnikRepository radnikRepository;

    public Radnik saveOrUpdateRadnik(Radnik radnik) {

        return radnikRepository.save(radnik);
    }
}
