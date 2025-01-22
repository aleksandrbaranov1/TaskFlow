package org.example.taskflow.user;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    
    private Long userId;
    private String content;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Task(Long userId, String content, Long id) {
        this.userId = userId;
        this.content = content;
        this.id = id;
    }


    public Task() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
