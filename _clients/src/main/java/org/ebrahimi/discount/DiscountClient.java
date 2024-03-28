package org.ebrahimi.discount;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("DISCOUNT")
public interface DiscountClient {
    @GetMapping("/api/v1/coupons/code/{code}")
    public Coupon findByCouponCode(@PathVariable("code") String code) ;
}


//http://DISCOUNT/api/v1/coupons/code/{code}
