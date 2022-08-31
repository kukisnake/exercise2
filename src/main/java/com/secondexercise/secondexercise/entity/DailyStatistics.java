package com.secondexercise.secondexercise.entity;

import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Entity
@Table(name = "daily_statistics")
public class DailyStatistics implements java.io.Serializable {
    private long id;
    private Date snapshotTime;
    private long views;
    private long comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "daily_statistics_video_id")
    private Video relatedVideo;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private Video video;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    // Getters
    @Id
    @Column(name = "stats_id", unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getId() {return id;}
    @Column(name = "snapshot_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getSnapshotTime() {return snapshotTime;}
    @Column(name = "views", nullable = false)
    public long getViews() {return views;}
    @Column(name = "comments", nullable = false)
    public long getComments() {return comments;}
    public Video getRelatedVideo() {
        return relatedVideo;}

}
