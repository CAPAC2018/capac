package ro.capac.android.capac2018.data.db.model;

import java.util.ArrayList;

public class Event {

    private String time;
    private String date;
    private String location;
    private String sportType;
    private String skillLevel;
    private String organizer;
    private String noOfAtendees;
    private String description;
    private String noReqPlayers;
    private String reqStars;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getNoOfAtendees() {
        return noOfAtendees;
    }

    public void setNoOfAtendees(String noOfAtendees) {
        this.noOfAtendees = noOfAtendees;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNoReqPlayers() {
        return noReqPlayers;
    }

    public void setNoReqPlayers(String noReqPlayers) {
        this.noReqPlayers = noReqPlayers;
    }

    public String getReqStars() {
        return reqStars;
    }

    public void setReqStars(String reqStars) {
        this.reqStars = reqStars;
    }

    public Event(String time, String date, String location, String sportType, String skillLevel, String organizer, String noOfAtendees, String description, String noReqPlayers, String reqStars) {
        this.time = time;
        this.date = date;
        this.location = location;
        this.sportType = sportType;
        this.skillLevel = skillLevel;
        this.organizer = organizer;
        this.noOfAtendees = noOfAtendees;
        this.description = description;
        this.noReqPlayers = noReqPlayers;
        this.reqStars = reqStars;
    }
    public Event(){

    }

    public static ArrayList<Event> getTestingList() {
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event("10:00 AM","3rd Jul", "Parcul Central", "Basketball", "Amator", "Mihai Popescu", "8", "null", "2-8", "3.5"));
        events.add(new Event("11:00 AM","4th Jul", "Parcul Rozelor", "Basketball", "Advanced", "Mihai Ionescu", "10", "null", "2-10", "4.5"));
        events.add(new Event("12:00 AM","5th Jul", "Parcul Central", "Marathon", "Amator", "Andrei Popescu", "20", "null", "2-20", "1.5"));
        events.add(new Event("13:00 AM","1st Jul", "Parcul Primaverii", "Mini Football", "Noob", "Mihai Popescu", "4", "null", "2-4", "2.5"));
        events.add(new Event("14:00 AM","2nd Jul", "Baza Sportiva Unirea", "Tenis", "Pro", "Andrei Popescu", "4", "null", "2-4", "3"));
        return events;

    }
}
