package com.br.desfio.challengebackend.controller;



import com.br.desfio.challengebackend.destino.*;
import com.br.desfio.challengebackend.domain.destino.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("destinos")
public class DestinoController {

    @Autowired
    private DestinoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroDestino dados, UriComponentsBuilder uriBuilder) {
        var destino = new Destino(dados);
        repository.save(destino);

        var uri = uriBuilder.path("destinos/{id}").buildAndExpand(destino.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoDestino(destino));
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemDestino>> listar(Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemDestino::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(DadosAtualizacaoDestinos dados) {
        var destino = repository.getReferenceById(dados.id());
        destino.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoDestino(destino));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var destino = repository.getReferenceById(id);
        destino.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var destino = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoDestino(destino));
    }





}
