package br.com.challenge.payment.boundary.http.swagger;

import br.com.challenge.payment.boundary.http.dto.TransferRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Tag(
        name = "Transfer API",
        description = "Endpoints for transfer money"
)
public interface TransferControllerSwagger {

    @Operation(summary = "Transfer money from user to another ")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202",
                    content = {@Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = TransferRequestDTO.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "User not exists",
                    content = {@Content}
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Transfer was not approved",
                    content = {@Content}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Users can not transfer",
                    content = {@Content}
            )
    })
    ResponseEntity<Void> transfer(TransferRequestDTO requestDTO);
}
