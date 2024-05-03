package fr.m2i.projet.DAO;



import java.sql.SQLException;
import java.util.ArrayList;


public interface GenericDAO<T> {
	T findById(Integer id) throws SQLException;
	ArrayList<T> findAll() throws SQLException ;
	void save (T entite, int id);
	void delete (T entite, int id);
	
	
}
