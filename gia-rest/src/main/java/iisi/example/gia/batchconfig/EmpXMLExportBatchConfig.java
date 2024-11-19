package iisi.example.gia.batchconfig;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableBatchProcessing
@Profile("xml-config")
@ImportResource("classpath:config/batch-config.xml")
public class EmpXMLExportBatchConfig {

}
