package com.br.desfio.challengebackend.destino;

public record DadosDetalhamentoDestino(Long id, String foto, Double preco, String nome ) {

    public DadosDetalhamentoDestino(Destino destino) {
        this(destino.getId(), destino.getFoto(), destino.getPreco(), destino.getNome());
    }
}
