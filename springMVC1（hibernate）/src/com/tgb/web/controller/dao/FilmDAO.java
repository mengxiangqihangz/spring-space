package com.tgb.web.controller.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.tgb.web.controller.entity.Film;

public class FilmDAO implements IFilmDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addFilm(Film film) {
		sessionFactory.getCurrentSession().save(film);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Film> getAllFilm() {
		String hql = "from Film";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}

	@Override
	public boolean delFilm(String id) {
		String hql = "delete Film f where f.id=?";
		System.out.println(id);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		return (query.executeUpdate() > 0);
	}

	@Override
	public Film getFilm(String id) {
		String hql = "from Film f where f.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);

		return (Film) query.uniqueResult();
	}

	@Override
	public boolean updateFilm(Film film) {
		String hql = "update Film f set f.proID=?,p.proName=? where p.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		/*
		 * query.setString(0, film.getProID()); query.setString(1,
		 * film.getProName()); query.setString(2, film.getId());
		 */
		return (query.executeUpdate() > 0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Film> getFilm3() {
		String hql = "from Film f where f.filmRank<4 order by f.filmRank asc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}

	@Override
	public Film getFilmByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Film f where f.filmName=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);

		return (Film) query.uniqueResult();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Film> getAllFilmIn(String in) {
		String hql = "from Film f where f.filmID in (?)";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, in);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Film> getFilmByScore5() {
		// TODO Auto-generated method stub
		String hql = "from Film f order by f.filmScore desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(5);
		return query.list();
	}

}
