package org.example.API;

public class ApiAuthResponse {
    String message;
    String token;
    String status;

    public ApiAuthResponse(String message, String token, String status) {
        this.message = message;
        this.token = token;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ApiAuthResponse{" +
                "message='" + message + '\'' +
                ", token='" + token + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
