package com.website.api.Repository;

import org.springframework.data.repository.CrudRepository;
import com.website.api.Entity.Contact;
import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ContactRepository extends CrudRepository<Contact, Integer> {
    Optional<Contact> findByMail(String email);
}