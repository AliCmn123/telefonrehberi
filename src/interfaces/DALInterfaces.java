package interfaces;

import java.sql.SQLException;
import java.util.List;

public interface DALInterfaces<T> {
boolean insert (T entity) throws SQLException;
List<T> getAll () throws SQLException;

boolean delete(int id) throws SQLException;
boolean update(T entity) throws SQLException;
List<T> getBySearch (String search) throws SQLException;



}
