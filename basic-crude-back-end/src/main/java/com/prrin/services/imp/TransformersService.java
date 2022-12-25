package com.prrin.services.imp;

import com.prrin.model.Transformer;
import com.prrin.repository.ITransformerRepository;
import com.prrin.services.ITransformerService;
import com.prrin.services.common.ServiceCrudeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TransformersService
  extends ServiceCrudeImpl<Transformer, Integer>
  implements ITransformerService {

  @Autowired
  private ITransformerRepository repo;

  @Override
  public JpaRepository<Transformer, Integer> getRepo() {
    return repo;
  }

  @Override
  public Transformer setBase(Transformer base, Transformer o) {
    base.setName(o.getName());
    base.setImage_url(o.getImage_url());
    base.setEnabled(o.isEnabled());
    return null;
  }

  @Override
  public Page<Transformer> setByEnabled(boolean enabled, Pageable pageable) {
    return repo.findByEnabled(enabled, pageable);
  }
}
