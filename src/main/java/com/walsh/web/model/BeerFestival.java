package com.walsh.web.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Holds all information related to a beer festival
 */
@Entity
public class BeerFestival {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name ="BEER_FESTIVAL_ID")
    private long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name ="BEER_FESTIVAL_BEERS", joinColumns = @JoinColumn(name="BEER_FESTIVAL_ID"))
    private Set<Beer> beers;

    public BeerFestival(){}

    public BeerFestival(String name){
        this.name = name;
    }

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

    public Set<Beer> getBeers() {
        return beers;
    }

    public void setBeers(Set<Beer> beers) {
        this.beers = beers;
    }
}
