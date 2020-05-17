package hr.tvz.zuti.autoservis.services;


import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.domain.Kvar;
import hr.tvz.zuti.autoservis.domain.Nalog;
import hr.tvz.zuti.autoservis.exceptions.CustomException;
import hr.tvz.zuti.autoservis.repositories.KvarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KvarService {

    @Autowired
    private KvarRepository kvarRepository;

    public Kvar saveOrUpdateKvar(Kvar kvar) {
        return kvarRepository.save(kvar);
    }

    public Optional<Kvar> findKvarById(Integer kvarId) {

        Optional<Kvar> kvar = kvarRepository.findById(kvarId);
        if (kvar.isPresent())
            return kvar;
        else throw new CustomException("Ne postoji kvar s ID-em '" + kvarId + "'.");
    }

    public Iterable<Kvar> findAllKvarovi() { return kvarRepository.findAll(); }

    public void deleteKvarById(Integer kvarId) { kvarRepository.deleteById(kvarId); }
}
