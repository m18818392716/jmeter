package org.apache.jmeter.functions;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;
import org.apache.jmeter.threads.JMeterVariables;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Susanna
 * @date 2021/6/16 20:42
 */
public class RandomPhoneJmeterFunctions extends AbstractFunction {
    private static Logger logger = LogManager.getLogger(RandomPhoneJmeterFunctions.class.getName());
    private String tel;
    //定义函数名称
    private static final String KEY = "__RandomPhone";
    //定义函数界面显示的参数名称
    private static final List<String> desc = new LinkedList<String>();
    static{
        desc.add("界面参数");
    }

    private static final String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153 ".split(",");

    private CompoundVariable varName;

    //业务主逻辑
    @Override
    public String execute(SampleResult sampleResult, Sampler sampler) throws InvalidVariableException {
        SampleResult sampleResult1 = new SampleResult();
        try {
            sampleResult1.sampleStart();
            int index=getNum(0,telFirst.length-1);
            String telNum = telFirst[index];
            String two = String.valueOf(getNum(1, 888) + 10000).substring(1);
            String three = String.valueOf(getNum(1, 9100) + 10000).substring(1);
            tel = telNum + two + three;
            logger.info("手机号区段："+ telNum +" 随机生成的手机号是：" + tel);
            if (varName != null) {
                JMeterVariables vars = getVariables();
                final String varTrim = varName.execute().trim();
                if (vars != null && varTrim.length() > 0) {
                    vars.put(varTrim, telNum);
                }
            }
            sampleResult1.setResponseData("手机号区段："+ telNum +" 随机生成的手机号是：" + tel,"utf-8");
            sampleResult1.setSuccessful(true);
        }catch (Exception e){
            sampleResult.setSuccessful(false);
            e.printStackTrace();

        }finally {
            sampleResult1.sampleEnd();

        }
        return tel;
    }

    //获取参数值
    @Override
    public void setParameters(Collection<CompoundVariable> args0) throws InvalidVariableException {
        //检测用户调用函数时，检测参数个数
        checkParameterCount(args0,1);
        Object[] params = args0.toArray();
        if (params.length > 0) {
            varName = (CompoundVariable) params[0];
        } else {
            varName = null;
        }
    }

    //获取函数的名称
    @Override
    public String getReferenceKey() {
        return KEY;
    }

    //获取界面所要显示的参数说明
    @Override
    public List<String> getArgumentDesc() {
        return desc;
    }

    private static int getNum(int start,int end)
    {
        return (int)(Math.random()*(end-1));
    }
}
