//package com.techinnovsn.entity;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "authorities")
//public class Authority {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(unique = true, nullable = false)
//    private String name;
//
//    @Column
//    private String description;
//
//     @JsonIgnore
//    @ManyToMany
//    @JoinTable(
//        name = "user_authorities",
//        joinColumns = @JoinColumn(name = "authority_id"),
//        inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    private Set<User> users = new HashSet<>();
//
//    // Constructeur vide (obligatoire pour JPA)
//    public Authority() {
//    }
//
//    // Constructeur avec name uniquement
//    public Authority(String name) {
//        this.name = name;
//        this.users = new HashSet<>();
//    }
//
//    // Constructeur avec name ET description (celui qui manque probablement)
//    public Authority(String name, String description) {
//        this.users = new HashSet<>();
//        this.name = name;
//        this.description = description;
//    }
//
//    // Getters et Setters
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Authority)) return false;
//        Authority authority = (Authority) o;
//        return name != null && name.equals(authority.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
//}