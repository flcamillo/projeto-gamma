package br.grupo01.itaumon.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.grupo01.itaumon.models.Evento;

public interface EventoRepo extends CrudRepository<Evento, Integer> {
    
    List<Evento> findAllByDataBetween(Date inicio, Date termino);
    
}