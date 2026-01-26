package br.com.challenge.user_shopping_batch.config;

import br.com.challenge.user_shopping_batch.infra.batch.ConsoleWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@Slf4j
public class BatchConsoleConfig {

    @Bean
    ItemWriter<String> writerConsole() {
        return new ConsoleWriter();
    }

    @Bean
    public Step stepConsole(JobRepository jobRepository,
                            PlatformTransactionManager transactionManager,
                            ItemReader<String> readerFromCsv) {
        return new StepBuilder("consoleStep", jobRepository)
                .<String, String>chunk(3, transactionManager)
                .reader(readerFromCsv)
                .writer(writerConsole())
                .build();
    }

    @Bean
    public Job consoleCsvJob(JobRepository jobRepository, Step stepConsole) {
        return new JobBuilder("consoleCsvJob", jobRepository)
                .start(stepConsole)
                .build();
    }
}
