package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Mjesto;
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
public class MjestoServiceTest {
    private static Logger logger = LoggerFactory.getLogger(MjestoServiceTest.class);

    @Mock
    private MjestoRepository mjestoRepository;

    @InjectMocks
    private MjestoService mjestoService;

    @Test
    void test_saveMjesto(){
        final Mjesto mjesto = new Mjesto();
        mjesto.setNazivMjesta("Velika Gorica");

        given(mjestoRepository.save(mjesto)).willAnswer(invocation -> invocation.getArgument(0));

        Mjesto savedMjesto = mjestoService.saveOrUpdateMjesto(mjesto);
        assertThat(savedMjesto).isNotNull();
        verify(mjestoRepository).save(any(Mjesto.class));
    }

    @Test
    public void test_getMjestoById(){
        Mjesto mjesto = new Mjesto();
        mjesto.setId(7);
        mjesto.setNazivMjesta("Sveti Ivan Zelina");

        final Optional<Mjesto> expected = mjestoService.findMjestoById(7);
        assertThat(expected).isNotNull();
    }

    @Test
    void test_getAllMjesta(){
        List<Mjesto> data = new ArrayList<>();
        Mjesto mjesto1 = new Mjesto();
        mjesto1.setId(9);
        mjesto1.setNazivMjesta("Zadar");
        Mjesto mjesto2 = new Mjesto();
        mjesto2.setId(10);
        mjesto2.setNazivMjesta("Vodice");
        data.add(mjesto1);
        data.add(mjesto2);

        given(mjestoRepository.findAll()).willReturn(data);
        Iterable<Mjesto> expected = mjestoService.findAllMjesta();
        assertEquals(expected,data);
        List<Mjesto> result = StreamSupport.stream(expected.spliterator(), false)
                .collect(Collectors.toList());

    }
}

