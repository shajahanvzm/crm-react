package com.sha.crm.service.impl;

import com.sha.crm.entity.Contact;
import com.sha.crm.exception.ResourceNotFoundException;
import com.sha.crm.payloads.ContactDto;
import com.sha.crm.reposirtory.ContactRepository;
import com.sha.crm.service.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ModelMapper mapper;

    public ContactServiceImpl(ContactRepository contactRepository, ModelMapper mapper) {
        this.contactRepository = contactRepository;
        this.mapper = mapper;
    }

    @Override
    public ContactDto createContact(ContactDto contactDto) {
        Contact contact = mapper.map(contactDto, Contact.class);
        return mapper.map(contactRepository.save(contact), ContactDto.class);
    }

    @Override
    public List<ContactDto> getAllContact() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream().map(contact -> mapper.map(contact,ContactDto.class)).collect(Collectors.toList());
    }

    @Override
    public ContactDto getContactById(long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Contact","Id",id));
        return mapper.map(contact, ContactDto.class);

    }

    @Override
    public ContactDto updateContact(long id, ContactDto contactDto) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Contact","Id",id));
        contact.setFirstName(contactDto.getFirstName());
        contact.setLastName(contactDto.getLastName());
        contact.setEmail(contactDto.getEmail());
        Contact updatedContact = contactRepository.save(contact);
        return mapper.map(updatedContact, ContactDto.class);
    }

    @Override
    public void deleteContactById(long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Contact","Id",id));
        contactRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
            contactRepository.deleteAll();
    }
}
