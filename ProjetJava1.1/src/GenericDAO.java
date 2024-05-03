


import java.sql.SQLException;
import java.util.ArrayList;


public interface GenericDAO<T> {
	T findById(Integer id) throws SQLException;
	ArrayList<T> findAll() throws SQLException ;
	void save (T entite, Montre obj, int id);
	void delete (T entite, int id);
	/*void save(Montre montre);
	void save(Montre montre, int id);
	void delete(int id);*/
	
}
