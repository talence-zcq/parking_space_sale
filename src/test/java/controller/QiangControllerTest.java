package controller;

import com.bean.Developers;
import com.bean.ParkingSpace;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import com.bean.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebAppConfiguration
@ContextConfiguration({ "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml",
        "classpath:spring/spring-mvc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback
@Transactional
public class QiangControllerTest {
    private static boolean initialized = false;
    @Autowired
    protected WebApplicationContext wac;

    protected static MockMvc mockMvc;

    static ArrayList<String> modifyPwdBlackTestList;
    static ArrayList<String> modifyPwdWhiteTestList;
    static ArrayList<String> getStatisticBlackTestList;
    static ArrayList<String> getStatisticWhiteTestList;
    static ArrayList<String> updateOrderBlackTestList;
    static ArrayList<String> updateOrderWhiteTestList;
    static ArrayList<String> deleteActivityBlackTestList;
    static ArrayList<String> deleteActivityWhiteTestList;
    static ArrayList<String> updateResidentialQuartersDelBlackTestList;
    static ArrayList<String> updateResidentialQuartersDelWhiteTestList;
//    卢鹏宇的测试用例
    static ArrayList<String> loginBlackTestList = new ArrayList<>();
    static ArrayList<String> loginWhiteTestList = new ArrayList<>();
    static ArrayList<String> userOrderBlackTestList = new ArrayList<>();
    static ArrayList<String> userOrderWhiteTestList = new ArrayList<>();
    static ArrayList<String> personalInfoBlackTestList = new ArrayList<>();
    static ArrayList<String> personalInfoWhiteTestList = new ArrayList<>();
    static ArrayList<String> updateUserInfoBlackTestList = new ArrayList<>();
    static ArrayList<String> updateUserInfoWhiteTestList = new ArrayList<>();

//    李勇达的测试用例
    //黑盒测试
    static ArrayList<String> unsealBlackTestList;
    static ArrayList<String> sealBlackTestList;
    static ArrayList<String> offlineBlackTestList;
    static ArrayList<String> passFileBlackTestList;
    static ArrayList<String> unpassfileBlackTestList;
    static ArrayList<String> selectDevelopersBlackTestList;

    //黑盒测试
    static ArrayList<String> unsealWhiteTestList;
    static ArrayList<String> sealWhiteTestList;
    static ArrayList<String> offlineWhiteTestList;
    static ArrayList<String> passFileWhiteTestList;
    static ArrayList<String> unpassfileWhiteTestList;
    static ArrayList<String> selectDevelopersWhiteTestList;

//    周萌的测试用例
    static ArrayList<String> selectActivityTestList;
    static ArrayList<String> manage_parkingSpaceTestList;
    static ArrayList<String> now_orderlistTestList;
    static ArrayList<String> select_ResidentialQuartersTestList;
    static ArrayList<String> add_ResidentialQuartersTestList;
    static ArrayList<String> select_developerInfoTestList;

//    吴青霞的测试用例

    static ArrayList<String> selectBankcardBlackTestList;
    static ArrayList<String> insertBankcardBlackTestList;
    static ArrayList<String> insertUserBlackTestList;
    static ArrayList<String> selectCouponBlackTestList;
//    黄益妙的测试用例

    static ArrayList<String> ParkingSpaceBlackTestList;
    static ArrayList<String> ParkingSpaceWhiteTestList;

    static ArrayList<String> ParkingSpaceIdBlackTestList;
    static ArrayList<String> ParkingSpaceIdWhiteTestList;

    static ArrayList<String> uploadBlackTestList;
    static ArrayList<String> uploadWhiteTestList;

    static ArrayList<String> canvasUpBlackTestList;
    static ArrayList<String> canvasUpWhiteTestList;
    //颜炅的测试用例
    static ArrayList<String> saleLoginWhiteTestList;
    static ArrayList<String> saleLoginBlackTestList;
    static ArrayList<String> addparkWhiteTestList;
    static ArrayList<String> addparkBlackTestList;
    static ArrayList<String> addexamineWhiteTestList;
    static ArrayList<String> addexamineBlackTestList;
    static ArrayList<String> addactivityWhiteTestList;
    static ArrayList<String> addactivityBlackTestList;
    //        用于获取项目地址
    static File directory;

    @Before
    public void setUp() throws IOException {
//        为了让Before代码只执行一次
        if (!initialized) {
            initialized = true;
            mockMvc = MockMvcBuilders.webAppContextSetup(wac)
//                .apply(sharedHttpSession()) // 配置公共session
//                .alwaysExpect(status().isOk()) // 预期响应状态码
                    .build();  //初始化MockMvc对象

//        用于获取项目地址
            directory = new File("");

//        修改密码黑盒测试用例读取
            modifyPwdBlackTestList = new ArrayList<>();
            File file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Qiang/modifyPwdBlackTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    modifyPwdBlackTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }

            //        修改密码白盒测试用例读取
            modifyPwdWhiteTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Qiang/modifyPwdWhiteTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    modifyPwdWhiteTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }

            //        数据统计黑盒测试用例读取
            getStatisticBlackTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Qiang/getStatisticBlackTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    getStatisticBlackTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }

            //        数据统计白盒测试用例读取
            getStatisticWhiteTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Qiang/getStatisticWhiteTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    getStatisticWhiteTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }

            //        处理订单黑盒测试用例读取
            updateOrderBlackTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Qiang/updateOrderBlackTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    updateOrderBlackTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }

            //        处理订单白盒测试用例读取
            updateOrderWhiteTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Qiang/updateOrderWhiteTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    updateOrderWhiteTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }


            //        删除活动黑盒测试用例读取
            deleteActivityBlackTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath() + "/src/test/java/controller/Qiang/deleteActivityBlackTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; deleteActivityBlackTestList.add(lineTxt)) {
                }
                read.close();
            } else {
                System.out.println("找不到指定的测试数据文件");
            }


            //        删除活动白盒测试用例读取
            deleteActivityWhiteTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath() + "/src/test/java/controller/Qiang/deleteActivityWhiteTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; deleteActivityWhiteTestList.add(lineTxt)) {
                }
                read.close();
            } else {
                System.out.println("找不到指定的测试数据文件");
            }

            //        删除小区黑盒测试用例读取
            updateResidentialQuartersDelBlackTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath() + "/src/test/java/controller/Qiang/updateResidentialQuartersDelBlackTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; updateResidentialQuartersDelBlackTestList.add(lineTxt)) {
                }
                read.close();
            } else {
                System.out.println("找不到指定的测试数据文件");
            }


            //        删除小区白盒测试用例读取
            updateResidentialQuartersDelWhiteTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath() + "/src/test/java/controller/Qiang/updateResidentialQuartersDelWhiteTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; updateResidentialQuartersDelWhiteTestList.add(lineTxt)) {
                }
                read.close();
            } else {
                System.out.println("找不到指定的测试数据文件");
            }

//            卢鹏宇的测试用例
            loginBlackTestList = readFile("/src/test/java/controller/Lu/loginBlackTest.txt");
            loginWhiteTestList = readFile("/src/test/java/controller/Lu/loginWhiteTest.txt");
            userOrderBlackTestList = readFile("/src/test/java/controller/Lu/userOrderBlackTest.txt");
            userOrderWhiteTestList = readFile("/src/test/java/controller/Lu/userOrderWhiteTest.txt");
            personalInfoBlackTestList = readFile("/src/test/java/controller/Lu/personalInfoBlackTest.txt");
            personalInfoWhiteTestList = readFile("/src/test/java/controller/Lu/personalInfoWhiteTest.txt");
            updateUserInfoBlackTestList = readFile("/src/test/java/controller/Lu/updateUserInfoBlackTest.txt");
            updateUserInfoWhiteTestList = readFile("/src/test/java/controller/Lu/updateUserInfoWhiteTest.txt");
