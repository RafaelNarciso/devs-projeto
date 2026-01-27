package com.tdd.projeto_teste_tdd.controller;

import com.tdd.projeto_teste_tdd.model.Produto;
import com.tdd.projeto_teste_tdd.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest
public class ProdutoControllerTest {

    @Autowired
    private ProdutoController produtoController;

    @MockitoBean
    private ProdutoService produtoService;

    @Autowired
    private MockMvc mockMvc;



    @BeforeEach
    void setup(){
        //aqui será executado antes de cada teste
        this.mockMvc = MockMvcBuilders.standaloneSetup(produtoController).build();
    }


    @Test
    void deve_retornar_status_200_quando_obter_todos_os_produtos() throws Exception{
        //implementar teste

        //Arrange
        List<Produto> produtos = new ArrayList<>();

        var requestBuilder = MockMvcRequestBuilders.get("/api/produtos");

        when(this.produtoService.obterTodos()).thenReturn(produtos);
        //ACT
        this.mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());//Assert

    }

}















