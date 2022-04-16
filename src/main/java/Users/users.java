package Users;

import Users.account;

public class users extends account {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean accountType;
    public proxy filtre;

    public users(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAccountType() {
        return accountType;
    }

    public void setAccountType(boolean accountType) {
        this.accountType = accountType;
    }



    public String toString(){
        return "User : " + this.firstName + " " + this.lastName;
    }

}
