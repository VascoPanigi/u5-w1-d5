package vascopanigi.u5_w1_d5.exceptions;

import java.time.LocalDate;
import java.util.UUID;

public class IllegalReservationException extends RuntimeException {

        public IllegalReservationException(LocalDate date){super("You already have an active reservation in this date: " + date);}

}
