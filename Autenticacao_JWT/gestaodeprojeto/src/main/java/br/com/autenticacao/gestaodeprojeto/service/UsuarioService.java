package br.com.autenticacao.gestaodeprojeto.service;

import br.com.autenticacao.gestaodeprojeto.model.Usuario;
import br.com.autenticacao.gestaodeprojeto.repository.UsuarioRepository;
import br.com.autenticacao.gestaodeprojeto.security.JWTService;
import br.com.autenticacao.gestaodeprojeto.view.usuario.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService {

    private  static final  String hederprefix = "Bearer ";

    @Autowired
    private UsuarioRepository repositoryUsuario;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    public List<Usuario>obterTodosUsuarios(){
        return repositoryUsuario.findAll();
    }

    public Optional<Usuario> obterPorId(UUID id){
        return repositoryUsuario.findById(id);
    }

    public Optional<Usuario> obterPorEmail(String email){
        return repositoryUsuario.findByEmail(email);
    }



    public Usuario adicionar(Usuario usuario){
        usuario.setId(null);
            //*Aqui estou verificando se já existe um usuário com o email informado
        if (obterPorEmail(usuario.getEmail()).isPresent()){
            throw new RuntimeException("Já existe um usuário com este email : "+ usuario.getEmail());
        }
        //*Aqui estou codificando a senha do usuário antes de salvar no banco de dados
        String senha = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senha);
        return repositoryUsuario.save(usuario);
    }

    public LoginResponse logar(String email, String senha){
        // Aqui estou autenticando o usuário com o email e senha informados
        Authentication authentication = authenticationManager.authenticate(
                new org.springframework.security.authentication.
                        UsernamePasswordAuthenticationToken(email, senha, Collections.emptyList()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token =hederprefix + jwtService.gerarToken(authentication);

        Usuario usuario = repositoryUsuario.findByEmail(email).get();


        return new LoginResponse(token, usuario);
        }

}
