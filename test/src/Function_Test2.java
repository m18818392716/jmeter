import org.junit.Test;

import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.config.Arguments;

/**
 * @author Susanna
 * @date 2021/6/28 15:20
 */
public class Function_Test2 {

//    public void setupTest() {
//        Arguments params = new Arguments();
//        RandomDemoTestFunctions test = new RandomDemoTestFunctions();
//    }
//    @Before
//    public void before(){
//        Arguments params = new Arguments();
//        RandomDemoTestFunctions test = new RandomDemoTestFunctions();
//    }
//
//    @After
//    public void after(){
//
//    }
    @Test
    public void randomTest() throws Exception {
        Arguments params = new Arguments();
        params.addArgument("x", "-9");
//        params.addArgument("key", "7930665351");
//        params.addArgument("secret", "31d5b2fa00c64b25b6db60434e51ecd3");
//        params.addArgument("method", "GET");
//        params.addArgument("path", "/test?test=1");
        JavaSamplerContext arg0 = new JavaSamplerContext(params);
        RandomDemoTestFunctions test = new RandomDemoTestFunctions();
        test.setupTest(arg0);
        test.runTest(arg0);
        test.teardownTest(arg0);
    }

    @Test
    public void randomTest1() throws Exception {
        Arguments params = new Arguments();
        params.addArgument("x", "10");
        JavaSamplerContext arg0 = new JavaSamplerContext(params);
        RandomDemoTestFunctions test = new RandomDemoTestFunctions();
        test.setupTest(arg0);
        test.runTest(arg0);
        test.teardownTest(arg0);
    }

    @Test
    public void randomTest2() throws Exception {
        Arguments params = new Arguments();
        params.addArgument("x", "88");
        JavaSamplerContext arg0 = new JavaSamplerContext(params);
        RandomDemoTestFunctions test = new RandomDemoTestFunctions();
        test.setupTest(arg0);
        test.runTest(arg0);
        test.teardownTest(arg0);
    }
}