//            李勇达的测试用例
            //黑盒测试
            passFileBlackTestList = new ArrayList<>();
            passFileBlackTestList = setData("/src/test/java/controller/da/passFileBlackTest.txt");
            unpassfileBlackTestList = new ArrayList<>();
            unpassfileBlackTestList = setData("/src/test/java/controller/da/unpassFileBlackTest.txt");
            sealBlackTestList = new ArrayList<>();
            sealBlackTestList = setData("/src/test/java/controller/da/sealBlackTest.txt");
            unsealBlackTestList = new ArrayList<>();
            unsealBlackTestList = setData("/src/test/java/controller/da/unsealBlackTest.txt");
            offlineBlackTestList = new ArrayList<>();
            offlineBlackTestList = setData("/src/test/java/controller/da/offlineBlackTest.txt");
            selectDevelopersBlackTestList = new ArrayList<>();
            selectDevelopersBlackTestList = setData("/src/test/java/controller/da/selectDevelopersBlackTest.txt");

            //白盒测试
            passFileWhiteTestList = new ArrayList<>();
            passFileWhiteTestList = setData("/src/test/java/controller/da/passFileWhiteTest.txt");
            unpassfileWhiteTestList = new ArrayList<>();
            unpassfileWhiteTestList = setData("/src/test/java/controller/da/unpassFileWhiteTest.txt");
            sealWhiteTestList = new ArrayList<>();
            sealWhiteTestList = setData("/src/test/java/controller/da/sealWhiteTest.txt");
            unsealWhiteTestList = new ArrayList<>();
            unsealWhiteTestList = setData("/src/test/java/controller/da/unsealWhiteTest.txt");
            offlineWhiteTestList = new ArrayList<>();
            offlineWhiteTestList = setData("/src/test/java/controller/da/offlineWhiteTest.txt");
            selectDevelopersWhiteTestList = new ArrayList<>();
            selectDevelopersWhiteTestList = setData("/src/test/java/controller/da/selectDevelopersWhiteTest.txt");

            //        周萌的测试用例

            manage_parkingSpaceTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Meng/manage_parkingSpaceTestList.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    manage_parkingSpaceTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }
            now_orderlistTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Meng/now_orderlistTestList.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    now_orderlistTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }

            select_ResidentialQuartersTestList= new ArrayList<>();
            file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Meng/select_ResidentialQuartersTestList.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    select_ResidentialQuartersTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }

            add_ResidentialQuartersTestList= new ArrayList<>();
            file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Meng/addResidentialQuartersTestList.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    add_ResidentialQuartersTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }

            select_developerInfoTestList= new ArrayList<>();
            file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Meng/select_developerInfoTestList.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    select_developerInfoTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }

            selectActivityTestList= new ArrayList<>();
            file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Meng/selectActivityTestList.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    selectActivityTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }

//        吴青霞的测试用例
//        查询银行卡黑盒测试用例读取
            selectBankcardBlackTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath() + "/src/test/java/controller/Wu/selectBankcardBlackTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                     selectBankcardBlackTestList.add(lineTxt)) {
                }
                read.close();
            } else {
                System.out.println("找不到指定的Con_selectBankcardBlackTest.txt测试数据文件");
            }

            //        添加银行卡黑盒测试用例读取
            insertBankcardBlackTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath() + "/src/test/java/controller/Wu/insertBankcardBlackTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                     insertBankcardBlackTestList.add(lineTxt)) {
                }
                read.close();
            } else {
                System.out.println("找不到指定的Con_insertBankcardBlackTest.txt测试数据文件");
            }

            //        注册用户黑盒测试用例读取
            insertUserBlackTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Wu/insertUserBlackTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    insertUserBlackTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的Con_insertUserBlackTest.txt测试数据文件");
            }

            //        查询优惠券黑盒测试用例读取
            selectCouponBlackTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath() + "/src/test/java/controller/Wu/selectCouponBlackTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                     selectCouponBlackTestList.add(lineTxt)) {
                }
                read.close();
            } else {
                System.out.println("找不到指定的Con_selectCouponBlackTest.txt测试数据文件");
            }
//        黄益妙测试用例读取
            ParkingSpaceBlackTestList = readFile("/src/test/java/controller/Miao/ParkingSpaceBlackTest.txt");
            ParkingSpaceWhiteTestList = readFile("/src/test/java/controller/Miao/ParkingSpaceWhiteTest.txt");
            ParkingSpaceIdBlackTestList = readFile("/src/test/java/controller/Miao/ParkingSpaceIdBlackTest.txt");
            ParkingSpaceIdWhiteTestList = readFile("/src/test/java/controller/Miao/ParkingSpaceIdWhiteTest.txt");
            uploadBlackTestList = readFile("/src/test/java/controller/Miao/uploadBlackTest.txt");
            uploadWhiteTestList = readFile("/src/test/java/controller/Miao/uploadWhiteTest.txt");
            canvasUpBlackTestList = readFile("/src/test/java/controller/Miao/canvasUpBlackTest.txt");
            canvasUpWhiteTestList = readFile("/src/test/java/controller/Miao/canvasUpWhiteTest.txt");
