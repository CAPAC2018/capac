package ro.capac.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "capac_event")
@SequenceGenerator(name="CAPAC_EVENT_ID_SEQ", sequenceName = "capac_event_id_seq", allocationSize = 1)
public class Event {

    @JsonProperty("ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAPAC_EVENT_ID_SEQ")
    @Column(name = "ID")
    private Long id;

    @JsonProperty("date_time")
    @Column(name = "date_time")
    private Date dateTime;

    @JsonProperty("location")
    @Column(name = "location")
    private String location;

    @JsonProperty("category")
    @Column(name = "category")
    private String category;

    @JsonProperty("description")
    @Column(name = "description")
    private String description;

    @JsonProperty("max_attendees")
    @Column(name = "max_attendees")
    private Integer maxAttendees;

    @JsonProperty("min_reputation")
    @Column(name = "min_reputation")
    private Float minReputation;

    @ManyToMany
    @JsonProperty("attendees")
    @Column(name = "attendees")
    private List<User> attendees;

    @JsonProperty("owner")
    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

    public List<User> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) &&
                Objects.equals(dateTime, event.dateTime) &&
                Objects.equals(category, event.category) &&
                Objects.equals(description, event.description) &&
                Objects.equals(maxAttendees, event.maxAttendees) &&
                Objects.equals(minReputation, event.minReputation) &&
                Objects.equals(owner, event.owner);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dateTime, category, location, description,
                maxAttendees, minReputation, owner);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("id=").append(id).append('\'');
        sb.append(", category=").append(category);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", description='").append(description).append('\'');
        sb.append(", maxAttendees=").append(maxAttendees);
        sb.append(", minReputation=").append(minReputation);
        sb.append(", owner=").append(owner);
        sb.append('}');
        return sb.toString();
    }
}
