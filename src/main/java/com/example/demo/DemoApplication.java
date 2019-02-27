package com.example.demo;

import com.example.demo.Model.Admin;
import com.example.demo.Model.Events;
import com.example.demo.Model.User;
import com.example.demo.Repository.AdminRepository;
import com.example.demo.Repository.EventsRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.Controller"})
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private EventsRepository eventsRepository ;

    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private AdminRepository adminRepository  ;
    public void run(String...args) throws Exception {
    Events event =new Events(new Date(),new Date(),"randonne","rando a ain drahem" ,25,25,"bizerte");
 //    eventsRepository.save(event);
       // Optional<Events> ev =eventsRepository.findById(3);
       /* System.out.println(ev.getClass());*/
        //Admin admin = new Admin("toto","ben ","root","root","responsable rh","15 rue tunis","24010217" );
       // adminRepository.save(admin) ;
       //  event.get
      //  User u=userRepository.findByEmail("ichraf@gmail.com");
       // User usr =new User("ichraf" ,"benfadhl","0000",222222,"ichrafben70@gmail.com");
       //event.getParticipants().add(usr);
        //usr.getEvents().add(event);
       // eventsRepository.save(event);
      //  userRepository.save(usr);
      // System.out.println(event.getParticipants());

       /* userRepository.save(usr);
 usr.getEvents().add(event);
        // Cleanup the tables
        System.out.println(usr.getEvents().stream().findFirst());
        userRepository.save(usr);
       eventsRepository.save(event);
*/

// Cleanup the tables
     //   userRepository.save(usr);
       // System.out.println(usr.getEvents().stream().findFirst());
       //System.out.println(event.getParticipants().stream().findFirst());

   //  eventsRepository.save(event);

    }

}
