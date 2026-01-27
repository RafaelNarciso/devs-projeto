package br.com.compras.Produto.sevice;

import br.com.compras.Produto.exception.ResourceNotFoundException;
import br.com.compras.Produto.model.Produto;
import br.com.compras.Produto.repository.ProdutoRepository;
import br.com.compras.Produto.shared.ProdutoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoDTO> obterTodos() {

        List<Produto> produtos = produtoRepository.findAll();

        return produtos.stream()
                .map(produto -> new ModelMapper()
                .map(produto, ProdutoDTO.class))
                .collect(Collectors.toList());
    }


    public Optional<ProdutoDTO> obterPorId(UUID id) {

        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isEmpty()) {
            throw new ResourceNotFoundException("Produto não encontrado com o ID : " + id);
        }

        ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);
        return Optional.of(dto);

    }

    public ProdutoDTO adicionar(ProdutoDTO produtoDTO) {
        produtoDTO.setId(null);

        ModelMapper mapper = new ModelMapper();

        Produto produto = mapper.map(produtoDTO, Produto.class);

        produto = produtoRepository.save(produto);

        produtoDTO.setId(produto.getId());

        return produtoDTO;
    }



    public ProdutoDTO atualizar(UUID id, ProdutoDTO produtoDTO) {

        if (produtoRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("Produto não encontrado com o ID : ♥ " + id);
        }

        produtoDTO.setId(id);
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoDTO, Produto.class);
        produtoRepository.save(produto);

        return produtoDTO;
    }


    public void deletar(UUID id) {
        Optional<Produto>produto  = produtoRepository.findById(id);
        if (produto.isEmpty()) {
            throw new ResourceNotFoundException("Produto não encontrado com o ID : ♥ " + id);
        }
        produtoRepository.deleteById(id);
    }

}

