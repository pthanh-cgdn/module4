package com.codegyme.module4_student.models;

import jakarta.persistence.*;

@Entity(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name", nullable = false, columnDefinition = "LONGTEXT")
    private String name;
    @Column(name="address", columnDefinition = "LONGTEXT")
    private String address;
    @Column(name="score")
    private Float score;
    @ManyToOne
    @JoinColumn(name="class_id")
    private Classroom classRoom;

    public Student() {
    }

    public Student(Long id, String name, String address, Float score) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.score = score;
    }

    public Student(String name, String address, Float score) {
        this.name = name;
        this.address = address;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Classroom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(Classroom classRoom) {
        this.classRoom = classRoom;
    }
}
