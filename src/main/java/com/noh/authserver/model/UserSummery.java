package com.noh.authserver.model;

import lombok.Data;

import java.util.Collection;

@Data
public class UserSummery {
    private Integer userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
//    private Collection<Role> roles;
//    private Collection<Province> provinces;
//    private Collection<District> districts;
//    private Collection<Village> village;
}
