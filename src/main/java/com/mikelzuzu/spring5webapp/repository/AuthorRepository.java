package com.mikelzuzu.spring5webapp.repository;

import com.mikelzuzu.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
