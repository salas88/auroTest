package com.example.test.entity;

import javax.persistence.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "kpac")
public class KPAC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
    @Column(name="createadAt", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @ManyToMany
    @JoinTable(name = "set_kpacs",
            joinColumns = @JoinColumn(name = "id_kpac"),
            inverseJoinColumns = @JoinColumn(name = "id_set_entity"))
    private List<KPAC> kpacs;


    @Transient
    private String newDate;

    public KPAC() {
    }

    public KPAC(String title, String description, String newDate) {
        this.title = title;
        this.description = description;
        this.newDate = newDate;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public String getNewDate() {

        return new SimpleDateFormat("dd-MM-yyyy").format(getCreatedAt());
    }

    public void setNewDate(String newDate) {
        this.newDate = newDate ;
    }

    public List<KPAC> getKpacs() {
        return kpacs;
    }

    public void setKpacs(List<KPAC> kpacs) {
        this.kpacs = kpacs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KPAC kpac = (KPAC) o;
        return id.equals(kpac.id) && title.equals(kpac.title) && description.equals(kpac.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }

    @Override
    public String toString() {
        return "K-Pac #" + id + ", title - " + title;
    }
}
