package com.oneday.digest.domains.product;

import com.oneday.digest.core.http.ApiResult;
import com.oneday.digest.core.http.dto.ApiRequestDto;
import com.oneday.digest.domains.product.exception.ProductException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import static com.oneday.digest.core.http.ApiResult.ApiEntity;
@Slf4j
@Validated
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
    public ApiEntity<?> addProduct(@Valid @RequestBody ProductRequestDto product, BindingResult bindingResult) throws ProductException {
        if(bindingResult.hasErrors()){
            log.info("errors={}", bindingResult);
            return ApiResult.error(HttpStatus.BAD_REQUEST, String.valueOf(bindingResult));
        }
        return ApiResult.success(productService.addProduct(product.toServiceDto()));
    }
    public record ProductRequestDto(
            @NotBlank
            String name,
            @Range(min = 0, max = 1000000)
            Integer price,
            @Range(min = 0, max = 1000)
            Integer quantity) implements ApiRequestDto<ProductService.ServiceDto>{
        @Override
        public ProductService.ServiceDto toServiceDto() {
            return new ProductService.ServiceDto(name, price, quantity);
        }
    }
}
