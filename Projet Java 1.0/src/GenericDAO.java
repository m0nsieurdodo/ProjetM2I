
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface GenericDAO<T> {
	Montre findById(Integer id) throws SQLException;
	ArrayList<Montre> findAll() throws SQLException ;
	void save (T entite);
	void delete (T entite);
	
}
