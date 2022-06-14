package com.zensar.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.demo.entity.Coupon;
import com.zensar.demo.service.CouponServices;

@RestController
@RequestMapping("/coupon-api")
public class CouponController {

	@Autowired
	private CouponServices couponServices;

	@GetMapping(value = "/coupon/{couponId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Coupon getCoupon(@PathVariable("couponId") int couponId) {
		return couponServices.getCoupon(couponId);
	}

	@GetMapping(value = "/coupon", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Coupon> getAllCoupon() {
		return couponServices.getAllCoupon();

	}

	@PostMapping(value = "/coupon", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public void insertCoupon(@RequestBody Coupon coupon) {
		couponServices.insertCoupon(coupon);
	}

	@PutMapping(value = "/coupon/{couponId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public void updateCoupon(@PathVariable("couponId") int couponId, @RequestBody Coupon coupon) {
		couponServices.updateCoupon(couponId, coupon);

	}

	@DeleteMapping("/coupon/{couponId}")
	public void deleteCoupon(@PathVariable("couponId") int couponId) {
		couponServices.deleteCoupon(couponId);

	}
}
