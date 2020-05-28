package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.domain.Kvar;
import hr.tvz.zuti.autoservis.repositories.KlijentRepository;
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
public class KlijentServiceTest {
    private static Logger logger = LoggerFactory.getLogger(KvarServiceTest.class);

    @Mock
    private KlijentRepository klijentRepository;

    @InjectMocks
    private KlijentService klijentService;

    @Test
    void test_saveKlijent(){
        final Klijent klijent = new Klijent();
        klijent.setIme("Filip");
        klijent.setPrezime("Grgic");
        klijent.setOib("01234567890");
        klijent.setBrojMob("0957235888");
        klijent.setEmail("filip@tvz.hr");

        given(klijentRepository.save(klijent)).willAnswer(invocation -> invocation.getArgument(0));

        Klijent savedKlijent = klijentService.saveOrUpdateKlijent(klijent);
        assertThat(savedKlijent).isNotNull();
        verify(klijentRepository).save(any(Klijent.class));

    }

    @Test
    void test_updateKlijent(){
        final Klijent klijent = new Klijent();
        klijent.setIme("Filip");
        klijent.setPrezime("Vucemilovic");
        klijent.setOib("01234567890");
        klijent.setBrojMob("0957235888");
        klijent.setEmail("filipvucemilo@tvz.hr");

        given(klijentRepository.save(klijent)).willReturn(klijent);

        final Klijent expected = klijentService.saveOrUpdateKlijent(klijent);

        assertThat(expected).isNotNull();

        verify(klijentRepository).save(any(Klijent.class));
    }

    @Test
    public void test_GetKlijentbyId(){
        Klijent klijent = new Klijent();
        int id = 15;
        klijent.setId(id);
        klijent.setIme("Filip");
        klijent.setPrezime("Vucemilovic");
        klijent.setOib("01234567890");
        klijent.setBrojMob("0957235888");
        klijent.setEmail("filipvucemilo@tvz.hr");

        final Optional<Klijent> expected = klijentService.findKlijentById(id);

        assertThat(expected).isNotNull();
    }

    @Test
    void test_getAllKlijenti(){
        List<Klijent> data = new ArrayList<>();
        Klijent klijent1 = new Klijent();
        Klijent klijent2 = new Klijent();
        klijent1.setId(3);
        klijent1.setIme("Filip");
        klijent1.setPrezime("Vucemilovic");
        klijent1.setOib("01234567890");
        klijent1.setBrojMob("0957235888");
        klijent1.setEmail("filipvucemilo@tvz.hr");
        klijent2.setId(4);
        klijent2.setIme("Lovre");
        klijent2.setPrezime("Marketin");
        klijent2.setOib("01234588890");
        klijent2.setBrojMob("0917535888");
        klijent2.setEmail("lovre@tvz.hr");

        given(klijentRepository.findAll()).willReturn(data);

        Iterable<Klijent> expected = klijentService.findAllKlijenti();

        assertEquals(expected,data);

        List<Klijent> result = StreamSupport.stream(expected.spliterator(), false)
                .collect(Collectors.toList());
    }
}
