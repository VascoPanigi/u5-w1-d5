package vascopanigi.u5_w1_d5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vascopanigi.u5_w1_d5.entities.Reservation;
import vascopanigi.u5_w1_d5.repositories.ReservationRepository;

@Service
@Slf4j
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public void saveReservation(Reservation newReservation){
        //quali sono i controlli che voglio fare su questo dato?


    }
}
