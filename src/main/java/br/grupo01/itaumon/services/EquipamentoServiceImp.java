package br.grupo01.itaumon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.grupo01.itaumon.dao.EquipamentoRepo;
import br.grupo01.itaumon.models.Equipamento;

@Component
public class EquipamentoServiceImp implements IEquipamentoService {

    @Autowired
    private EquipamentoRepo repo;

    @Override
    public Equipamento buscarEquipamentoPorId(int id) {
        return repo.findById(id).get();
    }
    
}