package com.test.nab.model;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author anhtuan_truong
 *
 */
@Entity
@Table(name = "T_PRODUCT")
public class Product {

    public enum COLOR_TYPE {RED, ORANGE, YELLOW, GREEN}

    /**
     *
     */
    private static final long serialVersionUID = 2137208465451079561L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "product_seq_gen")
    @SequenceGenerator(name = "product_seq_gen", sequenceName = "PRODUCT_SEQ")
    @Column(name="ID", length = 32)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private Brand brand;


    @Basic
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SIZE", nullable = false     )
    private int size;

    @Basic
    @Column(name = "COLOR", nullable = false)
    private COLOR_TYPE color;

    private Date creationDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public COLOR_TYPE getColor() {
        return color;
    }

    public void setColor(COLOR_TYPE color) {
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE", insertable = true)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_DATE", insertable = true)
    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


    @Column(name = "CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "MODIFIED_BY")
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
