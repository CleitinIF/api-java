package br.com.springboot.error;

public class NotFoundError {
    private String errorMessage;

    public NotFoundError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
