package br.com.autenticacao.gestaodeprojeto.view.controller;

import br.com.autenticacao.gestaodeprojeto.model.Usuario;
import br.com.autenticacao.gestaodeprojeto.service.UsuarioService;
import br.com.autenticacao.gestaodeprojeto.view.usuario.LoginRequest;
import br.com.autenticacao.gestaodeprojeto.view.usuario.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService servicoUsuario;

    @GetMapping
    public List<Usuario> obterTodosUsuarios(){
        return servicoUsuario.obterTodosUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> obter(@PathVariable("id") UUID id) {
        return servicoUsuario.obterPorId(id);
    }

    @PostMapping()
    public Usuario adicionar(@RequestBody Usuario usuario){
        return servicoUsuario.adicionar(usuario);
    }
    @PostMapping("/login")
    public LoginResponse login (@RequestBody LoginRequest request){
        return servicoUsuario.logar(request.getEmail(), request.getSenha());
    }






}
