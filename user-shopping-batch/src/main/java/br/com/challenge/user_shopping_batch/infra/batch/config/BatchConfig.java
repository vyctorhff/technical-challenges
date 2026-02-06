package br.com.challenge.user_shopping_batch.infra.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

    /**
     * Complete workflow
     *
     * 1 - find user enabled
     * 2 - step - tasklet - download file
     * 3 - step - tasklet - insert TB_FILE
     * 4 - step - before - logging
     * 5 - step - csv process
     * 6 - step - after - data statistics
     * 7 - step - tasklet - remove download file
     * 8 - step - taslket - send email
     * 9 - step - tasklet - call integration
     */

    @Bean
    public Job jobCompleteWorkflow(JobRepository jobRepository,
                                Step downloadFtpFileStep) {
        return new JobBuilder("completWorkflow", jobRepository)
                .start(downloadFtpFileStep)
                .build();
    }
}
