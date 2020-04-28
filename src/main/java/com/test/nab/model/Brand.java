package com.test.nab.model;

import javax.persistence.*;

@Entity
@Table(name = "T_BRAND")
public class Brand {

    public Brand(){}

    public Brand(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "brand_seq_gen")
    @SequenceGenerator(name = "brand_seq_gen", sequenceName = "BRAND_SEQ")
    @Column(name="ID", length = 32)
    private long id;

    @Basic
    @Column(name = "NAME", nullable = false)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
