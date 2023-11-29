package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
class Customer {

    private Long id;

    private String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String defaultText;

    public Customer(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.defaultText = "Default";
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