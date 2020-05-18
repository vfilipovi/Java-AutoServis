package hr.tvz.zuti.autoservis.services;


import hr.tvz.zuti.autoservis.domain.Kvar;
import hr.tvz.zuti.autoservis.exceptions.NotFoundException;
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
        if (!kvarRepository.existsById(kvarId))
            throw new NotFoundException("Kvar s ID-em '" + kvarId + "' ne postoji.");
        return kvarRepository.findById(kvarId); }

    public Iterable<Kvar> findAllKvarovi() { return kvarRepository.findAll(); }

    public void deleteKvarById(Integer kvarId) {
        if (!kvarRepository.existsById(kvarId))
            throw new NotFoundException("Kvar s ID-em '" + kvarId + "' ne postoji.");
        kvarRepository.deleteById(kvarId);
    }
}
