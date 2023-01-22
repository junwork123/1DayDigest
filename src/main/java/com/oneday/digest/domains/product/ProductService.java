package com.oneday.digest.domains.product;

import com.oneday.digest.core.http.dto.ApiResponseDto;
import com.oneday.digest.core.http.dto.ApiServiceDto;
import com.oneday.digest.domains.product.entity.Product;
import com.oneday.digest.domains.product.exception.ProductException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProductService {
    public List<ResponseDto> getProductList() {
        return List.of(ResponseDto.of(new Product()));
    }
    public long addProduct(ServiceDto productDto) throws ProductException {
        Product product = productDto.toEntity();
        if (StringUtils.hasText(product.getName())) {
            throw new ProductException("name is required");
        }
        return 1;
    }

    public ResponseDto getProduct(long id) {
        return ResponseDto.of(new Product());
    }

    protected record ServiceDto(String name, int price, int quantity) implements ApiServiceDto<Product> {
        @Override
        public Product toEntity() {
            return Product.builder()
                    .name(name)
                    .price(price)
                    .quantity(quantity)
                    .build();
        }
    }

    protected record ResponseDto (String name, int price, int quantity) implements ApiResponseDto<Product> {
        public static ResponseDto of(Product product) {
            return new ResponseDto(product.getName(), product.getPrice(), product.getQuantity());
        }
    }
}
