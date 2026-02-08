package br.com.challenge.user_shopping_batch.infra.batch.config;

import br.com.challenge.user_shopping_batch.infra.batch.tasklet.InsertFileTasklet;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class StepInsertFileConfig {

    @Bean
    public Step insertFileStep(JobRepository jobRepository,
                               PlatformTransactionManager transactionManager,
                               InsertFileTasklet insertFileTasklet) {
        return new StepBuilder("insertFile", jobRepository)
                .tasklet(insertFileTasklet, transactionManager)
                .build();
    }
}
