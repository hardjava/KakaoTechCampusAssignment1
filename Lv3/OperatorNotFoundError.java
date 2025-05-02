package Lv3;

public class OperatorNotFoundError extends RuntimeException{
    public OperatorNotFoundError(String message){
        super(message);
    }
}