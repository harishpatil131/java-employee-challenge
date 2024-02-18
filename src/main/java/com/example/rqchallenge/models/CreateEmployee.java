package com.example.rqchallenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

public class CreateEmployee {

    @JsonProperty("id")
    @JsonIgnore
    private Integer id;
    @JsonProperty("name")
    @JsonIgnore
    private String name;
    @JsonProperty("salary")
    @JsonIgnore
    private Integer salary;
    @JsonProperty("age")
    @JsonIgnore
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
