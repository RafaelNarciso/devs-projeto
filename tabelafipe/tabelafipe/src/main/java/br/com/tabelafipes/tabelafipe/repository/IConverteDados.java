package br.com.tabelafipes.tabelafipe.repository;

public interface IConverteDados {

    <T> T obterDados(String json,Class<T> classe);

}
