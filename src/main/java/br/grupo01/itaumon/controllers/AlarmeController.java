package br.grupo01.itaumon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.grupo01.itaumon.models.Alarme;
import br.grupo01.itaumon.services.IAlarmeService;

@RestController
@CrossOrigin("*")
public class AlarmeController {
    
    @Autowired
    private IAlarmeService servico;

    @GetMapping("/alarme/{id}")
    public ResponseEntity<Alarme> buscarPorId(@PathVariable int id) {
        Alarme alarme = servico.buscarAlarmePorId(id);
        if (alarme == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alarme);
    }

}