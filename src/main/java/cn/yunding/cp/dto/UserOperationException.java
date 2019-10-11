package cn.yunding.cp.dto;

/**
 * @author haoyuli
 */
public class UserOperationException extends RuntimeException {
    public UserOperationException(String message) {
        super(message);
    }

    public UserOperationException(String template, Object ... args) {
        super(String.format(template, args));
    }
}
