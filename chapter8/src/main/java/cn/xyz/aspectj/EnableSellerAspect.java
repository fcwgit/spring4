package cn.xyz.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableSellerAspect {
    //为NaiveWaiter添加接口实现
    //SmartSeller默认的接口实现
    @DeclareParents(value = "cn.xyz.aspectj.NaiveWaiter",defaultImpl = SmartSeller.class)
    public Seller seller;//要实现的目标接口
}
