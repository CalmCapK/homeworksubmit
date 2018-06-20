package Dao;

import java.util.List;

public interface Dao {
	void insert(Object bean);
	void update(Object bean);
	void delete(Object PKey);
	List  findAll();
	List findExecutingSQL(String sql, Object[] sqlParams);
}
