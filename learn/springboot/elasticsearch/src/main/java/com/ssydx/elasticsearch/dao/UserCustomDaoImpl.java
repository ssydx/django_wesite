package com.ssydx.elasticsearch.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Repository;

import com.ssydx.elasticsearch.domain.User;

@Repository
public class UserCustomDaoImpl implements UserCustomDao {
    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Override
    public List<User> customQuery(String name, String desc) {
        Criteria criteria = new Criteria("name").is(name).and("desc").is(desc);
        CriteriaQuery query = new CriteriaQuery(criteria);
        SearchHits<User> searchHits = elasticsearchOperations.search(query, User.class);
        return searchHits.getSearchHits().stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
    }
}
