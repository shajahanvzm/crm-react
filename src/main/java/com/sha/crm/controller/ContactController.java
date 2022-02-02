package com.sha.crm.controller;

import com.sha.crm.payloads.ContactDto;
import com.sha.crm.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact")
@CrossOrigin(origins = "http://localhost:3000/")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<ContactDto> createContact(@RequestBody ContactDto contactDto){
        return new ResponseEntity<>(contactService.createContact(contactDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContactDto>> getAllContact(){
        return ResponseEntity.ok(contactService.getAllContact());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable long id){
        return ResponseEntity.ok(contactService.getContactById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDto> updateContact(@PathVariable long id,@RequestBody ContactDto contactDto){
        return ResponseEntity.ok(contactService.updateContact(id, contactDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id){
        contactService.deleteContactById(id);
        return ResponseEntity.ok(String.format("Contact with %s is deleted!",id));
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteAll(){
        contactService.deleteAll();
        return ResponseEntity.ok("All records in Contact table is deleted successfully!");
    }
}