//            颜炅的测试用例读取
            saleLoginWhiteTestList = new ArrayList<>();
            saleLoginBlackTestList= new ArrayList<>();
            addparkWhiteTestList= new ArrayList<>();
            addparkBlackTestList= new ArrayList<>();
            addexamineWhiteTestList= new ArrayList<>();
            addexamineBlackTestList= new ArrayList<>();
            addactivityWhiteTestList= new ArrayList<>();
            addactivityBlackTestList= new ArrayList<>();
            File loginWhiteTestList_file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Yan/loginWhiteTest.txt");
            File loginBlackTestList_file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Yan/loginBlackTest.txt");
            File addparkWhiteTestList_file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Yan/addparkWhiteTest.txt");
            File addparkBlackTestList_file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Yan/addparkBlackTest.txt");
            File addexamineWhiteTestList_file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Yan/addexamineWhiteTest.txt");
            File addexamineBlackTestList_file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Yan/addexamineBlackTest.txt");
            File addactivityWhiteTestList_file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Yan/addactivityWhiteTest.txt");
            File addactivityBlackTestList_file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Yan/addactivityBlackTest.txt");
            //登录白盒测试
            if (loginWhiteTestList_file.isFile() && loginWhiteTestList_file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(loginWhiteTestList_file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    loginWhiteTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }
            //登录黑盒测试
            if (loginBlackTestList_file.isFile() && loginBlackTestList_file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(loginBlackTestList_file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    loginBlackTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }
            //添加车位白盒测试
            if (addparkWhiteTestList_file.isFile() && addparkWhiteTestList_file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(addparkWhiteTestList_file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    addparkWhiteTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }
            //添加车位黑盒测试
            if (addparkBlackTestList_file.isFile() && addparkBlackTestList_file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(addparkBlackTestList_file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    addparkBlackTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }
            //商家入驻白盒测试
            if (addexamineWhiteTestList_file.isFile() && addexamineWhiteTestList_file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(addexamineWhiteTestList_file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    addexamineWhiteTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }
            //商家入驻黑盒测试
            if (addexamineBlackTestList_file.isFile() && addexamineBlackTestList_file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(addexamineBlackTestList_file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    addexamineBlackTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }
            //添加活动白盒测试
            if (addactivityWhiteTestList_file.isFile() && addactivityWhiteTestList_file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(addactivityWhiteTestList_file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    addactivityWhiteTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }
            //添加活动黑盒测试
            if (addactivityBlackTestList_file.isFile() && addactivityBlackTestList_file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(addactivityBlackTestList_file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null;
                    addactivityBlackTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的测试数据文件");
            }
        }
    }

    @Test
//    处理订单黑盒测试
    public void updateOrderBlackTest() throws  Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();
//        循环测试
        for(int i = 0;i<updateOrderBlackTestList.size();i++){
            if(i == 0){
                String info = updateOrderBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = updateOrderBlackTestList.get(i);
                String[] data = line.split(",");
                //        设置session
                mockHttpSession.setAttribute("uid",data[6]);
                String expect = data[7];
//                生成multipartFile文件
                File file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Qiang/test.jpg");
                FileInputStream input = new FileInputStream(file);
                MockMultipartFile multipartFile = new MockMultipartFile("contractContent", data[3], "text/plain", IOUtils.toByteArray(input));
                MvcResult result =mockMvc.perform(MockMvcRequestBuilders.multipart("/developer/modify_orderlist")
                                .file(multipartFile)
                                .param("orderId",data[0])
                                .param("contractInitiator",data[1])
                                .param("parkingSpaceId",data[2])
                                .param("finalPrice",data[4])
                                .param("finalPaymentTime",data[5])
                                .session(mockHttpSession))
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                         .andReturn();
//                断言
                Assert.assertEquals(expect,result.getRequest().getSession().getAttribute("message"));


            }
        }
    }

    @Test
//    处理订单白盒测试
    public void updateOrderWhiteTest() throws  Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();
//        循环测试
        for(int i = 0;i<updateOrderWhiteTestList.size();i++){
            if(i == 0){
                String info = updateOrderWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = updateOrderWhiteTestList.get(i);
                String[] data = line.split(",");
                //        设置session
                mockHttpSession.setAttribute("uid",data[6]);
                String expect = data[7];
//                生成multipartFile文件
                MockMultipartFile multipartFile = null;
                if(data[3].equals("")){
                    File file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Qiang/empty.jpg");
                    FileInputStream input = new FileInputStream(file);
                    multipartFile = new MockMultipartFile("contractContent", data[3], "text/plain", IOUtils.toByteArray(input));
                }
                else{
                    File file = new File(directory.getAbsolutePath()+"/src/test/java/controller/Qiang/test.jpg");
                    FileInputStream input = new FileInputStream(file);
                    multipartFile = new MockMultipartFile("contractContent", data[3], "text/plain", IOUtils.toByteArray(input));
                }
                MvcResult result =mockMvc.perform(MockMvcRequestBuilders.multipart("/developer/modify_orderlist")
                                .file(multipartFile)
                                .param("orderId",data[0])
                                .param("contractInitiator",data[1])
                                .param("parkingSpaceId",data[2])
                                .param("finalPrice",data[4])
                                .param("finalPaymentTime",data[5])
                                .session(mockHttpSession))
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
//                断言
                Assert.assertEquals(expect,result.getRequest().getSession().getAttribute("message"));
            }
        }
    }

    @Test
//    数据统计黑盒测试
    public void getStatisticBlackTest()throws  Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
//        循环测试
        for(int i = 0;i<getStatisticBlackTestList.size();i++){
            if(i == 0){
                String info = getStatisticBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = getStatisticBlackTestList.get(i);
                String[] data = line.split(",");
                //        设置session
                mockHttpSession.setAttribute("did",data[0]);
                if(data[1].equals("")){
                    data[1]=null;
                }
                //        配置请求
                RequestBuilder request = get("/developer/statistic")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
//                断言
                if(result.getRequest().getSession().getAttribute("message")==null){
                    int sum = (int)result.getModelAndView().getModel().get("parking_space")+(int)result.getModelAndView().getModel().get("money")+(int)result.getModelAndView().getModel().get("order_wait")
                            +(int)result.getModelAndView().getModel().get("order_ing")+(int)result.getModelAndView().getModel().get("order_finish")+(int)result.getModelAndView().getModel().get("order_stop");
                    Assert.assertEquals(Integer.parseInt(data[2]),sum);
                }
                Assert.assertEquals(data[1],result.getRequest().getSession().getAttribute("message"));


            }
        }

    }

    @Test
//    数据统计白盒测试
    public void getStatisticWhiteTest()throws  Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
//        循环测试
        for (int i = 0; i < getStatisticWhiteTestList.size(); i++) {
            if (i == 0) {
                String info = getStatisticWhiteTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第" + i + "次测试");
                String line = getStatisticWhiteTestList.get(i);
                String[] data = line.split(",");
                //        设置session
                mockHttpSession.setAttribute("did", data[0]);
                if (data[1].equals("")) {
                    data[1] = null;
                }
                //        配置请求
                RequestBuilder request = get("/developer/statistic")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
//                断言
                if (result.getRequest().getSession().getAttribute("message") == null) {
                    int sum = (int) result.getModelAndView().getModel().get("parking_space") + (int) result.getModelAndView().getModel().get("money") + (int) result.getModelAndView().getModel().get("order_wait")
                            + (int) result.getModelAndView().getModel().get("order_ing") + (int) result.getModelAndView().getModel().get("order_finish") + (int) result.getModelAndView().getModel().get("order_stop");
                    Assert.assertEquals(Integer.parseInt(data[2]), sum);
                }
                Assert.assertEquals(data[1], result.getRequest().getSession().getAttribute("message"));


            }

        }
    }

    @Test
    public void deleteActivityBlackTest() throws Exception {
//        循环测试
        for (int i = 0; i < deleteActivityBlackTestList.size(); i++) {
            if (i == 0) {
                String info = deleteActivityBlackTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第" + i + "次测试");
                String line = deleteActivityBlackTestList.get(i);
                String[] data = line.split(",");
                //        配置请求
                RequestBuilder request = get("/developer/delete_Activity")
                        .param("activity_id",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON);
                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
//                断言
                Assert.assertEquals(data[1], result.getRequest().getSession().getAttribute("message"));


            }
        }
    }

    @Test
    public void deleteActivityWhiteTest() throws Exception {
//        循环测试
        for (int i = 0; i < deleteActivityWhiteTestList.size(); i++) {
            if (i == 0) {
                String info = deleteActivityWhiteTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第" + i + "次测试");
                String line = deleteActivityWhiteTestList.get(i);
                String[] data = line.split(",");
                //        配置请求
                RequestBuilder request = get("/developer/delete_Activity")
                        .param("activity_id",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON);
                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
//                断言
                Assert.assertEquals(data[1], result.getRequest().getSession().getAttribute("message"));


            }
        }
    }

    @Test
    public void deleteResidentialQuartersBlackTest() throws Exception {
//        循环测试
        for (int i = 0; i < updateResidentialQuartersDelBlackTestList.size(); i++) {
            if (i == 0) {
                String info = updateResidentialQuartersDelBlackTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第" + i + "次测试");
                String line = updateResidentialQuartersDelBlackTestList.get(i);
                String[] data = line.split(",");
                //        配置请求
                RequestBuilder request = get("/developer/update_ResidentialQuarters")
                        .param("residential_quarters_id", data[0])
                        .param("state",data[1])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON);
                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
//                断言
                Assert.assertEquals(data[2], result.getRequest().getSession().getAttribute("message"));


            }
        }
    }
    @Test
    public void deleteResidentialQuartersWhiteTest() throws Exception {
//        循环测试
        for (int i = 0; i < updateResidentialQuartersDelWhiteTestList.size(); i++) {
            if (i == 0) {
                String info = updateResidentialQuartersDelWhiteTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第" + i + "次测试");
                String line = updateResidentialQuartersDelWhiteTestList.get(i);
                String[] data = line.split(",");
                //        配置请求
                RequestBuilder request = get("/developer/update_ResidentialQuarters")
                        .param("residential_quarters_id", data[0])
                        .param("state",data[1])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON);
                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
//                断言
                Assert.assertEquals(data[2], result.getRequest().getSession().getAttribute("message"));


            }
        }
    }

    @Test
