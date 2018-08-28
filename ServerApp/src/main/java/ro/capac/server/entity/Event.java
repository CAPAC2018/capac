package ro.capac.server.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "event")
@SequenceGenerator(name="EVENT_ID_SEQ", sequenceName = "event_id_seq", allocationSize = 1)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENT_ID_SEQ")
    private Long id;

    @Column(name = "event_name")
    private String name;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "location")
    private String location;

    //TODO: Use ID for categories instead of strings to handle data easier
    @Column(name = "sport_category")
    private String sportCategory;

    @Column(name = "description")
    private String description;

    @Column(name = "max_players")
    private int maxPlayers;

    @Column(name = "req_rep")
    private int reqRep;

    @Column(name = "organizer_id")
    private Long organizerID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getReqRep() {
        return reqRep;
    }

    public void setReqRep(int reqRep) {
        this.reqRep = reqRep;
    }

    public Long getOrganizerID() {
        return organizerID;
    }

    public void setOrganizerID(Long organizerID) {
        this.organizerID = organizerID;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", sportCategory='" + sportCategory + '\'' +
                ", description='" + description + '\'' +
                ", maxPlayers=" + maxPlayers +
                ", reqRep=" + reqRep +
                ", organizerID=" + organizerID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return maxPlayers == event.maxPlayers &&
                reqRep == event.reqRep &&
                Objects.equals(id, event.id) &&
                Objects.equals(name, event.name) &&
                Objects.equals(date, event.date) &&
                Objects.equals(time, event.time) &&
                Objects.equals(location, event.location) &&
                Objects.equals(sportCategory, event.sportCategory) &&
                Objects.equals(description, event.description) &&
                Objects.equals(organizerID, event.organizerID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, date, time, location, sportCategory, description, maxPlayers, reqRep, organizerID);
    }
}
