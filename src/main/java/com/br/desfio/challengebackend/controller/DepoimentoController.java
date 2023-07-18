package com.br.desfio.challengebackend.controller;

import com.br.desfio.challengebackend.depoimento.DadosCadastroDepoimento;
import com.br.desfio.challengebackend.depoimento.Depoimento;
import com.br.desfio.challengebackend.depoimento.DepoimentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("depoimentos")
public class DepoimentoController {

    @Autowired
    private DepoimentoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroDepoimento dados) {
        repository.save(new Depoimento(dados));
    }
}
