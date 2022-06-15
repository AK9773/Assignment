package com.zensar.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zensar.demo.Repository.CouponRepository;
import com.zensar.demo.entity.Coupon;

@Service
public class CouponServiceImpl implements CouponServices {

	@Autowired
	private CouponRepository couponRepository;

	@Override
	public Coupon getCoupon(int couponId) {

		return couponRepository.findById(couponId).get();
	}

	@Override
	public List<Coupon> getAllCoupon() {

		return couponRepository.findAll();
	}

	@Override
	public void insertCoupon(Coupon coupon) {
		couponRepository.save(coupon);

	}

	@Override
	public void updateCoupon(int couponId, Coupon coupon) {

		couponRepository.save(coupon);
	}

	@Override
	public void deleteCoupon(int couponId) {
		couponRepository.deleteById(couponId);
	}

}
