package com.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity(
        name = "Note"
)
@Table(
        name = "notes"
)
public class Note {
    @Id
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator"
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
            name = "content",
            length = 99999
    )
    private  String content;
    @Column(
            name = "created_date"
    )
    private Date createdDate;

    public Note(String title, String content, Date createdDate){
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
    }
    public Note(){

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
