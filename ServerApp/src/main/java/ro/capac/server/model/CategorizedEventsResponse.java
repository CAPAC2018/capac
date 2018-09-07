package ro.capac.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import ro.capac.server.entity.Event;

public class CategorizedEventsResponse {
    @JsonProperty("events")
    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
