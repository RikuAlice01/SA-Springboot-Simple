package com.sut.sa.cpe.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Video {

    @Id
    @SequenceGenerator(name="video_seq",sequenceName="video_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="video_seq")  
    @Column(name="VIDEO_ID")

    private @NonNull Long id;
    private @NonNull String code;
    private @NonNull String title;
    private @NonNull String url;
    
    @ManyToOne
    @JsonIgnore
    private User videoUser;

}
