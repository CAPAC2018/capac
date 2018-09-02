package ro.capac.android.capac2018.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class EventResponse {
    private EventResponse(){}

    public static class CreateEventResponse {
        @Expose
        @SerializedName("status_code")
        private String statusCode;

        @Expose
        @SerializedName("message")
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

    public static class Event{
//        @Expose
//        @SerializedName("id") private Long id;

        @Expose
        @SerializedName("name") private String name;

        @Expose
        @SerializedName("date_time") private Date dateTime;

        @Expose
        @SerializedName("latitude") private Double latitude;

        @Expose
        @SerializedName("longitude") private Double longitude;

        @Expose
        @SerializedName("description") private String description;

        @Expose
        @SerializedName("max_attendees") private Integer maxAttendees;

        @Expose
        @SerializedName("min_reputation") private Float minReputation;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getDateTime() {
            return dateTime;
        }

        public void setDateTime(Date dateTime) {
            this.dateTime = dateTime;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getMaxAttendees() {
            return maxAttendees;
        }

        public void setMaxAttendees(Integer maxAttendees) {
            this.maxAttendees = maxAttendees;
        }

        public Float getMinReputation() {
            return minReputation;
        }

        public void setMinReputation(Float minReputation) {
            this.minReputation = minReputation;
        }
    }

    public static class CategorizedEvents{
        @Expose
        @SerializedName("events") private  List<Event> events;

        public List<Event> getEvents() {
            return events;
        }

        public void setEvents(List<Event> events) {
            this.events = events;
        }
    }
}
