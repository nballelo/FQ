package edu.upc.eetac.dsa.fq;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ignacio on 31/05/2017.
 */

public class User implements Serializable {
    private String login;
    private String id;
    private String avatar_url;
    private String public_repos;
    public User(){}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(String public_repos) {
        this.public_repos = public_repos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
