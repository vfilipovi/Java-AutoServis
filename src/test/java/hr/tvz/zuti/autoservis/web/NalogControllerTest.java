package hr.tvz.zuti.autoservis.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.domain.Kvar;
import hr.tvz.zuti.autoservis.domain.Mjesto;
import hr.tvz.zuti.autoservis.domain.Radnik;
import hr.tvz.zuti.autoservis.domain.enumerations.Prioritet;
import hr.tvz.zuti.autoservis.domain.enumerations.StatusRadnogOdnosa;
import hr.tvz.zuti.autoservis.domain.enumerations.VrstaRadnogOdnosa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class NalogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createNewNalog() throws Exception {

        String TEST_REGISTRACIJA_VOZILA = "Test";
        String TEST_DATUM_PREUZIMANJA = "2020.05.10";
        String TEST_DATUM_IZDAVANJA = "2020.05.10";
        int TEST_UTROSENI_SATI_SERVISA = 5;

        Prioritet prioritet = Prioritet.NISKI;
        String TEST_PRIORITET = prioritet.toString();

        String TEST_NAZIV_MJESTA = "Zagreb";
        int TEST_MJESTO_ID = 1;

        Mjesto mjesto = new Mjesto();
        mjesto.setId(TEST_MJESTO_ID);
        mjesto.setNazivMjesta(TEST_NAZIV_MJESTA);

        String TEST_IME = "Testno ime";
        String TEST_PREZIME = "Testno prezime";
        String TEST_OIB = "01234567899";
        String TEST_BROJ_MOB = "0123456789";
        String TEST_EMAIL = "test@email.com";

        Klijent klijent = new Klijent();
        klijent.setIme(TEST_IME);
        klijent.setPrezime(TEST_PREZIME);
        klijent.setOib(TEST_OIB);
        klijent.setBrojMob(TEST_BROJ_MOB);
        klijent.setEmail(TEST_EMAIL);
        klijent.setMjesto(mjesto);


        double TEST_OSNOVICA = 10;
        double TEST_KOEFICIJENT = 2;

        StatusRadnogOdnosa status = StatusRadnogOdnosa.ZAPOSLEN;
        String TEST_STATUS = status.toString();

        VrstaRadnogOdnosa vrsta = VrstaRadnogOdnosa.NEODREDENO;
        String TEST_VRSTA = vrsta.toString();

        Radnik radnik = new Radnik();
        radnik.setIme(TEST_IME);
        radnik.setPrezime(TEST_PREZIME);
        radnik.setOib(TEST_OIB);
        radnik.setIznosOsnovice(TEST_OSNOVICA);
        radnik.setKoefPlace(TEST_KOEFICIJENT);
        radnik.setStatusRadnogOdnosa(status);
        radnik.setVrstaRadnogOdnosa(vrsta);
        radnik.setMjesto(mjesto);


        String TEST_NAZIV_KVARA = "Testni kvar";
        String TEST_OPIS_KVARA = "Testni opis kvara";

        Kvar kvar = new Kvar();
        kvar.setNazivKvara(TEST_NAZIV_KVARA);
        kvar.setOpisKvara(TEST_OPIS_KVARA);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(klijent);

        this.mockMvc.perform(
                post("/api/v1/nalozi")
                        .with(user("admin")
                                .password("test")
                                .roles("ADMIN")
                        )
                        .with(csrf())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .characterEncoding("utf-8")
        )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.registracijaVozila").value(TEST_REGISTRACIJA_VOZILA))
                .andExpect(jsonPath("$.prioriet").value(TEST_PRIORITET))
                .andExpect(jsonPath("$.datumPreuzimanja").value(TEST_DATUM_PREUZIMANJA))
                .andExpect(jsonPath("$.datumIzdavanja").value(TEST_DATUM_IZDAVANJA))
                .andExpect(jsonPath("$.utroseniRadniSatiServisa").value(TEST_UTROSENI_SATI_SERVISA))
                .andExpect(jsonPath("$.klijent.ime").value(TEST_IME))
                .andExpect(jsonPath("$.klijent.prezime").value(TEST_PREZIME))
                .andExpect(jsonPath("$.klijent.oib").value(TEST_OIB))
                .andExpect(jsonPath("$.klijent.iznosOsnovice").value(TEST_BROJ_MOB))
                .andExpect(jsonPath("$.klijent.email").value(TEST_EMAIL))
                .andExpect(jsonPath("$.klijent.mjesto.id").value(TEST_MJESTO_ID))
                .andExpect(jsonPath("$.klijent.mjesto.nazivMjesta").value(TEST_NAZIV_MJESTA))
                .andExpect(jsonPath("$.radnik.ime").value(TEST_IME))
                .andExpect(jsonPath("$.radnik.prezime").value(TEST_PREZIME))
                .andExpect(jsonPath("$.radnik.oib").value(TEST_OIB))
                .andExpect(jsonPath("$.radnik.iznosOsnovice").value(TEST_OSNOVICA))
                .andExpect(jsonPath("$.radnik.koefPlace").value(TEST_KOEFICIJENT))
                .andExpect(jsonPath("$.radnik.statusRadnoOdnosa").value(TEST_STATUS))
                .andExpect(jsonPath("$.radnik.vrstaRadnogOdnosa").value(TEST_VRSTA))
                .andExpect(jsonPath("$.klijent.mjesto.id").value(TEST_MJESTO_ID))
                .andExpect(jsonPath("$.klijent.mjesto.nazivMjesta").value(TEST_NAZIV_MJESTA))
                .andExpect(jsonPath("$.kvar.nazivKvara").value(TEST_NAZIV_KVARA))
                .andExpect(jsonPath("$.klijent.opisKvara").value(TEST_OPIS_KVARA));
    }


    @Test
    void getAllNalozi() throws Exception {
        this.mockMvc.perform(
                get("/api/v1/nalozi")
                        .characterEncoding("utf-8")
                        .with(user("admin")
                                .password("test")
                                .roles("ADMIN")
                        )
                        .with(csrf())
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(5)));
    }

}
