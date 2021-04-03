package jm.springtoy.urlshortener.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShortURL {
    @Id private String id;
    private String url;
    private String password;

    public ShortURL() {

    }

    public ShortURL(String id, String url, String password) {
        this.id = id;
        this.url = url;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
