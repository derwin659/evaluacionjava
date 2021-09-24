
package controller;

import caseuse.CreateUser;
import entity.Phone;
import entity.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/users"})
public class UserRestController {
    private CreateUser createUser;

    public UserRestController(CreateUser createUser) {
        this.createUser = createUser;
    }

    @PostMapping(
            consumes = {"application/xml", "application/json"},
            produces = {"application/xml", "application/json"}
    )
    public ResponseEntity<User> newUser( @RequestBody User newUser, Phone newPhone) {
        User usuario = new User();
        Phone phone = new Phone();
        usuario.setName(newUser.getName());
        usuario.setPassword(newUser.getEmail());
        phone.setNumber(newPhone.getNumber());
        phone.setCityCode(newPhone.getCityCode());
        phone.setCountryCode(newPhone.getCountryCode());
        return new ResponseEntity(usuario, HttpStatus.OK);
    }
}
