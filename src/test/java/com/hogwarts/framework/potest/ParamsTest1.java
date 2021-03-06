package com.hogwarts.framework.potest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.hogwarts.framework.params.ParamsTest;
import com.hogwarts.framework.params.SeleniumTestCase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;

/**
 * 参数化框架5--实战2-数据驱动：读到的Yaml参数是一个类(code)
 * 从外界获取参数，代码不在再受参数影响。
 *
 * 在前面4的基础上，只修改了参数获取部分。
 * 参考: ParamsTest.class
 */
public class ParamsTest1 {

    @ParameterizedTest
    @MethodSource
    void search(SeleniumTestCase testCase){
        //todo 测试步骤
//        ChromeDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://ceshiren.com/");
//        driver.findElement(By.id("search-button")).click(); //搜索按钮
//        driver.findElement(By.id("search-term")).sendKeys(keyword);//点击搜索输入框


        System.out.println(testCase);
        //done: runner引擎
        testCase.run();

    }
    static List<SeleniumTestCase> search() throws IOException {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        TypeReference typeReference = new TypeReference<List<String>>() {
//        };

        SeleniumTestCase testCase =  mapper.readValue( //读取的数据是TestCase类型的
                ParamsTest.class.getResourceAsStream("/framework/search_po_test.yaml"),
                SeleniumTestCase.class);
        return testCase.testcase_generate(); // 先读取数据，在调用 testcase_generate() 获取想要的测试数据


    }


}
