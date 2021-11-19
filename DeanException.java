/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-09-07
 */

public class DeanException extends Exception{

    /**
     * This exception is thrown when the line has reached maximum capacity.
     * @param message This is the parameter that is extended by Exception.
     *                it allows the exception to return a message.
     */

    public DeanException(String message){
        super(message);
    }
}
