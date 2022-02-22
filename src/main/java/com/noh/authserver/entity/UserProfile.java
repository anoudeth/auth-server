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
    @Column(name = "middlee_name")
    private String middleName;
    @Column(name = "lastName")
    private String lastname;

    @Column(name = "address")
    private String address;
    @Column(name = "mobileNo")
    private String mobileNo;
    @Column(name = "sms")
    private String sms;
    @Column(name = "phoneNo")
    private String phoneNo;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;
}
