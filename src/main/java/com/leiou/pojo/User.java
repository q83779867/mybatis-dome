package com.leiou.pojo;

public class User {
    private Integer id;
    private String name;
    private String password;
    private String gender;
    private String add;

    public User() {
    }

    public User(Integer id, String name, String password, String gender, String add) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.add = add;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", add='" + add + '\'' +
                '}';
    }
}
