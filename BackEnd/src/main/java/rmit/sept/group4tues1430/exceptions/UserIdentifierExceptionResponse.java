package rmit.sept.group4tues1430.exceptions;

public class UserIdentifierExceptionResponse {
    private String userIdentifier;

    public UserIdentifierExceptionResponse(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }
}
