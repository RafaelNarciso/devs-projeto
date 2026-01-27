package br.com.autenticacao.gestaodeprojeto.security;

import br.com.autenticacao.gestaodeprojeto.model.Usuario;
import br.com.autenticacao.gestaodeprojeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String email) {
//        Usuario usuario = getUser(()-> usuarioService.obterPorEmail(email));
//        return usuario;
        return usuarioService.obterPorEmail(email).get();
    }

    public UserDetails obterUsuarioPorId(UUID id) {
        return usuarioService.obterPorEmail(String.valueOf(id)).get();
    }

//    private Usuario getUser(Supplier<Optional<Usuario>>supplier){
//        return supplier.get().orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
//    }

}
