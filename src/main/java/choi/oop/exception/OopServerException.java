package choi.oop.exception;

public class OopServerException extends RuntimeException {
    private ErrorCode code;
    
    public OopServerException(ErrorCode code, String message) {
        super(message);
        
        this.code = code;
    }
    
    public ErrorCode getErrorCode() {
        return this.code;
    }
}