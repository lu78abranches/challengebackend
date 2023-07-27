package com.br.desfio.challengebackend.domain.depoimento;

public record DadosDetalhamentoDepoimento(Long id, String foto, String depoimento, String nome) {

    public DadosDetalhamentoDepoimento(Depoimento depoimento) {
        this(depoimento.getId(), depoimento.getFoto(), depoimento.getDepoimento(), depoimento.getNome());
    }
}
