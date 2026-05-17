package br.com.challenge.payment.boundary.http.swagger;

import br.com.challenge.payment.boundary.http.dto.UserListRequestDTO;
import br.com.challenge.payment.boundary.http.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.List;

@Tag(name = "User API", description = "Endpoint for user")
public interface UserControllerSwagger {

    @Operation(summary = "Get user by database Id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = {@Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserResponseDTO.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "User not found it",
                    content = {@Content}
            )
    })
    UserResponseDTO getUser(Integer id);

    @Operation(summary = "Get two or more user at the same time")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = {@Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = List.class)
                    )}
            )
    })
    List<UserResponseDTO> getUsers(UserListRequestDTO dto);
}
