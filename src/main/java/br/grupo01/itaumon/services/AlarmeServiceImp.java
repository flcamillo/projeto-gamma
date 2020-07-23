package br.grupo01.itaumon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.grupo01.itaumon.dao.AlarmeRepo;
import br.grupo01.itaumon.models.Alarme;

@Component
public class AlarmeServiceImp implements IAlarmeService {

    @Autowired
    private AlarmeRepo repo;

    @Override
    public Alarme buscarAlarmePorId(int id) {
        return repo.findById(id).get();
    }
    
}