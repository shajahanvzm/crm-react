package com.sha.crm.loader;

import com.sha.crm.entity.Contact;
import com.sha.crm.reposirtory.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbLoader implements CommandLineRunner {

    private final ContactRepository contactRepository;

    public DbLoader(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        contactRepository.save(new Contact("Sha", "Jahan", "shajahanvzm@gmail.com"));
    }
}
