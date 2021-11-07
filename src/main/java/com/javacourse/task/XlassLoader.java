package com.javacourse.task;

import java.io.*;
import java.lang.reflect.Method;

/*
 作业: 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。
 */
public class XlassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception {

        final String className = "Hello";
        final String methodName = "hello";
        // 创建类加载器
        ClassLoader classLoader = new XlassLoader();
        // 加载相应的类
        Class<?> clazz = classLoader.loadClass(className);
        // 看看里面有些什么方法
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(clazz.getSimpleName() + "." + m.getName());
        }
        // 创建对象
        Object instance = clazz.getDeclaredConstructor().newInstance();
        // 调用实例方法
        Method method = clazz.getMethod(methodName);
        method.invoke(instance);
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] bytes = null;

        try {
            bytes = loadClassData(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (null != bytes) {
            return defineClass(name, bytes, 0, bytes.length);
        } else {
            return null;
        }
    }

    private byte[] loadClassData(String name) throws FileNotFoundException {
        // 文件后缀
        final String suffix = ".xlass";
        // 获取输入流
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(name + suffix);

        try {
            // 读取数据
            int length = inputStream.available();
            byte[] data = new byte[length];
            inputStream.read(data);

            // 解码
            byte[] bytes = decode(data);
            return bytes;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(inputStream);
        }

        return null;
    }

    private static byte[] decode(byte[] bytes) {
        byte[] byteArray = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            byteArray[i] = (byte) (255 - bytes[i]);
        }
        return byteArray;
    }


    private static void close(Closeable res) {
        if (null != res) {
            try {
                res.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
