package vascopanigi.u5_w1_d5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vascopanigi.u5_w1_d5.entities.Reservation;
import vascopanigi.u5_w1_d5.exceptions.IllegalReservationException;
import vascopanigi.u5_w1_d5.repositories.ReservationRepository;

import java.util.List;

@Service
@Slf4j
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public void saveReservation(Reservation reservation){
        //I. controllo se ci sono prenotazioni attive per quel giorno in quello workspace
        List<Reservation> existingReservations = reservationRepository.findByUser_UsernameAndReservationDate(reservation.getUser().getUsername(), reservation.getReservationDate());

        if (!existingReservations.isEmpty()){
//            throw new IllegalArgumentException("You already have an active reservation in this date.");
//            System.out.println("You already have an active reservation in this date.");
            throw new IllegalReservationException(reservation.getReservationDate());
        }

        reservationRepository.save(reservation);

    }
}
