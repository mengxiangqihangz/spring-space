package com.tgb.web.controller.service;

import java.util.List;

import com.tgb.web.controller.entity.Film;


public interface IFilmManager {
	
	public List<Film> getFilmByScore5();

	public void addFilm(Film file);
	
	public List<Film> getAllFilm();
	
	public List<Film> getFilm3();
	
	public boolean delFilm(String id);
	
	public Film getFilm(String id);
	
	public Film getFilmByName(String name);
	
	public boolean updateFilm(Film film);
}
