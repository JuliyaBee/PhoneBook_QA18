package models;

public class User {
    private String email ;
    private String password ;

    public User() {}



    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }

}
