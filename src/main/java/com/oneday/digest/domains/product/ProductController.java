package com.oneday.digest.domains.product;

import com.oneday.digest.core.http.ApiResult;
import com.oneday.digest.core.http.dto.ApiRequestDto;
import com.oneday.digest.domains.product.exception.ProductException;
import com.oneday.digest.domains.product.validation.ProductValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import static com.oneday.digest.core.http.ApiResult.ApiEntity;
@Slf4j
@AllArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;
    private final ProductValidator productValidator;
    @InitBinder
    public void init(WebDataBinder dataBinder) {
        log.info("init binder {}", dataBinder);
        dataBinder.addValidators(productValidator);
    }
    @GetMapping("/product")
    public ApiEntity<?> getProductList() {
        return ApiResult.success(productService.getProductList());
    }
    @GetMapping("/product/{id}")
    public ApiEntity<?> getProduct(@PathVariable long id) {
        return ApiResult.success(productService.getProduct(id));
    }

    @PostMapping("/product")
    public ApiEntity<?> addProduct(@Validated @RequestBody ProductRequestDto product, BindingResult bindingResult) throws ProductException {
        if(bindingResult.hasErrors()){
            log.info("errors={}", bindingResult);
            return ApiResult.error(HttpStatus.BAD_REQUEST, String.valueOf(bindingResult));
        }
        return ApiResult.success(productService.addProduct(product.toServiceDto()));
    }
    public record ProductRequestDto(String name, Integer price, Integer quantity) implements ApiRequestDto<ProductService.ServiceDto>{
        @Override
        public ProductService.ServiceDto toServiceDto() {
            return new ProductService.ServiceDto(name, price, quantity);
        }
    }
}
