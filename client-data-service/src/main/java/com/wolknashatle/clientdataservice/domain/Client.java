package com.wolknashatle.clientdataservice.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bank_clients")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cl_id")
    private @Setter Integer id;

    @Column(name="cl_first_name")
    private  String firstName;

    @Column(name="cl_last_name")
    private  String lastName;

    @Column(name="cl_date_of_birth")
    private String dateOfBirth;

    @Column(name="cl_acc_number")
    private  String accauntNumber;

    @Column(name="cl_email")
    private  String email;

    @Column(name="cl_phone_number")
    private  String phoneNumber;

    @Column(name="cl_address")
    private  String address;
}
