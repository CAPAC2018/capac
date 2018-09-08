package ro.capac.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationResponse {
    private AuthenticationResponse(){}

    public static class LoginResponse {

        @JsonProperty("status_code")
        private String statusCode;

        @JsonProperty("user_id")
        private Long userId;

        @JsonProperty("access_token")
        private String accessToken;

        @JsonProperty("user_name")
        private String userName;

        @JsonProperty("email")
        private String userEmail;

        @JsonProperty("server_profile_pic_url")
        private String serverProfilePicUrl;

        @JsonProperty("fb_profile_pic_url")
        private String fbProfilePicUrl;

        @JsonProperty("google_profile_pic_url")
        private String googleProfilePicUrl;

        @JsonProperty("message")
        private String message;

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
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

        public String getFbProfilePicUrl() {
            return fbProfilePicUrl;
        }

        public void setFbProfilePicUrl(String fbProfilePicUrl) {
            this.fbProfilePicUrl = fbProfilePicUrl;
        }

        public String getGoogleProfilePicUrl() {
            return googleProfilePicUrl;
        }

        public void setGoogleProfilePicUrl(String googleProfilePicUrl) {
            this.googleProfilePicUrl = googleProfilePicUrl;
        }

        public String getServerProfilePicUrl() {
            return serverProfilePicUrl;
        }

        public void setServerProfilePicUrl(String serverProfilePicUrl) {
            this.serverProfilePicUrl = serverProfilePicUrl;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;

            LoginResponse that = (LoginResponse) object;

            if (statusCode != null ? !statusCode.equals(that.statusCode) : that.statusCode != null)
                return false;
            if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
            if (accessToken != null ? !accessToken.equals(that.accessToken) : that.accessToken != null)
                return false;
            if (userName != null ? !userName.equals(that.userName) : that.userName != null)
                return false;
            if (userEmail != null ? !userEmail.equals(that.userEmail) : that.userEmail != null)
                return false;
            if (serverProfilePicUrl != null ? !serverProfilePicUrl.equals(that.serverProfilePicUrl)
                    : that.serverProfilePicUrl != null)
                return false;
            if (fbProfilePicUrl != null ? !fbProfilePicUrl.equals(that.fbProfilePicUrl)
                    : that.fbProfilePicUrl != null)
                return false;
            if (googleProfilePicUrl != null ? !googleProfilePicUrl.equals(that.googleProfilePicUrl)
                    : that.googleProfilePicUrl != null)
                return false;
            return message != null ? message.equals(that.message) : that.message == null;

        }

        @Override
        public int hashCode() {
            int result = statusCode != null ? statusCode.hashCode() : 0;
            result = 31 * result + (userId != null ? userId.hashCode() : 0);
            result = 31 * result + (accessToken != null ? accessToken.hashCode() : 0);
            result = 31 * result + (userName != null ? userName.hashCode() : 0);
            result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
            result = 31 * result + (serverProfilePicUrl != null ? serverProfilePicUrl.hashCode() : 0);
            result = 31 * result + (fbProfilePicUrl != null ? fbProfilePicUrl.hashCode() : 0);
            result = 31 * result + (googleProfilePicUrl != null ? googleProfilePicUrl.hashCode() : 0);
            result = 31 * result + (message != null ? message.hashCode() : 0);
            return result;
        }
    }

    /**
     * Send the response of a logout request to the client
     */
    public static class LogoutResponse {

        @JsonProperty("status_code")
        private String statusCode;

        @JsonProperty("message")
        private String message;

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }


        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;

            LogoutResponse that = (LogoutResponse) object;

            if (statusCode != null ? !statusCode.equals(that.statusCode) : that.statusCode != null)
                return false;
            return message != null ? message.equals(that.message) : that.message == null;

        }

        @Override
        public int hashCode() {
            int result = statusCode != null ? statusCode.hashCode() : 0;
            result = 31 * result + (message != null ? message.hashCode() : 0);
            return result;
        }
    }

    public static class RegisterUserResponse {

        @JsonProperty("status_code")
        private String statusCode;

        @JsonProperty("message")
        private String message;

        @JsonProperty("user_name")
        private String userName;

        @JsonProperty("user_email")
        private String userEmail;

        @JsonProperty("ID")
        private Long userId;

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }


        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;

            RegisterUserResponse that = (RegisterUserResponse) object;

            if (statusCode != null ? !statusCode.equals(that.statusCode) : that.statusCode != null)
                return false;
            return message != null ? message.equals(that.message) : that.message == null;

        }

        @Override
        public int hashCode() {
            int result = statusCode != null ? statusCode.hashCode() : 0;
            result = 31 * result + (message != null ? message.hashCode() : 0);
            return result;
        }
    }
}
