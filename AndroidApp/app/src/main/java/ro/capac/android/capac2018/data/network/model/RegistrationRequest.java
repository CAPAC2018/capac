package ro.capac.android.capac2018.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationRequest {
    private RegistrationRequest(){
    }

    public static class ServerRegistrationRequest {
        @Expose
        @SerializedName("user_name") private String userName;
        @Expose
        @SerializedName("user_email") private String userEmail;
        @Expose
        @SerializedName("user_phone_number") private String userPhoneNumber;
        @Expose
        @SerializedName("user_password") private String userPassword;

        public ServerRegistrationRequest(String userName, String userEmail, String userPhoneNumber, String userPassword) {
            this.userName = userName;
            this.userEmail = userEmail;
            this.userPhoneNumber = userPhoneNumber;
            this.userPassword = userPassword;
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

        public String getUserPhoneNumber() {
            return userPhoneNumber;
        }

        public void setUserPhoneNumber(String userPhoneNumber) {
            this.userPhoneNumber = userPhoneNumber;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }
    }
}
