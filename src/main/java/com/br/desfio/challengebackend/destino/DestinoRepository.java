package com.br.desfio.challengebackend.destino;

import com.br.desfio.challengebackend.depoimento.Depoimento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinoRepository extends JpaRepository <Destino, Long> {
    Page<Destino> findAllByAtivoTrue(Pageable paginacao);
}
