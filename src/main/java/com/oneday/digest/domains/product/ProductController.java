package com.oneday.digest.domains.product;

import com.oneday.digest.core.http.ApiResult;
import com.oneday.digest.core.http.dto.ApiRequestDto;
import com.oneday.digest.domains.product.exception.ProductException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.oneday.digest.core.http.ApiResult.ApiEntity;
@Slf4j
@AllArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;
    @GetMapping("/product")
    public ApiEntity<?> getProductList() {
        return ApiResult.success(productService.getProductList());
    }
    @GetMapping("/product/{id}")
    public ApiEntity<?> getProduct(@PathVariable long id) {
        return ApiResult.success(productService.getProduct(id));
    }

    @PostMapping("/product")
    public ApiEntity<?> addProduct(@RequestBody ProductRequestDto product) throws ProductException {
        return ApiResult.success(productService.addProduct(product.toServiceDto()));
    }
    protected record ProductRequestDto(String name, int price, int quantity) implements ApiRequestDto<ProductService.ServiceDto>{
        @Override
        public ProductService.ServiceDto toServiceDto() {
            return new ProductService.ServiceDto(name, price, quantity);
        }
    }
}
