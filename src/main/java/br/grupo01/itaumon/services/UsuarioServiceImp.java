package br.grupo01.itaumon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.grupo01.itaumon.dao.UsuarioRepo;
import br.grupo01.itaumon.models.Usuario;

@Component
public class UsuarioServiceImp implements IUsuarioService {

    @Autowired
    private UsuarioRepo repo;

    @Override
    public Usuario buscarUsuarioPorId(int id) {
        return repo.findById(id).get();
    }

    @Override
    public Usuario buscarUsuarioPorNomeOuRACF(Usuario usuario) {
        if (!usuario.getNome().equals("")) {
            return repo.findByNomeAndSenha(usuario.getNome(), usuario.getSenha());
        }
        return repo.findByRacfAndSenha(usuario.getRacf(), usuario.getSenha());
    }
    
}