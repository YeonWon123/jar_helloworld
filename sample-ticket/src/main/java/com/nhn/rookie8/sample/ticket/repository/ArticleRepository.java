package com.nhn.rookie8.sample.ticket.repository;

import com.nhn.rookie8.sample.ticket.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
