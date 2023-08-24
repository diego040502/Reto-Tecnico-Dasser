package com.example.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombres")
    @NotBlank
    private String nombres;
    @Column(name = "apellidos")
    @NotBlank
    private String apellidos;
    @Column(name = "login")
    @NotBlank
    private String login;
    @Column(name = "created", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created;
    @Column(name = "last_update", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime lastUpdate;
    @Column(name = "email")
    @NotBlank
    private String email;
    @Column(name = "password")
    @NotBlank
    private String password;

    @OneToOne
    @JoinColumn(name = "states_id", referencedColumnName = "id")
    private StateModel state_id;

    @PrePersist
    protected void onCreate(){
        created = LocalDateTime.now();
        lastUpdate = created;
    }

    public UserModel(Integer id, String nombres, String apellidos, String login, LocalDateTime created, LocalDateTime lastUpdate, String email, String password, StateModel state_id) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.login = login;
        this.created = created;
        this.lastUpdate = lastUpdate;
        this.email = email;
        this.password = password;
        this.state_id = state_id;
    }

    public UserModel() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
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

    public StateModel getState_id() {
        return state_id;
    }

    public void setState_id(StateModel state_id) {
        this.state_id = state_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
