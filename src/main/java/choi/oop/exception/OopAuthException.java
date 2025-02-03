package choi.oop.exception;

import org.apache.tomcat.websocket.AuthenticationException;

public class OopAuthException extends AuthenticationException {
    private ErrorCode code;

    public OopAuthException(ErrorCode code, String message) {
        super(message);
        
        this.code = code;
    }
    
    public ErrorCode getErrorCode() {
        return this.code;
    }
}