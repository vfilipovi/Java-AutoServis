package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Kvar;
import hr.tvz.zuti.autoservis.domain.Radnik;
import hr.tvz.zuti.autoservis.domain.Mjesto;
import hr.tvz.zuti.autoservis.domain.enumerations.StatusRadnogOdnosa;
import hr.tvz.zuti.autoservis.domain.enumerations.VrstaRadnogOdnosa;
import hr.tvz.zuti.autoservis.repositories.RadnikRepository;
import hr.tvz.zuti.autoservis.repositories.MjestoRepository;
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


public class RadnikServiceTest {
    private static Logger logger = LoggerFactory.getLogger(KvarServiceTest.class);

    @Mock
    private RadnikRepository radnikRepository;

    @InjectMocks
    private RadnikService radnikService;

    @Test
    void test_saveRadnik(){
        final Radnik radnik = new Radnik();
        radnik.setIme("Matej");
        radnik.setPrezime("Matijevic");
        radnik.setOib("32866544794");
        radnik.setIznosOsnovice(3000.00);
        radnik.setKoefPlace(7.00);
        //radnik.setVrstaRadnogOdnosa();
        //radnik.setStatusRadnogOdnosa();

        given(radnikRepository.save(radnik)).willAnswer(invocation -> invocation.getArgument(0));
        Radnik savedRadnik = radnikService.saveOrUpdateRadnik(radnik);
        assertThat(savedRadnik).isNotNull();
        verify(radnikRepository).save(any(Radnik.class));
    }
    @Test
    void test_updateRadnik(){
        final Radnik radnik = new Radnik();
        radnik.setIme("Matej");
        radnik.setPrezime("Matijevic");
        radnik.setOib("32866544794");
        radnik.setIznosOsnovice(3200.00);
        radnik.setKoefPlace(7.00);
        StatusRadnogOdnosa statuss = StatusRadnogOdnosa.ZAPOSLEN;
        String test2 = statuss.toString();
        VrstaRadnogOdnosa stat2 = VrstaRadnogOdnosa.NEODREDENO;
        String testVrsta2 = stat2.toString();
        radnik.setVrstaRadnogOdnosa(stat2);
        radnik.setStatusRadnogOdnosa(statuss);

        given(radnikRepository.save(radnik)).willReturn(radnik);
        final Radnik expected = radnikService.saveOrUpdateRadnik(radnik);
        assertThat(expected).isNotNull();
        verify(radnikRepository).save(any(Radnik.class));

    }
    @Test
    public void test_getRadnikById(){
        Radnik radnik = new Radnik();
        radnik.setId(3);
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

        final Optional<Radnik> expected = radnikService.findRadnikById(3);
        assertThat(expected).isNotNull();
    }

    @Test
    void test_getAllRadnici(){
        List<Radnik> data = new ArrayList<>();
        Radnik radnik1 = new Radnik();
        radnik1.setIme("Matej");
        radnik1.setPrezime("Matijevic");
        radnik1.setOib("32866544794");
        radnik1.setIznosOsnovice(3200.00);
        radnik1.setKoefPlace(7.00);
        StatusRadnogOdnosa status = StatusRadnogOdnosa.ZAPOSLEN;
        String test1 = status.toString();
        VrstaRadnogOdnosa stat = VrstaRadnogOdnosa.NEODREDENO;
        String testVrsta1 = stat.toString();
        radnik1.setVrstaRadnogOdnosa(stat);
        radnik1.setStatusRadnogOdnosa(status);
        Radnik radnik2 = new Radnik();
        radnik2.setIme("Nikola");
        radnik2.setPrezime("Lata");
        radnik2.setOib("32869944794");
        radnik2.setIznosOsnovice(3100.00);
        radnik2.setKoefPlace(4.00);
        StatusRadnogOdnosa status1 = StatusRadnogOdnosa.ZAPOSLEN;
        String test1 = status1.toString();
        VrstaRadnogOdnosa stat1 = VrstaRadnogOdnosa.NEODREDENO;
        String testVrsta1 = stat1.toString();
        radnik2.setVrstaRadnogOdnosa(stat1);
        radnik2.setStatusRadnogOdnosa(status1);

        given(radnikRepository.findAll()).willReturn(data);
        Iterable<Radnik> expected = radnikService.findAllRadnici();
        assertEquals(expected,data);
        List<Radnik> result = StreamSupport.stream(expected.spliterator(), false)
                .collect(Collectors.toList());

    }
}
