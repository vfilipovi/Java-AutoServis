package hr.tvz.zuti.autoservis.services;

import hr.tvz.zuti.autoservis.domain.Kvar;
import hr.tvz.zuti.autoservis.repositories.KvarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


//We create this class extend with MockitoExtension,
// so dont need to declare MockitoAnnotations.initMocks(this).
// We create using annotation based, because I think is very usefull.
//https://medium.com/backend-habit/integrate-junit-and-mockito-unit-testing-for-service-layer-a0a5a811c58a
@ExtendWith(MockitoExtension.class)
public class KvarServiceTest {


    //@Mock : because on UserService have dependency to UserRepository,
    // we create mock object to simulate behaviour of the real object.
    @Mock
    private KvarRepository kvarRepository;

    //@InjectMock : is create Object to inject mock dependency,
    // because on this case we simulate about UserService,
    // so we create @InjectMock based on UserService.
    @InjectMocks
    private KvarService kvarService;

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



}
