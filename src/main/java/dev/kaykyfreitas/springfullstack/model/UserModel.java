package dev.kaykyfreitas.springfullstack.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "tb_user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String email;

    private String phone;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birth;

    public UserModel() {}

    public UserModel(String name, String email, String phone, Date birth) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birth = birth;
    }

    public UserModel(Long id, String name, String email, String phone, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birth = birth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birth=" + birth +
                '}';
    }

}
