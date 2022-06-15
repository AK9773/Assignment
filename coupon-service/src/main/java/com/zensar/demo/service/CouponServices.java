package com.zensar.demo.service;

import java.util.List;

import com.zensar.demo.entity.Coupon;

public interface CouponServices {
	public Coupon getCoupon(int couponId);

	public List<Coupon> getAllCoupon();

	public void insertCoupon(Coupon coupon);

	public void updateCoupon(int couponId, Coupon coupon);

	public void deleteCoupon(int couponId);
}
