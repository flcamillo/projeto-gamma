package br.grupo01.itaumon.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.grupo01.itaumon.models.Evento;
import br.grupo01.itaumon.services.IEventoService;

@RestController
@CrossOrigin("*")
public class EventoController {
    
    @Autowired
    private IEventoService servico;

    @GetMapping("/evento/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable int id) {
        Evento evento = servico.buscarEventoPorId(id);
        if (evento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(evento);
    }

    @PostMapping("/evento/equipamento/entre")
    public ResponseEntity<List<Evento>> buscarEntreDatas(@RequestParam("inicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicio, @RequestParam("termino") @DateTimeFormat(pattern = "yyyy-MM-dd") Date termino) {
        List<Evento> eventos = servico.buscarEventosEntreDatas(inicio, termino);
        if (eventos == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(eventos);
    }

    @PostMapping("/evento/alarme/entre")
    public ResponseEntity<List<?>> buscarQuantidadePorAlarmeEntreDatas(@RequestParam("inicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicio, @RequestParam("termino") @DateTimeFormat(pattern = "yyyy-MM-dd") Date termino) {
        List<?> eventos = servico.buscarEventosPorAlarmeEntreDatas(inicio, termino);
        if (eventos == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(eventos);
    }

}