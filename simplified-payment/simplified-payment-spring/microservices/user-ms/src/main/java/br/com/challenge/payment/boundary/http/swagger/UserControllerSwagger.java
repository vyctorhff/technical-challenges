package br.com.challenge.payment.boundary.http.swagger;

import br.com.challenge.payment.boundary.http.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User API", description = "Endpoint for user")
public interface UserControllerSwagger {

    @Operation(summary = "Get user by database Id")
    UserResponseDTO getUser(Integer id);
}
