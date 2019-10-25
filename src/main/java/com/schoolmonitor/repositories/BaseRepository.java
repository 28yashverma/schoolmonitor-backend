package com.schoolmonitor.repositories;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable> extends CrudRepository<T, ID>{

}
