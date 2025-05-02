package Lv1;

public class OperatorNotFoundError extends RuntimeException{
    public OperatorNotFoundError(String message){
        super(message);
    }
}