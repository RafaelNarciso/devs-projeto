package br.com.cinematoorafael.cinemamaisvoce.repository;

public interface IConverteDados {

    <T> T obterDados(String json,Class<T> classe);

}
