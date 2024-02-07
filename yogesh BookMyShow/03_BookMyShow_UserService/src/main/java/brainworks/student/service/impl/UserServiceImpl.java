package brainworks.student.service.impl;

import brainworks.student.entity.User;
import brainworks.student.exception.ResourceNotFoundException;
import brainworks.student.payload.request.LoginDto;
import brainworks.student.payload.UserDto;
import brainworks.student.payload.response.*;
import brainworks.student.repository.UserRepository;
import brainworks.student.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.*;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
//    @Autowired
//    MovieService movieService;
//    @Autowired
//    BookingService bookingService;
//    @Autowired
//    CinemaHallService cinemaHallService;
//    @Autowired
//    ShowtimeService showtimeService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId (UUID.randomUUID ().toString ());
        User user=new User ();
        BeanUtils.copyProperties (userDto,user);
        user.setPassword (passwordEncoder.encode (userDto.getPassword ()));
        User saved = userRepository.save (user);
        BeanUtils.copyProperties (saved,userDto);
        return userDto ;
    }
    @Override
    public UserDto getUserById(String userId) {
        User user = userRepository
                .findById (userId).orElseThrow (()->new ResourceNotFoundException ("User","userId",userId));
        UserDto userDto=new UserDto ();
        BeanUtils.copyProperties (user,userDto);
        //List<BookingDto> bookingDtoList = bookingService.getAllbookings ();
        //userDto.setBookingDtos (getBookingList (bookingDtoList));
        return userDto;
    }


//    private List<BookingDto> getBookingList(List<BookingDto> list) {
//        List<BookingDto> collect = list.stream ().map (bookings -> {
//            MovieDto movieById = movieService.getMovieById (bookings.getMovieId ());
//            CinemaHallDto cinemaHallById = cinemaHallService.getCinemaHallById (bookings.getCinemaHallId ());
//            ShowtimeDto showtimeById = showtimeService.getShowtimeById (bookings.getShowtimeId ());
//            bookings.setMovie (movieById);
//            bookings.setCinemaHall (cinemaHallById);
//            bookings.setShowtime (showtimeById);
//            return bookings;
//        }).collect (Collectors.toList ());
//        return collect;
//    }

//    @Override
//    public List<UserResponseDto> getUserResponseDto(){
//        List<BookingDto> bookingDtoList = bookingService.getAllbookings ();
//        List<UserResponseDto> userResponseDtoList=new ArrayList<> ();
//        for(BookingDto bookingDto:bookingDtoList){
//            UserResponseDto userResponseDto=new UserResponseDto ();
//            MovieDto movieById = movieService.getMovieById (bookingDto.getMovieId ());
//            CinemaHallDto cinemaHallById = cinemaHallService.getCinemaHallById (bookingDto.getCinemaHallId ());
//            ShowtimeDto showtimeById = showtimeService.getShowtimeById (bookingDto.getShowtimeId ());
//            satValues (bookingDto, userResponseDto, showtimeById, cinemaHallById, movieById, userResponseDtoList);
//        }
//        return userResponseDtoList;
//    }
//
//    private void satValues(BookingDto bookingDto, UserResponseDto userResponseDto, ShowtimeDto showtimeById, CinemaHallDto cinemaHallById, MovieDto movieById, List<UserResponseDto> userResponseDtoList) {
//        User user = userRepository.findById (bookingDto.getUserId ())
//                .orElseThrow (()->new ResourceNotFoundException ("User","userId", bookingDto.getUserId ()));
//
//        userResponseDto.setShowtimeDto (showtimeById);
//        userResponseDto.setCinemaHallDto (cinemaHallById);
//        userResponseDto.setMovieDto (movieById);
//        userResponseDto.setFullname (user.getFullname ());
//        userResponseDto.setEmail (user.getEmail ());
//        userResponseDto.setFood ("Burger");
//        userResponseDto.setFoodBill (100);
//        userResponseDto.setTotalBill (1000);
//        userResponseDto.setUserId (bookingDto.getUserId ());
//        userResponseDtoList.add (userResponseDto);
//    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> userList = userRepository.findAll ();
        List<UserDto> userDtoLIst=new ArrayList<> ();
        for(User user: userList){
            UserDto userDto = new UserDto ();
            BeanUtils.copyProperties (user, userDto);
            userDtoLIst.add (userDto);
        }
        return userDtoLIst;
    }


    @Override
    public Boolean deleteUser(String userId) {
        User user = userRepository
                .findById (userId).orElseThrow (() -> new ResourceNotFoundException ("User", "user", userId));
        if (user == null) return false;
        userRepository.delete (user);
        return true;
    }

    @Override
    public UserDto login(LoginDto loginDto) {
        try {
            String loginDtoUsername = loginDto.getUsername ();
            String loginDtoPassword = loginDto.getPassword ();
            User byUsername = userRepository.findByUsername (loginDtoUsername);
            String existingPassword = byUsername.getPassword ();
            if (passwordEncoder.matches (loginDtoPassword,existingPassword )) {
                UserDto userDto = new UserDto ();
                BeanUtils.copyProperties (byUsername, userDto);
                return userDto;
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return null;
    }

    @Override
    public UserDto updateSpecificField(String userId, Map<String, Object> fields) {

        User user = this.userRepository.findById (userId)
                .orElseThrow (() -> new ResourceNotFoundException ("User", "uId", userId));
        fields.forEach ((key, value) -> {
            Field field = ReflectionUtils.findField (User.class, key);
            Optional<Field> optionalField = Optional.ofNullable (field);
            if (optionalField.isPresent ()) {
                field.setAccessible (true);
                ReflectionUtils.setField (field, user, value);
            } else {
                // Handle the case where the field is not found.
                // You may want to log a warning or throw an exception.
                System.err.println ("Field not found: " + key);
            }
        });
        User savedUser = userRepository.save (user);
        UserDto userDto = new UserDto ();
        BeanUtils.copyProperties (savedUser, userDto);
        return userDto;
    }
}
