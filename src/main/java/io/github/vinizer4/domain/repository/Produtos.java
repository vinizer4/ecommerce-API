package io.github.vinizer4.domain.repository;

import io.github.vinizer4.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos  extends JpaRepository<Produto, Integer> {
}
