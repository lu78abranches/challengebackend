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

    public Depoimento(DadosCadastroDepoimento dados) {
        this.foto = dados.foto();
        this.depoimento = dados.depoimento();
        this.nome = dados.nome();
    }
}
