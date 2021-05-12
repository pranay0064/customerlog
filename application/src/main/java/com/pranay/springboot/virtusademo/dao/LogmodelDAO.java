package com.pranay.springboot.virtusademo.dao;

import java.util.List;

import com.pranay.springboot.virtusademo.entity.Logmodel;

public interface LogmodelDAO {
	public List<Logmodel> findAll();
	public void saveit(Logmodel lm);
	public List<Logmodel> findByDate(String date);
}