//    修改密码黑盒测试
    public void modifyPwdBlackTest() throws Exception{
//        数据库得有uid为001,密码为123456的用户
        MockHttpSession mockHttpSession = new MockHttpSession();
//        循环测试
        for(int i = 0;i<modifyPwdBlackTestList.size();i++){
            if(i == 0){
                String info = modifyPwdBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = modifyPwdBlackTestList.get(i);
                String[] data = line.split(",");
                //        设置session
                mockHttpSession.setAttribute("uid",data[0]);
                //        配置请求
                RequestBuilder request = post("/developer/modify_pwd")
                        .param( "old_pwd",data[1])
                        .param("new_pwd1", data[2])
                        .param("new_pwd2", data[3])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
//                断言
                Assert.assertEquals(data[4],result.getRequest().getSession().getAttribute("message"));

            }
        }
    }

    @Test
//    修改密码白盒测试
    public void modifyPwdWhiteTest() throws Exception{
//        数据库得有uid为001,密码为123456的用户
        MockHttpSession mockHttpSession = new MockHttpSession();
//        循环测试
        for(int i = 0;i<modifyPwdWhiteTestList.size();i++){
            if(i == 0){
                String info = modifyPwdWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = modifyPwdWhiteTestList.get(i);
                String[] data = line.split(",");
                //        设置session
                mockHttpSession.setAttribute("uid",data[0]);
                //        配置请求
                RequestBuilder request = post("/developer/modify_pwd")
                        .param( "old_pwd",data[1])
                        .param("new_pwd1", data[2])
                        .param("new_pwd2", data[3])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
//                断言
                Assert.assertEquals(data[4],result.getRequest().getSession().getAttribute("message"));

            }
        }
    }

//    卢鹏宇的测试用例

    @Test
    public void loginBlackTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        // 循环测试
        for(int i = 0;i<loginBlackTestList.size();i++){
            if(i == 0){
                String info = loginBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = loginBlackTestList.get(i);
                String[] data = line.split(";");
                // 配置请求
                RequestBuilder request = post("/user/login")
                        .param("username",data[0])
                        .param("password", data[1])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andReturn();
                Assert.assertEquals(data[2],result.getModelAndView().getModel().values().toString().substring(1,result.getModelAndView().getModel().values().toString().lastIndexOf("]")));

            }
        }
    }

    @Test
    public void loginWhiteTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        // 循环测试
        for(int i = 0;i<loginWhiteTestList.size();i++){
            if(i == 0){
                String info = loginWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = loginWhiteTestList.get(i);
                String[] data = line.split(";");
                // 配置请求
                RequestBuilder request = post("/user/login")
                        .param("username",data[0])
                        .param("password", data[1])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andReturn();
                Assert.assertEquals(data[2],result.getModelAndView().getModel().values().toString().substring(1,result.getModelAndView().getModel().values().toString().lastIndexOf("]")));

            }
        }
    }

    @Test
    public void userOrderBlackTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        // 循环测试
        for(int i = 0;i<userOrderBlackTestList.size();i++){
            if(i == 0){
                String info = userOrderBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = userOrderBlackTestList.get(i);
                String[] data = line.split(";");
                // 配置请求
                RequestBuilder request = get("/user/userorder")
                        .param("userid",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andReturn();
                List<Order> listOrder = (List<Order>) result.getRequest().getSession().getAttribute("orderlist");
                Assert.assertEquals(data[1],String.valueOf(listOrder.size()));

            }
        }
    }

    @Test
    public void userOrderWhiteTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        // 循环测试
        for(int i = 0;i<userOrderWhiteTestList.size();i++){
            if(i == 0){
                String info = userOrderWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = userOrderWhiteTestList.get(i);
                String[] data = line.split(";");
                // 配置请求
                RequestBuilder request = get("/user/userorder")
                        .param("userid",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andReturn();
                List<Order> listOrder = (List<Order>) result.getRequest().getSession().getAttribute("orderlist");
                Assert.assertEquals(data[1],String.valueOf(listOrder.size()));

            }
        }
    }

    @Test
    public void personalInfoBlackTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        // 循环测试
        for(int i = 0;i<personalInfoBlackTestList.size();i++){
            if(i == 0){
                String info = personalInfoBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = personalInfoBlackTestList.get(i);
                String[] data = line.split(";");
                // 配置请求
                RequestBuilder request = get("/user/personalinfo")
                        .param("userid",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andReturn();
                List<Order> listOrder = (List<Order>) result.getRequest().getSession().getAttribute("bankcardlist");
                Assert.assertEquals(data[1],String.valueOf(listOrder.size()));

            }
        }
    }

    @Test
    public void personalInfoWhiteTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        // 循环测试
        for(int i = 0;i<personalInfoWhiteTestList.size();i++){
            if(i == 0){
                String info = personalInfoWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = personalInfoWhiteTestList.get(i);
                String[] data = line.split(";");
                // 配置请求
                RequestBuilder request = get("/user/personalinfo")
                        .param("userid",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andReturn();
                List<Order> listOrder = (List<Order>) result.getRequest().getSession().getAttribute("bankcardlist");
                Assert.assertEquals(data[1],String.valueOf(listOrder.size()));

            }
        }
    }

    @Test
    public void updateUserInfoBlackTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        // 循环测试
        for(int i = 0;i<updateUserInfoBlackTestList.size();i++){
            if(i == 0){
                String info = updateUserInfoBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = updateUserInfoBlackTestList.get(i);
                String[] data = line.split(";");
                // 配置请求
                RequestBuilder request = get("/user/updateuserinfo")
                        .param("userid",data[0])
                        .param("useremail", data[1])
                        .param("username",data[2])
                        .param("userphone", data[3])
                        .param("sex",data[4])
                        .param("userquarter", data[5])
                        .param("userbuilding",data[6])
                        .param("userhouse", data[7])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andReturn();
                Assert.assertEquals(data[8],String.valueOf(result.getRequest().getSession().getAttribute("updatestate")));

            }
        }
    }

    @Test
    public void updateUserInfoWhiteTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        // 循环测试
        for(int i = 0;i<updateUserInfoWhiteTestList.size();i++){
            if(i == 0){
                String info = updateUserInfoWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = updateUserInfoWhiteTestList.get(i);
                String[] data = line.split(";");
                // 配置请求
                RequestBuilder request = get("/user/updateuserinfo")
                        .param("userid",data[0])
                        .param("useremail", data[1])
                        .param("username",data[2])
                        .param("userphone", data[3])
                        .param("sex",data[4])
                        .param("userquarter", data[5])
                        .param("userbuilding",data[6])
                        .param("userhouse", data[7])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andReturn();
                Assert.assertEquals(data[8],String.valueOf(result.getRequest().getSession().getAttribute("updatestate")));

            }
        }
    }

    public ArrayList<String> readFile(String path) throws IOException {
        //用于获取项目地址
        File directory = new File("");

        //修改密码黑盒测试用例读取
        ArrayList<String> list = new ArrayList<>();
        File file = new File(directory.getAbsolutePath() + path);
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; list.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }
        return list;
    }
    public ArrayList setData(String path) throws IOException {
        File directory = new File("");
        ArrayList<String> List = new ArrayList<>();
        File file = new File(directory.getAbsolutePath() + path);
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; List.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }
        return List;
    }
