package org.apache.jmeter;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author Susanna
 * @date 2021/6/28 15:09
 */
public class RandomDemoFunctions extends AbstractJavaSamplerClient{

    private static Logger logger = LogManager.getLogger(RandomDemoFunctions.class.getName());
    private String x;

    /**
     * 这个方法是用来自定义java方法入参的
     * params.addArgument("x","");表示入参名字叫x，默认值为空。
     * @return
     */
    @Override
    public Arguments getDefaultParameters() {
        Arguments params = new Arguments();
        params.addArgument("x","");
        return params;
    }

    /**
     * 每个线程测试前执行一次，做一些初始化工作
     * 获取输入的参数,赋值给变量,参数也可以在下面的runTest方法中获取,这里是为了展示该方法的作用
     * @param arg0
     */
    @Override
    public void setupTest(JavaSamplerContext arg0) {
        x = arg0.getParameter("x");
        System.out.println("x的值：" + x);
    }

    /**
     * 真正执行逻辑的方法
     * @param arg0
     * @return
     */
    @Override
    public SampleResult runTest(JavaSamplerContext arg0) {
        SampleResult sr = new SampleResult();
        sr.setSamplerData("请求参数x的值为："+x);
        try {
            // jmeter 开始统计响应时间标记
            sr.sampleStart();
            int sum = Integer.parseInt(x);
            if (sum<0){
                logger.info(sum + "<0的值是"+ "-1");
                // 通过下面的操作就可以将被测方法的响应输出到Jmeter的察看结果树中的响应数据里面了。
                sr.setResponseData("结果是："+"-1", "utf-8");
                System.out.println("比较结果是："+ -1);
                //设置响应失败
                sr.setSuccessful(false);
            }
            else {
                String str = String.valueOf(x);
                final StringBuilder builder = new StringBuilder(str);
                if (builder.reverse().toString().equals(str)) {  //reverse 字符串反转，比如输入66，反转后为66，再做比较
                    logger.info(sum + ">0的值做比较后是"+ "0");
                    // 通过下面的操作就可以将被测方法的响应输出到Jmeter的察看结果树中的响应数据里面了。
                    sr.setResponseData("结果是："+"0", "utf-8");
                    System.out.println("比较结果是："+ 0);
                    sr.setDataType(SampleResult.TEXT);
                }else {
                    logger.info(sum + ">0的值是"+ "1");
                    // 通过下面的操作就可以将被测方法的响应输出到Jmeter的察看结果树中的响应数据里面了。
                    sr.setResponseData("结果是："+"1", "utf-8");
                    System.out.println("比较结果是："+ 1);
                }
                //设置响应执行成功
                sr.setSuccessful(true);

            }
        } catch (Throwable e) {
            //有异常,执行失败
            sr.setSuccessful(false);
            e.printStackTrace();
        } finally {
            // jmeter 结束统计响应时间标记
            sr.sampleEnd();
        }
        return sr;
    }

    /**
     * 测试结束后调用
     * @param arg0
     */
    @Override
    public void teardownTest(JavaSamplerContext arg0) {
        SampleResult sr = new SampleResult();
        logger.info("测试结束");
        // 通过下面的操作就可以将被测方法的响应输出到Jmeter的察看结果树中的响应数据里面了。
        sr.setResponseData("测试结束", "utf-8");
    }

    public static void main(String[] args) {
        // 测试测试类是否有问题，打包的时候需要注释掉
        Arguments params = new Arguments();
        params.addArgument("x", "88");
        JavaSamplerContext arg0 = new JavaSamplerContext(params);
        RandomDemoFunctions test = new RandomDemoFunctions();
        test.setupTest(arg0);
        test.runTest(arg0);
        test.teardownTest(arg0);
    }
}
