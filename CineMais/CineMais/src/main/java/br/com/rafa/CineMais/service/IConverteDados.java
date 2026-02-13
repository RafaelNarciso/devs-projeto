package br.com.rafa.CineMais.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
