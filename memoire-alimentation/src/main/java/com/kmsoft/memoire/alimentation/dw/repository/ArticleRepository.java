 package com.kmsoft.memoire.alimentation.dw.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kmsoft.memoire.alimentation.dw.model.Article;

@Repository
public class ArticleRepository implements IArticleRepository {

	@PersistenceContext
	private EntityManager em;

	public String saveArticle(Article art) {

		final String sql = "INSERT INTO article (id, codeArt, designationArt, prixVente) " + "VALUES(?1, ?2, ?3, ?4)";
		final Query query = this.em.createNativeQuery(sql);
		query.setParameter(1, art.getId());
		query.setParameter(2, art.getCodeArt());
		query.setParameter(3, art.getDesignationArt());
		query.setParameter(4, art.getPrixVente());
		int res = query.executeUpdate();
		return res >=1 ? "Réussie" : "echoué";
	}


	@Override
	@Transactional(noRollbackFor=Exception.class)
	public String saveManyArticle(List<Article> data) {
		String info = "";
			for (Article art : data) {
				info = this.saveArticle(art);
			}
			return info;
		
	}

}
