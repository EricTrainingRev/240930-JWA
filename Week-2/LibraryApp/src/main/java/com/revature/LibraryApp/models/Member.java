package com.revature.LibraryApp.models;

public class Member {
    private int memberId;
    private String name;
    private String email;
    private String password;

    // Constructor
    public Member(int memberId, String name, String email, String password) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Member(){}

    // Getters and Setters
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString method
    @Override
    public String toString() {
        return "Member{" +
                "id=" + memberId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}