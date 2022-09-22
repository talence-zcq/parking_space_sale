package controller.ldy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.io.*;
import java.util.ArrayList;

import static org.junit.matchers.JUnitMatchers.containsString;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.setup.SharedHttpSessionConfigurer.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml",
        "classpath:spring/spring-mvc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback
@Transactional
public class YuanControllerTest {
    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;




    @Before
    public void setUp() throws IOException {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
//                .apply(sharedHttpSession()) // 配置公共session
//                .alwaysExpect(status().isOk()) // 预期响应状态码
                .build();  //初始化MockMvc对象





    }

    @Test
    public void loginTest() throws Exception {
        ArrayList<String> loginblacklist;
        MockHttpSession mockHttpSession = new MockHttpSession();
        loginblacklist = new ArrayList<>();
        File file = new File( "src\\test\\java\\controller\\ldy\\loginwhite.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                 loginblacklist.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }


        //        循环测试
        for (int i = 0; i < loginblacklist.size(); i++) {
            if (i == 0) {
                String info = loginblacklist.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第" + i + "次测试");
                String line = loginblacklist.get(i);
                String[] data = line.split(",");
                //        配置请求
                RequestBuilder request = post("/administrators/login")
                        .param("adminName", data[0]).param("adminPassword", data[1])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[2], result.getRequest().getSession().getAttribute("igno"));
                System.out.println("测试完成且通过");

            }
        }
    }

