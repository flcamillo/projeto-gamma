package br.grupo01.itaumon.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.grupo01.itaumon.models.Evento;

public interface EventoRepo extends CrudRepository<Evento, Integer> {
    
    List<Evento> findAllByDataBetween(Date inicio, Date termino);

    @Query(value = "SELECT t2.nome, COUNT(t1.num_seq) AS total FROM itmn_evento AS t1 LEFT JOIN itmn_alarme AS t2 ON t1.id_alarme = t2.id_alarme WHERE t1.data_evt BETWEEN :inicio AND :termino GROUP BY t2.nome", nativeQuery = true)
    List<Object[]> buscarEventosPorAlarmeEntreDatas(@Param("inicio") Date inicio, @Param("termino") Date termino);

}