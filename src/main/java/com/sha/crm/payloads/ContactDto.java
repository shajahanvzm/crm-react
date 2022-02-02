package com.sha.crm.payloads;

import lombok.Data;

@Data
public class ContactDto {
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
}
