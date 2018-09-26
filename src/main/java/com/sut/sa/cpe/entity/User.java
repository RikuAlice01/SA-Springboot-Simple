package com.sut.sa.cpe.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
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
public class User {
	@Id
	@SequenceGenerator(name="user_seq",sequenceName="user_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")      
	@Column(name="USER_ID",unique = true, nullable = false)
	private @NonNull Long id;
	private @NonNull String username;


}
