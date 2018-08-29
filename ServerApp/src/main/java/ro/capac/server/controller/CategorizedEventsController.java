package ro.capac.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import ro.capac.server.entity.Event;
import ro.capac.server.repository.EventRepository;

@RestController
public class CategorizedEventsController {
    private final Logger log = LoggerFactory.getLogger(CategorizedEventsController.class);
    @Autowired
    private EventRepository eventRepo;

    @RequestMapping("/getEventsByCategory")
    public ArrayList<Long> getEventsByCategory(
            @RequestParam(value = "category") String category
    ) {
      List<Event> events = eventRepo.findByCategory(category);
      ArrayList<Long> idList = null;
        for (Event e:events
             ) {
            try {
                idList.add(e.getId());
            } catch (Exception e1) {
                log.error("The list is null");
            }
        }
        return idList;
    }

}
