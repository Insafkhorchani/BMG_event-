package com.example.demo.Repository;

import com.example.demo.Model.Events;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.ParameterMetaData;
import java.util.Optional;

public interface  EventsRepository extends JpaRepository<Events,Long> {
    public Events  findById(long id);
    public  Events findByNom(String nom);



    @Query(value = "select  p from Events p where  p.nom like :x")
    public Page<Events> chercher(@Param("x") String  mcv , Pageable pageable);

    @Query(value = "select  p from Events p where  p.region like :x")
    public Page<Events> chercherRegion(@Param("x") String mcv ,Pageable pageable) ;



}

