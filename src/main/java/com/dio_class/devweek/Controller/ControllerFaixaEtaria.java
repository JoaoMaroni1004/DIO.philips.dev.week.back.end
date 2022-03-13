package com.dio_class.devweek.Controller;

import com.dio_class.devweek.Entity.FaixaEtaria;
import com.dio_class.devweek.Repository.FaixaEtariaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerFaixaEtaria {
    private FaixaEtariaRepository frepository;

    public ControllerFaixaEtaria(FaixaEtariaRepository frepository) {
        this.frepository = frepository;
    }

    @GetMapping("/faixaetaria")
    public ResponseEntity<?> findAllFaixaEtaria(@PathVariable Long id){
        try {
            Optional<FaixaEtaria> unidOptional = frepository.findById(id);
            if (unidOptional.isPresent()) {
                FaixaEtaria faixaEtariaUnid = unidOptional.get();
                return new ResponseEntity<>(faixaEtariaUnid, HttpStatus.OK);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<FaixaEtaria> findByIdFaixaEtaria(@PathVariable Long id){
        try{
            Optional<FaixaEtaria> unidOptional = frepository.findById(id);
            if (unidOptional.isPresent()){
                FaixaEtaria faixaEtariaUnid = unidOptional.get();
                return new ResponseEntity<>(faixaEtariaUnid, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping ("faixaetaria/novo")
    public FaixaEtaria newFaixaEtaria(@RequestBody FaixaEtaria newFaixa){
        return frepository.save(newFaixa);
    }

    @DeleteMapping ("faixaetaria/remover/{id}")
    public void deleteFaixaEtaria(@PathVariable long id){
        frepository.deleteById(id);
    }
}