//    李勇达的测试代码
@Test
public void passfileBlackTest() throws  Exception{
    MockHttpSession mockHttpSession = new MockHttpSession();

    //        循环测试
    for(int i = 0;i<passFileBlackTestList.size();i++){
        if(i == 0){
            String info = passFileBlackTestList.get(i);
            System.out.println("现在测试:"+info);
        }
        else{
            System.out.println("第"+i+"次测试");
            String line = passFileBlackTestList.get(i);
            String[] data = line.split(",");
            //        设置session
            mockHttpSession.setAttribute("adminName",data[0]);
            //        配置请求
            RequestBuilder request = post("/administrators/passfile")
                    .param( "eid",data[1])
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .accept(MediaType.APPLICATION_JSON)
                    .session(mockHttpSession);
            MvcResult result =mockMvc.perform(request)
                    .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                    .andReturn();
            Assert.assertEquals(data[2],result.getRequest().getSession().getAttribute("message"));
            System.out.println("测试完成且通过");

        }
    }
}


    @Test
    public void unpassfileBlackTest() throws  Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();

        //        循环测试
        for(int i = 0;i<unpassfileBlackTestList.size();i++){
            if(i == 0){
                String info = unpassfileBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = unpassfileBlackTestList.get(i);
                String[] data = line.split(",");
                //        设置session
                mockHttpSession.setAttribute("adminName",data[0]);
                //        配置请求
                RequestBuilder request = post("/administrators/unpassfile")
                        .param( "eid",data[1])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[2],result.getRequest().getSession().getAttribute("message"));
                System.out.println("测试完成且通过");

            }
        }
    }

    @Test
    public void sealBlackTest() throws  Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();

        //        循环测试
        for(int i = 0;i<sealBlackTestList.size();i++){
            if(i == 0){
                String info = sealBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = sealBlackTestList.get(i);
                String[] data = line.split(",");
                //        配置请求
                RequestBuilder request = post("/administrators/seal")
                        .param( "did",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[1],result.getRequest().getSession().getAttribute("message"));
                System.out.println("测试完成且通过");

            }
        }
    }

    @Test
    public void unsealBlackTest() throws  Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();

        //        循环测试
        for(int i = 0;i<unsealBlackTestList.size();i++){
            if(i == 0){
                String info = unsealBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = unsealBlackTestList.get(i);
                String[] data = line.split(",");
                //        配置请求
                RequestBuilder request = post("/administrators/unseal")
                        .param( "did",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[1],result.getRequest().getSession().getAttribute("message"));
                System.out.println("测试完成且通过");

            }
        }
    }

    @Test
    public void offlineBlackTest() throws  Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();

        //        循环测试
        for(int i = 0;i<offlineBlackTestList.size();i++){
            if(i == 0){
                String info = offlineBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = offlineBlackTestList.get(i);
                String[] data = line.split(",");
                //        配置请求
                RequestBuilder request = post("/administrators/offline")
                        .param( "did",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[1],result.getRequest().getSession().getAttribute("message"));
                System.out.println("测试完成且通过");

            }
        }
    }

    @Test
    public void selectDevelopersBlackTest() throws  Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();

        //        循环测试
        for(int i = 0;i<selectDevelopersBlackTestList.size();i++){
            if(i == 0){
                String info = selectDevelopersBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = selectDevelopersBlackTestList.get(i);
                String[] data = line.split(",");
                //        配置请求
                RequestBuilder request = post("/administrators/developerinfo")
                        .param( "pageSize",data[0]).param("pageNum",data[1])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                List<Developers> list = (List<Developers>) result.getRequest().getSession().getAttribute("developerlist");
                //System.out.println(list.get(1).getDeveloperName());
                boolean actual = false;
                if(list.isEmpty()){
                    actual = false;
                }
                else {
                    actual = true;
                }

                Assert.assertEquals(data[2],result.getRequest().getSession().getAttribute("pageSize"));
                Assert.assertEquals(data[3],result.getRequest().getSession().getAttribute("pageNum"));
                boolean expect = Boolean.parseBoolean(data[4]);
                Assert.assertEquals(expect,actual);
                System.out.println("测试完成且通过");

            }
        }
    }

    //白盒测试
    @Test
    public void passfileWhiteTest() throws  Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();

        //        循环测试
        for(int i = 0;i<passFileWhiteTestList.size();i++){
            if(i == 0){
                String info = passFileWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = passFileWhiteTestList.get(i);
                String[] data = line.split(",");
                //        设置session
                mockHttpSession.setAttribute("adminName",data[0]);
                //        配置请求
                RequestBuilder request = post("/administrators/passfile")
                        .param( "eid",data[1])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[2],result.getRequest().getSession().getAttribute("message"));
                System.out.println("测试完成且通过");

            }
        }
    }


    @Test
    public void unpassfileWhiteTest() throws  Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();

        //        循环测试
        for(int i = 0;i<unpassfileWhiteTestList.size();i++){
            if(i == 0){
                String info = unpassfileWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = unpassfileWhiteTestList.get(i);
                String[] data = line.split(",");
                //        设置session
                mockHttpSession.setAttribute("adminName",data[0]);
                //        配置请求
                RequestBuilder request = post("/administrators/unpassfile")
                        .param( "eid",data[1])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[2],result.getRequest().getSession().getAttribute("message"));
                System.out.println("测试完成且通过");

            }
        }
    }

    @Test
    public void sealWhiteTest() throws  Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();

        //        循环测试
        for(int i = 0;i<sealWhiteTestList.size();i++){
            if(i == 0){
                String info = sealWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = sealWhiteTestList.get(i);
                String[] data = line.split(",");
                //        配置请求
                RequestBuilder request = post("/administrators/seal")
                        .param( "did",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[1],result.getRequest().getSession().getAttribute("message"));
                System.out.println("测试完成且通过");

            }
        }
    }

    @Test
    public void unsealWhiteTest() throws  Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();

        //        循环测试
        for(int i = 0;i<unsealWhiteTestList.size();i++){
            if(i == 0){
                String info = unsealWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = unsealWhiteTestList.get(i);
                String[] data = line.split(",");
                //        配置请求
                RequestBuilder request = post("/administrators/unseal")
                        .param( "did",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[1],result.getRequest().getSession().getAttribute("message"));
                System.out.println("测试完成且通过");

            }
        }
    }

    @Test
    public void offlineWhiteTest() throws  Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();

        //        循环测试
        for(int i = 0;i<offlineWhiteTestList.size();i++){
            if(i == 0){
                String info = offlineWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = offlineWhiteTestList.get(i);
                String[] data = line.split(",");
                //        配置请求
                RequestBuilder request = post("/administrators/offline")
                        .param( "did",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[1],result.getRequest().getSession().getAttribute("message"));
                System.out.println("测试完成且通过");

            }
        }
    }

    @Test
    public void selectDevelopersWhiteTest() throws  Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();

        //        循环测试
        for(int i = 0;i<selectDevelopersWhiteTestList.size();i++){
            if(i == 0){
                String info = selectDevelopersWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = selectDevelopersWhiteTestList.get(i);
                String[] data = line.split(",");
                //        配置请求
                RequestBuilder request = post("/administrators/developerinfo")
                        .param( "pageSize",data[0]).param("pageNum",data[1])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                List<Developers> list = (List<Developers>) result.getRequest().getSession().getAttribute("developerlist");
                //System.out.println(list.get(1).getDeveloperName());
                boolean actual = false;
                if(list.isEmpty()){
                    actual = false;
                }
                else {
                    actual = true;
                }

                Assert.assertEquals(data[2],result.getRequest().getSession().getAttribute("pageSize"));
                Assert.assertEquals(data[3],result.getRequest().getSession().getAttribute("pageNum"));
                boolean expect = Boolean.parseBoolean(data[4]);
                Assert.assertEquals(expect,actual);
                System.out.println("测试完成且通过");

            }
        }
    }
    @Test
    public void select_developerInfo() throws  Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();
