package org.example.spring.springmvcorm.user.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// is a model object which represents a database table
@Entity
@Table(name = "user")
public class User implements Comparable<User> {

    @Id
    // we don't need the @Attribute here because the names match the DB names
    private Integer id;
    private String name;
    private String email;

    @Override
    public int compareTo(User user) {
        return this.id.compareTo(user.id);  // want to sort by id
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
