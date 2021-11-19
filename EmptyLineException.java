/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-09-07
 */

public class EmptyLineException extends Exception{
    /**
     * This exception is thrown when the line is empty.
     * @param message This is the parameter that is extended by Exception.
     *                it allows the exception to return a message.
     */

    public EmptyLineException(String message){
        super(message);
    }
}
