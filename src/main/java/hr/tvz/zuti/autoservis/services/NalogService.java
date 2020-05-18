package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Nalog;
import hr.tvz.zuti.autoservis.exceptions.NotFoundException;
import hr.tvz.zuti.autoservis.repositories.NalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NalogService {

    @Autowired
    private NalogRepository nalogRepository;

    public Nalog saveOrUpdateNalog(Nalog nalog) { return nalogRepository.save(nalog); }

    public Optional<Nalog> findNalogById(Integer nalogId) {
      if (!nalogRepository.existsById(nalogId))
          throw new NotFoundException("Klijent s ID-em '" + nalogId + "' ne postoji.");
      return nalogRepository.findById(nalogId);
    }

    public Iterable<Nalog> findAllMjesta() { return nalogRepository.findAll(); }
}
