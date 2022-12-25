package com.prrin.services.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class ServiceCrudeImpl<T, ID> implements IServiceCrude<T, ID> {

	public abstract JpaRepository<T, ID> getRepo();

	public abstract T setBase(T base, T o);

	public abstract Page<T> setByEnabled(boolean enabled, Pageable pageable);

	@Override
	public T create(T t) throws Exception {
		try {
			t = getRepo().saveAndFlush(t);
			return t;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int delete(ID id) throws Exception {
		try {
			getRepo().deleteById(id);
			return 200;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Page<T> getByEnabled(boolean enabled, Pageable pageable) throws Exception {
		try {
			return setByEnabled(enabled, pageable);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public T getById(ID id) throws Exception {
		try {
			return getRepo().findById(id).orElse(null);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int update(T t, ID id) throws Exception {
		try {
			T base = getById(id);

			if (base == null)
				return 204;

			base = setBase(base, t);

			getRepo().save(base);
			return 200;
		} catch (Exception e) {
			throw e;
		}
	}
}
