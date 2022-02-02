package com.sha.crm.service;

import com.sha.crm.payloads.ContactDto;

import java.util.List;

public interface ContactService {
    ContactDto createContact(ContactDto contactDto);
    List<ContactDto> getAllContact();
    ContactDto getContactById(long id);
    ContactDto updateContact(long id, ContactDto contactDto);
    void deleteContactById(long id);
    void deleteAll();
}
