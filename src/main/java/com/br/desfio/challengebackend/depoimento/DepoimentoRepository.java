package com.br.desfio.challengebackend.depoimento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepoimentoRepository extends JpaRepository<Depoimento, Long> {
    Page<Depoimento> findAllByAtivoTrue(Pageable paginacao);
}
