package br.com.challenge.user_shopping_batch.infra.batch.config;

import br.com.challenge.user_shopping_batch.infra.batch.processor.CsvRowProcessor;
import br.com.challenge.user_shopping_batch.infra.batch.dto.CsvShoppingRowInput;
import br.com.challenge.user_shopping_batch.infra.batch.dto.CsvShoppingRowOutput;
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
public class StepCsvProcessorConfig {

    @Bean
    public FlatFileItemReader<CsvShoppingRowInput> readerFromCsv() {
        return new FlatFileItemReaderBuilder<CsvShoppingRowInput>()
                .name("csvUserShoppingReader")
                .resource(new ClassPathResource("data/csv/file.csv"))
                .linesToSkip(1)
                .delimited()
                .delimiter(";")
                .names("name", "shoppingDetail", "amount", "date")
                .targetType(CsvShoppingRowInput.class)
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<CsvShoppingRowOutput> dataBaseWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<CsvShoppingRowOutput>()
                .sql("""
                     INSERT INTO TB_SHOPPING_LOG
                        (ID_FILE, DS_PRODUCT, VL_AMOUNT, DT_ORDER) VALUES
                        (:name, :shoppingDetail, :amount, :date)
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
                .<CsvShoppingRowInput, CsvShoppingRowOutput>chunk(10, transactionManager)
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
