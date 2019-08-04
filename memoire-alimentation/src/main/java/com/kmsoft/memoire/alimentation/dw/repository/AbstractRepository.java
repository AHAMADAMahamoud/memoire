
package com.kmsoft.memoire.alimentation.dw.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SuppressWarnings("unchecked")
public class AbstractRepository<T extends Object> {

	@PersistenceContext
	private EntityManager em;

	public T findOne(Long id, T t) {
		return (T) em.find(t.getClass(), id);
	}

	

	public List<T> findAll(T t) {
		final StringBuilder sb = new StringBuilder();

		sb.append("SELECT t FROM ").append(t.getClass().getCanonicalName()).append(" t");

		List<T> emps = (List<T>) em.createQuery(sb.toString(), t.getClass()).getResultList();
		return emps;
	}

	public T update(T t) {

		return em.merge(t);
	}

	public void delete(Long id, T t) {
		this.em.remove(this.findOne(id, t));
	}

	
	public String save(T t) {
		StringBuilder sb = new StringBuilder();
		sb.append("Opération ");
		try {
			em.persist(t);
			sb.append("effectuée ");
		} catch (TransactionRequiredException | IllegalArgumentException e) {
			sb.append("échouée ");
		}
		return sb.toString();
	}
	@Transactional
	public String saveMany(T t) {
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
	@Transactional(noRollbackFor=Exception.class)
	public String saveMany(List<T> data) {
		String info = "";
		for (T t : data) {
			info = this.save(t);
		}
		return info;
	}
	
	@Transactional(noRollbackFor=Exception.class)
	public String saveManyByForceID(List<T> data) {
		String info = "";
		for (T t : data) {
			info = this.saveMany(t);
		}
		return info;
	}
}
