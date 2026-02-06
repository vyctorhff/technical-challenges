package br.com.challenge.user_shopping_batch.infra.batch.config;

import br.com.challenge.user_shopping_batch.infra.batch.dto.CsvShoppingRowInput;
import br.com.challenge.user_shopping_batch.infra.batch.dto.CsvShoppingRowOutput;
import br.com.challenge.user_shopping_batch.infra.batch.enums.JobParamNames;
import br.com.challenge.user_shopping_batch.infra.batch.processor.CsvRowProcessor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class StepCsvProcessorConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<CsvShoppingRowInput> readerFromCsv(
            @Value("#{jobParameters['client.file.download.path']}") String filePath
    ) {
        return new FlatFileItemReaderBuilder<CsvShoppingRowInput>()
                .name("csvUserShoppingReader")
//                .resource(new ClassPathResource("data/csv/file.csv"))
                .resource(new FileSystemResource(filePath))
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
                        (:idFile, :name, :shoppingDetail, :amount, :date)
                     """)
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }

    @Bean
    public Step stepImportFromCsvToDataBase(JobRepository jobRepository,
                                            PlatformTransactionManager transactionManager,
                                            ItemReader<CsvShoppingRowInput> readerFromCsv,
                                            CsvRowProcessor csvRowProcessor,
                                            DataSource dataSource) {

        return new StepBuilder("stepImportFromCsvToDataBase", jobRepository)
                .<CsvShoppingRowInput, CsvShoppingRowOutput>chunk(10, transactionManager)
                .reader(readerFromCsv)
                .processor(csvRowProcessor)
                .writer(dataBaseWriter(dataSource))
                .build();
    }
}
