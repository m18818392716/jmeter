import org.junit.Test;

/**
 * @author Susanna
 * @date 2021/6/16 20:41
 */
public class Function_Test {
    @Test
    public void phoneTest() throws Exception {
        RandomPhoneJmeterFunctions randomPhone= new RandomPhoneJmeterFunctions();
        String phoneString = randomPhone.execute();
        System.out.println("随机手机号:" + phoneString);
    }
}
