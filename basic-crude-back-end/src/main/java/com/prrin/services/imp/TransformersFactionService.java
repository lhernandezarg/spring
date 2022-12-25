package com.prrin.services.imp;

import com.prrin.model.TransformersFaction;
import com.prrin.model.TransformersFactionId;
import com.prrin.repository.ITransformersFactionRepository;
import com.prrin.services.ITransformerFactionService;
import com.prrin.services.common.ServiceCrudeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TransformersFactionService
  extends ServiceCrudeImpl<TransformersFaction, TransformersFactionId>
  implements ITransformerFactionService {

  @Autowired
  private ITransformersFactionRepository repo;

  @Override
  public JpaRepository<TransformersFaction, TransformersFactionId> getRepo() {
    return repo;
  }

  @Override
  public TransformersFaction setBase(
    TransformersFaction base,
    TransformersFaction o
  ) {
    base.setFaction(o.getFaction());
    base.setTransformer(o.getTransformer());
    base.setEnabled(o.isEnabled());
    return base;
  }

  @Override
  public Page<TransformersFaction> setByEnabled(
    boolean enabled,
    Pageable pageable
  ) {
    return repo.findByEnabled(enabled, pageable);
  }
}
