
import java.util.List;

public interface GenericDAO<T> {
	T findById(Integer id);
	List<T> findAll();
	void save (T entite);
	void delete (T entite);
	
}
