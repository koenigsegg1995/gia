package iisi.example.gia.task;

import iisi.example.gia.emp2.dto.Emp2ExportDTO;
import iisi.example.gia.emp2.view.Emp2ExportVO;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;

public class EmpItemProcessor implements ItemProcessor<Emp2ExportDTO, Emp2ExportVO> {

    @Override
    public Emp2ExportVO process(@NonNull Emp2ExportDTO empExportDTO) throws Exception {
        // 包裝成 VO
        Emp2ExportVO empExportVO = new Emp2ExportVO();
        empExportVO.setEmpno(empExportDTO.getEmpno());
        empExportVO.setEname(empExportDTO.getEname());
        empExportVO.setJob(empExportDTO.getJob());
        empExportVO.setHiredate(empExportDTO.getHiredate());
        empExportVO.setComm(empExportDTO.getComm());
        empExportVO.setDeptno(empExportDTO.getDeptno());
        empExportVO.setDname(empExportDTO.getDname());

        return empExportVO;
    }

}
