package com.zensar.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.demo.entity.Coupon;


public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	
	List<Coupon> findByPercentDiscount(int percentDiscount);
	
	List<Coupon> findByCouponCodeOrPercentDiscount(int couponCode, int percentDiscount);
}

