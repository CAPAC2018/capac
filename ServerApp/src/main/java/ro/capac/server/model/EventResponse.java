package ro.capac.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import ro.capac.server.entity.Event;
import ro.capac.server.entity.User;

public class EventResponse {
    private EventResponse(){}

    public static class CreateEventResponse {
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

    public static class EventsListResponse {
        @JsonProperty("events")
        private List<Event> events;

        public List<Event> getEvents() {
            return events;
        }

        public void setEvents(List<Event> events) {
            this.events = events;
        }
    }

    public static class AttendEventResponse{
        @JsonProperty("status_code")
        private String statusCode;

        @JsonProperty("message")
        private String message;

        @JsonProperty("user_list")
        private List<User> users;

        public List<User> getUsers() {
            return users;
        }

        public void setUsers(List<User> users) {
            this.users = users;
        }

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
    }
}
