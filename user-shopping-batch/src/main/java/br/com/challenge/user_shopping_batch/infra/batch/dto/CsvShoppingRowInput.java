package br.com.challenge.user_shopping_batch.infra.batch.dto;

public record CsvShoppingRowInput(
        String name,
        String shoppingDetail,
        String amount,
        String date
) {
}
