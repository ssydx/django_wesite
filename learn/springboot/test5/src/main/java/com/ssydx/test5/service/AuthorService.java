package com.ssydx.test5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ssydx.test5.dto.AuthorDto;
import com.ssydx.test5.entity.AuthorEntity;
import com.ssydx.test5.repository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    public Long addAuthor(AuthorDto authorDto) {
        AuthorEntity authorEntity = new AuthorEntity().setName(authorDto.getName()).setAge(authorDto.getAge());
        authorRepository.save(authorEntity);
        return authorEntity.getId();
    }
    public List<AuthorEntity> getAllAuthor() {
        return authorRepository.findAll();
    }
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
    private Page<AuthorEntity> page(int page,int size)  {
        Pageable pageable = PageRequest.of(page, size);
        return authorRepository.findAll(pageable);
    }
    public Page<AuthorEntity> getAllAuthorPage(int page,int size) {
        return page(page, size);
    }
}
