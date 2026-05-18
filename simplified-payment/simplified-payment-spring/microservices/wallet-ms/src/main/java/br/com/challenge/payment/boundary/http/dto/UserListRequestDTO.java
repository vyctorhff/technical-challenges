package br.com.challenge.payment.boundary.http.dto;

import java.util.List;

public record UserListRequestDTO (List<Integer> ids) {}