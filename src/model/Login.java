package model;

/**
 * @author Simon Sperr
 * @version 2020.1.1, 02.12.2020
 **/
public class Login {
    private String username;
    private String password;

    public Login(String username, String password)
    {
        this.setUsername(username);
        this.setPassword(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login)o;
        return this.username.equals(login.username) &&
                this.password.equals(login.password);
    }

    public Login(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
