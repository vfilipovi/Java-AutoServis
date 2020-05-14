package hr.tvz.zuti.autoservis.web;

import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.services.KlijentService;
import hr.tvz.zuti.autoservis.services.MapValidationErrorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/klijenti")
public class KlijentController {

    @Autowired
    private KlijentService klijentService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewKlijent(@Valid @RequestBody Klijent _klijent, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

        if (errorMap != null) return errorMap;

        Klijent klijent = klijentService.saveOrUpdateKlijent(_klijent);
        //  ResponseEntity<> is short for ResponseEntity<Klijent>
        return new ResponseEntity<>(klijent, HttpStatus.CREATED);
    }

    @GetMapping("/{klijentId}")
    public ResponseEntity<Optional<Klijent>> getKlijentById(@PathVariable Integer klijentId) {

        Optional<Klijent> klijent = klijentService.findKlijentById(klijentId);
        return new ResponseEntity<>(klijent, HttpStatus.OK);
    }

    @GetMapping("")
    public Iterable<Klijent> getAllKlijenti() { return klijentService.findAllKlijenti(); }

    @PutMapping("/{klijentId}")
    public ResponseEntity<?> updateKlijentById(@Valid @RequestBody Klijent _klijent, @PathVariable Integer klijentId, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

        if (errorMap != null) return errorMap;

        Optional<Object> updatedKlijent = klijentService.findKlijentById(klijentId).map(klijent -> {
            klijent.setIme(_klijent.getIme());
            klijent.setPrezime(_klijent.getPrezime());
            klijent.setOib(_klijent.getOib());
            klijent.setBrojMob(_klijent.getBrojMob());
            klijent.setEmail(_klijent.getEmail());

            return klijentService.saveOrUpdateKlijent(klijent);
        });

        return new ResponseEntity<>(updatedKlijent, HttpStatus.OK);
    }

    @DeleteMapping("/{klijentId}")
    public  ResponseEntity<?> deleteKlijent(@PathVariable Integer klijentId) {

        klijentService.deleteKlijentById(klijentId);

        return  new ResponseEntity<>("Korisnik s ID-em " + klijentId + " je izbrisan.", HttpStatus.NO_CONTENT);
    }
}