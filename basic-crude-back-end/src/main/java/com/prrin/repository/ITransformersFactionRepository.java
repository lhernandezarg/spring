package com.prrin.repository;

import com.prrin.model.TransformersFaction;
import com.prrin.model.TransformersFactionId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransformersFactionRepository
  extends JpaRepository<TransformersFaction, TransformersFactionId> {
  Page<TransformersFaction> findByEnabled(boolean enabled, Pageable pageable);
}
