package com.br.desfio.challengebackend.controller;

import com.br.desfio.challengebackend.depoimento.*;
import com.br.desfio.challengebackend.destino.DadosDetalhamentoDestino;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity cadastrar(@RequestBody DadosCadastroDepoimento dados, UriComponentsBuilder uriBuilder) {
        var depoimento = new Depoimento(dados);
        repository.save(depoimento);

        var uri = uriBuilder.path("depoimentos/{id}").buildAndExpand(depoimento.getDepoimento()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoDepoimento(depoimento));
    }

    @GetMapping(value = ("/depoimentos-home"))
    public ResponseEntity<Page<DadosListagemDepoimento>> listar(@PageableDefault(size = 3 ) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemDepoimento::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoDepoimentos dados) {
      var depoimento = repository.getReferenceById(dados.id());
      depoimento.atualizarInformacoes(dados);

      return ResponseEntity.ok(new DadosDetalhamentoDepoimento(depoimento));


    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var depoimento = repository.getReferenceById(id);
        depoimento.excluir();

        return ResponseEntity.ok(new DadosDetalhamentoDepoimento(depoimento));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var depoimento = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoDepoimento(depoimento));
    }

}
