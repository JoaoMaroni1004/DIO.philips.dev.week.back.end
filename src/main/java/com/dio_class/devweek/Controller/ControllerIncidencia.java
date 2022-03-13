package com.dio_class.devweek.Controller;

import com.dio_class.devweek.Repository.IncidenciaRepository;
import com.dio_class.devweek.Entity.IncidenciaExame;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerIncidencia {
    private final IncidenciaRepository ocRepository;

    public ControllerIncidencia(IncidenciaRepository ocRepository) {
        this.ocRepository = ocRepository;
    }

    @GetMapping("/incidencias")
    public ResponseEntity<List<IncidenciaExame>> findIncidencias(){
        List<IncidenciaExame> listaIncidencia = ocRepository.findAll();
        if (listaIncidencia.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        return new ResponseEntity<>(listaIncidencia, HttpStatus.OK);
    }

    @GetMapping("/incidencia/{id}")
    public ResponseEntity<IncidenciaExame> findIncidenciaById(@PathVariable Long id){
        Optional<IncidenciaExame> incidenciaOptional = ocRepository.findById(id);
        if (incidenciaOptional.isPresent()){
            IncidenciaExame incidenciaUnid = incidenciaOptional.get();
            return new ResponseEntity<>(incidenciaUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
