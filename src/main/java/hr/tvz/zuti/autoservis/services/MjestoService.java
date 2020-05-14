package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.domain.Mjesto;
import hr.tvz.zuti.autoservis.repositories.KlijentRepository;
import hr.tvz.zuti.autoservis.repositories.MjestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MjestoService {

    @Autowired
    private MjestoRepository mjestoRepository;

    public Mjesto saveOrUpdateMjesto(Mjesto mjesto) { return mjestoRepository.save(mjesto); }

    public Optional<Mjesto> findMjestoById(Integer mjestoId) { return mjestoRepository.findById(mjestoId); }

}
