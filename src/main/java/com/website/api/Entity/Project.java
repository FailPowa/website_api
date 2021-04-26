package com.website.api.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter
    private Integer id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String icon;

    @Getter
    @Setter
    private Boolean gem;

    @Getter
    @Setter
    private String color;

    @Getter
    @Setter
    private String github;

    @Getter
    @Setter
    private String url;

    @Getter
    @Setter
    private String imageName;
}