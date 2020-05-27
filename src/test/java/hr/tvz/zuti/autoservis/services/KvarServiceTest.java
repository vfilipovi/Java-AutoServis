package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Kvar;
import hr.tvz.zuti.autoservis.repositories.KvarRepository;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.LenientStubber;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


//We create this class extend with MockitoExtension,
// so dont need to declare MockitoAnnotations.initMocks(this).
//https://medium.com/backend-habit/integrate-junit-and-mockito-unit-testing-for-service-layer-a0a5a811c58a
@ExtendWith(MockitoExtension.class)
public class KvarServiceTest {

    @Mock
    private KvarRepository kvarRepository;

    @InjectMocks
    private KvarService kvarService;

    @Rule
    MockitoRule mockito = MockitoJUnit.rule().strictness(Strictness.LENIENT);
    

    @Test
        void trebaSpremitiKvar(){
        final Kvar kvar = new Kvar();
        kvar.setNazivKvara("Zamjena ekrana");
        kvar.setOpisKvara("Zamjena 12inch LCD ekrana");
        
        given(kvarRepository.save(kvar)).willAnswer(invocation -> invocation.getArgument(0));

        Kvar savedKvar = kvarService.saveOrUpdateKvar(kvar);

        assertThat(savedKvar).isNotNull();

        verify(kvarRepository).save(any(Kvar.class));
    }

    @Test
        void updateKvar(){
        final Kvar kvar = new Kvar();
        kvar.setNazivKvara("Zamjena ekrana");
        kvar.setOpisKvara("Zamjena 12inch LCD ekrana");

        given(kvarRepository.save(kvar)).willReturn(kvar);

        final Kvar ocekivano = kvarService.saveOrUpdateKvar(kvar);

        assertThat(ocekivano).isNotNull();

        verify(kvarRepository).save(any(Kvar.class));
    }

    @Test
        void findKvarById(){

        final Kvar kvar = new Kvar();
        final int id = 25;
        kvar.setId(id);
        kvar.setNazivKvara("Zamjena stakla");
        kvar.setOpisKvara("Prednje slaklo");

        //lenient().when(findKvarById().)
        //Mockito.lenient().when(kvarRepository.findById(id)).thenReturn(Optional.of(kvar));

        //when(kvarRepository.findById(id)).thenReturn(Optional.of(kvar));

        given(kvarRepository.save(kvar)).willReturn(kvar);

        final Optional<Kvar> ocekivano = kvarService.findKvarById(id);

        assertThat(ocekivano).isNotNull();
    }


    @Test
        void trebaVratitiSveKvarove(){
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
    }




}
