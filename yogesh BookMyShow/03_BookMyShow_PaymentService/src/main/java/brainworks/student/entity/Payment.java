package brainworks.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    private String paymentId;
    private String userId;
    private  String bookingId;
    private Double amount;
    private  String paymentStatus;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDate createDate;


}
