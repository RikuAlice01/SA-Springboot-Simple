package com.sut.sa.cpe.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class View {
	@Id
	@SequenceGenerator(name="view_seq",sequenceName="view_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="view_seq")      
	@Column(name="VIEW_ID")

	private @NonNull Long id;
    private @NonNull Date watchedDate;
    private @NonNull Timestamp watchedTime;
    
    @ManyToOne
    private Video  watchedVideo;

    @ManyToOne
    private User watchingUser;

}
