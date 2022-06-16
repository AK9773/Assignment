package com.zensar.demo.service;

import java.util.List;

import com.zensar.demo.dto.CouponDto;
import com.zensar.demo.entity.Coupon;

public interface CouponServices {
	public CouponDto getCoupon(int couponId);

	public List<CouponDto> getAllCoupon(int pageNumber, int pageSize);

	public CouponDto insertCoupon(CouponDto couponDto);

	public CouponDto updateCoupon(int couponId, CouponDto couponDto);

	public void deleteCoupon(int couponId);

	List<CouponDto> findByPercentDiscount(int percentDiscount);

	List<CouponDto> findByCouponCodeOrPercentDiscount(int couponCode, int percentDiscount);

	List<CouponDto> test(int percentDiscount);

	List<CouponDto> test2(int couponCode, int percentDiscount);
}
