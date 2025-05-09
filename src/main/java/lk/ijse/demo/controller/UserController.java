package lk.ijse.demo.controller;

import lk.ijse.demo.dto.UserDTO;
import lk.ijse.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private final UserService userService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        try {
            System.out.println(userDTO);
            userService.saveUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);

        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }

    }
}
