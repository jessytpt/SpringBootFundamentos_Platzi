package com.fundamentos.platzi.fundamentos.entity;

import javax.persistence.*;

@Entity
@Table(name="employe")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_employe", nullable = false,unique = true)
    private Long id_employe;

    @Override
    public String toString() {
        return "Employe{" +
                "id_employe=" + id_employe +
                ", name_employee='" + name_employee + '\'' +
                ", email_employee='" + email_employee + '\'' +
                '}';
    }

    @Column(name="name_employee", length = 50)
    private String name_employee;

    @Column(name="email_employee", length = 100)
    private String email_employee;

    public Employe(String name_employee, String email_employee) {
        this.name_employee = name_employee;
        this.email_employee = email_employee;
    }

    public Long getId_employe() {
        return id_employe;
    }

    public void setId_employe(Long id_employe) {
        this.id_employe = id_employe;
    }

    public String getName_employee() {
        return name_employee;
    }

    public void setName_employee(String name_employee) {
        this.name_employee = name_employee;
    }

    public Employe() {
    }

    public String getEmail_employee() {
        return email_employee;
    }

    public void setEmail_employee(String email_employee) {
        this.email_employee = email_employee;
    }
}
