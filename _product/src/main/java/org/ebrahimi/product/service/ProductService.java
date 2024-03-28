package org.ebrahimi.product.service;

import org.ebrahimi.discount.Coupon;
import org.ebrahimi.discount.DiscountClient;
import org.ebrahimi.product.dto.ProductRequest;
import org.ebrahimi.product.entity.Product;
import org.ebrahimi.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private DiscountClient discountClient;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product create(ProductRequest productRequest) {
        // Rest Tamplate
        // Coupon coupon = restTemplate.getForObject("http://DISCOUNT/api/v1/coupons/code/{code}", Coupon.class, productRequest.getCode());
        // Feign Client
        Coupon coupon = discountClient.findByCouponCode(productRequest.getCode());
        assert coupon != null;
        BigDecimal subtract = new BigDecimal("100").subtract(coupon.getDiscount());
        var product = Product.builder()
                .description(productRequest.getDescription())
                .price(subtract.multiply(new BigDecimal(productRequest.getPrice()).divide(new BigDecimal("100"))))
                .name(productRequest.getName())
                .build();

        return productRepository.save(product);
    }

    public Product update(Long id, Product updatedProduct) {
        Product product = findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        // Map updated product fields to existing product
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
