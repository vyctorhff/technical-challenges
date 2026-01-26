package br.com.challenge.user_shopping_batch.config;

import br.com.challenge.user_shopping_batch.infra.batch.CsvRowProcessor;
import br.com.challenge.user_shopping_batch.infra.batch.dto.CsvShoppingRowDTO;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    @Bean
    public FlatFileItemReader<String> readerFromCsv() {
        return new FlatFileItemReaderBuilder<String>()
                .name("csvUserShoppingReader")
                .resource(new ClassPathResource("data/csv/file.csv"))
                .delimited()
                .names("name", "shopping detail", "amount", "date")
                .lineMapper((line, number) -> line)
//                .targetType(CsvShoppingRowDTO.class)
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<CsvShoppingRowDTO> dataBaseWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<CsvShoppingRowDTO>()
                .sql("""
                     INSERT INTO TB_SHOPPING_LOG
                        (ID_FILE, DS_PRODUCT, VL_AMOUNT, DT_ORDER) VALUES
                        (:name, :detail, :amount, :date)
                     """)
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }

    @Bean
    public Step stepImportFromCsvToDataBase(JobRepository jobRepository,
                           PlatformTransactionManager transactionManager,
                           CsvRowProcessor csvRowProcessor,
                           DataSource dataSource) {
        return new StepBuilder("stepImportFromCsvToDataBase", jobRepository)
                .<String, CsvShoppingRowDTO>chunk(10, transactionManager)
                .reader(readerFromCsv())
                .processor(csvRowProcessor)
                .writer(dataBaseWriter(dataSource))
                .build();
    }

    @Bean
    public Job importFromCsvJob(JobRepository jobRepository,
                                Step stepImportFromCsvToDataBase) {
        return new JobBuilder("importFromCsvJob", jobRepository)
                .start(stepImportFromCsvToDataBase)
                .build();
    }
}
