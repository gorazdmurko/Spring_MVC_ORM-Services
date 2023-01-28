package org.example.spring.springmvcorm.user.entity;

import org.example.spring.springmvcorm.user.dto.Address;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class Employee {

    private String username;
    private String password;
    private String email;
    private Date birthDate;
    private String profession;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", profession='" + profession + '\'' +
                '}';
    }
}
