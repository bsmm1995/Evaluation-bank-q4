package com.bp.cbe.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "CUSTOMER")
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerEntity extends BaseEntity {
    @Column(name = "DOCUMENT_NUMBER", length = 20, nullable = false, unique = true)
    private String documentNumber;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String lastname;
    @Column(nullable = false)
    private Short age;
    @Column(name = "PHONE_NUMBER", length = 20)
    private String phoneNumber;
    @Column(length = 100)
    private String email;
}
