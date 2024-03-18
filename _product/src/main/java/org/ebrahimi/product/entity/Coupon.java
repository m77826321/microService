package org.ebrahimi.product.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Coupon {

    private Long id;
    @NonNull
    private String code;
    @NonNull
    private BigDecimal discount;

    private LocalDate expireDate;



}
