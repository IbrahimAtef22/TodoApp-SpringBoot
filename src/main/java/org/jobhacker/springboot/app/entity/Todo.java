package org.jobhacker.springboot.app.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity // This tells Hibernate to make a table out of this class
@Table (name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column
    private String title;
    @Column
    @NonNull
    private String description;
    @Column
    private long timestamp;

    public Todo() {
        this.timestamp = System.currentTimeMillis();
    }

    public Todo(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.timestamp = System.currentTimeMillis();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
