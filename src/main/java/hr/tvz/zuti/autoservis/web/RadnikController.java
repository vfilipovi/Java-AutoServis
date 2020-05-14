package hr.tvz.zuti.autoservis.web;

import hr.tvz.zuti.autoservis.domain.Radnik;
import hr.tvz.zuti.autoservis.services.RadnikService;
import hr.tvz.zuti.autoservis.services.MapValidationErrorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/radnici")
public class RadnikController {

    @Autowired
    private RadnikService radnikService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewRadnik(@Valid @RequestBody Radnik _radnik, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

        if (errorMap != null) return errorMap;

        Radnik radnik = radnikService.saveOrUpdateRadnik(_radnik);
        //  ResponseEntity<> is short for ResponseEntity<Radnik>
        return new ResponseEntity<>(radnik, HttpStatus.CREATED);
    }

    @GetMapping("/{radnikId}")
    public ResponseEntity<Optional<Radnik>> getRadnikById(@PathVariable Integer radnikId) {

        Optional<Radnik> radnik = radnikService.findRadnikById(radnikId);
        return new ResponseEntity<>(radnik, HttpStatus.OK);
    }

    @GetMapping("")
    public Iterable<Radnik> getAllRadniki() { return radnikService.findAllRadniki(); }

    @PutMapping("/{radnikId}")
    public ResponseEntity<?> updateRadnikById(@Valid @RequestBody Radnik _radnik, @PathVariable Integer radnikId, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

        if (errorMap != null) return errorMap;

        Optional<Object> updatedRadnik = radnikService.findRadnikById(radnikId).map(radnik -> {
            radnik.setIme(_radnik.getIme());
            radnik.setPrezime(_radnik.getPrezime());
            radnik.setOib(_radnik.getOib());
            radnik.setIznosOsnovice(_radnik.getIznosOsnovice());
            radnik.setKoefPlace(_radnik.getKoefPlace());
            radnik.setStatusRadnogOdnosa(_radnik.getStatusRadnogOdnosa());
            radnik.setVrstaRadnogOdnosa(_radnik.getVrstaRadnogOdnosa());

            return radnikService.saveOrUpdateRadnik(radnik);
        });

        return new ResponseEntity<>(updatedRadnik, HttpStatus.OK);
    }

    @DeleteMapping("/{radnikId}")
    public  ResponseEntity<?> deleteRadnik(@PathVariable Integer radnikId) {

        radnikService.deleteRadnikById(radnikId);

        return  new ResponseEntity<>("Korisnik s ID-em " + radnikId + " je izbrisan.", HttpStatus.NO_CONTENT);
    }
}