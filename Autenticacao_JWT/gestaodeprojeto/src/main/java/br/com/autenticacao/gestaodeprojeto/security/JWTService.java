package br.com.autenticacao.gestaodeprojeto.security;

import br.com.autenticacao.gestaodeprojeto.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Component
public class JWTService {

    private static final String chavePrivada = "secretkey";

    public String gerarToken(Authentication authentication) {

        int tempoExpiracao = 3600000; // 1 hora em milissegundos

        // Data de expiração do token
        Date dataExpiracao = new Date(new Date().getTime() + tempoExpiracao);

        //aqui foi feito o cast para pegar o usuario logado(Usuario)
        Usuario usuario = (Usuario)authentication.getPrincipal();//aqui estou pegano o usuario logado

        //! Aqui estamos criando o token JWT
        return Jwts.builder()
                .setSubject(usuario.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS512, chavePrivada)//assinatura do token criptografada
                .compact();
    }


    public Optional<UUID> obterIdUsuarioDoToken(String token) {
        try {
            Claims claims = parse(token).getBody();
            return Optional.ofNullable(UUID.fromString(claims.getSubject()));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    //Metodo que sabe descobrir se o token é valido ou nao
    private Jws<Claims>parse(String token) {
        return Jwts.parser()
                .setSigningKey(chavePrivada)
                .parseClaimsJws(token);
    }


}

