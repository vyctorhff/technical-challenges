package br.com.challenge.user_shopping_batch.infra.batch.config;

import br.com.challenge.user_shopping_batch.infra.batch.tasklet.DownloadFileTasklet;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class StepFptConfig {

    @Bean
    public Step downloadFtpFileStep(JobRepository jobRepository,
                        PlatformTransactionManager transactionManager,
                        DownloadFileTasklet tasklet) {
        return new StepBuilder("fileDownloadFtp", jobRepository)
                .tasklet(tasklet, transactionManager)
                .build();
    }
}
