package com.tgb.web.controller.service;

import java.util.List;

import com.tgb.web.controller.dao.IFilmDAO;
import com.tgb.web.controller.entity.Film;


public class FilmManager implements IFilmManager {
	
	private IFilmDAO filmDao;


	public void setFilmDao(IFilmDAO filmDao) {
		this.filmDao = filmDao;
	}


	@Override
	public void addFilm(Film film) {
		filmDao.addFilm(film);
	}


	@Override
	public List<Film> getAllFilm() {
		return filmDao.getAllFilm();
	}


	@Override
	public boolean delFilm(String id) {
		return filmDao.delFilm(id);
	}


	@Override
	public Film getFilm(String id) {
		return filmDao.getFilm(id);
	}


	@Override
	public boolean updateFilm(Film film) {
		return filmDao.updateFilm(film);
	}


	@Override
	public Film getFilmByName(String name) {
		// TODO Auto-generated method stub
		return filmDao.getFilmByName(name);
	}


	@Override
	public List<Film> getFilm3() {
		// TODO Auto-generated method stub
		return filmDao.getFilm3();
	}


	@Override
	public List<Film> getFilmByScore5() {
		// TODO Auto-generated method stub
		return filmDao.getFilmByScore5();
	}



}
