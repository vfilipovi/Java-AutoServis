package hr.tvz.zuti.autoservis.web;

import hr.tvz.zuti.autoservis.domain.Mjesto;
import hr.tvz.zuti.autoservis.services.MapValidationErrorService;
import hr.tvz.zuti.autoservis.services.MjestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/mjesta")
public class MjestoController {

    @Autowired
    private MjestoService mjestoService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Secured("ROLE_ADMIN")
    @PostMapping("")
    public ResponseEntity<?> createNewMjesto(@Valid @RequestBody Mjesto _mjesto, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

        if (errorMap != null) return errorMap;

        Mjesto mjesto = mjestoService.saveOrUpdateMjesto(_mjesto);
        return new ResponseEntity<>(mjesto, HttpStatus.CREATED);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/{mjestoId}")
    public ResponseEntity<Optional<Mjesto>> getMjestoById(@PathVariable Integer mjestoId) {

        Optional<Mjesto> mjesto = mjestoService.findMjestoById(mjestoId);

        return new ResponseEntity<>(mjesto, HttpStatus.OK);
    }

    @GetMapping("")
    public Iterable<Mjesto> getAllMjesta() { return mjestoService.findAllMjesta(); }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{mjestoId}")
    public ResponseEntity<?> updateMjestoById(@Valid @RequestBody Mjesto _mjesto, @PathVariable Integer mjestoId, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

        if (errorMap != null) return errorMap;

        Optional<Mjesto> updatedMjesto = mjestoService.findMjestoById(mjestoId).map(mjesto -> {
            mjesto.setNazivMjesta(_mjesto.getNazivMjesta());

            return mjestoService.saveOrUpdateMjesto(mjesto);
        });

        return new ResponseEntity<>(updatedMjesto, HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{mjestoId}")
    public ResponseEntity<?> deleteMjesto(@PathVariable Integer mjestoId) {

        mjestoService.deleteMjestotById(mjestoId);

        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}