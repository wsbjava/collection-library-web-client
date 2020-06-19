package pl.wsb.collection.libraryclientweb.exceptions;

public class UnauthenticatedException extends Exception {

    public UnauthenticatedException(){
        super("Unauthenticated access...");
    }

    public UnauthenticatedException(String message){
        super(message);
    }


}
