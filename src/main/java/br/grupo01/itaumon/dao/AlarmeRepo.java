package br.grupo01.itaumon.dao;

import org.springframework.data.repository.CrudRepository;

import br.grupo01.itaumon.models.Alarme;

public interface AlarmeRepo extends CrudRepository<Alarme, Integer> {
    
}