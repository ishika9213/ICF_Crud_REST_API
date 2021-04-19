package com.howtodoinjava.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.EducationalQualificationsEntity;
import com.howtodoinjava.demo.repository.EducationalQualificationsRepository;

@Service
public class EducationalQualificationsService {
	
	@Autowired
	EducationalQualificationsRepository repository;
	
	public List<EducationalQualificationsEntity> getAllQualifications()
	{
		List<EducationalQualificationsEntity> result = (List<EducationalQualificationsEntity>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<EducationalQualificationsEntity>();
		}
	}
	
	public EducationalQualificationsEntity getQualificationsByEmpId(Long id) throws RecordNotFoundException 
	{
		Optional<EducationalQualificationsEntity> qualifications = repository.findById(id);
		
		if(qualifications.isPresent()) {
			return qualifications.get();
		} else {
			throw new RecordNotFoundException("No dependants record exist for given id");
		}
	}
	
	public EducationalQualificationsEntity createOrUpdateQualifications(EducationalQualificationsEntity entity) 
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<EducationalQualificationsEntity> qualifications = repository.findById(entity.getId());
			
			if(qualifications.isPresent()) 
			{
				EducationalQualificationsEntity newEntity = qualifications.get();
				newEntity.setEid(entity.getEid());
				newEntity.setType(entity.getType());
				newEntity.setStartDate(entity.getStartDate());
				newEntity.setEndDate(entity.getEndDate());
				newEntity.setInstitution(entity.getInstitution());
				newEntity.setAddress(entity.getAddress());
				newEntity.setPercentage(entity.getPercentage());
	 
	            newEntity = repository.save(newEntity);
	             
	            return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	public void deleteQualificationsById(Long id) throws RecordNotFoundException 
	{
		Optional<EducationalQualificationsEntity> qualifications = repository.findById(id);
		
		if(qualifications.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No dependants record exist for given id");
		}
	} 
}