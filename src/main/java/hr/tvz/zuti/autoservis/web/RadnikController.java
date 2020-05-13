package hr.tvz.zuti.autoservis.web;

import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.domain.Radnik;
import hr.tvz.zuti.autoservis.services.MapValidationErrorService;
import hr.tvz.zuti.autoservis.services.RadnikService;

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


    public ResponseEntity<?> createNewRadnik(@Valid @RequestBody Radnik radnik, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

        if (errorMap != null) return errorMap;

        Radnik radnik1 = radnikService.saveOrUpdateRadnik(radnik);
        //  ResponseEntity<> is short for ResponseEntity<Radnik>
        return new ResponseEntity<>(radnik, HttpStatus.CREATED);
    }

    @GetMapping("/{radnikId}")
    public ResponseEntity<?> getRadnikById(@PathVariable Integer radnikId) {

        Optional<Radnik> radnik = radnikService.findRadnikById(radnikId);

        return new ResponseEntity<>(radnik, HttpStatus.OK);
    }

    @GetMapping("")
    public Iterable<Radnik> getAllRadnici() { return radnikService.findAllRadnici(); }

    @DeleteMapping("/{radnikId}")
    public  ResponseEntity<?> deleteRadnik(@PathVariable Integer radnikId) {

        radnikService.deleteRadnikById(radnikId);

        return  new ResponseEntity<>("Radnik s ID-em " + radnikId + " je izbrisan.", HttpStatus.OK);
    }
}