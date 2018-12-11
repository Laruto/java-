package com.wc.Demo.JVM;

import java.io.IOException;
import java.io.InputStream;

/**不同的类加载器对instanceof关键字运算结果的影响
 * Created by WC on 2018/12/11
 */

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{
        ClassLoader myloader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
//                return super.loadClass(name);
                try{
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null)
                        return super.loadClass(name);
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                }
                catch (IOException e){
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myloader.loadClass("com.wc.Demo.JVM.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.wc.Demo.JVM.ClassLoaderTest);

    }
}
