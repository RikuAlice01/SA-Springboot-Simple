package com.sut.sa.cpe.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
//@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Comment {
    @Id 
    @GeneratedValue
    private @NonNull Long id;
    private @NonNull String content;

    private @NonNull Long userid;
    private @NonNull Long videoid;

	public void setContent(String content) {
        this.content = content;
	}

    public Object getContent() {
		return this.content;
    }

    public void setUserID(Long userid) {
        this.userid = userid;
	}

	public Long getUserID() {
		return this.userid;
    }

    public void setVideoID(Long videoid) {
        this.videoid = videoid;
	}

	public Long getVideoID() {
		return this.videoid;
    }
}

