package rmit.sept.group4tues1430.exceptions;

import rmit.sept.group4tues1430.model.User;

public class UserIdExceptionResponse {
    private String userIdentifier;

    public UserIdExceptionResponse(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public String getPersonIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }
}