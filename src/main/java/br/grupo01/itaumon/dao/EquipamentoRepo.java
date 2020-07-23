package br.grupo01.itaumon.dao;

import org.springframework.data.repository.CrudRepository;

import br.grupo01.itaumon.models.Equipamento;

public interface EquipamentoRepo extends CrudRepository<Equipamento, Integer> {
    
}