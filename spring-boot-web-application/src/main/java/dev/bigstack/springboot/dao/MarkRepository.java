package dev.bigstack.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import dev.bigstack.springboot.model.Mark;


@Transactional
public interface MarkRepository  {
	public int save(Mark mark);
	public List<Mark> findAll();
}
