package ro.capac.server.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.capac.server.model.Greeting;
import ro.capac.server.model.LoginResponse;
import ro.capac.server.model.LogoutResponse;

@RestController
public class GreetingController {

    private final Logger log = LoggerFactory.getLogger(GreetingController.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/serverLogin")
    public LoginResponse serverLogin(@RequestParam(value="name", defaultValue="World") String name) {
        log.info("serverLogin: name={}", name);
        LoginResponse resp = new LoginResponse();
        resp.setUserId(13L);
        resp.setUserName("Name of " + name);
        resp.setUserEmail(name + "@some.user");
        resp.setStatusCode("success");
        resp.setAccessToken("dummy.access.token." + System.currentTimeMillis());
        resp.setMessage("Login Success!");
        return resp;
    }

    @RequestMapping("/serverLogout")
    public LogoutResponse serverLogout() {
        log.info("serverLogout");
        LogoutResponse resp = new LogoutResponse();
        resp.setStatusCode("success");
        resp.setMessage("Logout success");
        return resp;
    }
}
