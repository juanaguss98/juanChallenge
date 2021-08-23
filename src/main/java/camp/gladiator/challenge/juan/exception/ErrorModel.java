package camp.gladiator.challenge.juan.exception;

import io.swagger.annotations.ApiModel;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@ApiModel(description = "Model for an error")
public class ErrorModel {

    private HttpStatus httpStatus;

    private LocalDateTime timestamp;

    private String message;

    private String details;

    public ErrorModel() {
    }

    public ErrorModel(String message, HttpStatus httpStatus, String details) {
        this.httpStatus = httpStatus;
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.details = details;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ErrorModel{" +
                "httpStatus=" + httpStatus +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
