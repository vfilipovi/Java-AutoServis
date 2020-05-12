package hr.tvz.zuti.autoservis.web;

import hr.tvz.zuti.autoservis.domain.Radnik;
import hr.tvz.zuti.autoservis.services.MapValidationErrorService;
import hr.tvz.zuti.autoservis.services.RadnikService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}