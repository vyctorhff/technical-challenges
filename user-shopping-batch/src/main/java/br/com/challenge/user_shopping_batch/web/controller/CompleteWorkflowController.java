package br.com.challenge.user_shopping_batch.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complete")
@RequiredArgsConstructor
@Slf4j
public class CompleteWorkflowController {

    private final Job completWorkflow;
    private final JobLauncher jobLauncher;

    @PostMapping
    public ResponseEntity<Void> execute() {
        try {
            jobLauncher.run(completWorkflow, new JobParametersBuilder().toJobParameters());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("error during console batch ", e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
