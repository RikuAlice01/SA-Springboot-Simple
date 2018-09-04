package com.sut.sa.cpe;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
// @Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Video {
    @Id
    @GeneratedValue
    private @NonNull Long id;
    private @NonNull String code;
    private @NonNull String title;
    private @NonNull String url;
    private @NonNull Long userid;

    public void setCode(String code) {
        this.code = code;
    }

    public Object getCode() {
        return this.code;
    }

    public Object getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getUrl() {
        return this.url;
    }

    public void setUserID(Long userid) {
        this.userid = userid;
    }

    public Object getUserID() {
        return this.userid;
    }

    public Long getVideoID(String code) {
        if (code == this.code)
            return id;
        return id;
    }

}