//        循环测试
        for(int i = 0;i<select_developerInfoTestList.size();i++){
            if(i == 0){
                String info = select_developerInfoTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = select_developerInfoTestList.get(i);
                String[] data = line.split(",");
                //        设置session
                mockHttpSession.setAttribute("uid",data[1]);
                mockHttpSession.setAttribute("did",data[0]);
                //        配置请求
                RequestBuilder request = post("/developer/select_developerInfo")
//                            .param( "uid",data[0])
//                            .param("did", data[1])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =
                        mockMvc.perform(get("/select_developerInfo", "json").accept(MediaType.APPLICATION_JSON)).andReturn();
//                            .accept(MediaType.APPLICATION_JSON)
//                          .andDo(print())
//                        .andExpect(status().isOk()).andReturn();
                String flag="0";
                if(result!=null){
                    flag="1";
                }
//                    Assert.assertEquals(data[2],result.getResponse().getContentAsString());
                Assert.assertEquals(data[2],flag);
            }
        }
    }



    @Test
    public void select_ResidentialQuarters()throws  Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
//        循环测试
        for(int i = 0;i<select_ResidentialQuartersTestList.size();i++){
            if(i == 0){
                String info = select_ResidentialQuartersTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = select_ResidentialQuartersTestList.get(i).toString();
                String[] data = line.split(",");
                //        设置session
                mockHttpSession.setAttribute("did",data[0]);
                //        配置请求
                RequestBuilder request = post("/developer/select_ResidentialQuarters")
                        .param("pageSize", data[1])
                        .param("pageNum", data[2])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request).andExpect(status().isOk()).andReturn();
                String result1="0";
                if(result!=null){
                    result1="1";
                }
                Assert.assertEquals(data[3],result1);

            }
        }
    }

    @Test
    public void add_ResidentialQuarters()throws  Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
//        循环测试
        for(int i = 0;i<add_ResidentialQuartersTestList.size();i++){
            if(i == 0){
                String info = add_ResidentialQuartersTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = add_ResidentialQuartersTestList.get(i).toString();
                System.out.println("第"+i+"次");
                String[] data = line.split(",");
                //        设置session
                mockHttpSession.setAttribute("did",data[0]);
                //        配置请求
                RequestBuilder request = post("/developer/add_ResidentialQuarters")
//                            .param("developer_id", "1234")
                        .param("residential_quarters_name", data[1])
                        .param("residential_quarters_state", data[2])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request).andExpect(status().isOk()).andReturn();
                Assert.assertEquals(data[3],result.getRequest().getSession().getAttribute("message"));

            }
        }
    }
    @Test
    public void selectActivity() throws  Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();
//        循环测试
        for(int i = 0;i<selectActivityTestList.size();i++){
            if(i == 0){
                String info = selectActivityTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = selectActivityTestList.get(i).toString();
                String[] data = line.split(",");
                //        设置session
                mockHttpSession.setAttribute("did",data[0]);
                //        配置请求
                RequestBuilder request = post("/developer/selectActivity")
                        .param( "search",data[1])
                        .param("pageSize", data[2])
                        .param("pageNum", data[3])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request).andExpect(status().isOk()).andReturn();
                String result1="0";
                if(result!=null){
                    result1="1";
                }
                Assert.assertEquals(data[4],result1);

            }
        }
    }


    @Test
    public void now_orderlist()throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
//        循环测试
        for(int i = 0;i<now_orderlistTestList.size();i++){
            if(i == 0){
                String info = now_orderlistTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = now_orderlistTestList.get(i).toString();
                String[] data = line.split(",");
                //        设置session
                mockHttpSession.setAttribute("did",data[0]);
                //        配置请求
                RequestBuilder request = post("/developer/now_orderlist")
                        .param( "search",data[1])
                        .param("pageSize", data[2])
                        .param("pageNum", data[3])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request).andExpect(status().isOk()).andReturn();
                String result1="0";
                if(result!=null){
                    result1="1";
                }
                Assert.assertEquals(data[4],result1);

            }
        }
    }


    @Test
    public void manage_parkingSpace() throws Exception{

        MockHttpSession mockHttpSession = new MockHttpSession();
//        循环测试
        for(int i = 0;i<manage_parkingSpaceTestList.size();i++){
            if(i == 0){
                String info = manage_parkingSpaceTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = manage_parkingSpaceTestList.get(i).toString();
                String[] data = line.split(",");
                //        设置session
                mockHttpSession.setAttribute("did",data[0]);
                //        配置请求
                RequestBuilder request = post("/developer/manage_parkingSpace")
                        .param( "search",data[1])
                        .param("pageSize", data[2])
                        .param("pageNum", data[3])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request).andExpect(status().isOk()).andReturn();
                String result1="0";
                if(result!=null){
                    result1="1";
                }
                Assert.assertEquals(data[4],result1);

            }
        }
    }
