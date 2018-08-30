package ro.capac.android.capac2018.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;

import ro.capac.android.capac2018.data.db.model.Event;
import ro.capac.android.capac2018.data.prefs.AppPreferencesHelper;

public class EventRequest {

    private EventRequest(){}

    public static class CreateEventRequest {
        @Inject AppPreferencesHelper mPref;

        @Expose
        @SerializedName("date")
        private String date;

        @Expose
        @SerializedName("time")
        private String time;

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
        private String maxPlayers;

        @Expose
        @SerializedName("req_rep")
        private String reqRep;

        @Expose
        @SerializedName("organizer_id")
        private Long organizerID;



        public CreateEventRequest(Event event) {
            this.date = event.getDate();
            this.time = event.getTime();
            this.location = event.getLocation();
            this.sportCategory = event.getSportType();
            this.description = event.getDescription();
            this.maxPlayers = event.getNoOfAttendees();
            this.reqRep = event.getReqStars();
            this.organizerID = this.mPref.getCurrentUserId();
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
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

        public String getMaxPlayers() {
            return maxPlayers;
        }

        public void setMaxPlayers(String maxPlayers) {
            this.maxPlayers = maxPlayers;
        }

        public String getReqRep() {
            return reqRep;
        }

        public void setReqRep(String reqRep) {
            this.reqRep = reqRep;
        }

        public Long getOrganizerID() {
            return organizerID;
        }

        public void setOrganizerID(Long organizerID) {
            this.organizerID = organizerID;
        }
    }
}
