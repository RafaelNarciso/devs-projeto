package br.com.marketcar.veiculos.view.model;

import br.com.marketcar.veiculos.enumerated.Categoria;
import br.com.marketcar.veiculos.enumerated.Marcas;
import br.com.marketcar.veiculos.enumerated.TipoCombustivel;
import br.com.marketcar.veiculos.enumerated.TipoVeiculo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;
import java.util.UUID;

public class VeiculoModeloInclusao {

    private UUID id = UUID.randomUUID();
    private Marcas marca;
    private TipoVeiculo tipoVeiculo;
    private Categoria categoria;
    private TipoCombustivel tipoCombustivel;
    private String modelo;
    private Year anoFabricacao;
    private String cor;
    private String placa;
    private BigDecimal valor;
    private String descricao;
    private boolean disponivel = true;


    //#region Getters e Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public Marcas getMarca() { return marca; }
    public void setMarca(Marcas marca) { this.marca = marca; }

    public TipoVeiculo getTipoVeiculo() { return tipoVeiculo; }
    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) { this.tipoVeiculo = tipoVeiculo; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public TipoCombustivel getTipoCombustivel() { return tipoCombustivel; }
    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) { this.tipoCombustivel = tipoCombustivel; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public Year getAnoFabricacao() { return anoFabricacao; }
    public void setAnoFabricacao(Year anoFabricacao) { this.anoFabricacao = anoFabricacao; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa != null ? placa.toUpperCase() : null; }

    public BigDecimal getValor() { return valor; }

    public void setValor(BigDecimal valor) {
        this.valor = (valor == null) ? null : valor.setScale(2, RoundingMode.HALF_UP);
    }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    //#endregion

}
