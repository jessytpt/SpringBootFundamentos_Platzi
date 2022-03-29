package com.fundamentos.platzi.fundamentos.entity;

import javax.persistence.*;

@Entity
@Table(name="post") //nombre de la tabla
public class Post {
    @Id //indica que es un ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para que el ID sea único
    @Column(name="id_post", nullable = false,unique = true)
    private Long id;

    @Column(name="description",length = 255)
    private String description;

    @ManyToOne // declarar una relación de uno a muchos
    private User user;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post(Long id, String description, User user) {
        this.id = id;
        this.description = description;
       // this.user = user;
    }

    public Post() {
    }
}
