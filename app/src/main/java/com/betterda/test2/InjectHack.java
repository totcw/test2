package com.betterda.test2;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;

/**
 * Created by Administrator on 2016/7/27.
 */
public class InjectHack {

    public static void main(String[] args)
    {
        try {
            String path = "D:\\aswork\\test2\\shape\\build\\intermediates\\classes\\debug";
            ClassPool classes = ClassPool.getDefault();

            classes.appendClassPath(path);//项目的bin目录即可
            //会从classpath中查询该类
            CtClass c = classes.get("com.betterda.shape.LoadBugClass");
            CtConstructor ctConstructor = c.getConstructors()[0];
            //在上面的类中的构造方法中插入下面这句话
            ctConstructor
                    .insertAfter("System.out.println(com.betterda.shape.aa.AntilazyLoad.class);");
            c.writeFile(path + "/output");
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
