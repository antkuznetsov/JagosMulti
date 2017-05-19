package ru.innopolis.models.entities;

import org.apache.log4j.Logger;

import javax.persistence.*;

/**
 * Created by Kuznetsov on 13/04/2017.
 */

@Entity
@Table(name="lessons")
public class Lesson {

    private static final Logger LOGGER = Logger.getLogger(Lesson.class);

    private int id;
    private String title;
    private String content;
    private int courseId;

    public Lesson() {

    }

    public Lesson(int id, String title, String content, int courseId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.courseId = courseId;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "course_id")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lesson lesson = (Lesson) o;

        return id == lesson.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}