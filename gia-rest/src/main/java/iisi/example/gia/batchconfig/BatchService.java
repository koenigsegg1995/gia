package iisi.example.gia.batchconfig;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchService {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job exportEmpJob;

    // ExportEmp
    public JobExecution exportJob() throws Exception{
        // 創建 Job 參數
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

        // 執行 Job 並回傳執行結果
        return jobLauncher.run(exportEmpJob, jobParameters);
    }

}
