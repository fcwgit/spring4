package cn.xyz.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    public static Car initByDefaultConst() throws Throwable{
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("cn.xyz.reflect.Car");

        Constructor constructor = clazz.getConstructor(null);
        Car car = (Car)constructor.newInstance();

        Method setBrand = clazz.getMethod("setBrand",String.class);
        setBrand.invoke(car,"红旗CA72");
        Method setColor = clazz.getMethod("setColor",String.class);
        setColor.invoke(car,"red");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed",int.class);
        setMaxSpeed.invoke(car,123);
        return car;
    }

    public static void main(String[] args) {
        try {
            Car car = ReflectTest.initByDefaultConst();
            car.introduce();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
