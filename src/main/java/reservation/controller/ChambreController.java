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
import reservation.entity.Chambre;
import reservation.service.ChambreServiceCRUD;
import reservation.service.HotelServiceCRUD;

/**
 *
 * @author formation
 */
@Controller
@RequestMapping(value="/chambre")
public class ChambreController {

    @Autowired
    private ChambreServiceCRUD chambreService;
    
    @Autowired
    private HotelServiceCRUD hotelService;
    
    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public String ajouterPOST(@ModelAttribute("chambre") Chambre chambre)
    {
        // Ajout DB
        chambreService.save(chambre);
        
        // Redirection vers 
        return "redirect:/chambre/lister";
    }
    
    @RequestMapping(value = "/ajouter", method = RequestMethod.GET)
    public String ajouterGET(Model model)
    {
        //ajouter au modèle liste hotels
        model.addAttribute("hotels", hotelService.findAll());
        
        //Ajouter mon ModelAttribute (= DTO) au modèle
        model.addAttribute("chambre", new Chambre());
        return "/chambre/ajouter.jsp";
        
    }
    
    @RequestMapping(value = "/modifier", method = RequestMethod.POST)
    public String modifierPOST(@ModelAttribute(value = "chambre") Chambre chambre){
        
        //ajout db
        chambreService.save(chambre);
        
        //redirection sur liste
        return "/chambre/modifier";
    }
    
    @RequestMapping(value = "/modifier/{idChambre}", method = RequestMethod.GET)
    public String modifierGET(Model model, @PathVariable(value = "idChambre") long idChambre){
        
        //selection chambre à modifier en fonction id
        Chambre chambre = chambreService.findOne(idChambre);
        
        //modification
        model.addAttribute(chambre);
        
        return "/chambre/modifier.jsp";
    }

    @RequestMapping(value = "/supprimer/{id}", method = RequestMethod.GET)
    public String supprimerChambre(@PathVariable(value="id") long idChambre){
        //trouver puis supprimer la chambre
        this.chambreService.delete(idChambre);
        
        //redirection vers liste de chambres
        return "redirect:/chambre/lister";
        
    }
    
    @RequestMapping(value = "/lister", method = RequestMethod.GET)
    public String lister(Model model){
        //recuperation de la liste de toutes les chambres
        List<Chambre> chambres = (List<Chambre>) chambreService.findAll();
        
        //envoi sur la vue
        model.addAttribute("listeChambres", chambres);
        
        return "/chambre/lister.jsp";
        
        
    }
    
}
