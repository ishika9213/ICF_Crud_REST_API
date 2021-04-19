package com.howtodoinjava.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.DependantsEntity;
import com.howtodoinjava.demo.repository.DependantsRepository;

@Service
public class DependantsService {
	
	@Autowired
	DependantsRepository repository;
	
	public List<DependantsEntity> getAllDependants()
	{
		List<DependantsEntity> result = (List<DependantsEntity>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<DependantsEntity>();
		}
	}
	
	public DependantsEntity getDependantsByEmpId(Long id) throws RecordNotFoundException 
	{
		Optional<DependantsEntity> dependants = repository.findById(id);
		
		if(dependants.isPresent()) {
			return dependants.get();
		} else {
			throw new RecordNotFoundException("No dependants record exist for given id");
		}
	}
	
	public DependantsEntity createOrUpdateDependants(DependantsEntity entity) 
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<DependantsEntity> dependants = repository.findById(entity.getId());
			
			if(dependants.isPresent()) 
			{
				DependantsEntity newEntity = dependants.get();
				newEntity.setEid(entity.getEid());
	            newEntity.setFirstName(entity.getFirstName());
				newEntity.setLastName(entity.getLastName());
				newEntity.setGender(entity.getGender());
				newEntity.setDOB(entity.getDOB());
				newEntity.setRelationship(entity.getRelationship());
	 
	            newEntity = repository.save(newEntity);
	             
	            return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	public void deleteDependantsById(Long id) throws RecordNotFoundException 
	{
		Optional<DependantsEntity> dependants = repository.findById(id);
		
		if(dependants.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No dependants record exist for given id");
		}
	} 
}