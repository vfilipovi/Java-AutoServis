package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Kvar;
import hr.tvz.zuti.autoservis.repositories.KvarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
public class KvarServiceTest {
    private static Logger logger = LoggerFactory.getLogger(KvarServiceTest.class);

    @Mock
    private KvarRepository kvarRepository;

    @InjectMocks
    private KvarService kvarService;


    @Test
        void test_trebaSpremitiKvar(){
        final Kvar kvar = new Kvar();
        kvar.setNazivKvara("Zamjena ekrana");
        kvar.setOpisKvara("Zamjena 12inch LCD ekrana");

        given(kvarRepository.save(kvar)).willAnswer(invocation -> invocation.getArgument(0));

        Kvar savedKvar = kvarService.saveOrUpdateKvar(kvar);

        assertThat(savedKvar).isNotNull();

        verify(kvarRepository).save(any(Kvar.class));


    }

    @Test
        void test_updateKvar(){
        final Kvar kvar = new Kvar();
        kvar.setNazivKvara("Zamjena ekrana");
        kvar.setOpisKvara("Zamjena 12inch LCD ekrana");

        given(kvarRepository.save(kvar)).willReturn(kvar);

        final Kvar ocekivano = kvarService.saveOrUpdateKvar(kvar);

        assertThat(ocekivano).isNotNull();

        verify(kvarRepository).save(any(Kvar.class));
    }

    @Test
    public void test_GetKvarById(){
        Kvar kvar = new Kvar();
        int id = 15;
        kvar.setId(id);
        kvar.setNazivKvara("Zamjena stakla na prozoru");
        kvar.setOpisKvara("Prednje slaklo");

        final Optional<Kvar> ocekivano = kvarService.findKvarById(id);

        assertThat(ocekivano).isNotNull();
    }


    @Test
        void test_trebaVratitiSveKvarove(){
        List<Kvar> data = new ArrayList<>();
        Kvar kvar1 = new Kvar();
        kvar1.setId(12);
        kvar1.setNazivKvara("Promjena znacke");
        kvar1.setOpisKvara("glancanje");
        Kvar kvar2 = new Kvar();
        kvar2.setId(13);
        kvar2.setNazivKvara("Test Motora");
        kvar2.setOpisKvara("Dyno");
        data.add(kvar1);
        data.add(kvar2);

        given(kvarRepository.findAll()).willReturn(data);

        Iterable<Kvar> ocekivano = kvarService.findAllKvarovi();

        assertEquals(ocekivano,data);

        List<Kvar> result = StreamSupport.stream(ocekivano.spliterator(), false)
                .collect(Collectors.toList());

        //System.out.println(result.get(0).getId() + "  " + result.get(0).getNazivKvara());
        //System.out.println(result.get(1).getId() + "  " + result.get(1).getNazivKvara());
    }




}
