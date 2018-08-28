package ro.capac.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateEventResponse {
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

        CreateEventResponse that = (CreateEventResponse) object;

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
