package iisi.example.gia.dept2.dao;

import iisi.example.gia.dept2.entity.Dept2DO;
import java.util.List;

public interface Dept2DAO {

	//INSERT
	int insert(Dept2DO dept2DO);
	
	//DELETE
	int delete(Integer deptno);
	
	//UPDATE
	int update(Dept2DO dept2DO);
	
	//SELECT One
	Dept2DO selectOne(Integer deptno);
	
	//SELECT All
	List<Dept2DO> selectAll();
	
}
