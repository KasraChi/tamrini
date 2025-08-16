package com.example.application.repository;

import com.example.application.model.PrepaidUserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrepaidUserInformationRepository extends JpaRepository<PrepaidUserInformation, Long> {

    long count();


//    @Query("select count() from Pre")
//   List<Integer> PrepaidUserInformationCount();


}
