package com.dynastymasra.spring.domain;

import com.dynastymasra.spring.domain.enumeration.Sex;
import javax.persistence.*;

/**
 * Author   : Dynastymasra
 * Password     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

@Entity
@Table(name = "pitb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "username", nullable = false, length = 30)
    private String username;
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
