package com.example.demo.Controller;


import com.example.demo.Model.Events;
import com.example.demo.Repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EventsController  {
    @Autowired
    EventsRepository eventsRepository ;
    @GetMapping ("/accueil")
    public String accueil(Model model)
    { return "home" ;
    }


    @GetMapping("/afficher")
    public  String afficher(Model model)
    {
        List<Events> events =eventsRepository.findAll();
        model.addAttribute("listEvents",events) ;
        return "listedEvents" ;
    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(Long id)
    {
        eventsRepository.deleteById(id);
        return "redirect:/afficher" ;

    }
    @GetMapping  ("/addEvent")
    public  String nouveau (Model model){
        model.addAttribute("ev" ,new Events())   ;
        return  "addev" ;

    }


    @PostMapping ("/addEvent")
    public  String addEvent(Model model , @ModelAttribute @Valid Events  ev ,BindingResult bindingResult )
    {
        Events eventIdExist = eventsRepository.findById(ev.getId()) ;
        Events eventNomExist =eventsRepository.findByNom(ev.getNom()) ;
        if((eventNomExist !=null) || (eventIdExist != null))
        {
            return ("addev") ;

        }
        eventsRepository.save(ev) ;
        return("redirect : /afficher") ;

    }



    @RequestMapping("/rechercherByName")
    public String rechercherByName(Model model ,
                                   @RequestParam (name = "mc" ,defaultValue = "")String mc ,
                                   @RequestParam (name = "page" ,defaultValue = "0")int page,
                                   @RequestParam (name = "size" ,defaultValue = "4")int   size)
    { Page<Events> pageEvents = eventsRepository.chercher("%"+mc+"%" ,new PageRequest(page,size));
        model.addAttribute("listEvents",pageEvents.getContent());
        int[] pages = new int [pageEvents.getTotalPages()];
        model.addAttribute("motcle",mc);
        model.addAttribute ("pages",pages) ;
        return "recherche"   ;
    }
    @RequestMapping("/rechercherById")
    public String rechercherById(Model model , @RequestParam (name = "mc" ,defaultValue = "")long mc )

    {Events events = eventsRepository.findById(mc) ;

        model.addAttribute("motcle",mc);
        model.addAttribute ("event",events) ;

        return "rechercheId"   ;
    }


    @RequestMapping("/rechercherByPlace")
    public String rechercherByPlace(Model model ,
                                    @RequestParam (name = "mc" ,defaultValue = "")String mc ,
                                    @RequestParam (name = "page" ,defaultValue = "0")int page,
                                    @RequestParam (name = "size" ,defaultValue = "4")int   size)
    { Page<Events> pageEvents = eventsRepository.chercherRegion("%"+mc+"%" ,new PageRequest(page,size));
        model.addAttribute("listEvents",pageEvents.getContent());
        int[] pages = new int [pageEvents.getTotalPages()];
        model.addAttribute("motcle",mc);
        model.addAttribute ("pages",pages) ;
        return "rechercherRegion"   ;
    }









}

