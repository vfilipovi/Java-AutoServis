package hr.tvz.zuti.autoservis.web;

import hr.tvz.zuti.autoservis.domain.Kvar;
import hr.tvz.zuti.autoservis.domain.Mjesto;
import hr.tvz.zuti.autoservis.services.KvarService;
import hr.tvz.zuti.autoservis.services.MapValidationErrorService;
import hr.tvz.zuti.autoservis.services.MjestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/mjesta")
public class MjestoController {

    @Autowired
    private MjestoService mjestoService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewMjesto(@Valid @RequestBody Mjesto mjesto, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

        if (errorMap != null) return errorMap;

        Mjesto mjesto1 = mjestoService.saveOrUpdateMjesto(mjesto);
        //  ResponseEntity<> is short for ResponseEntity<Klijent>
        return new ResponseEntity<>(mjesto, HttpStatus.CREATED);
    }

    @GetMapping("/{mjestoId}")
    public ResponseEntity<?> getMjestoById(@PathVariable Integer mjestoId) {

        Optional<Mjesto> mjesto = mjestoService.findMjestoById(mjestoId);

        return new ResponseEntity<>(mjesto, HttpStatus.OK);
    }

    ///Nisu sva mjesta implementirana
    /*@GetMapping("")
    public Iterable<Mjesto> getAllMjesta() {
        return mjestoService.findAllMjesta();
    }
    */


}
