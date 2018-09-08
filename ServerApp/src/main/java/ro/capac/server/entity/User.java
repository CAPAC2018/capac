package ro.capac.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "capac_user")
@SequenceGenerator(name="CAPAC_USER_ID_SEQ", sequenceName = "capac_user_id_seq", allocationSize = 1)
public class User {

    @JsonProperty("ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAPAC_USER_ID_SEQ")
    @Column(name = "ID")
    private Long id;

    @JsonProperty("user_name")
    @Column(name = "user_name")
    private String userName;

    @JsonProperty("email")
    @Column(name = "email", unique = true)
    private String userEmail;

    @JsonProperty("password")
    @Column(name = "password")
    private String password;

    @JsonProperty("phone")
    @Column(name = "phone")
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userEmail, user.userEmail) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userName, userEmail, password, phone);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
