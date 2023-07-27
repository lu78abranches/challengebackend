package com.br.desfio.challengebackend.destino;

import com.br.desfio.challengebackend.depoimento.DadosAtualizacaoDepoimentos;
import com.br.desfio.challengebackend.depoimento.DadosCadastroDepoimento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table (name = "destinos")
@Entity(name = "Destino")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foto;
    private String nome;
    private Double preco;
    private boolean ativo;

    public Destino(DadosCadastroDestino dados) {
        this.ativo = true;
        this.foto = dados.foto();
        this.preco = dados.preco();
        this.nome = dados.nome();
    }

    public void atualizarInformacoes(DadosAtualizacaoDestinos dados) {

        if(dados.foto() != null) {
            this.foto = dados.foto();
        }
        if(dados.preco() != null) {
            this.preco = dados.preco();
        }
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}






