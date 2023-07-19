package com.br.desfio.challengebackend.depoimento;

public record DadosListagemDepoimento(Long id,String foto, String depoimento, String nome) {

    public DadosListagemDepoimento(Depoimento depoimento) {
        this(depoimento.getId(), depoimento.getFoto(), depoimento.getDepoimento(), depoimento.getNome());
    }
}
