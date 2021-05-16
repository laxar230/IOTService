package com.iotproject.iotservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReadingRepository extends CrudRepository<Reading, Long> {
}
