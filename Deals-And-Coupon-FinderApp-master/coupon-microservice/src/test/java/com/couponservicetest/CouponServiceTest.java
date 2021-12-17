package com.couponservicetest;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.couponservice.entity.Coupon;
import com.couponservice.repository.CouponRepository;
import com.couponservice.service.CouponService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponServiceTest {

	@Autowired
	private CouponService service;

	@MockBean
	private CouponRepository repository;

	@Test
	public void fetchAllOrdersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Coupon("1", "sports",3,"20%","xyz"),
						new Coupon("2", "electronics",2,"10%","def")).collect(Collectors.toList()));
		assertEquals(2, service.findAll().size());
	}
	
	@Test
	public void saveTest() {
		Coupon coupon = new Coupon("23", "gadgets",1,"50%","lmn");
		when(repository.save(coupon)).thenReturn(coupon);
		assertEquals(coupon, service.save(coupon));
	}

}
