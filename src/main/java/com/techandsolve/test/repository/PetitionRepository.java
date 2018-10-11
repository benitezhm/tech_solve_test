/**
 * 
 */
package com.techandsolve.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techandsolve.test.model.Petition;

/**
 * @author miguel
 *
 */
@Repository
public interface PetitionRepository extends JpaRepository<Petition, Long> {

}