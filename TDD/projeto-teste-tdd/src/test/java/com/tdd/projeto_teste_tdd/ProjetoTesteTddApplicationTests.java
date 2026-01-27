package com.tdd.projeto_teste_tdd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjetoTesteTddApplicationTests {

	@Test
	void contextLoads() {
	}

}
/**
 * Criar uma api de vendas
 * vendas igual ou acima de 1000 tem 15% de desconto
 * vendas entre 500 e 999 tem 10% de desconto
 * vendas entre 200 e 499 tem 5% de desconto
 * vendas abaixo de 200 não tem desconto
 *
 * class comissao que calcule a comissao
 *
 * */