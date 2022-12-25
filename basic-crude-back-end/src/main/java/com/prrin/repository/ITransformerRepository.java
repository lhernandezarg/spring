package com.prrin.repository;

import com.prrin.model.Transformer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransformerRepository
  extends JpaRepository<Transformer, Integer> {
  Page<Transformer> findByEnabled(boolean enabled, Pageable pageable);
}
