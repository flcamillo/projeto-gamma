package br.grupo01.itaumon.services;

import br.grupo01.itaumon.models.Usuario;

public interface IUsuarioService {
    
    public Usuario buscarUsuarioPorId(int id);
    public Usuario buscarUsuarioPorNomeOuRACF(Usuario usuario);

}