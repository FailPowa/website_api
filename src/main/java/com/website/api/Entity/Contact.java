package com.website.api.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter
    private Integer id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String firstname;

    @Getter
    @Setter
    private String mail;

    @Getter
    @Setter
    private String business;

    @Getter
    @Setter
    @Column(length = 5000)
    private String message;
}