package brainworks.student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint (columnNames = "email")
})
public class User {
    @Id
    private String userId;
    private String fullname;
    private LocalDate dob;
    private String email;
    private String username;
    private String password;
    //@Transient
    //private List<BookingDto> bookingsList=new ArrayList<> ();
}
