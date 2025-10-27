package com.example.pg_manager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String district;
    private String state;
    private String pincode;

    @OneToOne
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    private Login login;

    // Getters & Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getDistrict() { return district; }

    public void setDistrict(String district) { this.district = district; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public String getPincode() { return pincode; }

    public void setPincode(String pincode) { this.pincode = pincode; }

    public Login getLogin() { return login; }

    public void setLogin(Login login) { this.login = login; }
}