    @Test
    public void loginTestblack() throws Exception {
        ArrayList<String> loginblacklist;
        MockHttpSession mockHttpSession = new MockHttpSession();
        loginblacklist = new ArrayList<>();
        File file = new File( "src\\test\\java\\controller\\ldy\\loginblack.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                 loginblacklist.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }


        //        循环测试
        for (int i = 0; i < loginblacklist.size(); i++) {
            if (i == 0) {
                String info = loginblacklist.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第" + i + "次测试");
                String line = loginblacklist.get(i);
                String[] data = line.split(",");
                //        配置请求
                RequestBuilder request = post("/administrators/login")
                        .param("adminName", data[0]).param("adminPassword", data[1])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[2], result.getRequest().getSession().getAttribute("igno"));
                System.out.println("测试完成且通过");

            }
        }
    }
    @Test
    public void GenerateOrderTest() throws  Exception
    {
        MockHttpSession mockHttpSession = new MockHttpSession();
        ArrayList<String>  GenerateOrderblacklist = new ArrayList<>();
        //读取生成订单测试用例
        File file = new File( "src\\test\\java\\controller\\ldy\\GenerateOrderwhite.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                 GenerateOrderblacklist.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }


        //        循环测试
        for (int i = 0; i < GenerateOrderblacklist.size(); i++) {
            if (i == 0) {
                String info = GenerateOrderblacklist.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第" + i + "次测试");
                String line = GenerateOrderblacklist.get(i);
                String[] data = line.split(",");
                //        配置请求
                mockHttpSession.setAttribute("adminName",data[0]);
                RequestBuilder request = post("/administrators/GenerateOrder")
                        .param("parkingSpaceId", data[1])
                        .param("contractSignatory", data[2])
                        .param("contractInitiator", data[3])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();

                Assert.assertEquals(data[4], result.getRequest().getSession().getAttribute("igno"));
                System.out.println("测试完成且通过");

            }
        }
    }
    public void GenerateOrderTestblack() throws  Exception
    {
        MockHttpSession mockHttpSession = new MockHttpSession();
        ArrayList<String>  GenerateOrderblacklist = new ArrayList<>();
        //读取生成订单测试用例
        File file = new File( "src\\test\\java\\controller\\ldy\\GenerateOrderblack.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                 GenerateOrderblacklist.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }


        //        循环测试
        for (int i = 0; i < GenerateOrderblacklist.size(); i++) {
            if (i == 0) {
                String info = GenerateOrderblacklist.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第" + i + "次测试");
                String line = GenerateOrderblacklist.get(i);
                String[] data = line.split(",");
                //        配置请求
                mockHttpSession.setAttribute("adminName",data[0]);
                RequestBuilder request = post("/administrators/GenerateOrder")
                        .param("parkingSpaceId", data[1])
                        .param("contractSignatory", data[2])
                        .param("contractInitiator", data[3])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();

                Assert.assertEquals(data[4], result.getRequest().getSession().getAttribute("igno"));
                System.out.println("测试完成且通过");

            }
        }
    }

    @Test
    public  void CancelOrderTest()throws Exception
    {
        MockHttpSession mockHttpSession = new MockHttpSession();
        ArrayList<String>  GenerateOrderblacklist = new ArrayList<>();
        //读取生成订单测试用例
        File file = new File( "src\\test\\java\\controller\\ldy\\CancelOrderwhite.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                 GenerateOrderblacklist.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }


        //        循环测试
        for (int i = 0; i < GenerateOrderblacklist.size(); i++) {
            if (i == 0) {
                String info = GenerateOrderblacklist.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第" + i + "次测试");
                String line = GenerateOrderblacklist.get(i);
                String[] data = line.split(",");
                //        配置请求
                mockHttpSession.setAttribute("adminName",data[0]);
                RequestBuilder request = get("/administrators/CancelOrder")
                        .param("OrderId", data[1])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();

                int aa=Integer.parseInt(data[2]);
                Assert.assertEquals(aa, result.getRequest().getSession().getAttribute("orderFinalState"));
                System.out.println("测试完成且通过");

            }
        }
    }
    @Test
    public  void CancelOrderTestblack()throws Exception
    {
        MockHttpSession mockHttpSession = new MockHttpSession();
        ArrayList<String>  GenerateOrderblacklist = new ArrayList<>();
        //读取生成订单测试用例
        File file = new File( "src\\test\\java\\controller\\ldy\\CancelOrderblack.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                 GenerateOrderblacklist.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }


        //        循环测试
        for (int i = 0; i < GenerateOrderblacklist.size(); i++) {
            if (i == 0) {
                String info = GenerateOrderblacklist.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第" + i + "次测试");
                String line = GenerateOrderblacklist.get(i);
                String[] data = line.split(",");
                //        配置请求
                mockHttpSession.setAttribute("adminName",data[0]);
                RequestBuilder request = get("/administrators/CancelOrder")
                        .param("OrderId", data[1])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();

                int aa=Integer.parseInt(data[2]);
                Assert.assertEquals(aa, result.getRequest().getSession().getAttribute("orderFinalState"));
                System.out.println("测试完成且通过");

            }
        }
    }

    @Test
    public  void FinishOrderTest()throws  Exception
    {
        MockHttpSession mockHttpSession = new MockHttpSession();
        ArrayList<String>  GenerateOrderblacklist = new ArrayList<>();
        //读取生成订单测试用例
        File file = new File( "src\\test\\java\\controller\\ldy\\FinishOrderwhite.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                 GenerateOrderblacklist.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }


        //        循环测试
        for (int i = 0; i < GenerateOrderblacklist.size(); i++) {
            if (i == 0) {
                String info = GenerateOrderblacklist.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第"  + i+"次测试");
                String line = GenerateOrderblacklist.get(i);
                String[] data = line.split(",");
                //        配置请求
                mockHttpSession.setAttribute("adminName",data[0]);
                RequestBuilder request = get("/administrators/FinishOrder")
                        .param("OrderId", data[1])
                        .param("userId", data[2])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();


                Assert.assertEquals(data[3], result.getRequest().getSession().getAttribute("igno"));
                System.out.println("测试完成且通过");

            }
        }
    }
    @Test
    public  void FinishOrderTestblack()throws  Exception
    {
        MockHttpSession mockHttpSession = new MockHttpSession();
        ArrayList<String>  GenerateOrderblacklist = new ArrayList<>();
        //读取生成订单测试用例
        File file = new File( "src\\test\\java\\controller\\ldy\\FinishOrderblack.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                 GenerateOrderblacklist.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }


        //        循环测试
        for (int i = 0; i < GenerateOrderblacklist.size(); i++) {
            if (i == 0) {
                String info = GenerateOrderblacklist.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第"  + i+"次测试");
                String line = GenerateOrderblacklist.get(i);
                String[] data = line.split(",");
                //        配置请求
                mockHttpSession.setAttribute("adminName",data[0]);
                RequestBuilder request = get("/administrators/FinishOrder")
                        .param("OrderId", data[1])
                        .param("userId", data[2])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();


                Assert.assertEquals(data[3], result.getRequest().getSession().getAttribute("igno"));
                System.out.println("测试完成且通过");

            }
        }
    }

    @Test
    public  void readfileTest()throws Exception
    {
        MockHttpSession mockHttpSession = new MockHttpSession();
        ArrayList<String>  GenerateOrderblacklist = new ArrayList<>();
        //读取生成订单测试用例
        File file = new File( "src\\test\\java\\controller\\ldy\\readfilewhite.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                 GenerateOrderblacklist.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }


        //        循环测试
        for (int i = 0; i < GenerateOrderblacklist.size(); i++) {
            if (i == 0) {
                String info = GenerateOrderblacklist.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第"  + i+"次测试");
                String line = GenerateOrderblacklist.get(i);
                String[] data = line.split(",");
                //        配置请求
                mockHttpSession.setAttribute("adminName",data[0]);
                RequestBuilder request = post("/administrators/readfile")
                        .param("pageSize", data[1])
                        .param("pageNum", data[2])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();


                Assert.assertEquals(data[3], result.getRequest().getSession().getAttribute("igno"));
                System.out.println("测试完成且通过");

            }
        }
    }
    public  void readfileTestblack()throws Exception
    {
        MockHttpSession mockHttpSession = new MockHttpSession();
        ArrayList<String>  GenerateOrderblacklist = new ArrayList<>();
        //读取生成订单测试用例
        File file = new File( "src\\test\\java\\controller\\ldy\\readfileblack.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                 GenerateOrderblacklist.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }


        //        循环测试
        for (int i = 0; i < GenerateOrderblacklist.size(); i++) {
            if (i == 0) {
                String info = GenerateOrderblacklist.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第"  + i+"次测试");
                String line = GenerateOrderblacklist.get(i);
                String[] data = line.split(",");
                //        配置请求
                mockHttpSession.setAttribute("adminName",data[0]);
                RequestBuilder request = post("/administrators/readfile")
                        .param("pageSize", data[1])
                        .param("pageNum", data[2])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();


                Assert.assertEquals(data[3], result.getRequest().getSession().getAttribute("igno"));
                System.out.println("测试完成且通过");

            }
        }
    }

    public  void unreadfileTest()throws Exception
    {
        MockHttpSession mockHttpSession = new MockHttpSession();
        ArrayList<String>  GenerateOrderblacklist = new ArrayList<>();
        //读取生成订单测试用例
        File file = new File( "src\\test\\java\\controller\\ldy\\unreadfilewhite.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                 GenerateOrderblacklist.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }


        //        循环测试
        for (int i = 0; i < GenerateOrderblacklist.size(); i++) {
            if (i == 0) {
                String info = GenerateOrderblacklist.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第"  + i+"次测试");
                String line = GenerateOrderblacklist.get(i);
                String[] data = line.split(",");
                //        配置请求
                mockHttpSession.setAttribute("adminName",data[0]);
                RequestBuilder request = post("/administrators/unreadfile")
                        .param("pageSize", data[1])
                        .param("pageNum", data[2])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();


                Assert.assertEquals(data[3], result.getRequest().getSession().getAttribute("igno"));
                System.out.println("测试完成且通过");

            }
        }
    }
    public  void unreadfileTestblack()throws Exception
    {
        MockHttpSession mockHttpSession = new MockHttpSession();
        ArrayList<String>  GenerateOrderblacklist = new ArrayList<>();
        //读取生成订单测试用例
        File file = new File( "src\\test\\java\\controller\\ldy\\unreadfileblack.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                 GenerateOrderblacklist.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }


        //        循环测试
        for (int i = 0; i < GenerateOrderblacklist.size(); i++) {
            if (i == 0) {
                String info = GenerateOrderblacklist.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第"  + i+"次测试");
                String line = GenerateOrderblacklist.get(i);
                String[] data = line.split(",");
                //        配置请求
                mockHttpSession.setAttribute("adminName",data[0]);
                RequestBuilder request = post("/administrators/unreadfile")
                        .param("pageSize", data[1])
                        .param("pageNum", data[2])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();


                Assert.assertEquals(data[3], result.getRequest().getSession().getAttribute("igno"));
                System.out.println("测试完成且通过");

            }
        }
    }
}