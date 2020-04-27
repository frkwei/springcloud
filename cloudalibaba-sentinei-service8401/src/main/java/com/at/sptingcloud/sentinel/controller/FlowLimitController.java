package com.at.sptingcloud.sentinel.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.util.TimeUtil;

@RestController
public class FlowLimitController {
	@GetMapping("/testA")
	public String testA() {
		System.out.println(Thread.currentThread().getName()+"---------------------------");
		return "--------------testA";
	}
	
	@GetMapping("/testB")
	public String testB() {
		
		return "--------------testB";
	}
	

	@GetMapping("/testD")
	public String testD() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "--------------testD";
	}
	
	@GetMapping("/hotkey")
	@SentinelResource(value="testhotkey",blockHandler = "deal_hotkey")
	public String hotKey(@RequestParam(value = "p1",required = false) String p1,
						 @RequestParam(value = "p2",required = false) String p2) {
		return "p1: "+p1+" "+ " p2:"+p2;
	}
	
	public String deal_hotkey(String p1,String p2,BlockException blockException){
		return "failed*****************************************************************";
	}
}
