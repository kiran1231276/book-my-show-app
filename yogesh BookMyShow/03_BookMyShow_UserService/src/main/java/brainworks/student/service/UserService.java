package brainworks.student.service;

import brainworks.student.payload.request.LoginDto;
import brainworks.student.payload.UserDto;
import java.util.List;
import java.util.Map;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById (String userId);

    List<UserDto> getAllUser();

    Boolean deleteUser(String userId);

    UserDto login(LoginDto loginDto);

    UserDto updateSpecificField(String userId, Map<String, Object> fields);

    //List<UserResponseDto> getUserResponseDto();

}
