package ro.capac.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import ro.capac.server.entity.Event;
import ro.capac.server.model.CategorizedEventsResponse;
import ro.capac.server.model.CreateEventResponse;
import ro.capac.server.repository.EventRepository;
import ro.capac.server.repository.UserRepository;

@RestController
public class EventController {

    private final Logger log = LoggerFactory.getLogger(LoginLogOutController.class);

    @Autowired
    private EventRepository eventRepo;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/createEvent")
    public CreateEventResponse createEvent(
            @RequestParam("date_time") Date dateTime,
            @RequestParam("location")  String location,
            @RequestParam("sport_category")  String sportCategory,
            @RequestParam("description")  String description,
            @RequestParam("max_players")  int maxPlayers,
            @RequestParam("req_rep")  Float reqRep,
            @RequestParam("organizer_id")  Long organizerID
    ){
        Event event = new Event();
        event.setDateTime(dateTime);
        event.setLocation(location);
        event.setCategory(sportCategory);
        event.setDescription(description);
        event.setMaxAttendees(maxPlayers);
        event.setMinReputation(reqRep);
        event.setOwner(userRepository.findUserById(organizerID));
        eventRepo.save(event);
        CreateEventResponse response = new CreateEventResponse();
        response.setStatusCode("200");
        response.setMessage("Saved");
        return response;
    }

    @RequestMapping("/findEventsByCategory")
    public CategorizedEventsResponse findEventsByCategory(
            @RequestParam("category") String category
    ){
        CategorizedEventsResponse response = new CategorizedEventsResponse();
        response.setEvents(eventRepo.findEventsByCategory(category,null));
        return response;
    }
}
