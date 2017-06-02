/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Reservation;
import reservation.service.ReservationServiceCRUD;

/**
 *
 * @author formation
 */
@Controller
@RequestMapping(value = "/reservation")
public class ReservationController {
    
    @Autowired
    private ReservationServiceCRUD serviceReservation;
    
    @RequestMapping(value = "/lister", method = RequestMethod.POST)
    public String listerPOST(@ModelAttribute("reservation") Reservation reservation){
        //
    }

}
