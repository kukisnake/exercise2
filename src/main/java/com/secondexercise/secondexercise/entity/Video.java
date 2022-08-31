package com.secondexercise.secondexercise.entity;

import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Setter
@Entity
@Table(name = "video")
public class Video implements java.io.Serializable {
    private long id;
    private String name;
    private Date createdOn;
    @OneToMany(mappedBy = "video")
    private Set<DailyStatistics> dailyStatistics;
    private Boolean userHasAccess;

    // Getters
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getId() {return id;}
    @Column(name = "name", nullable = false)
    public String getName() {return name;}
    @Column(name = "created_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedOn() {return createdOn;}
    @Transient
    public Boolean isUserHasAccess() {return userHasAccess;}
    @Column
    @ElementCollection(targetClass=DailyStatistics.class)
    public Set<DailyStatistics> getDailyStatistics() {
        return dailyStatistics;
    }
}
