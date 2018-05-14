package com.csit2111.perfectplaces.repository;

import com.csit2111.perfectplaces.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlaceRepository extends JpaRepository<Place, Long> {

   //@Query("select p from place where p.name = :name")
    //Place findPlaceByName(@Param("name") String name);
}
