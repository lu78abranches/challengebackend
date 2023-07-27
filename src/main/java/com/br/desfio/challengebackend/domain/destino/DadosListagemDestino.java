package com.br.desfio.challengebackend.domain.destino;

public record DadosListagemDestino(Long id, String foto, Double preco, String nome) {

    public DadosListagemDestino(Destino destino) {
        this(destino.getId(), destino.getFoto(), destino.getPreco(), destino.getNome());
    }
}
