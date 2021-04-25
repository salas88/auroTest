package com.example.test.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "set_entity")
public class SetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,
                           CascadeType.PERSIST,CascadeType.REFRESH},
                fetch = FetchType.EAGER)
    @JoinTable(name = "set_kpacs",
            joinColumns = @JoinColumn(name = "id_set_entity"),
            inverseJoinColumns = @JoinColumn(name = "id_kpac"))
    private List<KPAC> kpacs;

    public void deleteByid(int id){
        kpacs.remove(id);
    }

    public SetEntity(String title) {
        this.title = title;
    }

    public SetEntity() {
    }

    public SetEntity(String title, List<KPAC> kpacs) {
        this.title = title;
        this.kpacs = kpacs;
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

    public List<KPAC> getKpacs() {
        return kpacs;
    }

    public void setKpacs(List<KPAC> kpacs) {
        this.kpacs = kpacs;
    }

    @Override
    public String toString() {
        return "SetEntity with id: " + id + " title: " + title;
    }
}
