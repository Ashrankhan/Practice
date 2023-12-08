package com.example.productservice_proxy.Clients.DTO;

import com.example.productservice_proxy.dto.ratingDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreDto implements IClientDto {
    private Long id;
    private String title;
    private double price;
    private String description;

    private String image;
    private String category;
    private ratingDTO ratingdto;
}
