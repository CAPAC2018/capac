package ro.capac.android.capac2018.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

import javax.inject.Inject;

import ro.capac.android.capac2018.data.db.model.Event;
import ro.capac.android.capac2018.data.prefs.AppPreferencesHelper;
import ro.capac.android.capac2018.utils.CommonUtils;

public class EventRequest {

    private EventRequest(){}

    public static class CreateEventRequest {
        @Inject AppPreferencesHelper mPref;

        @Expose
        @SerializedName("date_time")
        private Date dateTime;

        @Expose
        @SerializedName("location")
        private String location;

        @Expose
        @SerializedName("sport_category")
        private String sportCategory;

        @Expose
        @SerializedName("description")
        private String description;

        @Expose
        @SerializedName("max_players")
        private int maxPlayers;

        @Expose
        @SerializedName("req_rep")
        private Float reqRep;

        @Expose
        @SerializedName("organizer_id")
        private Long organizerID;



        public CreateEventRequest(Event event) {
            this.dateTime = CommonUtils.formatStringToDate(event.getDate(), event.getTime());
            this.location = event.getLocation();
            this.sportCategory = event.getSportType();
            this.description = event.getDescription();
            this.maxPlayers = Integer.parseInt(event.getMaxAttendees());
            this.reqRep = Float.parseFloat(event.getReqStars());
            this.organizerID = event.getOwnerId();
        }

        public Date getDate() {
            return dateTime;
        }

        public void setDateTime(Date dateTime) {
            this.dateTime = dateTime;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getSportCategory() {
            return sportCategory;
        }

        public void setSportCategory(String sportCategory) {
            this.sportCategory = sportCategory;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getMaxPlayers() {
            return maxPlayers;
        }

        public void setMaxPlayers(int maxPlayers) {
            this.maxPlayers = maxPlayers;
        }

        public Float getReqRep() {
            return reqRep;
        }

        public void setReqRep(Float reqRep) {
            this.reqRep = reqRep;
        }

        public Long getOrganizerID() {
            return organizerID;
        }

        public void setOrganizerID(Long organizerID) {
            this.organizerID = organizerID;
        }
    }

    public static class GetEventsByCategoryRequest{
        @Expose
        @SerializedName("category")
        private String category;

        public GetEventsByCategoryRequest(String category){
            this.category = category;
        }
    }

    public static class AttendEventRequest{
        @Expose
        @SerializedName("event_id") Long eventId;
        @Expose
        @SerializedName("user_id") Long userId;

        public AttendEventRequest(Long eventId, Long userId) {
            this.eventId = eventId;
            this.userId = userId;
        }

        public Long getEventId() {
            return eventId;
        }

        public void setEventId(Long eventId) {
            this.eventId = eventId;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }

    public static class MyEventsRequest{
        @Expose
        @SerializedName("user_id") Long userId;

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }
}
