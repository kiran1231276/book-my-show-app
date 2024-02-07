package brainworks.student.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ApiResponseStatus extends Throwable {
    private String msg;
    private boolean success;
}
