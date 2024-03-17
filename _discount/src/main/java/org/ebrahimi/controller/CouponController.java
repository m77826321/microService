package org.ebrahimi.controller;

import org.ebrahimi.entity.Coupon;
import org.ebrahimi.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping("/list")
    public List<Coupon> findAll() {
        return couponService.findAll();
    }

    @GetMapping("/{id}")
    public Coupon findById(@PathVariable Long id) {
        return couponService.findById(id);
    }

    @PostMapping("/add")
    public Coupon save(@RequestBody Coupon coupon) {
        return couponService.save(coupon);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        couponService.deleteById(id);
    }

    @GetMapping("/code/{code}")
    public Coupon findByCouponCode(@PathVariable("code") String code) {

        return couponService.findByCode(code);
    }
}
