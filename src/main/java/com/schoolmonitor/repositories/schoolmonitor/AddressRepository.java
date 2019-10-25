package com.schoolmonitor.repositories.schoolmonitor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.schoolmonitor.entities.schoolmonitor.Address;
/**
 * @author PrabhjeetS
 * @version 1.0
 */

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
