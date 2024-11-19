package iisi.example.gia.batchconfig;

import iisi.example.gia.emp2.dto.Emp2ExportDTO;
import iisi.example.gia.emp2.view.Emp2ExportVO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.mybatis.spring.batch.builder.MyBatisPagingItemReaderBuilder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
@Profile("java-config")
public class EmpExportBatchConfig {

    // 定義交易管理器，用於管理批次處理中的事務
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    // 定義 ItemReader
    @Bean
    @StepScope
    public MyBatisPagingItemReader<Emp2ExportDTO> empReader(SqlSessionFactory sqlSessionFactory){
        return new MyBatisPagingItemReaderBuilder<Emp2ExportDTO>()
                .sqlSessionFactory(sqlSessionFactory)
                .queryId("iisi.example.gia.emp2.dao.Emp2DAO.selectForExport")
                .pageSize(10)
                .build();
    }

    @Bean
    @StepScope
    public ItemProcessor<Emp2ExportDTO, Emp2ExportVO> empProcessor() {
        return empExportDTO -> {
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
        };
    }

    @Bean
    @StepScope
    public FlatFileItemWriter<Emp2ExportVO> empWriter(){
        return new FlatFileItemWriterBuilder<Emp2ExportVO>()
                .name("empWriter") // Writer 的名稱
                .resource(new FileSystemResource(BatchConstants.EXPORT_PATH + "/emp2_export.csv")) // 輸出檔案路徑
                .delimited() // 使用分隔符號格式 (csv)
                .delimiter(",") // 預設為 "," ，但明確標示
                .names("empno", "ename", "job", "hiredate", "sal", "comm", "deptno", "dname") // csv 的欄位順序
                .headerCallback(writer -> {
                        writer.write("\uFEFF");
                        writer.write("\"員工編號\", \"員工姓名\", \"職位\", \"到職日\", \"薪資\", \"獎金\", \"部門編號\", \"部門名稱\"");
                }) // csv 表頭
                .encoding("UTF-8")
                .build();
    }

    // 定義 Step
    @Bean
    public Step exportEmpStep(
            JobRepository jobRepository, // 用於儲存和更新 Job 的執行狀態
            PlatformTransactionManager transactionManager,
            MyBatisPagingItemReader<Emp2ExportDTO> empReader,
            ItemProcessor<Emp2ExportDTO, Emp2ExportVO> empProcessor,
            FlatFileItemWriter<Emp2ExportVO> empWriter){

        return new StepBuilder("exportEmpStep", jobRepository)
                .<Emp2ExportDTO, Emp2ExportVO> chunk(20, transactionManager)
                .reader(empReader)
                .processor(empProcessor)
                .writer(empWriter)
                .build();
    }

    // 定義 Job
    @Bean
    public Job exportEmpJob(JobRepository jobRepository, Step exportEmpStep){
        return new JobBuilder("exportEmpJob", jobRepository)
                .start(exportEmpStep) // 設定第一個 Step
                .build();
    }

}
