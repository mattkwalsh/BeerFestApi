package com.walsh.web.model;

import javax.persistence.*;

/**
 * A beer!
 */
@Entity
public class Beer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "BEER_ID")
    private long id;
    private String brewery;
    private String name;
    private String abv;
    private String description;
    private String style;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbv() {
        return abv;
    }

    public void setAbv(String abv) {
        this.abv = abv;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
