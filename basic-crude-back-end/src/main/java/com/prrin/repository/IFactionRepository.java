package com.prrin.repository;

import com.prrin.model.Faction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFactionRepository extends JpaRepository<Faction, Integer> {
  Page<Faction> findByEnabled(boolean enabled, Pageable pageable);
}
