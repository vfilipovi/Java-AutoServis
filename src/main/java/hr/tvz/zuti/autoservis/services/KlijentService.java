package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.repositories.KlijentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KlijentService {

    @Autowired
    private KlijentRepository klijentRepository;

    public Klijent saveOrUpdateKlijent(Klijent klijent) { return klijentRepository.save(klijent); }

    public Optional<Klijent> findKlijentById(Integer klijentId) { return klijentRepository.findById(klijentId); }

    public Iterable<Klijent> findAllKlijenti() { return klijentRepository.findAll(); }

    public void deleteKlijentById(Integer klijentId) { klijentRepository.deleteById(klijentId); }
}
