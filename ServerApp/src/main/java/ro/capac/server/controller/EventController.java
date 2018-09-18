package ro.capac.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ro.capac.server.entity.Event;
import ro.capac.server.entity.User;
import ro.capac.server.model.EventResponse;
import ro.capac.server.repository.EventRepository;
import ro.capac.server.repository.UserRepository;

@RestController
public class EventController {

    private final Logger log = LoggerFactory.getLogger(AuthenticationController.LoginLogOutController.class);

    @Autowired
    private EventRepository eventRepo;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/createEvent")
    public EventResponse.CreateEventResponse createEvent(
            @RequestParam("date_time") Date dateTime,
            @RequestParam("location")  String location,
            @RequestParam("sport_category")  String sportCategory,
            @RequestParam("description")  String description,
            @RequestParam("max_players")  int maxPlayers,
            @RequestParam("req_rep")  Float reqRep,
            @RequestParam("organizer_id")  Long organizerID
    ){
        Event event = new Event();
        List<User> attendingUsers = new ArrayList<>();
        attendingUsers.add(userRepository.findById(organizerID).get());
        event.setAttendees(attendingUsers);
        event.setDateTime(dateTime);
        event.setLocation(location);
        event.setCategory(sportCategory);
        event.setDescription(description);
        event.setMaxAttendees(maxPlayers);
        event.setMinReputation(reqRep);
        if(userRepository.findById(organizerID).isPresent()) {
            event.setOwner(userRepository.findById(organizerID).get());
        }
        eventRepo.save(event);
        EventResponse.CreateEventResponse response = new EventResponse.CreateEventResponse();
        response.setStatusCode("200");
        response.setMessage("Saved");
        return response;
    }

    @RequestMapping("/findEventsByCategory")
    public EventResponse.EventsListResponse findEventsByCategory(
            @RequestParam("category") String category
    ){
        EventResponse.EventsListResponse response = new EventResponse.EventsListResponse();
        response.setEvents(eventRepo.findEventsByCategoryIgnoreCase(category,null));
        return response;
    }

    @RequestMapping("/attendEvent")
    public EventResponse.AttendEventResponse attendEvent(
            @RequestParam("event_id") Long eventId,
            @RequestParam("user_id") Long userId
    ){
        log.info("attendEvent called with eventId={}, userId={}", eventId, userId);
        EventResponse.AttendEventResponse response = new EventResponse.AttendEventResponse();
        if(eventRepo.findById(eventId).isPresent()) {
            Event event = eventRepo.findById(eventId).get();
            if(event.getAttendees().contains(userRepository.findById(userId).get())){
                response.setStatusCode("good_error");
                response.setMessage("You're already singed-up for this event, see you there!");
            } else if(event.getAttendees().size() >= event.getMaxAttendees()){
                log.warn("Nr of attendees for event with ID={} exceeded", eventId);
                response.setStatusCode("error");
                response.setMessage("Sorry, this event is full, but don't worry you can look for another one or just create your own!");
            }else{
                event.getAttendees().add(userRepository.findById(userId).get());
                eventRepo.save(event);
                log.debug("User with ID={} was added as attendee to event with ID={}", userId, eventId);
                response.setStatusCode("success");
                response.setMessage("Get ready.. Set.. GO!");
                response.setUsers(eventRepo.findById(eventId).get().getAttendees());
            }
        }else{
            log.info("event with ID={} does not exist", eventId);
            response.setMessage("Sorry, this event is no longer available, the owner probably erased it :(");
            response.setStatusCode("error");
        }
        return response;
    }

    @RequestMapping("/getMyEvents")
    public EventResponse.EventsListResponse getMyResponse(
            @RequestParam("user_id") Long userId
    ){
        EventResponse.EventsListResponse response = new EventResponse.EventsListResponse();
        List myEvents = new ArrayList();
        User me = userRepository.findById(userId).get();
        Iterable<Event> events = eventRepo.findAll();
        for (Event e:events
             ) {
            if(e.getAttendees().contains(me)){
                myEvents.add(e);
            }
        }
        response.setEvents(myEvents);
        return response;
    }
}
