package com.prrin.services.imp;

import com.prrin.model.Faction;
import com.prrin.repository.IFactionRepository;
import com.prrin.services.IFactionService;
import com.prrin.services.common.ServiceCrudeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class FactionService
  extends ServiceCrudeImpl<Faction, Integer>
  implements IFactionService {

  @Autowired
  private IFactionRepository repo;

  @Override
  public JpaRepository<Faction, Integer> getRepo() {
    return repo;
  }

  @Override
  public Faction setBase(Faction base, Faction o) {
    base.setFaction(o.getFaction());
    base.setEnabled(o.isEnabled());
    return base;
  }

  @Override
  public Page<Faction> setByEnabled(boolean enabled, Pageable pageable) {
    return repo.findByEnabled(enabled, pageable);
  }
}
