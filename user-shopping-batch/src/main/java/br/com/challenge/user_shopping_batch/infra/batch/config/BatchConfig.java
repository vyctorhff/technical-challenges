package br.com.challenge.user_shopping_batch.infra.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

    @Bean
    public Job completWorkflow(JobRepository jobRepository,
                                Step downloadFtpFileStep) {
        return new JobBuilder("completWorkflow", jobRepository)
                .start(downloadFtpFileStep)
                .build();
    }
}
