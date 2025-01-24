package com.todo.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity(
        name = "Todo"
)
@Table(
        name = "todos"
)
public class Todo {
    @Id
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.uuid.UuidGenerator"
    )
    @GeneratedValue(
            generator = "uuid"
    )
    @Column(
            name = "id"
    )
    private String id;
    @Column(
            name = "title"
    )
    private String title;
    @Column(
            name = "content"
    )
    private  String content;
    @Column(
            name = "created_date"
    )
    private Date createdDate;

    public Todo(String id, String title, String content, Date createdDate){
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
    }
    public Todo(){

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
