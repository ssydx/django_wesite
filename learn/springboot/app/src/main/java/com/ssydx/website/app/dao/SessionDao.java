package com.ssydx.website.app.dao;

import org.springframework.data.repository.ListCrudRepository;

import com.ssydx.website.app.domain.Session;

public interface SessionDao extends ListCrudRepository<Session,String> {
    
}
