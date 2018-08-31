package com.test.vegetable.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.vegetable.dao.entity.VegetableBag;

/**
 * Repository class for VegetableBag entity.
 * 
 * @author apparao
 *
 */
@Repository
public interface VegetableBagRepository extends JpaRepository<VegetableBag, String> {

}
