package net.wei.website.model;

import lombok.Data;

@Data
public class User {

    private Integer id;

    private String password;

    private String username;

    private String sex;

    private Integer age;

    private String phone;
}
