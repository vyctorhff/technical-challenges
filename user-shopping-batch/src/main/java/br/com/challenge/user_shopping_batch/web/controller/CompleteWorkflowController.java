package br.com.challenge.user_shopping_batch.web.controller;

import br.com.challenge.user_shopping_batch.infra.service.CompleteWorkflowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complete")
@RequiredArgsConstructor
@Slf4j
public class CompleteWorkflowController {

    private final CompleteWorkflowService service;

    @PostMapping
    public ResponseEntity<Void> execute() {
        try {
            service.execute();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("error during console batch ", e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
