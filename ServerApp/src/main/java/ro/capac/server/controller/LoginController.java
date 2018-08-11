package ro.capac.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;

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
    public LoginResponse serverLogin(
            @RequestParam(value="email") String email,
            @RequestParam(value="password") String password
    ) {
        log.info("serverLogin: email={}", email);
        LoginResponse resp = new LoginResponse();
        Optional<User> userOpt = userRepo.findByUserEmailAndPassword(email, password);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            resp.setUserId(user.getId());
            resp.setUserName(user.getUserName());
            resp.setUserEmail(user.getUserEmail());
            resp.setStatusCode("success");
            resp.setAccessToken("dummy.access.token." + System.currentTimeMillis());
            resp.setMessage("Login Success!");
        } else {
            resp.setStatusCode("error");
            resp.setMessage("User with email '" + email + "' and specified password could not be found");
        }
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
