package com.example.demo.Controller;

import com.example.demo.Model.Events;
import com.example.demo.Model.User;
import com.example.demo.Repository.EventsRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.Optional;

@Controller
public class Event_ParticipantController {

    @Autowired
    private EventsRepository eventsRepository ;

    @Autowired
    private UserRepository userRepository ;

    @GetMapping("/event/{id}")
    public String addEventParticipant (Model model){
        Events event1 = eventsRepository.getOne((long) 47);
        model.addAttribute("event1", event1);
        return "home" ;
    }

    @PostMapping("/event")
    public String addEventParticipant1(@ModelAttribute Events ev ,@RequestParam(value="id")String i , HttpSession session){
       Events event1= (Events) eventsRepository.getOne( Long.parseLong(i));
       System.out.println(event1.getId());
       Long id= (Long) session.getAttribute("user");
        User participant = userRepository.getOne((long) 66) ;
        System.out.println(participant.getId());
        participant.getEvents().add(event1);
         event1.getParticipants().add(participant);
        Optional<Events> eve =participant.getEvents().stream().findFirst();
        System.out.println(eve.toString());
        event1.setNbre_de_place(event1.getNbre_de_place()-1);
        eventsRepository.save(event1);

        return "test";
    }
}
