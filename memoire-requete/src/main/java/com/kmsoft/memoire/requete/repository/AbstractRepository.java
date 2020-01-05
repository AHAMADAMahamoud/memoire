
package com.kmsoft.memoire.requete.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@SuppressWarnings("unchecked")
public class AbstractRepository<T extends Object> {

	@PersistenceContext
	public EntityManager em;

	public T findOne(Integer idArt, T t) {
		return (T) em.find(t.getClass(), idArt);
	}
	
	public T findOneTmp(Integer idArt, T t) {
		return (T) em.find(t.getClass(), idArt);
	}
	
	public T findOne(long id, T t) {
		return (T) em.find(t.getClass(), id);
	}

	public List<T> findAll(T t) {
		final StringBuilder sb = new StringBuilder();

		sb.append("SELECT t FROM ").append(t.getClass().getCanonicalName()).append(" t");

		List<T> emps = (List<T>) em.createQuery(sb.toString(), t.getClass()).getResultList();
		return emps;
	}

	public T findByColumn(final String colunValue, final String columnName, T t) {
		final StringBuilder sb = new StringBuilder();
		sb.append("SELECT t FROM ").append(t.getClass().getCanonicalName()).append(" t WHERE ").append(columnName)
				.append("=").append("'").append(colunValue).append("'");
		List<T> list = (List<T>) em.createQuery(sb.toString(), t.getClass()).getResultList();
		if (!list.isEmpty())
			return list.get(0);
		return null;
	}

	public T update(T t) {

		return em.merge(t);
	}

	public void delete(Long id, T t) {
		this.em.remove(this.findOne(id, t));
	}

	@Transactional
	public String saveObject(T t) {
		StringBuilder sb = new StringBuilder();
		sb.append("Opération ");
		try {
			em.merge(t);
			sb.append("effectuée ");
		} catch (TransactionRequiredException | IllegalArgumentException e) {
			sb.append("échouée ");
		}
		return sb.toString();
	}

	@Transactional(rollbackFor = Exception.class)
	public String saveMany(List<T> data) {
		String info = "";
		for (T t : data) {
			info = this.saveObject(t);
		}
		return info;
	}

	public String save(T t) {
		return this.saveObject(t);
	}

	public boolean ifExist(T t, String clause) {

		try {
			final StringBuilder sb = new StringBuilder();
			sb.append("SELECT t FROM ").append(t.getClass().getCanonicalName()).append(" t ").append(clause);
			List<T> results = (List<T>) em.createQuery(sb.toString(), t.getClass()).getResultList();
			if (!results.isEmpty()) {
				T ob = (T) results.get(0);
				if (ob != null)
					return true;
			}
		} catch (NoResultException e) {
			return false;
		}
		return false;
	}

	

}
