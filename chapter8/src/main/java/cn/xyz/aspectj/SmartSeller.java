package cn.xyz.aspectj;

public class SmartSeller implements Seller {
    @Override
    public void sell(String goods) {
        System.out.println("SmartSeller : " + goods);
    }
}
