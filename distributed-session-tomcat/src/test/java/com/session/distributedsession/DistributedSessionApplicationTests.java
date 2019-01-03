package com.session.distributedsession;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.whalin.MemCached.MemCachedClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistributedSessionApplicationTests {
	@Autowired
	private MemCachedClient memCachedClient;

	@Test
	public void contextLoads() {
		// 放入缓存
		memCachedClient.set("a", 1);

		// 取出缓存
		Object a = memCachedClient.get("a");
		System.out.println(a);

		// 3s后过期
		memCachedClient.set("b", "2", new Date(3000));
		Object b = memCachedClient.get("b");
		System.out.println(b);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		b = memCachedClient.get("b");
		System.out.println(a);
		System.out.println(b);
	}

}
