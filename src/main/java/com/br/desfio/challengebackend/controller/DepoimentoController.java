package com.br.desfio.challengebackend.controller;

import com.br.desfio.challengebackend.depoimento.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("depoimentos")
public class DepoimentoController {

    @Autowired
    private DepoimentoRepository repository;

    Random idAleatorio = new Random();
    int idGerado = idAleatorio.nextInt(2);

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroDepoimento dados) {
        repository.save(new Depoimento(dados));
    }

    @GetMapping(value = ("/depoimentos-home"))
    public Page<DadosListagemDepoimento> listar(@PageableDefault(size = 3 ) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemDepoimento::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoDepoimentos dados) {
      var depoimento = repository.getReferenceById(dados.id());
      depoimento.atualizarInformacoes(dados);
    }

}
