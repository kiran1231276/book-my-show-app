package brainworks.student.payload;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String userId;

    @NotNull
    @NotEmpty
    @Size(min = 2,message = "Atleast 2 characters expected!!!")
    private String fullname;

    @NotNull
    private LocalDate dob;

    @Email(message = "Email is not valid!!!")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@gmail\\.com$")
    private String email;

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    @Pattern (regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,20}$",message = "At least one uppercase letter, one lowercase letter, one digit, and minimum length of 8 characters")
    @JsonIgnoreProperties
    private String password;

}
