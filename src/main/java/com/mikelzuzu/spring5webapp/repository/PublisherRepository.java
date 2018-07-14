package com.mikelzuzu.spring5webapp.repository;

import com.mikelzuzu.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
