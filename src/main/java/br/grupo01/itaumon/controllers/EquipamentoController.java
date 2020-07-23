package br.grupo01.itaumon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.grupo01.itaumon.models.Equipamento;
import br.grupo01.itaumon.services.IEquipamentoService;

@RestController
@CrossOrigin("*")
public class EquipamentoController {
    
    @Autowired
    private IEquipamentoService servico;

    @GetMapping("/equipamento/{id}")
    public ResponseEntity<Equipamento> buscarPorId(@PathVariable int id) {
        Equipamento equipamento = servico.buscarEquipamentoPorId(id);
        if (equipamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipamento);
    }

}