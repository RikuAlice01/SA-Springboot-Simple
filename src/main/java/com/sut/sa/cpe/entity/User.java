package com.sut.sa.cpe.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
// @Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
	@Id
	@GeneratedValue
	private @NonNull Long id;
	private @NonNull String username;

	public void setName(String name) {
		this.username = name;
	}

	public Object getName() {
		return username;
	}

	public Long getUserID(String name) {
		if (name == username)
			return id;
		return id;
	}

}
