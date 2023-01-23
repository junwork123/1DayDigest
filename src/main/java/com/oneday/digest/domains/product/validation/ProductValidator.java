package com.oneday.digest.domains.product.validation;

import com.oneday.digest.domains.product.ProductController;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {
    private final int MIN_PRICE = 1000;
    private final int MAX_PRICE = 1000000;
    private final int MAX_QUANTITY = 9999;
    private final int MIN_TOTAL_PRICE = 10000;
    @Override
    public boolean supports(Class<?> clazz) {
        return ProductController.ProductRequestDto.class.isAssignableFrom(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        ProductController.ProductRequestDto product = (ProductController.ProductRequestDto) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemName", "required");

        if (isInvalidPrice(product)) {
            errors.rejectValue("price", "range", new Object[]{MIN_PRICE, MAX_PRICE}, null);
        }
        if (isInvalidQuantity(product)) {
            errors.rejectValue("quantity", "max", new Object[]{MAX_QUANTITY}, null);
        }
        //특정 필드 예외가 아닌 전체 예외
        if (isInvalidTotalPrice(product)) {
            errors.reject("totalPriceMin", new Object[]{MIN_TOTAL_PRICE, getTotalPrice(product)}, null);
        }
    }
    private boolean isInvalidPrice(ProductController.ProductRequestDto product) {
        return product.price() == null || product.price() < MIN_PRICE || product.price() > MAX_PRICE;
    }
    private boolean isInvalidQuantity(ProductController.ProductRequestDto product) {
        return product.quantity() == null || product.quantity() > MAX_QUANTITY;
    }
    private boolean isInvalidTotalPrice(ProductController.ProductRequestDto product) {
        return getTotalPrice(product) < MIN_TOTAL_PRICE;
    }
    private int getTotalPrice(ProductController.ProductRequestDto product) {
        return product.price() * product.quantity();
    }
}