//    梁德源地代码
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

    @Test
    public void selectBankcard()throws Exception{
        MockHttpSession mockHttpSession=new MockHttpSession();
        //        循环测试
        for(int i=0;i<selectBankcardBlackTestList.size();i++){
            if(i==0){
                String info=selectBankcardBlackTestList.get(i);
                System.out.println("现在测试Controller_selectBankcard"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line=selectBankcardBlackTestList.get(i);
                String[] data=line.split(",");
                //        设置session(无,跳过)

                //        配置请求
                RequestBuilder request = post("/user/bankcard")
                        .param( "userid",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[1],result.getRequest().getSession().getAttribute("message"));

            }
        }

    }

    @Test
    public void insertBankcard()throws Exception{
        MockHttpSession mockHttpSession=new MockHttpSession();
        //        循环测试
        for(int i=0;i<insertBankcardBlackTestList.size();i++){
            if(i==0){
                String info=insertBankcardBlackTestList.get(i);
                System.out.println("现在测试Controller_insertBankcard"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line=insertBankcardBlackTestList.get(i);
                String[] data=line.split(",");
                //        设置session(无,跳过)
                System.out.println("输入信息:"+data[0]+","+data[1]+","+data[2]);
                //        配置请求
                RequestBuilder request = post("/user/addbankcard")
                        .param( "bankcardid",data[0])
                        .param("userid", data[1])
                        .param("bank", data[2])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[3],result.getRequest().getSession().getAttribute("message"));

            }
        }

    }

    @Test
    public void insertUser() throws Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();
//        循环测试
        for(int i = 0;i<insertUserBlackTestList.size();i++){
            if(i == 0){
                String info = insertUserBlackTestList.get(i);
                System.out.println("现在测试Controller_insertUser:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = insertUserBlackTestList.get(i);
                String[] data = line.split(",");
                //        设置session(无,跳过)
                System.out.println("输入信息:"+data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]+","+data[5]);
                //        配置请求
                RequestBuilder request = post("/user/register")
                        .param("Email",data[0])
                        .param( "username",data[1])
                        .param("password", data[2])
                        .param("sex", data[3])
                        .param("phone",data[4])
                        .param("invitee",data[5])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[6],result.getRequest().getSession().getAttribute("message"));
            }
        }
    }

    @Test
    public void selectCoupon()throws Exception{
        MockHttpSession mockHttpSession=new MockHttpSession();
        //        循环测试
        for(int i=0;i<selectCouponBlackTestList.size();i++){
            if(i==0){
                String info=selectCouponBlackTestList.get(i);
                System.out.println("现在测试Controller_selectCoupon"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line=selectCouponBlackTestList.get(i);
                String[] data=line.split(",");
                //        设置session(无,跳过)

                //        配置请求
                RequestBuilder request = post("/user/personalinfo")
                        .param( "userid",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[1],result.getRequest().getSession().getAttribute("message"));
            }
        }
    }

//    黄益妙的测试
    /**
     * @Description: 查询车位的控制层黑盒
     * @Param: []
     * @return: void
     * @Author: hym(huangyimiao666@gmail.com)
     * @Date: 16:25 2022/6/3
     */
    @Test
    public void ParkingSpaceBlackTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        // 循环测试
        for(int i = 0;i<ParkingSpaceBlackTestList.size();i++){
            if(i == 0){
                String info = ParkingSpaceBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = ParkingSpaceBlackTestList.get(i);
                String[] data = line.split(";");
                // 配置请求
                RequestBuilder request = get("/user/manageparkingSpace")
                        .param("pageNum",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andReturn();
                List<ParkingSpace> list = (List<ParkingSpace>) result.getModelAndView().getModel().get("parklist");
                Assert.assertEquals(data[1],String.valueOf(list.size()));

            }
        }
    }

    /**
     * @Description: 查询车位的控制层白盒
     * @Param: []
     * @return: void
     * @Author: hym(huangyimiao666@gmail.com)
     * @Date: 16:26 2022/6/3
     */
    @Test
    public void ParkingSpaceWhiteTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        for(int i = 0;i<ParkingSpaceWhiteTestList.size();i++){
            if(i == 0){
                String info = ParkingSpaceWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = ParkingSpaceWhiteTestList.get(i);
                String[] data = line.split(";");
                // 配置请求
                RequestBuilder request = get("/user/manageparkingSpace")
                        .param("pageNum",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andReturn();
                List<ParkingSpace> list = (List<ParkingSpace>) result.getModelAndView().getModel().get("parklist");
                Assert.assertEquals(data[1],String.valueOf(list.size()));
            }
        }

    }

    /**
     * @Description: 车位详情的控制层黑盒
     * @Param: []
     * @return: void
     * @Author: hym(huangyimiao666@gmail.com)
     * @Date: 16:26 2022/6/3
     */
    @Test
    public void ParkingSpaceIdBlackTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        // 循环测试
        for(int i = 0;i<ParkingSpaceIdBlackTestList.size();i++){
            if(i == 0){
                String info = ParkingSpaceIdBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = ParkingSpaceIdBlackTestList.get(i);
                String[] data = line.split(";");
                // 配置请求
                RequestBuilder request = get("/user/parkspace")
                        .param("parkid",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andReturn();
                ParkingSpace parkspace = (ParkingSpace) result.getRequest().getSession().getAttribute("parkspace");
                if(data[1].equals(String.valueOf(parkspace.getId()))){
                    System.out.println("测试用例" + i + "通过");
                }
                else{
                    System.out.println("测试用例" + i + "不通过");
                }
                Assert.assertEquals(data[1],String.valueOf(parkspace.getId()));
            }
        }
    }

    /**
     * @Description: 车位详情的控制层白盒
     * @Param: []
     * @return: void
     * @Author: hym(huangyimiao666@gmail.com)
     * @Date: 16:26 2022/6/3
     */
    @Test
    public void ParkingSpaceIdWhiteTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        // 循环测试
        for(int i = 0;i<ParkingSpaceIdWhiteTestList.size();i++){
            if(i == 0){
                String info = ParkingSpaceIdWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = ParkingSpaceIdWhiteTestList.get(i);
                String[] data = line.split(";");
                // 配置请求
                RequestBuilder request = get("/user/parkspace")
                        .param("parkid",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andReturn();
                ParkingSpace parkspace = (ParkingSpace) result.getRequest().getSession().getAttribute("parkspace");
                if(data[1].equals(String.valueOf(parkspace.getId()))){
                    System.out.println("测试用例" + i + "通过");
                }
                else{
                    System.out.println("测试用例" + i + "不通过");
                }
                Assert.assertEquals(data[1],String.valueOf(parkspace.getId()));
            }
        }
    }

    /**
     * @Description: 用户签字黑盒
     * @Param: []
     * @return: void
     * @Author: hym(huangyimiao666@gmail.com)
     * @Date: 10:22 2022/6/4
     */
    @Test
    public void uploadBlackTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        // 循环测试
        for(int i = 0;i<uploadBlackTestList.size();i++){
            if(i == 0){
                String info = uploadBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = uploadBlackTestList.get(i);
                String[] data = line.split("'");
                // 配置请求
                RequestBuilder request = post("/user/sign")
                        .param("filett",data[0])
                        .param("orderId",data[1])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andReturn();
                Object state = result.getRequest().getSession().getAttribute("orderFinalState");
                if(data[2].equals(String.valueOf(state))){
                    System.out.println("测试用例" + i + "通过");
                }
                else{
                    System.out.println("测试用例" + i + "不通过");
                }
                Assert.assertEquals(data[2],String.valueOf(state));
            }
        }
    }

    /**
     * @Description: 用户签字白盒
     * @Param: []
     * @return: void
     * @Author: hym(huangyimiao666@gmail.com)
     * @Date: 10:22 2022/6/4
     */
    @Test
    public void uploadWhiteTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        // 循环测试
        for(int i = 0;i<uploadWhiteTestList.size();i++){
            if(i == 0){
                String info = uploadWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = uploadWhiteTestList.get(i);
                String[] data = line.split("'");
                // 配置请求
                RequestBuilder request = post("/user/sign")
                        .param("filett",data[0])
                        .param("orderId",data[1])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andReturn();
                Object state = result.getRequest().getSession().getAttribute("orderFinalState");
                if(data[2].equals(String.valueOf(state))){
                    System.out.println("测试用例" + i + "通过");
                }
                else{
                    System.out.println("测试用例" + i + "不通过");
                }
                Assert.assertEquals(data[2],String.valueOf(state));
            }
        }
    }

    /**
     * @Description: 跳转用户签字黑盒
     * @Param: []
     * @return: void
     * @Author: hym(huangyimiao666@gmail.com)
     * @Date: 10:22 2022/6/4
     */
    @Test
    public void canvasUpBlackTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        // 循环测试
        for(int i = 0;i<canvasUpBlackTestList.size();i++){
            if(i == 0){
                String info = canvasUpBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = canvasUpBlackTestList.get(i);
                String[] data = line.split(";");
                // 配置请求
                RequestBuilder request = get("/user/canvasUp")
                        .param("orderid",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andReturn();
                Object orderid = result.getRequest().getSession().getAttribute("orderid");
                if(data[1].equals(String.valueOf(orderid))){
                    System.out.println("测试用例" + i + "通过");
                }
                else{
                    System.out.println("测试用例" + i + "不通过");
                }
                Assert.assertEquals(data[1],String.valueOf(orderid));
            }
        }
    }

    /**
     * @Description: 跳转用户签字白盒
     * @Param: []
     * @return: void
     * @Author: hym(huangyimiao666@gmail.com)
     * @Date: 10:23 2022/6/4
     */
    @Test
    public void canvasUpWhiteTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
        // 循环测试
        for(int i = 0;i<canvasUpWhiteTestList.size();i++){
            if(i == 0){
                String info = canvasUpWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                String line = canvasUpWhiteTestList.get(i);
                String[] data = line.split(";");
                // 配置请求
                RequestBuilder request = get("/user/canvasUp")
                        .param("orderid",data[0])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andReturn();
                Object orderid = result.getRequest().getSession().getAttribute("orderid");
                if(data[1].equals(String.valueOf(orderid))){
                    System.out.println("测试用例" + i + "通过");
                }
                else{
                    System.out.println("测试用例" + i + "不通过");
                }
                Assert.assertEquals(data[1],String.valueOf(orderid));
            }
        }
    }
