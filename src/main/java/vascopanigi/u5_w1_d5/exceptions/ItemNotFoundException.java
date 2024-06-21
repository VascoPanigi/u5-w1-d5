package vascopanigi.u5_w1_d5.exceptions;

import java.util.UUID;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(UUID id){super("The record with id: " +id + " has not been found in our database.");}
}
