package com.wc.Demo.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UnLog4j {

    //日志记录器
    private static Logger LOGGER = LogManager.getLogger(UnLog4j.class);
    //循环次数
    private static long CYCLE = 102;
    //程序入口——主函数
    public static void main(String[]args){
        long startTime = System.currentTimeMillis();
        //自动快速地使用缺省Log4j环境
        BasicConfigurator.configure();
        for(int i=0;i<CYCLE;i++){
            if(i<100){
                try{
                    LOGGER.info(i + "Person");//打印对象的信息
                }catch(Exception e){
                    LOGGER.error(i+"岁的小孩还不存在嘛！");//打印对象的信息
                }finally{
                    LOGGER.warn("现在大部分人的年龄都在0到100岁之间的!");//打印对象的信息
                }
            }else{
                LOGGER.info("我是一棵树，我今年活了"+i+"岁!哈哈，我厉害吧！");//打印对象的信息
            }
        }
        LOGGER.debug("此程序的运行时间是："+(System.currentTimeMillis()-startTime));//打印程序运行的时间
    }
}
