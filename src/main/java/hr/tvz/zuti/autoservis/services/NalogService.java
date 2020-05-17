package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Nalog;
import hr.tvz.zuti.autoservis.exceptions.CustomException;
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
        Optional<Nalog> nalog = nalogRepository.findById(nalogId);
        if (nalog.isPresent())
            return nalog;
        else throw new CustomException("Ne postoji nalog s ID-em '" + nalogId + "'.");
    }

    public Iterable<Nalog> findAllMjesta() { return nalogRepository.findAll(); }
}
