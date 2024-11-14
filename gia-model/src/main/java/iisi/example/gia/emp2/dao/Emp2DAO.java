package iisi.example.gia.emp2.dao;

import iisi.example.gia.emp2.dto.Emp2ComplexSelectDTO;
import iisi.example.gia.emp2.dto.Emp2ExportDTO;
import iisi.example.gia.emp2.entity.Emp2DO;
import iisi.example.gia.emp2.dto.Emp2WithDnameDTO;
import java.util.List;
import java.util.Set;

public interface Emp2DAO {

	// INSERT
	int insert(Emp2DO emp2DO);

	// DELETE
	int delete(Integer empno);

	// UPDATE
	int update(Emp2DO emp2DO);

	// SELECT One
	Emp2DO selectOne(Integer empno);

//	// SELECT All
//	List<Emp2DO> selectAll();

	// SELECT Jobs
	Set<String> listJobs();

	// Complex SELECT
	List<Emp2WithDnameDTO> selectEmps(Emp2ComplexSelectDTO emp2ComplexSelectDTO);

	// SELECT the count of Complex SELECT result
	Integer selectEmpsCount(Emp2ComplexSelectDTO emp2ComplexSelectDTO);

	// SELECT ALL Emps for Output
	List<Emp2ExportDTO> selectForExport();

}
