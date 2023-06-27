package com.project.accountingProject.model.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactInfoDto {

    private Long id;

    private String phoneNumber;

    private String email;

    private String city;

    private String country;

    private String address;

    private int postCode;
}
