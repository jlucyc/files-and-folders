package com.codeclan.files_and_folders.Models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="folder")
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @OneToMany(mappedBy="folder", fetch = FetchType.LAZY)
    Person person;

    private List<File> files;

    public Folder(String title, Person person){
        this.title = title;
        this.person = person;
    }

    public Folder(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public void addPerson(Person person) {
        this.person.add(person);
    }

}
