package br.com.challenge.payment.boundary.http;

import br.com.challenge.payment.boundary.http.dto.TransferRequestDTO;
import br.com.challenge.payment.boundary.http.swagger.TransferControllerSwagger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/transfer")
public class TransferController implements TransferControllerSwagger {

    @GetMapping
    public ResponseEntity<Void> transfer(@RequestBody TransferRequestDTO requestDTO) {
        return ResponseEntity.accepted().build();
    }
}
