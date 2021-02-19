package com.laioffer.travelPlanner.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "route")
public class Route implements Serializable {
    private static final long serialVersionUID = -897223276731725989L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Place> place;

    private int startdate;

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Place> getPlace() {
        return place;
    }

    public int getStartdate() {
        return startdate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPlace(List<Place> place) {
        this.place = place;
    }

    public void setStartdate(int startdate) {
        this.startdate = startdate;
    }
}
