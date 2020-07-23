package br.grupo01.itaumon.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.grupo01.itaumon.dao.EventoRepo;
import br.grupo01.itaumon.models.Evento;

@Component
public class EventoServiceImp implements IEventoService {

    @Autowired
    private EventoRepo repo;

    @Override
    public Evento buscarEventoPorId(int id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Evento> buscarEventosEntreDatas(Date inicio, Date termino) {
        return repo.findAllByDataBetween(inicio, termino);
    }
    
}