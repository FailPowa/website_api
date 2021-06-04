package com.website.api.Controller;

import org.springframework.stereotype.Controller;
import com.website.api.Repository.ContactRepository;
import com.website.api.Entity.Contact;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@RequestMapping(path="/contact")
public class ContactController {
  @Autowired
  private ContactRepository contactRepository;

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Contact> getAll() {
    return contactRepository.findAll();
  }

  @CrossOrigin
  @PostMapping
  public @ResponseBody Contact addContact(@RequestBody Contact newContact) {
    return contactRepository.findByMail(newContact.getMail()).map(contact -> {
        contact.setName(newContact.getName());
        contact.setFirstname(newContact.getFirstname());
        contact.setMail(newContact.getMail());
        contact.setBusiness(newContact.getBusiness());
        contact.setMessage(newContact.getMessage());
        return contactRepository.save(contact);
    }).orElseGet(() -> {
      Contact c = new Contact();
      c.setName(newContact.getName());
      c.setFirstname(newContact.getFirstname());
      c.setMail(newContact.getMail());
      c.setBusiness(newContact.getBusiness());
      c.setMessage(newContact.getMessage());
      return contactRepository.save(c);
    });
  }

}