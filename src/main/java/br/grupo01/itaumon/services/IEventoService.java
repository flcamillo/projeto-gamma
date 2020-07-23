package br.grupo01.itaumon.services;

import java.util.Date;
import java.util.List;

import br.grupo01.itaumon.models.Evento;

public interface IEventoService {
    
    public Evento buscarEventoPorId(int id);
    public List<Evento> buscarEventosEntreDatas(Date inicio, Date termino);

}