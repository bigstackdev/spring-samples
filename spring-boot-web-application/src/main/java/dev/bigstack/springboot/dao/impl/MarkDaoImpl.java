package dev.bigstack.springboot.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dev.bigstack.springboot.constants.ErrorCodes;
import dev.bigstack.springboot.dao.MarkRepository;
import dev.bigstack.springboot.exception.InvalidStudentException;
import dev.bigstack.springboot.model.Mark;

@Repository
@Transactional
public class MarkDaoImpl implements MarkRepository {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public int save(Mark mark) {
		int r = 0;
		try {
         entityManager.persist(mark);
         r=mark.getId();
		} catch (Exception e) {
			throw new InvalidStudentException(e.getMessage(), ErrorCodes.ERROR_ENTITY_NOT_FOUND);
		}
		return r;
    }

	@Override
	public List<Mark> findAll() {
		return entityManager.createQuery("from MARK").getResultList();
	}
	
	
}
