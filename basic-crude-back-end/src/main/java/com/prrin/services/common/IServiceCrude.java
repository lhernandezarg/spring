package com.prrin.services.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceCrude<T, ID> {
  T create(T t) throws Exception;

  int update(T t, ID id) throws Exception;

  int delete(ID id) throws Exception;

  T getById(ID id) throws Exception;

  Page<T> getByEnabled(boolean enabled, Pageable pageable) throws Exception;
}
