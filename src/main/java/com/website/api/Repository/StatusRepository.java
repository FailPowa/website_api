package com.website.api.Repository;

import org.springframework.data.repository.CrudRepository;
import com.website.api.Entity.Status;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface StatusRepository extends CrudRepository<Status, Integer> {

}