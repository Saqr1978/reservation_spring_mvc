/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Hotel;
import reservation.service.HotelServiceCRUD;

/**
 *
 * @author formation
 */
@Controller
@RequestMapping(value="/hotel")
public class HotelController {
    
    @Autowired
    private HotelServiceCRUD service; 
    
    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public String ajouterPOST( @ModelAttribute("hotel") Hotel h ){
        
        // Ajout en DB
        service.save(h);
        
        // Redirection ecran liste
        return "redirect:/hotel/lister";
    }
    
    @RequestMapping(value = "/ajouter", method = RequestMethod.GET)
    public String ajouterGET(Model m){
        
        Hotel h = new Hotel();
        
        m.addAttribute("hotel",h );
        
        return "/hotel/ajouter.jsp";
    }
    
    @RequestMapping(value="/modifier", method = RequestMethod.POST)
    public String modifierPOST( @ModelAttribute(value = "hotel") Hotel monHotel){
        
        // Modif en DB
        service.save(monHotel);
        
        // Redirection vers liste hotels
        return "redirect:/hotel/lister";
    }
    
    @RequestMapping("/modifier/{id}")
    public String modifierGET( Model model, @PathVariable("id") long hotelId){
        
        // Récup hotel en fonction id
        Hotel h = service.findOne(hotelId);
        
        // Passe cet hotel à la vue
        model.addAttribute("hotel", h);
        return "hotel/modifier.jsp";
    }
    
    @RequestMapping(value = "/supprimer/{idHotel}" )
    public String supprimer( @PathVariable(value = "idHotel") long id){
        
        // Supprime db DB
        this.service.delete( id );
        
        // Redirection vers liste
        return "redirect:/hotel/lister";
    }
    
    @RequestMapping(value = "/lister")
    public String lister(Model model){
        
        // Récupère liste hotels et la passe en attrib à la vue
        List<Hotel> hotels = (List<Hotel>) service.findAll();
        model.addAttribute("listeHotels", hotels);
        
        // Renvoie à la la vue
        return "hotel/lister.jsp";
    }
}
