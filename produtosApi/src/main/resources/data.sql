create table produtos (
    id UUID primary key,
    nome VARCHAR(100) not null,
    descricao TEXT,
    preco DECIMAL(18,2) not null,
    quantidadeEstoque INT not null,
    dataCriacao TIMESTAMP
);
