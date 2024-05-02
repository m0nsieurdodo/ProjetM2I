import java.sql.Connection;
import java.util.List;

public class MontreDAO implements GenericDAO<MontreDAO>{
	
	private Connection connection;
	
	public MontreDAO(Connection c) {
		connection = c;
	}

	@Override
	public MontreDAO findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MontreDAO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(MontreDAO entite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MontreDAO entite) {
		// TODO Auto-generated method stub
		
	};
	
	
}
