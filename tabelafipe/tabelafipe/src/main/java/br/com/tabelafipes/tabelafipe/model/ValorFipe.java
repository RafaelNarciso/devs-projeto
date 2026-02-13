package br.com.tabelafipes.tabelafipe.model;

public record ValorFipe( int TipoVeiculo,
                         String Valor,
                         String Marca,
                         String Modelo,
                         int AnoModelo,
                         String Combustivel,
                         String CodigoFipe,
                         String MesReferencia,
                         String SiglaCombustivel
) {
    @Override
    public String toString() {
        return """
            ===== TABELA FIPE =====
            Veículo       : %s
            Marca         : %s
            Modelo        : %s
            Ano           : %d
            Combustível   : %s
            Código FIPE   : %s
            Valor         : %s
            Referência    : %s
            ======================
            """.formatted(
                TipoVeiculo == 1 ? "Carro" :
                        TipoVeiculo == 2 ? "Moto" : "Caminhão",
                Marca,
                Modelo,
                AnoModelo,
                Combustivel,
                CodigoFipe,
                Valor,
                MesReferencia
        );
    }
}
