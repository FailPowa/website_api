package com.website.api.Request;

import lombok.Getter;
import lombok.Setter;

public class ProjectRequest {
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