package ro.capac.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "capac_event")
@SequenceGenerator(name="CAPAC_EVENT_ID_SEQ", sequenceName = "capac_event_id_seq", allocationSize = 1)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAPAC_EVENT_ID_SEQ")
    private Long id;

    @JsonProperty
    @Column(name = "name")
    private String name;

    @Column(name = "date_time")
    private Date dateTime;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "category")
    private String category;

    public void setCategory(String category) {
        this.category = category;
    }
    //    @ManyToOne
//    private  Category category;

    @Column(name = "description")
    private String description;

    @Column(name = "max_attendees")
    private Integer maxAttendees;

    @Column(name = "min_reputation")
    private Float minReputation;

    @ManyToOne
    private User owner;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

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
                Objects.equals(name, event.name) &&
                Objects.equals(dateTime, event.dateTime) &&
                Objects.equals(category, event.category) &&
                Objects.equals(latitude, event.latitude) &&
                Objects.equals(longitude, event.longitude) &&
                Objects.equals(description, event.description) &&
                Objects.equals(maxAttendees, event.maxAttendees) &&
                Objects.equals(minReputation, event.minReputation) &&
                Objects.equals(owner, event.owner);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, dateTime, category, latitude, longitude, description,
                maxAttendees, minReputation, owner);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", category=").append(category);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", description='").append(description).append('\'');
        sb.append(", maxAttendees=").append(maxAttendees);
        sb.append(", minReputation=").append(minReputation);
        sb.append(", owner=").append(owner);
        sb.append('}');
        return sb.toString();
    }
}
