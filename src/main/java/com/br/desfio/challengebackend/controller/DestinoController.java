package com.br.desfio.challengebackend.controller;

import com.br.desfio.challengebackend.depoimento.DadosListagemDepoimento;
import com.br.desfio.challengebackend.depoimento.Depoimento;
import com.br.desfio.challengebackend.destino.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("destinos")
public class DestinoController {

    @Autowired
    private DestinoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroDestino dados) {
        repository.save(new Destino(dados));
    }

    @GetMapping
    public Page<DadosListagemDestino> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemDestino::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(DadosAtualizacaoDestinos dados) {
        var destino = repository.getReferenceById(dados.id());
        destino.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var destino = repository.getReferenceById(id);
        destino.excluir();
    }





}
