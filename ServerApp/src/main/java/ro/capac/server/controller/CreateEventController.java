package ro.capac.server.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.capac.server.entity.Event;
import ro.capac.server.model.CreateEventResponse;
import ro.capac.server.repository.EventRepository;

@RestController
public class CreateEventController {
    private final Logger log = LoggerFactory.getLogger(CreateEventController.class);

    @Autowired
    private EventRepository eventRepo;

    @RequestMapping("/createEvent")
    public CreateEventResponse createEvent(
            @RequestParam(value = "event_name") String name,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "time") String time,
            @RequestParam(value = "location") String location,
            @RequestParam(value = "sport_category")String sportCategory,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "max_players")int maxPlayers,
            @RequestParam(value = "req_rep") int reqRep,
            @RequestParam(value = "organizer_id") Long organizerID
    ){
        log.info("createEvent - called");
        Event event = new Event();
        event.setName(name);
        event.setDate(date);
        event.setTime(time);
        event.setLocation(location);
        event.setSportCategory(sportCategory);
        event.setDescription(description);
        event.setMaxPlayers(maxPlayers);
        event.setReqRep(reqRep);
        event.setOrganizerID(organizerID);
        Event savedEvent = eventRepo.save(event);
        log.info("saved event: {}", savedEvent);
        CreateEventResponse response = new CreateEventResponse();
        response.setMessage("Your event is saved!");
        response.setStatusCode("success");
        return response;
    }
}
