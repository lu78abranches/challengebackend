package com.br.desfio.challengebackend.depoimento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "depoimentos")
@Entity(name = "Depoimento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Depoimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foto;
    private String depoimento;
    private String nome;
    private boolean ativo;

    public Depoimento(DadosCadastroDepoimento dados) {
        this.ativo = true;
        this.foto = dados.foto();
        this.depoimento = dados.depoimento();
        this.nome = dados.nome();
    }

    public void atualizarInformacoes(DadosAtualizacaoDepoimentos dados) {

        if(dados.foto() != null) {
            this.foto = dados.foto();
        }
        if(dados.depoimento() != null) {
            this.depoimento = dados.depoimento();
        }
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
