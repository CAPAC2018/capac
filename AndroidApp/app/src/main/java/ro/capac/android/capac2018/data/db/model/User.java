package ro.capac.android.capac2018.data.db.model;

public class User {

    private String userName;

    private String emailAdress;

    private String phoneNumber;

    private String password;

    public User(String userName,
            String emailAdress, String phoneNumber, String password) {
        this.userName = userName;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User() {
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}