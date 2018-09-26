package com.sut.sa.cpe.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Playlist {
    @Id
    @SequenceGenerator(name="playlist_seq",sequenceName="playlist_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="playlist_seq")  
    @Column(name="Playlist_ID")

    private @NonNull Long id;
    private @NonNull String name;

    @ManyToOne
    private  User adder;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Video> addVideo = new LinkedHashSet<Video>();

}


