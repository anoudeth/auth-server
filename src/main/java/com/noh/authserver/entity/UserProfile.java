package com.noh.authserver.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_profile")
public class UserProfile extends BaseIdEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastname;

    private String address;
    private String mobileNo;
    private String sms;
    @Column(name = "phone_no")
    private String phoneNo;

}
