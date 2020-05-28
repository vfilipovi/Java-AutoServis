package hr.tvz.zuti.autoservis.services;
import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.domain.Kvar;
import hr.tvz.zuti.autoservis.domain.Nalog;
import hr.tvz.zuti.autoservis.domain.Radnik;
import hr.tvz.zuti.autoservis.domain.enumerations.Prioritet;
import hr.tvz.zuti.autoservis.domain.enumerations.StatusRadnogOdnosa;
import hr.tvz.zuti.autoservis.domain.enumerations.VrstaRadnogOdnosa;
import hr.tvz.zuti.autoservis.repositories.NalogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.LenientStubber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


//We create this class extend with MockitoExtension,
// so dont need to declare MockitoAnnotations.initMocks(this).
//https://medium.com/backend-habit/integrate-junit-and-mockito-unit-testing-for-service-layer-a0a5a811c58a
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class NalogServiceTest {
    private static Logger logger = LoggerFactory.getLogger(KvarServiceTest.class);

    @Mock
    private NalogRepository nalogRepository;

    @InjectMocks
    private NalogService nalogService;

    @Test
    void test_saveNalog(){
        final Nalog nalog = new Nalog();
        Prioritet prioritet = Prioritet.SREDNJI;
        String priority =prioritet.toString();
        Klijent klijent = new Klijent();
        Kvar kvar = new Kvar();
        Radnik radnik = new Radnik();
        kvar.setNazivKvara("Zamjena ekrana");
        kvar.setOpisKvara("Zamjena 12inch LCD ekrana");
        klijent.setIme("Filip");
        klijent.setPrezime("Grgic");
        klijent.setOib("01234567890");
        klijent.setBrojMob("0957235888");
        klijent.setEmail("filip@tvz.hr");
        radnik.setIme("Matej");
        radnik.setPrezime("Matijevic");
        radnik.setOib("32866544794");
        radnik.setIznosOsnovice(3200.00);
        radnik.setKoefPlace(7.00);
        StatusRadnogOdnosa status = StatusRadnogOdnosa.ZAPOSLEN;
        String test = status.toString();
        VrstaRadnogOdnosa stat = VrstaRadnogOdnosa.NEODREDENO;
        String testVrsta = stat.toString();
        radnik.setVrstaRadnogOdnosa(stat);
        radnik.setStatusRadnogOdnosa(status);
        //nalog.setDatumIzdavanja();
        //nalog.setDatumPreuzimanja();
        nalog.setPrioritet(prioritet);
        nalog.setRegistracijaVozila("ZG5555FZ");
        nalog.setKlijent(klijent);
        nalog.setKvar(kvar);
        nalog.setRadnik(radnik);
        nalog.setUtroseniRadniSatiServisa(3);

        given(nalogRepository.save(nalog)).willAnswer(invocation -> invocation.getArgument(0));

        Nalog savedNalog = nalogService.saveOrUpdateNalog(nalog);
        assertThat(savedNalog).isNotNull();
        verify(nalogRepository).save(any(Nalog.class));
    }
    @Test
    void test_updateNalog(){
        final Nalog nalog = new Nalog();
        Prioritet prioritet = Prioritet.SREDNJI;
        String priority =prioritet.toString();
        Klijent klijent = new Klijent();
        Kvar kvar = new Kvar();
        Radnik radnik = new Radnik();
        kvar.setNazivKvara("Zamjena ekrana");
        kvar.setOpisKvara("Zamjena 12inch LCD ekrana");
        klijent.setIme("Filip");
        klijent.setPrezime("Grgic");
        klijent.setOib("01234567890");
        klijent.setBrojMob("0957235888");
        klijent.setEmail("filip@tvz.hr");
        radnik.setIme("Matej");
        radnik.setPrezime("Matan");
        radnik.setOib("32866544794");
        radnik.setIznosOsnovice(3200.00);
        radnik.setKoefPlace(7.00);
        StatusRadnogOdnosa status = StatusRadnogOdnosa.ZAPOSLEN;
        String test = status.toString();
        VrstaRadnogOdnosa stat = VrstaRadnogOdnosa.NEODREDENO;
        String testVrsta = stat.toString();
        radnik.setVrstaRadnogOdnosa(stat);
        radnik.setStatusRadnogOdnosa(status);
        //nalog.setDatumIzdavanja();
        //nalog.setDatumPreuzimanja();
        nalog.setPrioritet(prioritet);
        nalog.setRegistracijaVozila("ZG5555FZ");
        nalog.setKlijent(klijent);
        nalog.setKvar(kvar);
        nalog.setRadnik(radnik);
        nalog.setUtroseniRadniSatiServisa(3);

        given(nalogRepository.save(nalog)).willReturn(nalog);

        final Nalog expected = nalogService.saveOrUpdateNalog(nalog);

        assertThat(expected).isNotNull();

        verify(nalogRepository).save(any(Nalog.class));
    }
}
