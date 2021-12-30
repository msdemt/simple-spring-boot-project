package org.msdemt.simple.test;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 如何使用BigDecimal
 * https://blog.csdn.net/weixin_39861918/article/details/111199557
 */
public class BigDecimalTest {

    //猪肉单价（单位：kg）
    private static final BigDecimal MEAT_PRICE = new BigDecimal("19.98");
    //大米单价（单位：kg）
    private static final BigDecimal BIG_RICE_PRICE = new BigDecimal(3.33D);
    //小米单价（单位：kg）
    private static final BigDecimal SMALL_RICE_PRICE = BigDecimal.valueOf(3.33D);
    //清风卷纸（12包装）单价
    private static final BigDecimal QINGFENG_ROLL_PAPER_PRICE = BigDecimal.valueOf(25D);
    //维达卷纸（20包装）单价
    private static final BigDecimal VINDA_ROLL_PAPER_PRICE = BigDecimal.valueOf(50D);


    /**
     * double丢失精度问题
     */
    @Test
    public void testDouble(){
        double d1 = 1.0000001;
        double d2 = 0.0000001;
        double sum = d1 + d2;
        System.out.println("sum: " + sum); //sum: 1.0000002000000001
    }

    /**
     * BigDecimal参数类型为double的构造方法创建的数据会有误差
     *
     * 使用BigDecimal.valueOf(double)没有误差，是因为源码中调用了Double类型的toString方法，
     * 然后再调用了参数类型为String的构造函数创建该BigDecimal对象。
     *
     */
    @Test
    public void testBigDecimal1(){
        System.out.println("猪肉单价:" + MEAT_PRICE); //猪肉单价:19.98
        System.out.println("大米单价:" + BIG_RICE_PRICE); //大米单价:3.3300000000000000710542735760100185871124267578125
        System.out.println("小米单价:" + SMALL_RICE_PRICE); //小米单价:3.33
        System.out.println("清风卷纸单价:" + QINGFENG_ROLL_PAPER_PRICE); //清风卷纸单价:25.0
        System.out.println("维达卷纸单价:" + VINDA_ROLL_PAPER_PRICE); //维达卷纸单价:50.0
    }

    @Test
    public void testBigDecimal2(){
        BigDecimal amount = BigDecimal.valueOf(100D); //购物卡余额：100
        BigDecimal totalPrice = BigDecimal.ZERO; //总价初始化为 0
        //猪肉净含量
        double weightOfMeat = 2.25D;
        //小米净含量
        double weightOfSmallRice = 25.35D;
        //卷纸数量
        int quantityOfVinda = 1;

        //猪肉总价 19.98x2.25=44.955
        BigDecimal meatTotalPrice = MEAT_PRICE.multiply(BigDecimal.valueOf(weightOfMeat)).setScale(2, RoundingMode.HALF_UP); //44.96
        //小米总价 3.33x25.35=84.4155
        BigDecimal smallRiceTotalPrice = SMALL_RICE_PRICE.multiply(BigDecimal.valueOf(weightOfSmallRice)).setScale(2, RoundingMode.HALF_UP); //84.42
        System.out.println(SMALL_RICE_PRICE.multiply(BigDecimal.valueOf(weightOfSmallRice))); //84.4155
        //维达卷纸总价 50.0x1=50.0
        BigDecimal vindaRollPaperPrice = VINDA_ROLL_PAPER_PRICE.multiply(BigDecimal.valueOf(quantityOfVinda)).setScale(2, RoundingMode.HALF_UP); //50.00

        System.out.println("猪肉总价：" + meatTotalPrice); //猪肉总价：44.96
        System.out.println("小米总价：" + smallRiceTotalPrice); //小米总价：84.42
        System.out.println("维达卷纸总价：" + vindaRollPaperPrice); //维达卷纸总价：50.00

        //通过add（加法）计算总价 totalPrice
        totalPrice = totalPrice.add(meatTotalPrice).add(smallRiceTotalPrice).add(vindaRollPaperPrice); //179.38
        //通过 subtract（减法）计算差价
        BigDecimal differencePrice = amount.subtract(totalPrice);
        if(differencePrice.compareTo(BigDecimal.ZERO) < 0){
            System.out.println("请付款：" + differencePrice.abs() + "元，" + "购物卡余额：0元"); //请付款：79.38元，购物卡余额：0元
        }else{
            System.out.println("购物卡余额：" + differencePrice + "元。");
        }

        //通过divide（除法）计算一包清风纸的价格，设置采用四舍五入模式保留2位小数，并使用doubleValue方法将结果转化为double类型
        double qingFengSingle = QINGFENG_ROLL_PAPER_PRICE.divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP).doubleValue();
        //通过divide（除法）计算一包维达纸的价格
        double vindaSingle = VINDA_ROLL_PAPER_PRICE.divide(BigDecimal.valueOf(20)).setScale(2, RoundingMode.HALF_UP).doubleValue();
        int result = Double.compare(qingFengSingle, vindaSingle);

        if(result < 0){
            System.out.println("一包清风纸价格：" + qingFengSingle + "元，小于一包维达纸价格：" + vindaSingle + "元，所以购买清风更划算。"); //System.out.println("一包清风纸价格：" + qingFengSingle + "元，小于一包维达纸价格：" + vindaSingle + "元，所以购买清风更划算。");
        }else if(result == 0){
            System.out.println("一包清风纸价格：" + qingFengSingle + "元，等于一包维达纸价格：" + vindaSingle);
        }else{
            System.out.println("一包清风纸价格：" + qingFengSingle + "元，大于一包维达纸价格：" + vindaSingle + "元，所以购买维达更划算。");
        }
    }
}
