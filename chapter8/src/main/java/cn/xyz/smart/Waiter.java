package cn.xyz.smart;

import cn.xyz.annotation.NeedTest;

public interface Waiter {
	@NeedTest
	public void greetTo(String clientName);	
	public void serveTo(String clientName);
}
