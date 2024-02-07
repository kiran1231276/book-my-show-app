package brainworks.student.controller;

import brainworks.student.payload.UserDto;
import brainworks.student.payload.request.LoginDto;

import brainworks.student.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> allUser = userService.getAllUser ();
        return new ResponseEntity<> (allUser, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String userId) {
        UserDto user = userService.getUserById (userId);
        return new ResponseEntity<> (user, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable String userId) {
        Boolean isDeleted = userService.deleteUser (userId);
        if (!isDeleted) return new ResponseEntity<> ("Request failed", HttpStatus.NOT_FOUND);
        else return new ResponseEntity<> ("User deleted", HttpStatus.OK);
    }

    @PostMapping("/registration")
    public ResponseEntity<UserDto> registration(@Valid @RequestBody UserDto userDto) {
        UserDto user = userService.createUser (userDto);
        return new ResponseEntity<> (user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> userLogin(@Valid @RequestBody LoginDto loginDto) {
        UserDto logined = userService.login (loginDto);
        return  new ResponseEntity<> (logined,HttpStatus.OK);

    }

    @PatchMapping(value = "/{userId}",
            consumes = {"multipart/form-data","application/json","application/xml"})
    public ResponseEntity<UserDto> updateSpecificField(@PathVariable ("userId") String uId,@RequestBody Map<String,Object> objectMap){
        System.out.println (objectMap.isEmpty ());
        UserDto updatedUserDto = this.userService.updateSpecificField(uId,objectMap );
        return ResponseEntity.ok(updatedUserDto);
    }
//    @GetMapping("/getUserResponseDto")
//    public ResponseEntity<List<UserResponseDto>> getUserResponseDto() {
//        List<UserResponseDto> userResponseDto = userService.getUserResponseDto ();
//        return new ResponseEntity<> (userResponseDto, HttpStatus.OK);
//    }
}