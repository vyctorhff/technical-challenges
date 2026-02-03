package br.com.challenge.user_shopping_batch.infra.service;

import br.com.challenge.user_shopping_batch.infra.batch.enums.JobParamNames;
import br.com.challenge.user_shopping_batch.infra.db.entity.UserEntity;
import br.com.challenge.user_shopping_batch.infra.db.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CompleteWorkflowService {

    private final Job jobCompleteWorkflow;
    private final JobLauncher jobLauncher;

    private final UserRepository userRepository;

    public void execute() throws Exception {
        log.info("Staring completo workflow process");

        log.info("Searching active clients");
        List<UserEntity> userList = userRepository.findByEnable(Boolean.TRUE);

        if (userList.isEmpty()) {
            log.info("No client active. Ending process");
            return;
        }

        for (UserEntity entity : userList) {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong(JobParamNames.RUN_ID.getName(), System.currentTimeMillis())
                    .addLong(JobParamNames.CLIENT_ID.getName(), entity.id())
                    .addString(JobParamNames.CLIENT_NAME.getName(), entity.name())
                    .addString(JobParamNames.CLIENT_PATH.getName(), entity.config().pathFtp())
                    .addString(JobParamNames.CLIENT_FILE_NAME.getName(), entity.config().fileName())
                    .toJobParameters();

            jobLauncher.run(jobCompleteWorkflow, jobParameters);
        }
    }
}
