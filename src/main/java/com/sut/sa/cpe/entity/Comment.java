package com.sut.sa.cpe.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Comment {
    @Id
    @SequenceGenerator(name="comment_seq",sequenceName="comment_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="comment_seq")  
    @Column(name="Comment_ID")

    private @NonNull Long id;
    private @NonNull String content;

    @ManyToOne
    private  User commentedUser;

    @ManyToOne
    private  Video commentedVideo;
}

