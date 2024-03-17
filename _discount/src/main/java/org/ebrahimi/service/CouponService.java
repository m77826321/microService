package org.ebrahimi.service;

import lombok.extern.log4j.Log4j2;
import org.ebrahimi.entity.Coupon;
import org.ebrahimi.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CouponService {

    @Autowired
    private CouponRepository couponRepo;

    public List<Coupon> findAll() {

        return couponRepo.findAll();
    }

    public Coupon findById(Long id) {
        return couponRepo.findById(id).orElse(null);
    }

    public Coupon save(Coupon coupon) {
        return couponRepo.save(coupon);
    }

    public void deleteById(Long id) {
        couponRepo.deleteById(id);
    }

    public Coupon findByCode(String code) {
        log.info("findByCode: " + code);

        return couponRepo.findByCode(code).orElse(null);
    }
}