//颜炅的测试
@Test
public void saleLoginWhiteTest() throws Exception{
    //略微更改了一下controller层的login函数，增加了语句session.setAttribute("message", "登录成功")
    MockHttpSession mockHttpSession = new MockHttpSession();
//        循环测试
    for(int i = 0;i<saleLoginWhiteTestList.size();i++){
        if(i == 0){
            String info = saleLoginWhiteTestList.get(i);
            System.out.println("现在测试:"+info);
        }
        else{
            System.out.println("第"+i+"次测试");
            String line = saleLoginWhiteTestList.get(i);
            String[] data = line.split("/");
            //        设置session
            mockHttpSession.setAttribute("uid",data[0]);
            //        配置请求
            RequestBuilder request = post("/developer/login")
                    .param( "username",data[0])
                    .param("password", data[1])
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .accept(MediaType.APPLICATION_JSON)
                    .session(mockHttpSession);
            MvcResult result =mockMvc.perform(request)
                    .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                    .andReturn();
            Assert.assertEquals(data[2],result.getRequest().getSession().getAttribute("message"));

        }
    }
}

    @Test
    public void saleLoginBlackTest() throws Exception{
        //略微更改了一下controller层的login函数，增加了语句session.setAttribute("message", "登录成功")
        MockHttpSession mockHttpSession = new MockHttpSession();
//        循环测试
        for(int i = 0;i<saleLoginBlackTestList.size();i++){
            if(i == 0){
                String info = saleLoginBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = saleLoginBlackTestList.get(i);
                String[] data = line.split("/");
                //        配置请求
                RequestBuilder request = post("/developer/login")
                        .param( "username",data[0])
                        .param("password", data[1])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[2],result.getRequest().getSession().getAttribute("message"));

            }
        }
    }

    @Test
    public void addparkWhiteTest() throws Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();
        //在表user_information中要提前加入user_identity为yanjiong@126.com的数据
        //在表residential_quarters中要提前加入id为001的数据
        mockHttpSession.setAttribute("did","yanjiong@126.com");
//        循环测试
        for(int i = 0;i<addparkWhiteTestList.size();i++){
            sleep(1000); // 线程睡眠1s
            if(i == 0){
                String info = addparkWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = addparkWhiteTestList.get(i);
                String[] data = line.split("/");
                //        用于获取项目地址
                File directory = new File("");
                //        文件写入
                File file = new File(directory.getAbsolutePath()+"/src/test/java/Yan/controller/"+data[3]);
                MockMultipartFile firstFile = new MockMultipartFile("photo", "1.jpg",
                        MediaType.TEXT_PLAIN_VALUE, new FileInputStream(file));

                //        配置请求
                MvcResult result =mockMvc.perform(MockMvcRequestBuilders.fileUpload("/developer/addpark_pace")
                                .file(firstFile)
                                .param( "residential_quarters_id",data[0])
                                .param("address", data[1])
                                .param("price", data[2])
                                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                                .session(mockHttpSession))
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[4],result.getRequest().getSession().getAttribute("message"));

            }
        }
    }
    @Test
    public void addparkBlackTest() throws Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();
        //在表user_information中要提前加入user_identity为yanjiong@126.com的数据
        //在表residential_quarters中要提前加入id为001的数据
        mockHttpSession.setAttribute("did","yanjiong@126.com");
//        循环测试
        for(int i = 0;i<addparkBlackTestList.size();i++){
            sleep(1000); // 线程睡眠1s
            if(i == 0){
                String info = addparkBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = addparkBlackTestList.get(i);
                String[] data = line.split("/");
                //        用于获取项目地址
                File directory = new File("");
                //        文件写入
                File file = new File(directory.getAbsolutePath()+"/src/test/java/Yan/controller/"+data[3]);
                MockMultipartFile firstFile = new MockMultipartFile("photo", "1.jpg",
                        MediaType.TEXT_PLAIN_VALUE, new FileInputStream(file));

                //        配置请求
                MvcResult result =mockMvc.perform(MockMvcRequestBuilders.fileUpload("/developer/addpark_pace")
                                .file(firstFile)
                                .param( "residential_quarters_id",data[0])
                                .param("address", data[1])
                                .param("price", data[2])
                                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                                .session(mockHttpSession))
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[4],result.getRequest().getSession().getAttribute("message"));

            }
        }
    }

    @Test
    public void addexamineWhiteTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
//        循环测试
        for(int i = 0;i<addexamineWhiteTestList.size();i++){
            sleep(1000); // 线程睡眠1s
            if(i == 0){
                String info = addexamineWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = addexamineWhiteTestList.get(i);
                String[] data = line.split("/");
                //        用于获取项目地址
                File directory = new File("");
                //        文件写入
                File file = new File(directory.getAbsolutePath()+"/src/test/java/Yan/controller/"+data[2]);
                MockMultipartFile firstFile = new MockMultipartFile("file", "1.jpg",
                        MediaType.TEXT_PLAIN_VALUE, new FileInputStream(file));

                //        配置请求
                MvcResult result =mockMvc.perform(MockMvcRequestBuilders.fileUpload("/developer/examine")
                                .file(firstFile)
                                .param( "developer_id",data[0])
                                .param("developer_name", data[1])
                                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE))
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[3],result.getRequest().getSession().getAttribute("message"));

            }
        }
    }
    @Test
    public void addexamineBlackTest() throws Exception {
        MockHttpSession mockHttpSession = new MockHttpSession();
//        循环测试
        for(int i = 0;i<addexamineBlackTestList.size();i++){
            sleep(1000); // 线程睡眠1s
            if(i == 0){
                String info = addexamineBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = addexamineBlackTestList.get(i);
                String[] data = line.split("/");
                //        用于获取项目地址
                File directory = new File("");
                //        文件写入
                File file = new File(directory.getAbsolutePath()+"/src/test/java/Yan/controller/"+data[2]);
                MockMultipartFile firstFile = new MockMultipartFile("file", "1.jpg",
                        MediaType.TEXT_PLAIN_VALUE, new FileInputStream(file));

                //        配置请求
                MvcResult result =mockMvc.perform(MockMvcRequestBuilders.fileUpload("/developer/examine")
                                .file(firstFile)
                                .param( "developer_id",data[0])
                                .param("developer_name", data[1])
                                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE))
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[3],result.getRequest().getSession().getAttribute("message"));

            }
        }
    }


    @Test
    public void addactivityWhiteTest() throws Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();
        //在表developer中要提前加入develop_id为yanjiong@126.com的数据
        mockHttpSession.setAttribute("did","yanjiong@126.com");
//        循环测试
        for(int i = 0;i<addactivityWhiteTestList.size();i++){
            sleep(1000);
            if(i == 0){
                String info = addactivityWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = addactivityWhiteTestList.get(i);
                String[] data = line.split("/");
                //        配置请求
                RequestBuilder request = post("/developer/add_Activity")
                        .param( "activity_name",data[0])
                        .param("activity_category", data[1])
                        .param("activity_residential_quarters_id", data[2])
                        .param("activity_discount", data[3])
                        .param("activity_content", data[4])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[5],result.getRequest().getSession().getAttribute("message"));

            }
        }
    }
    @Test
    public void addactivityBlackTest() throws Exception{
        MockHttpSession mockHttpSession = new MockHttpSession();
        //在表developer中要提前加入develop_id为yanjiong@126.com的数据
        mockHttpSession.setAttribute("did","yanjiong@126.com");
//        循环测试
        for(int i = 0;i<addactivityBlackTestList.size();i++){
            sleep(1000);
            if(i == 0){
                String info = addactivityBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                String line = addactivityBlackTestList.get(i);
                String[] data = line.split("/");
                //        配置请求
                RequestBuilder request = post("/developer/add_Activity")
                        .param( "activity_name",data[0])
                        .param("activity_category", data[1])
                        .param("activity_residential_quarters_id", data[2])
                        .param("activity_discount", data[3])
                        .param("activity_content", data[4])
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.APPLICATION_JSON)
                        .session(mockHttpSession);
                MvcResult result =mockMvc.perform(request)
                        .andExpect(status().isOk())
//                        .andDo(print()) //输出MvcResult到控制台
                        .andReturn();
                Assert.assertEquals(data[5],result.getRequest().getSession().getAttribute("message"));

            }
        }
    }

}


