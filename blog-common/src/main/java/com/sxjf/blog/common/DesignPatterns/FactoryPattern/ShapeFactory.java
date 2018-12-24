package com.sxjf.blog.common.DesignPatterns.FactoryPattern;
/**
 * Created with IntelliJ IDEA.
 * Description: 创建一个工厂，生成基于给定信息的实体类的对象。
 * Author: wangyang
 * Date: 2018/12/10
 * Time: 11:21
 */
public class ShapeFactory {
    //使用getShape方法获取形状类型的对象
    public Shape getShape(String shapeType){
        if (shapeType == null){
            return null;
        }
        if (shapeType.equals("Rectangle")){
            return new Rectangle();
        }
        if (shapeType.equals("Square")){
            return new Square();
        }
        if (shapeType.equals("Circle")){
            return new Circle();
        }
        return null;
    }
}
