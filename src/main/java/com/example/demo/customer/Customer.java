package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table
class Customer {

    @Id
    private Long id;

    private String name;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String defaultText;

    public Customer(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.defaultText = "Default";
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Customer() {
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return id;
    }

    @JsonProperty("status")
    public String getDefaultText() {
        return defaultText;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                "password=" + password +
                "defaultText=" + defaultText +
                ", name='" + name + '\'' +
                '}';
    }
}