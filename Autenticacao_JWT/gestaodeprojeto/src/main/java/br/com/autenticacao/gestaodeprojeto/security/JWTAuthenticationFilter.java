package br.com.autenticacao.gestaodeprojeto.security;

import br.com.autenticacao.gestaodeprojeto.model.Usuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.*;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JWTService jwtService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    //*-*Metodo que vai interceptar todas as requisições HTTP
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = obterToken(request);
        Optional <UUID> idUsuario = jwtService.obterIdUsuarioDoToken(token);

        if (!idUsuario.isPresent()) {


            UserDetails usuario = (Usuario) customUserDetailsService.obterUsuarioPorId(idUsuario.get());

            // Aqui estamos criando o objeto de autenticação do Spring Security
            UsernamePasswordAuthenticationToken autenticacao =
                    new UsernamePasswordAuthenticationToken(usuario, null, Collections.emptyList());

            //*-*Aqui estamos dizendo que a autenticação foi bem sucedida*/
            autenticacao.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            //Agora estamos configurando o contexto de segurança do Spring Security
            SecurityContextHolder.getContext().setAuthentication(autenticacao);

        }
        // metodo padrao para continuar a cadeia de filtros
        filterChain.doFilter(request, response);

    }



    private String obterToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if (StringUtils.hasText(token)){
            return null;
        }
        return token.substring( 7);
    }
}
