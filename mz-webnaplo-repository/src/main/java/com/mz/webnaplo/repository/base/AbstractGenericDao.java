package com.mz.webnaplo.repository.base;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.EmptyResultDataAccessException;

public abstract class AbstractGenericDao<T> implements InterfaceGenericDao<T> {

	private Class<T> type;

	@PersistenceContext
	protected EntityManager entityManager;

	// private static final Logger logger = LoggerFactory.getLogger(AbstractGenericDao.class);

	public AbstractGenericDao(Class<T> type) {
		this.type = (Class<T>) type;
	}

	public T persist(final T t) {
		this.entityManager.persist(t);
		return t;
	}

	public T merge(T t) {
		this.entityManager.merge(t);
		return t;
	}

	public T remove(T t) {
		this.entityManager.remove(t);
		return t;
	}

	public T findById(final Object id) {
		return (T) this.entityManager.find(type, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return this.entityManager.createQuery("FROM " + type.getName()).getResultList();
	}

	@SuppressWarnings("unchecked")
	public T findByCustomField(String key, String value) throws NoResultException, EmptyResultDataAccessException {
		Query query = this.entityManager.createQuery("FROM " + type.getSimpleName() + " u WHERE u." + key + " = :value").setParameter("value", value);
		return (T) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<T> runCustomQuery(Query query) {
		return query.getResultList();
	}
}
