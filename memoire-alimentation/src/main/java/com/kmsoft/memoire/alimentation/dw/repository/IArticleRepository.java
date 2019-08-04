package com.kmsoft.memoire.alimentation.dw.repository;

import java.util.List;

import com.kmsoft.memoire.alimentation.dw.model.Article;

public interface IArticleRepository {

	
	String saveManyArticle(List<Article> data);

}