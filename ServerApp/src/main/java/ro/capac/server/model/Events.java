package ro.capac.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 *Events' fields
 */

public class Events {
    @JsonProperty("status_code")
    private String statusCode;

    @JsonProperty("message")
    private String message;

    @JsonProperty("event_sport")
    private Long eventSport;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("skill_level")
    private String skillLevel;

    @JsonProperty("description")
    private String eventDescription;

    @JsonProperty("players_number")
    private String playersNumber;

    @JsonProperty("event_location")
    private String eventLocation;

    @JsonProperty("event_time")
    private String eventTime;

    @JsonProperty("event_date")
    private String eventDate;


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public Long getEventSport() {
        return eventSport;
    }

    public void setEventSport (Long eventSport) {  this.eventSport = eventSport;}


    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation
        ;
    }

    public String getSkillLevel() {return skillLevel;}
    public void setSkillLevel(String skillLevel){ this.skillLevel = skillLevel;}

    public String getPlayersNumber(){return playersNumber;}
    public void setPlayersNumber(String playersNumber)
    {this.playersNumber=playersNumber;
    }

    public String getEventTime() {return eventTime;}
    public void setEventTime(String eventTime){this.eventTime = eventTime;}

    public String getEventDate() {return eventDate;}
    public void setEventDate(String eventDate){this.eventDate = eventDate;}



    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Events that = (Events) object;

        if (statusCode != null ? !statusCode.equals(that.statusCode) : that.statusCode != null)
            return false;
        if (eventSport != null ? !eventSport.equals(that.eventSport) : that.eventSport != null) return false;
        if (accessToken != null ? !accessToken.equals(that.accessToken) : that.accessToken != null)
            return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null)
            return false;
        if (eventTime != null ? !eventTime.equals(that.eventTime) : that.eventTime != null)
            return false;
        if (eventLocation != null ? !eventLocation.equals(that.eventLocation)
                : that.eventLocation != null)
            return false;
        if (playersNumber != null ? !playersNumber.equals(that.playersNumber)
                : that.playersNumber != null)
            return false;
        return message != null ? message.equals(that.message) : that.message == null;

    }

    @Override
    public int hashCode() {
        int result = statusCode != null ? statusCode.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (eventLocation != null ? eventLocation.hashCode() : 0);
        result = 31 * result + (eventTime != null ? eventTime.hashCode() : 0);
        result = 31 * result + (eventSport != null ? eventSport.hashCode() : 0);
        result = 31 * result + (eventDescription != null ? eventDescription.hashCode() : 0);
        result = 31 * result + (eventDate != null ? eventDate.hashCode() : 0);
        result = 31 * result + (playersNumber != null ? playersNumber.hashCode() : 0);
        return result;
    }
}
