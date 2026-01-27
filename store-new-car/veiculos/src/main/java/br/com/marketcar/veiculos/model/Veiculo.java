package br.com.marketcar.veiculos.model;

import br.com.marketcar.veiculos.enumerated.Categoria;
import br.com.marketcar.veiculos.enumerated.Marcas;
import br.com.marketcar.veiculos.enumerated.TipoCombustivel;
import br.com.marketcar.veiculos.enumerated.TipoVeiculo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;
import java.util.UUID;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id = UUID.randomUUID();

    @NotNull
    private Marcas marca;

    @NotNull
    private TipoVeiculo tipoVeiculo;

    @NotNull
    private Categoria categoria;

    @NotNull
    private TipoCombustivel tipoCombustivel;

    @NotBlank
    @Size(max = 100)
    private String modelo;

    @NotNull
    private Year anoFabricacao;

    @NotBlank
    @Size(max = 30)
    private String cor;

    // Aceita AAA1234 (antigo) ou AAA1A23 (Mercosul)
    @Pattern(
            regexp = "^(?:[A-Z]{3}\\d{4}|[A-Z]{3}\\d[A-Z]\\d{2})$",
            message = "Placa inválida (use padrão antigo AAA1234 ou Mercosul AAA1A23)"
    )
    private String placa;

    @NotNull
    @Digits(integer = 12, fraction = 2)
    @Positive
    private BigDecimal valor;

    @Size(max = 500)
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
