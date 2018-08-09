package ro.capac.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.capac.server.entity.User;
import ro.capac.server.model.LoginResponse;
import ro.capac.server.model.LogoutResponse;
import ro.capac.server.model.RegisterUserResponse;
import ro.capac.server.repository.UserRepository;

@RestController
public class LoginController {

    private final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/serverLogin")
    public LoginResponse mySuperDupperServerLogin(
            @RequestParam(value="name", defaultValue="World")
            String name
    ) {

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

    @RequestMapping("/registerUser")
    public RegisterUserResponse serverRegisterUser(
            @RequestParam(value="name", defaultValue = "name") String name,
            @RequestParam(value="email", defaultValue = "email") String email,
            @RequestParam(value="phone", defaultValue = "phone") String phone,
            @RequestParam(value="password", defaultValue = "passwd") String password
    ) {
        log.info("registerUser - called");
        User user = new User();
        user.setUserEmail(email);
        user.setUserName(name);
        user.setPhone(phone);
        user.setPassword(password);
        User savedUser = userRepo.save(user);
        log.info("saved user: {}", savedUser);
        //TODO save user
        RegisterUserResponse response= new RegisterUserResponse();
        response.setMessage("Bunaa, " + name + " cu ID=" + savedUser.getId());
        response.setStatusCode("success");
        return response;
    }
}
