package service;

import com.bean.Activity;
import com.bean.Developer_administrator;
import com.bean.Order;
import com.bean.ParkingSpace;
import com.dao.*;
import com.service.impl.DeveloperServiceImpl;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.bean.*;
import com.service.impl.*;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.text.ParseException;

import java.util.Date;


import static org.easymock.EasyMock.anyDouble;
import static org.easymock.EasyMock.anyObject;


@WebAppConfiguration
@ContextConfiguration({ "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback
@Transactional
public class QiangServiceTest {
//    张成强的测试用例
    private static boolean initialized = false;
    static ArrayList<String> modifyPasswordBlackTestList;
    static ArrayList<String> modifyPasswordWhiteTestList;
    static ArrayList<String> selectStaticsBlackTestList;
    static ArrayList<String> selectStaticsWhiteTestList;
    static ArrayList<String> updateOrderBlackTestList;
    static ArrayList<String> updateOrderWhiteTestList;
    static ArrayList<String> deleteActivityBlackTestList;
    static ArrayList<String> deleteActivityWhiteTestList;
    static ArrayList<String> updateResidentialQuartersDelBlackTestList;
    static ArrayList<String> updateResidentialQuartersDelWhiteTestList;
//    卢鹏宇的测试用例
    static ArrayList<String> userLoginBlackTestList = new ArrayList<>();
    static ArrayList<String> userLoginWhiteTestList = new ArrayList<>();
    static ArrayList<String> selectNameByIdBlackTestList = new ArrayList<>();
    static ArrayList<String> selectNameByIdWhiteTestList = new ArrayList<>();
    static ArrayList<String> userAuthenticationBlackTestList = new ArrayList<>();
    static ArrayList<String> userAuthenticationWhiteTestList = new ArrayList<>();
    static ArrayList<String> updateUserInfoBlackTestList = new ArrayList<>();
    static ArrayList<String> updateUserInfoWhiteTestList = new ArrayList<>();
    static ArrayList<String> selectUserOrderBlackTestList = new ArrayList<>();
    static ArrayList<String> selectUserOrderWhiteTestList = new ArrayList<>();
    static ArrayList<String> selectCouponBlackTestList = new ArrayList<>();
    static ArrayList<String> selectCouponWhiteTestList = new ArrayList<>();
    static ArrayList<String> selectBankcardBlackTestList = new ArrayList<>();
    static ArrayList<String> selectBankcardWhiteTestList = new ArrayList<>();
//    李勇达的测试用例
//黑盒测试
    static ArrayList<String> unsealBlackTestList;
    static ArrayList<String> sealBlackTestList;
    static ArrayList<String> offlineBlackTestList;
    static ArrayList<String> passFileBlackTestList;
    static ArrayList<String> unpassfileBlackTestList;
    static ArrayList<String> selectDevelopersBlackTestList;
    //白盒测试
    static ArrayList<String> passFileWhiteTestList;
    static ArrayList<String> unpassfileWhiteTestList;
    static ArrayList<String> selectDevelopersWhiteTestList;
    static ArrayList<String> unsealWhiteTestList;
    static ArrayList<String> sealWhiteTestList;
    static ArrayList<String> offlineWhiteTestList;
//    周萌的测试用例
    static ArrayList<String> selectActivityTestList;
    static ArrayList<String> manage_parkingSpaceTestList;
    static ArrayList<String> now_orderlistTestList;
    static ArrayList<String> select_ResidentialQuartersTestList;
    static ArrayList<String> add_ResidentialQuartersTestList;
    static ArrayList<String> select_developerInfoTestList;
//    吴青霞的测试用例
//从文件中读取测试用例，所以为String类型
    static ArrayList<String> insertBankcardBlackTestList;
    static ArrayList<String> insertUserBlackTestList;
    static ArrayList<String> WuSelectBankcardBlackTestList;
    static ArrayList<String> WuSelectCouponBlackTestList;
//    黄益妙的测试用例
    static ArrayList<String> selectAllSpaceBlackTestList;
    static ArrayList<String> selectAllSpaceWhiteTestList;

    static ArrayList<String> selectAllParkSpaceBlackTestList;
    static ArrayList<String> selectAllParkSpaceWhiteTestList;

    static ArrayList<String> selectParkingSpaceByIdBlackTestList;
    static ArrayList<String> selectParkingSpaceByIdWhiteTestList;

    static ArrayList<String> selectResidentialQuartersByIdBlackTestList;
    static ArrayList<String> selectResidentialQuartersByIdWhiteTestList;

    static ArrayList<String> updateOrderStateBlackTestList;
    static ArrayList<String> updateOrderStateWhiteTestList;
//    颜炅的测试用例
    static ArrayList<String> loginWhiteTestList;
    static ArrayList<String> loginBlackTestList;
    static ArrayList<String> addparkWhiteTestList;
    static ArrayList<String> addparkBlackTestList;
    static ArrayList<String> addexamineWhiteTestList;
    static ArrayList<String> addexamineBlackTestList;
    static ArrayList<String> addactivityWhiteTestList;
    static ArrayList<String> addactivityBlackTestList;
    @Before
    public void setUp() throws IOException {
//        为了让Before只执行一次
        if (!initialized) {
            initialized = true;
//        用于获取项目地址
            File directory = new File("");

//        修改密码黑盒测试用例读取
            modifyPasswordBlackTestList = new ArrayList<>();
            File file = new File(directory.getAbsolutePath() + "/src/test/java/service/Qiang/modifyPasswordBlackTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; modifyPasswordBlackTestList.add(lineTxt)) {
                }
                read.close();
            } else {
                System.out.println("找不到指定的测试数据文件");
            }

            //        修改密码白盒测试用例读取
            modifyPasswordWhiteTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath() + "/src/test/java/service/Qiang/modifyPasswordWhiteTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; modifyPasswordWhiteTestList.add(lineTxt)) {
                }
                read.close();
            } else {
                System.out.println("找不到指定的测试数据文件");
            }

            //        数据统计黑盒测试用例读取
            selectStaticsBlackTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath() + "/src/test/java/service/Qiang/selectStaticsBlackTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; selectStaticsBlackTestList.add(lineTxt)) {
                }
                read.close();
            } else {
                System.out.println("找不到指定的测试数据文件");
            }

            //        数据统计白盒测试用例读取
            selectStaticsWhiteTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath() + "/src/test/java/service/Qiang/selectStaticsWhiteTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; selectStaticsWhiteTestList.add(lineTxt)) {
                }
                read.close();
            } else {
                System.out.println("找不到指定的测试数据文件");
            }

            //        处理订单黑盒测试用例读取
            updateOrderBlackTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath() + "/src/test/java/service/Qiang/updateOrderBlackTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; updateOrderBlackTestList.add(lineTxt)) {
                }
                read.close();
            } else {
                System.out.println("找不到指定的测试数据文件");
            }

            //        处理订单白盒测试用例读取
            updateOrderWhiteTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath() + "/src/test/java/service/Qiang/updateOrderWhiteTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; updateOrderWhiteTestList.add(lineTxt)) {
                }
                read.close();
            } else {
                System.out.println("找不到指定的测试数据文件");
            }

            //        删除活动黑盒测试用例读取
            deleteActivityBlackTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath() + "/src/test/java/service/Qiang/deleteActivityBlackTest.txt");
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
            file = new File(directory.getAbsolutePath() + "/src/test/java/service/Qiang/deleteActivityWhiteTest.txt");
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
            file = new File(directory.getAbsolutePath() + "/src/test/java/service/Qiang/updateResidentialQuartersDelBlackTest.txt");
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
            file = new File(directory.getAbsolutePath() + "/src/test/java/service/Qiang/updateResidentialQuartersDelWhiteTest.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; updateResidentialQuartersDelWhiteTestList.add(lineTxt)) {
                }
                read.close();
            } else {
                System.out.println("找不到指定的测试数据文件");
            }
            //            卢鹏宇的测试用例读取
            userLoginBlackTestList = readFile("/src/test/java/service/Lu/userLoginBlackTest.txt");
            userLoginWhiteTestList = readFile("/src/test/java/service/Lu/userLoginWhiteTest.txt");
            selectNameByIdBlackTestList = readFile("/src/test/java/service/Lu/selectNameByIdBlackTest.txt");
            selectNameByIdWhiteTestList = readFile("/src/test/java/service/Lu/selectNameByIdWhiteTest.txt");
            userAuthenticationBlackTestList = readFile("/src/test/java/service/Lu/userAuthenticationBlackTest.txt");
            userAuthenticationWhiteTestList = readFile("/src/test/java/service/Lu/userAuthenticationWhiteTest.txt");
            updateUserInfoBlackTestList = readFile("/src/test/java/service/Lu/updateUserInfoBlackTest.txt");
            updateUserInfoWhiteTestList = readFile("/src/test/java/service/Lu/updateUserInfoWhiteTest.txt");
            selectUserOrderBlackTestList = readFile("/src/test/java/service/Lu/selectUserOrderBlackTest.txt");
            selectUserOrderWhiteTestList = readFile("/src/test/java/service/Lu/selectUserOrderWhiteTest.txt");
            selectCouponBlackTestList = readFile("/src/test/java/service/Lu/selectCouponBlackTest.txt");
            selectCouponWhiteTestList = readFile("/src/test/java/service/Lu/selectCouponWhiteTest.txt");
            selectBankcardBlackTestList = readFile("/src/test/java/service/Lu/selectBankcardBlackTest.txt");
            selectBankcardWhiteTestList = readFile("/src/test/java/service/Lu/selectBankcardWhiteTest.txt");

//            李勇达的用例读取
            //        用于获取项目地址
            //黑盒测试
            unsealBlackTestList = new ArrayList<>();
            unsealBlackTestList = setData("/src/test/java/service/da/unsealBlackTest.txt");
            sealBlackTestList = new ArrayList<>();
            sealBlackTestList = setData("/src/test/java/service/da/sealBlackTest.txt");
            offlineBlackTestList = new ArrayList<>();
            offlineBlackTestList = setData("/src/test/java/service/da/offlineBlackTest.txt");
            unpassfileBlackTestList = new ArrayList<>();
            unpassfileBlackTestList = setData("/src/test/java/service/da/unpassfileBlackTest.txt");
            passFileBlackTestList = new ArrayList<>();
            passFileBlackTestList = setData("/src/test/java/service/da/passFileBlackTest.txt");
            selectDevelopersBlackTestList = new ArrayList<>();
            selectDevelopersBlackTestList = setData("/src/test/java/service/da/selectDevelopersBlackTest.txt");

            //白盒测试
            passFileWhiteTestList = new ArrayList<>();
            passFileWhiteTestList = setData("/src/test/java/service/da/passFileWhiteTest.txt");
            unpassfileWhiteTestList = new ArrayList<>();
            unpassfileWhiteTestList = setData("/src/test/java/service/da/unpassfileWhiteTest.txt");
            selectDevelopersWhiteTestList = new ArrayList<>();
            selectDevelopersWhiteTestList = setData("/src/test/java/service/da/selectDevelopersWhiteTest.txt");
            unsealWhiteTestList = new ArrayList<>();
            unsealWhiteTestList = setData("/src/test/java/service/da/unsealWhiteTest.txt");
            sealWhiteTestList = new ArrayList<>();
            sealWhiteTestList = setData("/src/test/java/service/da/sealWhiteTest.txt");
            offlineWhiteTestList = new ArrayList<>();
            offlineWhiteTestList = setData("/src/test/java/service/da/offlineWhiteTest.txt");

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

//            吴青霞测试用例读取

            insertBankcardBlackTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath() + "/src/test/java/service/Wu/insertBankcardBlackTest.txt");
            if (file.isFile() && file.exists()) {
//        读文件
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; insertBankcardBlackTestList.add(lineTxt)) {
                }
                read.close();
            } else {
                System.out.println("找不到指定的测试数据文件Ser_insertBankcardBlackTest.txt");
            }

            insertUserBlackTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath() + "/src/test/java/service/Wu/insertUserBlackTest.txt");
            if (file.isFile() && file.exists()) {
//        读文件
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; insertUserBlackTestList.add(lineTxt)) {
                }
                read.close();
            } else {
                System.out.println("找不到指定的Ser_insertUserBlackTest.txt测试数据文件");
            }

            WuSelectBankcardBlackTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath() + "/src/test/java/service/Wu/selectBankcardBlackTest.txt");
            if (file.isFile() && file.exists()) {
//        读文件
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; WuSelectBankcardBlackTestList.add(lineTxt)) {
                }
                read.close();
            } else {
                System.out.println("找不到指定的Ser_selectBankcardBlackTest.txt测试数据文件");
            }

            WuSelectCouponBlackTestList = new ArrayList<>();
            file = new File(directory.getAbsolutePath()+"/src/test/java/service/Wu/selectCouponBlackTest.txt");
            if (file.isFile() && file.exists()) {
//        读文件
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                for(String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; WuSelectCouponBlackTestList.add(lineTxt)) {
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的Ser_selectCouponBlackTest.txt测试数据文件");
            }
//            黄益妙测试用例读取
            selectAllSpaceBlackTestList = readFile("/src/test/java/service/Miao/selectAllSpaceBlackTest.txt");
            selectAllSpaceWhiteTestList = readFile("/src/test/java/service/Miao/selectAllSpaceWhiteTest.txt");
            selectAllParkSpaceBlackTestList = readFile("/src/test/java/service/Miao/selectAllParkSpaceBlackTest.txt");
            selectAllParkSpaceWhiteTestList = readFile("/src/test/java/service/Miao/selectAllParkSpaceWhiteTest.txt");
            selectParkingSpaceByIdBlackTestList = readFile("/src/test/java/service/Miao/selectParkingSpaceByIdBlackTest.txt");
            selectParkingSpaceByIdWhiteTestList = readFile("/src/test/java/service/Miao/selectParkingSpaceByIdWhiteTest.txt");
            selectResidentialQuartersByIdBlackTestList = readFile("/src/test/java/service/Miao/selectResidentialQuartersByIdBlackTest.txt");
            selectResidentialQuartersByIdWhiteTestList = readFile("/src/test/java/service/Miao/selectResidentialQuartersByIdWhiteTest.txt");
            updateOrderStateBlackTestList = readFile("/src/test/java/service/Miao/updateOrderStateBlackTest.txt");
            updateOrderStateWhiteTestList = readFile("/src/test/java/service/Miao/updateOrderStateWhiteTest.txt");

//            颜炅的测试用例读取
            //        测试用例读取
            loginWhiteTestList = new ArrayList<>();
            loginBlackTestList= new ArrayList<>();
            addparkWhiteTestList= new ArrayList<>();
            addparkBlackTestList= new ArrayList<>();
            addexamineWhiteTestList= new ArrayList<>();
            addexamineBlackTestList= new ArrayList<>();
            addactivityWhiteTestList= new ArrayList<>();
            addactivityBlackTestList= new ArrayList<>();
            File loginWhiteTestList_file = new File(directory.getAbsolutePath()+"/src/test/java/service/Yan/loginWhiteTest.txt");
            File loginBlackTestList_file = new File(directory.getAbsolutePath()+"/src/test/java/service/Yan/loginBlackTest.txt");
            File addparkWhiteTestList_file = new File(directory.getAbsolutePath()+"/src/test/java/service/Yan/addparkWhiteTest.txt");
            File addparkBlackTestList_file = new File(directory.getAbsolutePath()+"/src/test/java/service/Yan/addparkBlackTest.txt");
            File addexamineWhiteTestList_file = new File(directory.getAbsolutePath()+"/src/test/java/service/Yan/addexamineWhiteTest.txt");
            File addexamineBlackTestList_file = new File(directory.getAbsolutePath()+"/src/test/java/service/Yan/addexamineBlackTest.txt");
            File addactivityWhiteTestList_file = new File(directory.getAbsolutePath()+"/src/test/java/service/Yan/addactivityWhiteTest.txt");
            File addactivityBlackTestList_file = new File(directory.getAbsolutePath()+"/src/test/java/service/Yan/addactivityBlackTest.txt");
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

//    张成强的Service层测试
    @Test
//    删除活动功能白盒测试
    public void deleteActivityWhiteTest() throws ParseException {
//        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

//      Bean类

//        注入DAO
        ActivityMapper activityMapper = EasyMock.createMock(ActivityMapper.class);
        developerService.setActivityMapper(activityMapper);

//        循环测试
        for(int i = 0;i<deleteActivityWhiteTestList.size();i++){
            if(i == 0){
                String info = deleteActivityWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(activityMapper);
                // 创建变量及对象
                String line = deleteActivityWhiteTestList.get(i);
                String[] data = line.split(",");
                String activity_id = data[0];
                boolean expect = Boolean.parseBoolean(data[1]);
                // 记录
                EasyMock.expect(activityMapper.deleteActivity(activity_id)).andReturn(true);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(activityMapper);
                // 接下来调用Service进行测试
                boolean actual = developerService.deleteActivity(activity_id);
                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(activityMapper);
            }
        }
    }
    @Test
//    删除活动黑盒测试
    public void deleteActivityBlackTest() throws ParseException {
//        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

//      Bean类

//        注入DAO
        ActivityMapper activityMapper = EasyMock.createMock(ActivityMapper.class);
        developerService.setActivityMapper(activityMapper);

//        循环测试
        for(int i = 0;i<deleteActivityBlackTestList.size();i++){
            if(i == 0){
                String info = deleteActivityBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(activityMapper);
                // 创建变量及对象
                String line = deleteActivityBlackTestList.get(i);
                String[] data = line.split(",");
                String activity_id = data[0];
                boolean expect = Boolean.parseBoolean(data[1]);
                // 记录
                EasyMock.expect(activityMapper.deleteActivity(activity_id)).andReturn(true);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(activityMapper);
                // 接下来调用Service进行测试
                boolean actual = developerService.deleteActivity(activity_id);
                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(activityMapper);
            }
        }

    }

    @Test
//    删除小区白盒测试
    public void updateResidentialQuartersDelWhiteTest() throws ParseException {
        //        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

//      Bean类

//        注入DAO
        ResidentialQuartersMapper residentialQuartersMapper = EasyMock.createMock(ResidentialQuartersMapper.class);
        developerService.setResidentialQuartersMapper(residentialQuartersMapper);

//        循环测试
        for(int i = 0;i<updateResidentialQuartersDelWhiteTestList.size();i++){
            if(i == 0){
                String info = updateResidentialQuartersDelWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(residentialQuartersMapper);
                // 创建变量及对象
                String line = updateResidentialQuartersDelWhiteTestList.get(i);
                String[] data = line.split(",");
                String activity_id = data[0];
                String state = data[1];
                boolean expect = Boolean.parseBoolean(data[2]);
                // 记录
                EasyMock.expect(residentialQuartersMapper.updateResidentialQuarters(activity_id,state)).andReturn(true);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(residentialQuartersMapper);
                // 接下来调用Service进行测试
                boolean actual = developerService.updateResidentialQuarters_del(activity_id,state);
                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(residentialQuartersMapper);
            }
        }
    }

    @Test
//    删除小区黑盒测试
    public void updateResidentialQuartersDelBlackTest() throws ParseException {
        //        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

//      Bean类

//        注入DAO
        ResidentialQuartersMapper residentialQuartersMapper = EasyMock.createMock(ResidentialQuartersMapper.class);
        developerService.setResidentialQuartersMapper(residentialQuartersMapper);

//        循环测试
        for(int i = 0;i<updateResidentialQuartersDelBlackTestList.size();i++){
            if(i == 0){
                String info = updateResidentialQuartersDelBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(residentialQuartersMapper);
                // 创建变量及对象
                String line = updateResidentialQuartersDelBlackTestList.get(i);
                String[] data = line.split(",");
                String activity_id = data[0];
                String state = data[1];
                boolean expect = Boolean.parseBoolean(data[2]);
                // 记录
                EasyMock.expect(residentialQuartersMapper.updateResidentialQuarters(activity_id,state)).andReturn(true);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(residentialQuartersMapper);
                // 接下来调用Service进行测试
                boolean actual = developerService.updateResidentialQuarters_del(activity_id,state);
                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(residentialQuartersMapper);
            }
        }
    }

    @Test
//    订单处理功能白盒测试
    public void updateOrderWhiteTest() throws ParseException {
//        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

//      Bean类
        ParkingSpace parkingSpace = new ParkingSpace("PS1641908053","RQ1641908004","PS1641908053","12号",1000.00,null,3,null,0);
        Date date = new Date();
        Order order = new Order("OR1641908101","PS1641908053","huangyimiao666@gmail.com","952430408@qq.com","OR1641908101.jpg",date,"余额支付",700.00,300.00,1,"一次性支付",date);
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(order);
        Activity activity1 = new Activity();
        activity1.setActivityCategory("满减");
        activity1.setActivityDiscount(100.00);
        activity1.setActivityContent(200);
        Activity activity2 = new Activity();
        activity2.setActivityCategory("打折");
        activity2.setActivityDiscount(0.7);
        List<Activity> activityList = new ArrayList<Activity>();
        activityList.add(activity1);
        activityList.add(activity2);

//        注入DAO
        OrderMapper orderMapper = EasyMock.createMock(OrderMapper.class);
        developerService.setOrderMapper(orderMapper);
        ParkingSpaceMapper parkingSpaceMapper = EasyMock.createMock(ParkingSpaceMapper.class);
        developerService.setParkingSpaceMapper(parkingSpaceMapper);
        ActivityMapper activityMapper = EasyMock.createMock(ActivityMapper.class);
        developerService.setActivityMapper(activityMapper);
//        循环测试
        for(int i = 0;i<updateOrderWhiteTestList.size();i++){
            if(i == 0){
                String info = updateOrderWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(orderMapper);
                EasyMock.reset(parkingSpaceMapper);
                EasyMock.reset(activityMapper);
                // 创建变量及对象
                String line = updateOrderWhiteTestList.get(i);
                String[] data = line.split(",");
                String orderId = data[0];
                String contractInitiator = data[1];
                String contractContent = data[2];
                String finalPrice=data[3];
                String finalPaymentTime = data[4];
                String did = data[5];
                String parkingSpaceId = data[6];
                Boolean expect = Boolean.parseBoolean(data[7]);

                // 记录
                EasyMock.expect(orderMapper.selectOrder(1,1,orderId,did)).andReturn(orderList);
                EasyMock.expectLastCall();
                EasyMock.expect(parkingSpaceMapper.selectParkingSpaceById(parkingSpaceId)).andReturn(parkingSpace).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(activityMapper.selectAllActivity(parkingSpaceId)).andReturn(activityList).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(orderMapper.updateOrder(anyObject())).andReturn(true);
                // 使能设置
                EasyMock.replay(orderMapper);
                EasyMock.replay(parkingSpaceMapper);
                EasyMock.replay(activityMapper);
                // 接下来调用Service进行测试
                Boolean actual = developerService.updateOrder(orderId,contractInitiator,contractContent,finalPrice,finalPaymentTime,did,parkingSpaceId);
                Assert.assertEquals(actual,expect);
                // 进行校验
                EasyMock.verify(orderMapper);
                EasyMock.verify(parkingSpaceMapper);
                EasyMock.verify(activityMapper);

            }
        }
    }


    @Test
//    订单处理功能黑盒测试
    public void updateOrderBlackTest() throws ParseException {
//        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

//      Bean类
        ParkingSpace parkingSpace = new ParkingSpace("PS1641908053","RQ1641908004","PS1641908053","12号",1000.00,null,3,null,0);
        Date date = new Date();
        Order order = new Order("OR1641908101","PS1641908053","huangyimiao666@gmail.com","952430408@qq.com","OR1641908101.jpg",date,"余额支付",700.00,300.00,1,"一次性支付",date);
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(order);

//        注入DAO
        OrderMapper orderMapper = EasyMock.createMock(OrderMapper.class);
        developerService.setOrderMapper(orderMapper);
        ParkingSpaceMapper parkingSpaceMapper = EasyMock.createMock(ParkingSpaceMapper.class);
        developerService.setParkingSpaceMapper(parkingSpaceMapper);
        ActivityMapper activityMapper = EasyMock.createMock(ActivityMapper.class);
        developerService.setActivityMapper(activityMapper);
//        循环测试
        for(int i = 0;i<updateOrderBlackTestList.size();i++){
            if(i == 0){
                String info = updateOrderBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(orderMapper);
                EasyMock.reset(parkingSpaceMapper);
                EasyMock.reset(activityMapper);
                // 创建变量及对象
                String line = updateOrderBlackTestList.get(i);
                String[] data = line.split(",");
                String orderId = data[0];
                String contractInitiator = data[1];
                String contractContent = data[2];
                String finalPrice=data[3];
                String finalPaymentTime = data[4];
                String did = data[5];
                String parkingSpaceId = data[6];
                Boolean expect = Boolean.parseBoolean(data[7]);
                List<Activity> activityList = new ArrayList<Activity>();

                // 记录
                EasyMock.expect(orderMapper.selectOrder(1,1,orderId,did)).andReturn(orderList);
                EasyMock.expectLastCall();
                EasyMock.expect(parkingSpaceMapper.selectParkingSpaceById(parkingSpaceId)).andReturn(parkingSpace).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(activityMapper.selectAllActivity(parkingSpaceId)).andReturn(activityList).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(orderMapper.updateOrder(anyObject())).andReturn(true);
                // 使能设置
                EasyMock.replay(orderMapper);
                EasyMock.replay(parkingSpaceMapper);
                EasyMock.replay(activityMapper);
                // 接下来调用Service进行测试
                Boolean actual = developerService.updateOrder(orderId,contractInitiator,contractContent,finalPrice,finalPaymentTime,did,parkingSpaceId);
                Assert.assertEquals(actual,expect);
                // 进行校验
                EasyMock.verify(orderMapper);
                EasyMock.verify(parkingSpaceMapper);
                EasyMock.verify(activityMapper);

            }
        }
    }
    @Test
//    数据统计功能黑盒测试
    public void selectStaticsBlackTest(){
//        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

//      Bean类
        Date date = new Date();
        Order order = new Order("OR1641908101","PS1641908053","huangyimiao666@gmail.com","952430408@qq.com","OR1641908101.jpg",date,"余额支付",700.00,300.00,1,"一次性支付",date);
        List<Order> list = new ArrayList<Order>();
        list.add(order);
//        注入DAO
        OrderMapper orderMapper = EasyMock.createMock(OrderMapper.class);
        developerService.setOrderMapper(orderMapper);
        DevelopersMapper developersMapper = EasyMock.createMock(DevelopersMapper.class);
        developerService.setDevelopersMapper(developersMapper);
        ParkingSpaceMapper parkingSpaceMapper = EasyMock.createMock(ParkingSpaceMapper.class);
        developerService.setParkingSpaceMapper(parkingSpaceMapper);

//        循环测试
        for(int i = 0;i<selectStaticsBlackTestList.size();i++){
            if(i == 0){
                String info = selectStaticsBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(orderMapper);
                EasyMock.reset(developersMapper);
                EasyMock.reset(parkingSpaceMapper);
                // 创建变量及对象
                String line = selectStaticsBlackTestList.get(i);
                String[] data = line.split(",");
                String did = data[0];
                Integer expect1 = Integer.parseInt(data[1]);
                Integer expect2 = Integer.parseInt(data[2]);
                Integer expect3 = Integer.parseInt(data[3]);
                Integer expect4 = Integer.parseInt(data[4]);
                Integer expect5 = Integer.parseInt(data[5]);
                Integer expect6 = Integer.parseInt(data[6]);
                // 记录
                EasyMock.expect(orderMapper.selectAllOrderByDid(did)).andReturn(list);
                EasyMock.expectLastCall();
                EasyMock.expect(developersMapper.selectMoney(did)).andReturn(Double.parseDouble(data[2]));
                EasyMock.expectLastCall();
                EasyMock.expect(parkingSpaceMapper.countParkSpace(did)).andReturn(expect1);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(orderMapper);
                EasyMock.replay(developersMapper);
                EasyMock.replay(parkingSpaceMapper);
                // 接下来调用Service进行测试
                ArrayList<Integer> actual = developerService.selectStatics(data[0]);
                Assert.assertEquals(expect1,actual.get(0));
                Assert.assertEquals(expect2,actual.get(1));
                Assert.assertEquals(expect3,actual.get(2));
                Assert.assertEquals(expect4,actual.get(3));
                Assert.assertEquals(expect5,actual.get(4));
                Assert.assertEquals(expect6,actual.get(5));
                // 进行校验
                EasyMock.verify(orderMapper);
                EasyMock.verify(developersMapper);
                EasyMock.verify(parkingSpaceMapper);
            }
        }
    }

    @Test
//    数据统计功能白盒测试
    public void selectStaticsWhiteTest(){
        //        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

//      Bean类
        Date date = new Date();
        Order order = new Order("OR1641908101","PS1641908053","huangyimiao666@gmail.com","952430408@qq.com","OR1641908101.jpg",date,"余额支付",700.00,300.00,1,"一次性支付",date);
        Order order1 = new Order("OR1641908101","PS1641908053","huangyimiao666@gmail.com","952430408@qq.com","OR1641908101.jpg",date,"余额支付",700.00,300.00,2,"一次性支付",date);
        Order order2= new Order("OR1641908101","PS1641908053","huangyimiao666@gmail.com","952430408@qq.com","OR1641908101.jpg",date,"余额支付",700.00,300.00,3,"一次性支付",date);
        Order order3 = new Order("OR1641908101","PS1641908053","huangyimiao666@gmail.com","952430408@qq.com","OR1641908101.jpg",date,"余额支付",700.00,300.00,4,"一次性支付",date);
        List<Order> list = new ArrayList<Order>();
        list.add(order);
        list.add(order1);
        list.add(order2);
        list.add(order3);
//        注入DAO
        OrderMapper orderMapper = EasyMock.createMock(OrderMapper.class);
        developerService.setOrderMapper(orderMapper);
        DevelopersMapper developersMapper = EasyMock.createMock(DevelopersMapper.class);
        developerService.setDevelopersMapper(developersMapper);
        ParkingSpaceMapper parkingSpaceMapper = EasyMock.createMock(ParkingSpaceMapper.class);
        developerService.setParkingSpaceMapper(parkingSpaceMapper);

//        循环测试
        for(int i = 0;i<selectStaticsWhiteTestList.size();i++){
            if(i == 0){
                String info = selectStaticsWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(orderMapper);
                EasyMock.reset(developersMapper);
                EasyMock.reset(parkingSpaceMapper);
                // 创建变量及对象
                String line = selectStaticsWhiteTestList.get(i);
                String[] data = line.split(",");
                String did = data[0];
                Integer expect1 = Integer.parseInt(data[1]);
                Integer expect2 = Integer.parseInt(data[2]);
                Integer expect3 = Integer.parseInt(data[3]);
                Integer expect4 = Integer.parseInt(data[4]);
                Integer expect5 = Integer.parseInt(data[5]);
                Integer expect6 = Integer.parseInt(data[6]);
                // 记录
                EasyMock.expect(orderMapper.selectAllOrderByDid(did)).andReturn(list);
                EasyMock.expectLastCall();
                EasyMock.expect(developersMapper.selectMoney(did)).andReturn(Double.parseDouble(data[2]));
                EasyMock.expectLastCall();
                EasyMock.expect(parkingSpaceMapper.countParkSpace(did)).andReturn(expect1);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(orderMapper);
                EasyMock.replay(developersMapper);
                EasyMock.replay(parkingSpaceMapper);
                // 接下来调用Service进行测试
                ArrayList<Integer> actual = developerService.selectStatics(data[0]);
                Assert.assertEquals(expect1,actual.get(0));
                Assert.assertEquals(expect2,actual.get(1));
                Assert.assertEquals(expect3,actual.get(2));
                Assert.assertEquals(expect4,actual.get(3));
                Assert.assertEquals(expect5,actual.get(4));
                Assert.assertEquals(expect6,actual.get(5));
                // 进行校验
                EasyMock.verify(orderMapper);
                EasyMock.verify(developersMapper);
                EasyMock.verify(parkingSpaceMapper);
            }
        }

    }

    @Test
//    修改密码黑盒测试
    public void modifyPasswordBlackTest() {
//        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

//      Bean类
        Developer_administrator developer_administrator = new Developer_administrator();

//        注入DAO
        DeveloperMapper developerMapper = EasyMock.createMock(DeveloperMapper.class);
        developerService.setDeveloperMapper(developerMapper);

//        循环测试
        for(int i = 0;i<modifyPasswordBlackTestList.size();i++){
            if(i == 0){
                String info = modifyPasswordBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(developerMapper);
                // 创建变量及对象
                String line = modifyPasswordBlackTestList.get(i);
                String[] data = line.split(",");
                String uid = data[0];
                String old_pwd = data[1];
                String new_pwd1 = data[2];
                String new_pwd2 = data[3];
                boolean expect = Boolean.parseBoolean(data[4]);
                // 记录
                EasyMock.expect(developerMapper.login(uid,old_pwd)).andReturn(developer_administrator);
                EasyMock.expectLastCall();
                EasyMock.expect(developerMapper.modify_password(uid,new_pwd1)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(developerMapper);
                // 接下来调用Service进行测试
                boolean actual = developerService.modifyPassword(uid,old_pwd,new_pwd1,new_pwd2);
                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(developerMapper);
            }
        }
    }

    @Test
//    修改密码白盒测试
    public void modifyPasswordWhiteTest() {
//        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

//      Bean类
        Developer_administrator developer_administrator = new Developer_administrator();

//        注入DAO
        DeveloperMapper developerMapper = EasyMock.createMock(DeveloperMapper.class);
        developerService.setDeveloperMapper(developerMapper);

//        循环测试
        for(int i = 0;i<modifyPasswordWhiteTestList.size();i++){
            if(i == 0){
                String info = modifyPasswordWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(developerMapper);
                // 创建变量及对象
                String line = modifyPasswordWhiteTestList.get(i);
                String[] data = line.split(",");
                String uid = data[0];
                String old_pwd = data[1];
                String new_pwd1 = data[2];
                String new_pwd2 = data[3];
                boolean expect = Boolean.parseBoolean(data[4]);
                // 记录
                EasyMock.expect(developerMapper.login(uid,old_pwd)).andReturn(developer_administrator);
                EasyMock.expectLastCall();
//                EasyMock.expect(developerMapper.modify_password(uid,new_pwd1)).andReturn(false).anyTimes();
//                EasyMock.expectLastCall();
                EasyMock.expect(developerMapper.modify_password(uid,new_pwd1)).andReturn(expect).anyTimes();
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(developerMapper);
                // 接下来调用Service进行测试
                boolean actual = developerService.modifyPassword(uid,old_pwd,new_pwd1,new_pwd2);
                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(developerMapper);
            }
        }
    }

//    卢鹏宇的Service层测试
@Test
public void userLoginBlackTest() {
    // Service类
    UserServiceImpl userService = new UserServiceImpl();

    // Bean类
    User user = new User();

    // 注入DAO
    UserMapper userMapper = EasyMock.createMock(UserMapper.class);
    userService.setUserMapper(userMapper);

    // 循环测试
    for (int i = 0; i < userLoginBlackTestList.size(); i++) {
        if (i == 0) {
            String info = userLoginBlackTestList.get(i);
            System.out.println("现在测试:" + info);
        } else {
            EasyMock.reset(userMapper);
            // 创建变量及对象
            String line = userLoginBlackTestList.get(i);
            String[] data = line.split(";");
            String username = data[0];
            String password = data[1];
            String expect1 = data[2];
            String expect2 = data[3];
            user.setUserIdentity(username);
            user.setUserPassword(password);
            // 记录
            EasyMock.expect(userMapper.userLogin(username,password)).andReturn(user);;
            EasyMock.expectLastCall();
            // 使能设置
            EasyMock.replay(userMapper);
            // 接下来调用Service进行测试
            User actual = userService.userLogin(username,password);
            String actual1 = actual.getUserIdentity();
            String actual2 = actual.getUserPassword();
            if(actual1.equals("")){
                actual1 = null;
            }
            if(actual2.equals("")){
                actual2 = null;
            }
            Assert.assertEquals(expect1, String.valueOf(actual1));
            Assert.assertEquals(expect2, String.valueOf(actual2));
            // 进行校验
            EasyMock.verify(userMapper);
        }
    }
}

    @Test
    public void userLoginWhiteTest() {
        // Service类
        UserServiceImpl userService = new UserServiceImpl();

        // Bean类
        User user = new User();

        // 注入DAO
        UserMapper userMapper = EasyMock.createMock(UserMapper.class);
        userService.setUserMapper(userMapper);

        // 循环测试
        for (int i = 0; i < userLoginWhiteTestList.size(); i++) {
            if (i == 0) {
                String info = userLoginWhiteTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(userMapper);
                // 创建变量及对象
                String line = userLoginWhiteTestList.get(i);
                String[] data = line.split(";");
                String username = data[0];
                String password = data[1];
                String expect1 = data[2];
                String expect2 = data[3];
                user.setUserIdentity(username);
                user.setUserPassword(password);
                // 记录
                EasyMock.expect(userMapper.userLogin(username,password)).andReturn(user);;
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(userMapper);
                // 接下来调用Service进行测试
                User actual = userService.userLogin(username,password);
                String actual1 = actual.getUserIdentity();
                String actual2 = actual.getUserPassword();
                if(actual1.equals("")){
                    actual1 = null;
                }
                if(actual2.equals("")){
                    actual2 = null;
                }
                Assert.assertEquals(expect1, String.valueOf(actual1));
                Assert.assertEquals(expect2, String.valueOf(actual2));
                // 进行校验
                EasyMock.verify(userMapper);
            }
        }
    }

    @Test
    public void selectNameByIdBlackTest() {
        // Service类
        UserServiceImpl userService = new UserServiceImpl();

        // Bean类
        User user = new User();

        // 注入DAO
        UserMapper userMapper = EasyMock.createMock(UserMapper.class);
        userService.setUserMapper(userMapper);

        // 循环测试
        for (int i = 0; i < selectNameByIdBlackTestList.size(); i++) {
            if (i == 0) {
                String info = selectNameByIdBlackTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(userMapper);
                // 创建变量及对象
                String line = selectNameByIdBlackTestList.get(i);
                String[] data = line.split(";");
                String username = data[0];
                String expect = data[1];
                user.setUserIdentity(username);
                // 记录
                EasyMock.expect(userMapper.selectNameById(username)).andReturn(user);;
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(userMapper);
                // 接下来调用Service进行测试
                User actual = userService.selectNameById(username);
                String actual1 = actual.getUserIdentity();
                if(actual1.equals("")){
                    actual1 = null;
                }
                Assert.assertEquals(expect, String.valueOf(actual1));
                // 进行校验
                EasyMock.verify(userMapper);
            }
        }
    }

    @Test
    public void selectNameByIdWhiteTest() {
        // Service类
        UserServiceImpl userService = new UserServiceImpl();

        // Bean类
        User user = new User();

        // 注入DAO
        UserMapper userMapper = EasyMock.createMock(UserMapper.class);
        userService.setUserMapper(userMapper);

        // 循环测试
        for (int i = 0; i < selectNameByIdWhiteTestList.size(); i++) {
            if (i == 0) {
                String info = selectNameByIdWhiteTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(userMapper);
                // 创建变量及对象
                String line = selectNameByIdWhiteTestList.get(i);
                String[] data = line.split(";");
                String username = data[0];
                String expect = data[1];
                user.setUserIdentity(username);
                // 记录
                EasyMock.expect(userMapper.selectNameById(username)).andReturn(user);;
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(userMapper);
                // 接下来调用Service进行测试
                User actual = userService.selectNameById(username);
                String actual1 = actual.getUserIdentity();
                if(actual1.equals("")){
                    actual1 = null;
                }
                Assert.assertEquals(expect, String.valueOf(actual1));
                // 进行校验
                EasyMock.verify(userMapper);
            }
        }
    }

    @Test
    public void userAuthenticationBlackTest() {
        // Service类
        UserServiceImpl userService = new UserServiceImpl();

        // Bean类
        User user = new User();

        // 注入DAO
        UserMapper userMapper = EasyMock.createMock(UserMapper.class);
        userService.setUserMapper(userMapper);

        // 循环测试
        for (int i = 0; i < userAuthenticationBlackTestList.size(); i++) {
            if (i == 0) {
                String info = userAuthenticationBlackTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(userMapper);
                // 创建变量及对象
                String line = userAuthenticationBlackTestList.get(i);
                String[] data = line.split(";");
                String userResidentialQuarters = data[0];
                String userBuildingNumber = data[1];
                String userHouseNum = data[2];
                String expect = data[3];
                user.setUserIdentity(null);
                // 记录
                EasyMock.expect(userMapper.userAuthentication(userResidentialQuarters,userBuildingNumber,userHouseNum)).andReturn(user);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(userMapper);
                // 接下来调用Service进行测试
                User actual = userService.userAuthentication(userResidentialQuarters,userBuildingNumber,userHouseNum);
                String actual1 = actual.getUserIdentity();
                Assert.assertEquals(expect, String.valueOf(actual1));
                // 进行校验
                EasyMock.verify(userMapper);
            }
        }
    }

    @Test
    public void userAuthenticationWhiteTest() {
        // Service类
        UserServiceImpl userService = new UserServiceImpl();

        // Bean类
        User user = new User();

        // 注入DAO
        UserMapper userMapper = EasyMock.createMock(UserMapper.class);
        userService.setUserMapper(userMapper);

        // 循环测试
        for (int i = 0; i < userAuthenticationWhiteTestList.size(); i++) {
            if (i == 0) {
                String info = userAuthenticationWhiteTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(userMapper);
                // 创建变量及对象
                String line = userAuthenticationWhiteTestList.get(i);
                String[] data = line.split(";");
                String userResidentialQuarters = data[0];
                String userBuildingNumber = data[1];
                String userHouseNum = data[2];
                String expect = data[3];
                user.setUserIdentity("huangyimiao666@gmail.com");
                // 记录
                EasyMock.expect(userMapper.userAuthentication(userResidentialQuarters,userBuildingNumber,userHouseNum)).andReturn(user);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(userMapper);
                // 接下来调用Service进行测试
                User actual = userService.userAuthentication(userResidentialQuarters,userBuildingNumber,userHouseNum);
                String actual1 = actual.getUserIdentity();
                Assert.assertEquals(expect, String.valueOf(actual1));
                // 进行校验
                EasyMock.verify(userMapper);
            }
        }
    }

    @Test
    public void updateUserInfoBlackTest() {
        // Service类
        UserServiceImpl userService = new UserServiceImpl();

        // Bean类
        User user = new User();

        // 注入DAO
        UserMapper userMapper = EasyMock.createMock(UserMapper.class);
        userService.setUserMapper(userMapper);

        // 循环测试
        for(int i = 0;i<updateUserInfoBlackTestList.size();i++){
            if(i == 0){
                String info = updateUserInfoBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                EasyMock.reset(userMapper);
                // 创建变量及对象
                String line = updateUserInfoBlackTestList.get(i);
                String[] data = line.split(";");
                String useremail = data[0];
                String username = data[1];
                String userphone = data[2];
                String sex = data[3];
                String userquarter = data[4];
                String userbuilding = data[5];
                String userhouse = data[6];
                user.setUserIdentity(useremail);
                user.setUserName(username);
                user.setUserPhone(userphone);
                user.setUserSex(sex);
                user.setUserResidentialQuarters(userquarter);
                user.setUserBuildingNumber(userbuilding);
                user.setUserHouseNumber(userhouse);
                boolean mock = Boolean.parseBoolean(data[7]);
                boolean expect = Boolean.parseBoolean(data[8]);
                // 记录
                EasyMock.expect(userMapper.updateUserInfo(user)).andReturn(mock);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(userMapper);
                // 接下来调用Service进行测试
                boolean actual = userService.updateUserInfo(user);
                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(userMapper);
            }
        }
    }

    @Test
    public void updateUserInfoWhiteTest() {
        // Service类
        UserServiceImpl userService = new UserServiceImpl();

        // Bean类
        User user = new User();

        // 注入DAO
        UserMapper userMapper = EasyMock.createMock(UserMapper.class);
        userService.setUserMapper(userMapper);

        // 循环测试
        for(int i = 0;i<updateUserInfoWhiteTestList.size();i++){
            if(i == 0){
                String info = updateUserInfoWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                EasyMock.reset(userMapper);
                // 创建变量及对象
                String line = updateUserInfoWhiteTestList.get(i);
                String[] data = line.split(";");
                String useremail = data[0];
                String username = data[1];
                String userphone = data[2];
                String sex = data[3];
                String userquarter = data[4];
                String userbuilding = data[5];
                String userhouse = data[6];
                user.setUserIdentity(useremail);
                user.setUserName(username);
                user.setUserPhone(userphone);
                user.setUserSex(sex);
                user.setUserResidentialQuarters(userquarter);
                user.setUserBuildingNumber(userbuilding);
                user.setUserHouseNumber(userhouse);
                boolean mock = Boolean.parseBoolean(data[7]);
                boolean expect = Boolean.parseBoolean(data[8]);
                // 记录
                EasyMock.expect(userMapper.updateUserInfo(user)).andReturn(mock);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(userMapper);
                // 接下来调用Service进行测试
                boolean actual = userService.updateUserInfo(user);
                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(userMapper);
            }
        }
    }

    @Test
    public void selectUserOrderBlackTest() {
        // Service类
        OrderServiceImpl orderService = new OrderServiceImpl();

        // Bean类
        Order order = new Order();
        List<Order> orderList = new ArrayList<>();

        // 注入DAO
        OrderMapper orderMapper = EasyMock.createMock(OrderMapper.class);
        orderService.setOrderMapper(orderMapper);

        // 循环测试
        for (int i = 0; i < selectUserOrderBlackTestList.size(); i++) {
            if (i == 0) {
                String info = selectUserOrderBlackTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(orderMapper);
                // 创建变量及对象
                String line = selectUserOrderBlackTestList.get(i);
                String[] data = line.split(";");
                String userIdentity = data[0];
                String expect1 = data[1];
                String expect2 = data[2];
                String expect3 = data[3];
                order.setOrderId(expect1);
                order.setParkingSpaceId(expect2);
                order.setContractSignatory(expect3);
                orderList.add(order);
                // 记录
                EasyMock.expect(orderMapper.selectUserOrder(userIdentity)).andReturn(orderList);;
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(orderMapper);
                // 接下来调用Service进行测试
                String actual1,actual2,actual3;
                List<Order> actual = orderService.selectUserOrder(userIdentity);
                if(actual.size()==0){
                    actual1 = null;
                    actual2 = null;
                    actual3 = null;
                }else {
                    actual1 = actual.get(0).getOrderId();
                    actual2 = actual.get(0).getParkingSpaceId();
                    actual3 = actual.get(0).getContractSignatory();
                }
                Assert.assertEquals(expect1,String.valueOf(actual1));
                Assert.assertEquals(expect2,String.valueOf(actual2));
                Assert.assertEquals(expect3,String.valueOf(actual3));
                // 进行校验
                EasyMock.verify(orderMapper);
            }
        }
    }

    @Test
    public void selectUserOrderWhiteTest() {
        // Service类
        OrderServiceImpl orderService = new OrderServiceImpl();

        // Bean类
        Order order = new Order();
        List<Order> orderList = new ArrayList<>();

        // 注入DAO
        OrderMapper orderMapper = EasyMock.createMock(OrderMapper.class);
        orderService.setOrderMapper(orderMapper);

        // 循环测试
        for (int i = 0; i < selectUserOrderWhiteTestList.size(); i++) {
            if (i == 0) {
                String info = selectUserOrderWhiteTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(orderMapper);
                // 创建变量及对象
                String line = selectUserOrderWhiteTestList.get(i);
                String[] data = line.split(";");
                String userIdentity = data[0];
                String expect1 = data[1];
                String expect2 = data[2];
                String expect3 = data[3];
                order.setOrderId(expect1);
                order.setParkingSpaceId(expect2);
                order.setContractSignatory(expect3);
                orderList.add(order);
                // 记录
                EasyMock.expect(orderMapper.selectUserOrder(userIdentity)).andReturn(orderList);;
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(orderMapper);
                // 接下来调用Service进行测试
                String actual1,actual2,actual3;
                List<Order> actual = orderService.selectUserOrder(userIdentity);
                if(actual.size()==0){
                    actual1 = null;
                    actual2 = null;
                    actual3 = null;
                }else {
                    actual1 = actual.get(0).getOrderId();
                    actual2 = actual.get(0).getParkingSpaceId();
                    actual3 = actual.get(0).getContractSignatory();
                }
                Assert.assertEquals(expect1,String.valueOf(actual1));
                Assert.assertEquals(expect2,String.valueOf(actual2));
                Assert.assertEquals(expect3,String.valueOf(actual3));
                // 进行校验
                EasyMock.verify(orderMapper);
            }
        }
    }

    @Test
    public void selectCouponBlackTest() {
        // Service类
        CouponServiceImpl couponService = new CouponServiceImpl();

        // Bean类
        Coupon coupon = new Coupon();
        List<Coupon> couponList = new ArrayList<>();

        // 注入DAO
        CouponMapper couponMapper = EasyMock.createMock(CouponMapper.class);
        couponService.setCouponMapper(couponMapper);

        // 循环测试
        for (int i = 0; i < selectCouponBlackTestList.size(); i++) {
            if (i == 0) {
                String info = selectCouponBlackTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(couponMapper);
                // 创建变量及对象
                String line = selectCouponBlackTestList.get(i);
                String[] data = line.split(";");
                String userIdentity = data[0];
                String expect = data[1];
                coupon.setId(expect);
                couponList.add(coupon);
                // 记录
                EasyMock.expect(couponMapper.selectCoupon(userIdentity)).andReturn(couponList);;
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(couponMapper);
                // 接下来调用Service进行测试
                String actual1;
                List<Coupon> actual = couponService.selectCoupon(userIdentity);
                if(actual.size()==0){
                    actual1 = null;
                }else {
                    actual1 = actual.get(0).getId();
                }
                Assert.assertEquals(expect,String.valueOf(actual1));
                // 进行校验
                EasyMock.verify(couponMapper);
            }
        }
    }

    @Test
    public void selectCouponWhiteTest() {
        // Service类
        CouponServiceImpl couponService = new CouponServiceImpl();

        // Bean类
        Coupon coupon = new Coupon();
        List<Coupon> couponList = new ArrayList<>();

        // 注入DAO
        CouponMapper couponMapper = EasyMock.createMock(CouponMapper.class);
        couponService.setCouponMapper(couponMapper);

        // 循环测试
        for (int i = 0; i < selectCouponWhiteTestList.size(); i++) {
            if (i == 0) {
                String info = selectCouponWhiteTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(couponMapper);
                // 创建变量及对象
                String line = selectCouponWhiteTestList.get(i);
                String[] data = line.split(";");
                String userIdentity = data[0];
                String expect = data[1];
                coupon.setId(expect);
                couponList.add(coupon);
                // 记录
                EasyMock.expect(couponMapper.selectCoupon(userIdentity)).andReturn(couponList);;
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(couponMapper);
                // 接下来调用Service进行测试
                String actual1;
                List<Coupon> actual = couponService.selectCoupon(userIdentity);
                if(actual.size()==0){
                    actual1 = null;
                }else {
                    actual1 = actual.get(0).getId();
                }
                Assert.assertEquals(expect,String.valueOf(actual1));
                // 进行校验
                EasyMock.verify(couponMapper);
            }
        }
    }

    @Test
    public void selectBankcardBlackTest() {
        // Service类
        BankcardServiceImpl bankcardService = new BankcardServiceImpl();

        // Bean类
        Bankcard bankcard = new Bankcard();
        List<Bankcard> bankcardList = new ArrayList<>();

        // 注入DAO
        BankcardMapper bankcardMapper = EasyMock.createMock(BankcardMapper.class);
        bankcardService.setBankcardMapper(bankcardMapper);

        // 循环测试
        for (int i = 0; i < selectBankcardBlackTestList.size(); i++) {
            if (i == 0) {
                String info = selectBankcardBlackTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(bankcardMapper);
                // 创建变量及对象
                String line = selectBankcardBlackTestList.get(i);
                String[] data = line.split(";");
                String userIdentity = data[0];
                String expect = data[1];
                bankcard.setBankcardId(expect);
                bankcardList.add(bankcard);
                // 记录
                EasyMock.expect(bankcardMapper.selectBankcard(userIdentity)).andReturn(bankcardList);;
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(bankcardMapper);
                // 接下来调用Service进行测试
                String actual1;
                List<Bankcard> actual = bankcardService.selectBankcard(userIdentity);
                if(actual.size()==0){
                    actual1 = null;
                }else {
                    actual1 = actual.get(0).getBankcardId();
                }
                Assert.assertEquals(expect,String.valueOf(actual1));
                // 进行校验
                EasyMock.verify(bankcardMapper);
            }
        }
    }

    @Test
    public void selectBankcardWhiteTest() {
        // Service类
        BankcardServiceImpl bankcardService = new BankcardServiceImpl();

        // Bean类
        Bankcard bankcard = new Bankcard();
        List<Bankcard> bankcardList = new ArrayList<>();

        // 注入DAO
        BankcardMapper bankcardMapper = EasyMock.createMock(BankcardMapper.class);
        bankcardService.setBankcardMapper(bankcardMapper);

        // 循环测试
        for (int i = 0; i < selectBankcardWhiteTestList.size(); i++) {
            if (i == 0) {
                String info = selectBankcardWhiteTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(bankcardMapper);
                // 创建变量及对象
                String line = selectBankcardWhiteTestList.get(i);
                String[] data = line.split(";");
                String userIdentity = data[0];
                String expect = data[1];
                bankcard.setBankcardId(expect);
                bankcardList.add(bankcard);
                // 记录
                EasyMock.expect(bankcardMapper.selectBankcard(userIdentity)).andReturn(bankcardList);;
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(bankcardMapper);
                // 接下来调用Service进行测试
                String actual1;
                List<Bankcard> actual = bankcardService.selectBankcard(userIdentity);
                if(actual.size()==0){
                    actual1 = null;
                }else {
                    actual1 = actual.get(0).getBankcardId();
                }
                Assert.assertEquals(expect,String.valueOf(actual1));
                // 进行校验
                EasyMock.verify(bankcardMapper);
            }
        }
    }
    @Test
    public void manage_parkingSpaceTest() {
//        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

//      Bean类
        Developer_administrator developer_administrator = new Developer_administrator();
        ParkingSpace parkingSpace=new ParkingSpace();
//        注入DAO
        ParkingSpaceMapper parkingSpaceMapper = EasyMock.createMock(ParkingSpaceMapper.class);
        developerService.setParkingSpaceMapper(parkingSpaceMapper);

//        循环测试
        for(int i = 0;i<manage_parkingSpaceTestList.size();i++){
            if(i == 0){
                String info = manage_parkingSpaceTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                List<ParkingSpace> list=new ArrayList<>();
                list.add(parkingSpace);
                EasyMock.reset(parkingSpaceMapper);
                // 创建变量及对象
                String line = manage_parkingSpaceTestList.get(i);
                System.out.println("第"+i+"次测试");
                String[] data = line.split(",");
                String did = data[0];
                //System.out.println(did);
//                String search = data[1];
                String search="";
                int pageSize = Integer.valueOf(data[2]);
                int pageNum = Integer.valueOf(data[3]);
                int expect = Integer.valueOf(data[4]);
                // 记录
                EasyMock.expect(parkingSpaceMapper.selectParkSpace(pageNum,pageSize,search,did)).andReturn(list);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(parkingSpaceMapper);
                // 接下来调用Service进行测试
                List<ParkingSpace> actual = developerService.selectParkingSpace(pageNum,pageSize,search,did);
                // 进行校验
                int result=0;
                if(actual!=null) result=1;
                //先确保实际返回的对象非空
                Assert.assertNotNull(actual);
                Assert.assertEquals(expect,result);
                EasyMock.verify(parkingSpaceMapper);
            }
        }
    }

    @Test
    public void testselectOrder() {
        //        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

//      Bean类
        Order o = new Order();
//        注入DAO
        OrderMapper orderMapper = EasyMock.createStrictMock(OrderMapper.class);
        developerService.setOrderMapper(orderMapper);

//        循环测试
        for(int i = 0;i<now_orderlistTestList.size();i++){
            if(i == 0){
                String info = now_orderlistTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                List<Order> list=new ArrayList<>();
                list.add(o);
                EasyMock.reset(orderMapper);
                // 创建变量及对象
                String line = now_orderlistTestList.get(i);
                String[] data = line.split(",");
                String did = data[0];
                String search = data[1];
                int pageSize = Integer.valueOf(data[2]);
                int pageNum = Integer.valueOf(data[3]);
                int expect = Integer.valueOf(data[4]);
                // 记录
                EasyMock.expect(orderMapper.selectOrder(pageNum,pageSize,search,did)).andReturn(list);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(orderMapper);
                // 接下来调用Service进行测试
                List<Order> actual = developerService.selectOrder(pageNum,pageSize,search,did);
                // 进行校验
                int result=0;
                if(actual!=null) result=1;
                //先确保实际返回的对象非空
                Assert.assertNotNull(actual);
                Assert.assertEquals(expect,result);
                EasyMock.verify(orderMapper);
            }
        }
    }

    @Test
    public void testselectactivity() {
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

//      Bean类
        Activity activity = new Activity();
//        注入DAO
        ActivityMapper activityMapper = EasyMock.createStrictMock(ActivityMapper.class);
        developerService.setActivityMapper(activityMapper);

//        循环测试
        for(int i = 0;i<selectActivityTestList.size();i++){
            if(i == 0){
                String info = selectActivityTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                List<Activity> list=new ArrayList<>();
                list.add(activity);
                EasyMock.reset(activityMapper);
                // 创建变量及对象
                String line = selectActivityTestList.get(i);
                String[] data = line.split(",");
                String did = data[0];
                String search = data[1];
                int pageSize = Integer.valueOf(data[2]);
                int pageNum = Integer.valueOf(data[3]);
                int expect = Integer.valueOf(data[4]);
                // 记录
                EasyMock.expect(activityMapper.selectActivity(pageNum,pageSize,search,did)).andReturn(list);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(activityMapper);
                // 接下来调用Service进行测试
                List<Activity> actual = developerService.selectActivity(pageNum,pageSize,search,did);
                // 进行校验
                int result=0;
                if(actual!=null) result=1;
                //先确保实际返回的对象非空
                Assert.assertNotNull(actual);
                Assert.assertEquals(expect,result);
                EasyMock.verify(activityMapper);
            }
        }
    }

    @Test
    public void testselect_developerInfo() {
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

//      Bean类
        Developer_administrator developer_administrator = new Developer_administrator();
        Developers developers=new Developers();
//        注入DAO
        DevelopersMapper developersMapper = EasyMock.createStrictMock(DevelopersMapper.class);
        DeveloperMapper developerMapper = EasyMock.createStrictMock(DeveloperMapper.class);
        developerService.setDevelopersMapper(developersMapper);
        developerService.setDeveloperMapper(developerMapper);

//        循环测试
        for(int i = 0;i<select_developerInfoTestList.size();i++){
            if(i == 0){
                String info = select_developerInfoTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                EasyMock.reset(developerMapper);
                // 创建变量及对象
                String line = select_ResidentialQuartersTestList.get(i);
                String[] data = line.split(",");
                String did = data[0];
                String uid = data[1];
                int expect = Integer.valueOf(data[2]);
                // 记录
//                EasyMock.expect(developerMapper.select_roleInfo(uid)).andReturn(developer_administrator);
//                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.expect(developersMapper.selectDeveloper(did)).andReturn(developers);
                EasyMock.expectLastCall();
                EasyMock.replay(developerMapper);
                EasyMock.replay(developersMapper);
                // 接下来调用Service进行测试
                Developers actual1= developerService.selectDeveloperInfo1(did);
//                Developer_administrator actual2=developerService.selectDeveloperInfo2(did);
                // 进行校验
                int result=0;
                if(actual1!=null) result=1;
                //先确保实际返回的对象非空
                Assert.assertNotNull(actual1);
//                Assert.assertNotNull(actual2);
                Assert.assertEquals(expect,result);
                EasyMock.verify(developersMapper);
                EasyMock.verify(developerMapper);
            }
        }
    }

    @Test
    public void testselectAllResidentialQuarters() {
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

//      Bean类
        ResidentialQuarters residentialQuarters = new ResidentialQuarters();
//        注入DAO
        ResidentialQuartersMapper residentialQuartersMapper = EasyMock.createStrictMock(ResidentialQuartersMapper.class);
        developerService.setResidentialQuartersMapper(residentialQuartersMapper);

//        循环测试
        for(int i = 0;i<select_ResidentialQuartersTestList.size();i++){
            if(i == 0){
                String info = select_ResidentialQuartersTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                List<ResidentialQuarters> list=new ArrayList<>();
                list.add(residentialQuarters);
                EasyMock.reset(residentialQuartersMapper);
                // 创建变量及对象
                String line = select_ResidentialQuartersTestList.get(i);
                String[] data = line.split(",");
                String did = data[0];
                int pageSize = Integer.valueOf(data[1]);
                int pageNum = Integer.valueOf(data[2]);
                int expect = Integer.valueOf(data[3]);
                // 记录
                EasyMock.expect(residentialQuartersMapper.selectResidentialQuarters(did)).andReturn(list);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(residentialQuartersMapper);
                // 接下来调用Service进行测试
                List<ResidentialQuarters> actual = developerService.selectAllResidentialQuarters(did);
                // 进行校验
                int result=0;
                if(actual!=null) result=1;
                //先确保实际返回的对象非空
                Assert.assertNotNull(actual);
                Assert.assertEquals(expect,result);
                EasyMock.verify(residentialQuartersMapper);
            }
        }
    }

    @Test
    public void addResidentialQuarters() {
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

//      Bean类
        ResidentialQuarters residentialQuarters = new ResidentialQuarters();
//        注入DAO
        ResidentialQuartersMapper residentialQuartersMapper = EasyMock.createStrictMock(ResidentialQuartersMapper.class);
        developerService.setResidentialQuartersMapper(residentialQuartersMapper);

//        循环测试
        for(int i = 0;i<add_ResidentialQuartersTestList.size();i++){
            if(i == 0){
                String info = add_ResidentialQuartersTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                List<ResidentialQuarters> list=new ArrayList<>();
                list.add(residentialQuarters);
                EasyMock.reset(residentialQuartersMapper);
                // 创建变量及对象
                String line = add_ResidentialQuartersTestList.get(i);
                System.out.println(i);
                String[] data = line.split(",");
                String developer_id="1234";
                String residential_quarters_name=data[0];
                String state=data[1];
                int expect = Integer.valueOf(data[2]);
                // 记录
                EasyMock.expect(residentialQuartersMapper.insertResidentialQuarters(EasyMock.anyObject(ResidentialQuarters.class))).andReturn(true);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(residentialQuartersMapper);
                // 接下来调用Service进行测试
                Boolean actual = developerService.addResidentialQuarters(developer_id,residential_quarters_name,state);
                // 进行校验
                Assert.assertEquals(expect,actual);
                EasyMock.verify(residentialQuartersMapper);
            }
        }
    }

//    梁德源的代码
@Test
public void loginBlackTest() throws IOException {

    ArrayList<String> TestList;
    File directory = new File("");

//        修改密码黑盒测试用例读取
    TestList = new ArrayList<>();
    File file = new File("src\\test\\java\\service\\ldy\\loginblack.txt");
    if (file.isFile() && file.exists()) {
        InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(read);
        for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; TestList.add(lineTxt)) {
        }
        read.close();
    } else {
        System.out.println("找不到指定的测试数据文件");
    }

//        Service类
    AdministratorsServiceImpl administratorsService = new AdministratorsServiceImpl();

//      Bean类
    Developer_administrator developer_administrator = new Developer_administrator();
    Administrators administrators = new Administrators();

//        注入DAO
    AdministratorsMapper administratorsMapper = EasyMock.createMock(AdministratorsMapper.class);
    administratorsService.setAdministratorsMapper(administratorsMapper);


//        循环测试
    for (int i = 0; i < TestList.size(); i++) {
        if (i == 0) {
            String info = TestList.get(i);
            System.out.println("现在测试:" + info);
        } else {
            System.out.println("现在进行第" + i + "次测试");
            EasyMock.reset(administratorsMapper);
            // 创建变量及对象
            String line = TestList.get(i);
            String[] data = line.split(",");
            String adminname = data[0];

            boolean expect = Boolean.parseBoolean(data[1]);
            // 记录
            EasyMock.expect(administratorsMapper.selectAdministratorsByName(adminname)).andReturn(administrators).anyTimes();
            EasyMock.expectLastCall();
            // 使能设置
            EasyMock.replay(administratorsMapper);
            // 接下来调用Service进行测试
            boolean actual = false;
            Administrators ad = administratorsService.selectAdministratorsByName(adminname);
            if (ad != null) {
                actual = true;
            }
            Assert.assertEquals(expect, actual);
            // 进行校验
            EasyMock.verify(administratorsMapper);
            System.out.println("第" + i + "次测试通过");
        }
    }
}

    @Test
    public void loginWhiteTest() throws IOException {

        ArrayList<String> TestList;
        File directory = new File("");

//        修改密码黑盒测试用例读取
        TestList = new ArrayList<>();
        File file = new File("src\\test\\java\\service\\ldy\\loginwhite.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; TestList.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }

//        Service类
        AdministratorsServiceImpl administratorsService = new AdministratorsServiceImpl();

//      Bean类
        Developer_administrator developer_administrator = new Developer_administrator();
        Administrators administrators = new Administrators();

//        注入DAO
        AdministratorsMapper administratorsMapper = EasyMock.createMock(AdministratorsMapper.class);
        administratorsService.setAdministratorsMapper(administratorsMapper);


//        循环测试
        for (int i = 0; i < TestList.size(); i++) {
            if (i == 0) {
                String info = TestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("现在进行第" + i + "次测试");
                EasyMock.reset(administratorsMapper);
                // 创建变量及对象
                String line = TestList.get(i);
                String[] data = line.split(",");
                String adminname = data[0];

                boolean expect = Boolean.parseBoolean(data[1]);
                // 记录
                EasyMock.expect(administratorsMapper.selectAdministratorsByName(adminname)).andReturn(administrators).anyTimes();
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(administratorsMapper);
                // 接下来调用Service进行测试
                boolean actual = false;
                Administrators ad = administratorsService.selectAdministratorsByName(adminname);
                if (ad != null) {
                    actual = true;
                }
                Assert.assertEquals(expect, actual);
                // 进行校验
                EasyMock.verify(administratorsMapper);
                System.out.println("第" + i + "次测试通过");
            }
        }
    }

    @Test
    public void GenerateOrderBlackTest() throws IOException {

        ArrayList<String> TestList;
        File directory = new File("");

//        修改密码黑盒测试用例读取
        TestList = new ArrayList<>();
        File file = new File("src\\test\\java\\service\\ldy\\GenerateOrderblack.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; TestList.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }

//        Service类
        AdministratorsServiceImpl administratorsService = new AdministratorsServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

//      Bean类
        Developer_administrator developer_administrator = new Developer_administrator();
        Administrators administrators = new Administrators();
        ParkingSpace parkingSpace = new ParkingSpace();


//        注入DAO
        AdministratorsMapper administratorsMapper = EasyMock.createMock(AdministratorsMapper.class);
        ParkingSpaceMapper parkingSpaceMapper = EasyMock.createMock(ParkingSpaceMapper.class);
        OrderMapper orderMapper = EasyMock.createMock(OrderMapper.class);
        UserAdminBillMapper userAdminBillMapper = EasyMock.createMock(UserAdminBillMapper.class);
        orderService.setOrderMapper(orderMapper);
        orderService.setUserAdminBillMapper(userAdminBillMapper);
        orderService.setParkingSpaceMapper(parkingSpaceMapper);
        orderService.setAdministratorsMapper(administratorsMapper);


//        循环测试
        for (int i = 0; i < TestList.size(); i++) {
            if (i == 0) {
                String info = TestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("现在进行第" + i + "次测试");
                EasyMock.reset(administratorsMapper);
                // 创建变量及对象
                String line = TestList.get(i);
                String[] data = line.split(",");
                String adminname = data[0];
                String into1 = data[0];
                String into2 = data[1];
                String into3 = data[2];
                String into4 = data[3];
                boolean expect = Boolean.parseBoolean(data[4]);
                // 记录
                EasyMock.expect(administratorsMapper.selectAdministratorsByName(into4)).andReturn(administrators).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(parkingSpaceMapper.selectParkingSpaceById(into1)).andReturn(parkingSpace).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(orderMapper.insertOrder(anyObject())).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(userAdminBillMapper.insertUserAdminBill(anyObject())).andReturn(true).anyTimes();

                // 使能设置
                EasyMock.replay(userAdminBillMapper);
                EasyMock.replay(orderMapper);
                EasyMock.replay(administratorsMapper);
                EasyMock.replay(parkingSpaceMapper);
                // 接下来调用Service进行测试
                boolean actual = false;
                actual = orderService.insertOrder(into1, into2, into3, into4);
                Assert.assertEquals(expect, actual);
                // 进行校验
                EasyMock.verify(administratorsMapper);
                System.out.println("第" + i + "次测试通过");
            }
        }
    }

    @Test
    public void GenerateOrderWhiteTest() throws IOException {

        ArrayList<String> TestList;
        File directory = new File("");

//        修改密码黑盒测试用例读取
        TestList = new ArrayList<>();
        File file = new File("src\\test\\java\\service\\ldy\\GenerateOrderwhite.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; TestList.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }

//        Service类
        AdministratorsServiceImpl administratorsService = new AdministratorsServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

//      Bean类
        Developer_administrator developer_administrator = new Developer_administrator();
        Administrators administrators = new Administrators();
        ParkingSpace parkingSpace = new ParkingSpace();


//        注入DAO
        AdministratorsMapper administratorsMapper = EasyMock.createMock(AdministratorsMapper.class);
        ParkingSpaceMapper parkingSpaceMapper = EasyMock.createMock(ParkingSpaceMapper.class);
        OrderMapper orderMapper = EasyMock.createMock(OrderMapper.class);
        UserAdminBillMapper userAdminBillMapper = EasyMock.createMock(UserAdminBillMapper.class);
        orderService.setOrderMapper(orderMapper);
        orderService.setUserAdminBillMapper(userAdminBillMapper);
        orderService.setParkingSpaceMapper(parkingSpaceMapper);
        orderService.setAdministratorsMapper(administratorsMapper);


//        循环测试
        for (int i = 0; i < TestList.size(); i++) {
            if (i == 0) {
                String info = TestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("现在进行第" + i + "次测试");
                EasyMock.reset(administratorsMapper);
                // 创建变量及对象
                String line = TestList.get(i);
                String[] data = line.split(",");
                String adminname = data[0];
                String into1 = data[0];
                String into2 = data[1];
                String into3 = data[2];
                String into4 = data[3];
                boolean expect = Boolean.parseBoolean(data[4]);
                // 记录
                EasyMock.expect(administratorsMapper.selectAdministratorsByName(into4)).andReturn(administrators).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(parkingSpaceMapper.selectParkingSpaceById(into1)).andReturn(parkingSpace).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(orderMapper.insertOrder(anyObject())).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(userAdminBillMapper.insertUserAdminBill(anyObject())).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(userAdminBillMapper);
                EasyMock.replay(orderMapper);
                EasyMock.replay(administratorsMapper);
                EasyMock.replay(parkingSpaceMapper);
                // 接下来调用Service进行测试
                boolean actual = false;
                actual = orderService.insertOrder(into1, into2, into3, into4);
                Assert.assertEquals(expect, actual);
                // 进行校验
                EasyMock.verify(administratorsMapper);
                System.out.println("第" + i + "次测试通过");
            }
        }
    }

    @Test
    public void CancelOrderBlackTest() throws IOException {

        ArrayList<String> TestList;
        File directory = new File("");

//        修改密码黑盒测试用例读取
        TestList = new ArrayList<>();
        File file = new File("src\\test\\java\\service\\ldy\\CancelOrderblack.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; TestList.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }

//        Service类
        AdministratorsServiceImpl administratorsService = new AdministratorsServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

//      Bean类
        Developer_administrator developer_administrator = new Developer_administrator();
        Administrators administrators = new Administrators();
        ParkingSpace parkingSpace = new ParkingSpace();


//        注入DAO
        AdministratorsMapper administratorsMapper = EasyMock.createMock(AdministratorsMapper.class);
        ParkingSpaceMapper parkingSpaceMapper = EasyMock.createMock(ParkingSpaceMapper.class);
        OrderMapper orderMapper = EasyMock.createMock(OrderMapper.class);
        UserAdminBillMapper userAdminBillMapper = EasyMock.createMock(UserAdminBillMapper.class);
        UserMapper userMapper = EasyMock.createMock(UserMapper.class);

        administratorsService.setOrderMapper(orderMapper);
        administratorsService.setUserAdminBillMapper(userAdminBillMapper);
        administratorsService.setParkingSpaceMapper(parkingSpaceMapper);
        administratorsService.setAdministratorsMapper(administratorsMapper);
        administratorsService.setUserMapper(userMapper);


//        循环测试
        for (int i = 0; i < TestList.size(); i++) {
            if (i == 0) {
                String info = TestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("现在进行第" + i + "次测试");
                EasyMock.reset(administratorsMapper);
                EasyMock.reset(orderMapper);
                EasyMock.reset(userMapper);
                EasyMock.reset(userAdminBillMapper);
                EasyMock.reset(parkingSpaceMapper);

                // 创建变量及对象
                String line = TestList.get(i);
                String[] data = line.split(",");
                String adminname = data[0];
                String into1 = data[0];
                String into2 = data[1];
                String into3 = data[2];
//                String into4=data[3];
                boolean expect = Boolean.parseBoolean(data[2]);
                Order order = new Order();
                User user = new User();
                user.setUserName("admin");
                user.setMoney(123.3);
                // 记录
                EasyMock.expect(orderMapper.selectOrderById(into1)).andReturn(order).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(parkingSpaceMapper.updateParkSpaceState(1, null)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(userMapper.selectUserByUserId(anyObject())).andReturn(user).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(administratorsMapper.selectAdministratorsByName(into2)).andReturn(administrators).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(userAdminBillMapper.insertUserAdminBill(anyObject())).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(orderMapper.updateOrderState(5, into1)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(userMapper.updateUserMoney(123.3, null)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(administratorsMapper.updateAdministratorsMoney(0.0, into2)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();

                // 使能设置
                EasyMock.replay(userAdminBillMapper);
                EasyMock.replay(orderMapper);
                EasyMock.replay(administratorsMapper);
                EasyMock.replay(parkingSpaceMapper);
                EasyMock.replay(userMapper);
                // 接下来调用Service进行测试
                boolean actual = false;
                actual = administratorsService.cancelOrder(into1, into2);
                Assert.assertEquals(expect, actual);
                // 进行校验
                EasyMock.verify(administratorsMapper);
                System.out.println("第" + i + "次测试通过");
            }
        }
    }

    @Test
    public void CancelOrderWhiteTest() throws IOException {

        ArrayList<String> TestList;
        File directory = new File("");

//        修改密码黑盒测试用例读取
        TestList = new ArrayList<>();
        File file = new File("src\\test\\java\\service\\ldy\\CancelOrderwhite.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; TestList.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }


//        Service类
        AdministratorsServiceImpl administratorsService = new AdministratorsServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

//      Bean类
        Developer_administrator developer_administrator = new Developer_administrator();
        Administrators administrators = new Administrators();
        ParkingSpace parkingSpace = new ParkingSpace();


//        注入DAO
        AdministratorsMapper administratorsMapper = EasyMock.createMock(AdministratorsMapper.class);
        ParkingSpaceMapper parkingSpaceMapper = EasyMock.createMock(ParkingSpaceMapper.class);
        OrderMapper orderMapper = EasyMock.createMock(OrderMapper.class);
        UserAdminBillMapper userAdminBillMapper = EasyMock.createMock(UserAdminBillMapper.class);
        UserMapper userMapper = EasyMock.createMock(UserMapper.class);

        administratorsService.setOrderMapper(orderMapper);
        administratorsService.setUserAdminBillMapper(userAdminBillMapper);
        administratorsService.setParkingSpaceMapper(parkingSpaceMapper);
        administratorsService.setAdministratorsMapper(administratorsMapper);
        administratorsService.setUserMapper(userMapper);


//        循环测试
        for (int i = 0; i < TestList.size(); i++) {
            if (i == 0) {
                String info = TestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("现在进行第" + i + "次测试");
                EasyMock.reset(administratorsMapper);
                EasyMock.reset(orderMapper);
                EasyMock.reset(userMapper);
                EasyMock.reset(userAdminBillMapper);
                EasyMock.reset(parkingSpaceMapper);

                // 创建变量及对象
                String line = TestList.get(i);
                String[] data = line.split(",");
                String adminname = data[0];
                String into1 = data[0];
                String into2 = data[1];
                String into3 = data[2];
//                String into4=data[3];
                boolean expect = Boolean.parseBoolean(data[2]);
                Order order = new Order();
                User user = new User();
                user.setUserName("admin");
                user.setMoney(123.3);
                // 记录
                EasyMock.expect(orderMapper.selectOrderById(into1)).andReturn(order).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(parkingSpaceMapper.updateParkSpaceState(1, null)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(userMapper.selectUserByUserId(anyObject())).andReturn(user).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(administratorsMapper.selectAdministratorsByName(into2)).andReturn(administrators).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(userAdminBillMapper.insertUserAdminBill(anyObject())).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(orderMapper.updateOrderState(5, into1)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(userMapper.updateUserMoney(123.3, null)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(administratorsMapper.updateAdministratorsMoney(0.0, into2)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();

                // 使能设置
                EasyMock.replay(userAdminBillMapper);
                EasyMock.replay(orderMapper);
                EasyMock.replay(administratorsMapper);
                EasyMock.replay(parkingSpaceMapper);
                EasyMock.replay(userMapper);
                // 接下来调用Service进行测试
                boolean actual = false;
                actual = administratorsService.cancelOrder(into1, into2);
                Assert.assertEquals(expect, actual);
                // 进行校验
                EasyMock.verify(administratorsMapper);
                System.out.println("第" + i + "次测试通过");
            }
        }
    }

    @Test
    public void FinishOrderBlackTest() throws IOException {

        ArrayList<String> TestList;
        File directory = new File("");

//        修改密码黑盒测试用例读取
        TestList = new ArrayList<>();
        File file = new File("src\\test\\java\\service\\ldy\\FinishOrderblack.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; TestList.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }

//        Service类
        AdministratorsServiceImpl administratorsService = new AdministratorsServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

//      Bean类
        Developer_administrator developer_administrator = new Developer_administrator();
        Administrators administrators = new Administrators();
        ParkingSpace parkingSpace = new ParkingSpace();


//        注入DAO
        AdministratorsMapper administratorsMapper = EasyMock.createMock(AdministratorsMapper.class);
        ParkingSpaceMapper parkingSpaceMapper = EasyMock.createMock(ParkingSpaceMapper.class);
        OrderMapper orderMapper = EasyMock.createMock(OrderMapper.class);
        UserAdminBillMapper userAdminBillMapper = EasyMock.createMock(UserAdminBillMapper.class);
        UserMapper userMapper = EasyMock.createMock(UserMapper.class);
        DevelopersMapper developersMapper = EasyMock.createMock(DevelopersMapper.class);
        AdminDeveloperBillMapper adminDeveloperBillMapper = EasyMock.createMock(AdminDeveloperBillMapper.class);


        administratorsService.setOrderMapper(orderMapper);
        administratorsService.setUserAdminBillMapper(userAdminBillMapper);
        administratorsService.setParkingSpaceMapper(parkingSpaceMapper);
        administratorsService.setAdministratorsMapper(administratorsMapper);
        administratorsService.setUserMapper(userMapper);
        administratorsService.setDevelopersMapper(developersMapper);
        administratorsService.setAdminDeveloperBillMapper(adminDeveloperBillMapper);


//        循环测试
        for (int i = 0; i < TestList.size(); i++) {
            if (i == 0) {
                String info = TestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("现在进行第" + 2 + "次测试");
                EasyMock.reset(administratorsMapper);
                EasyMock.reset(orderMapper);
                EasyMock.reset(parkingSpaceMapper);
                EasyMock.reset(userAdminBillMapper);
                EasyMock.reset(userMapper);
                EasyMock.reset(developersMapper);
                EasyMock.reset(adminDeveloperBillMapper);


                // 创建变量及对象
                String line = TestList.get(i);
                String[] data = line.split(",");
                String adminname = data[0];
                String into1 = data[0];
                String into2 = data[1];
                String into3 = data[2];
//                String into4=data[3];
                boolean expect = Boolean.parseBoolean(data[2]);
                Order order = new Order();
                User user = new User();
                user.setUserName("admin");
                user.setMoney(123.3);
                // 记录
                EasyMock.expect(orderMapper.selectOrderById(into1)).andReturn(order).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(parkingSpaceMapper.updateParkSpaceState(3, null)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(userMapper.selectUserByUserId(anyObject())).andReturn(user).anyTimes();
                EasyMock.expectLastCall();

                EasyMock.expect(administratorsMapper.selectAdministratorsByName(into2)).andReturn(administrators).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(userAdminBillMapper.insertUserAdminBill(anyObject())).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(orderMapper.updateOrderState(4, into1)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(userMapper.updateUserMoney(1.2, null)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(administratorsMapper.updateAdministratorsMoney(0.0, into2)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(developersMapper.selectMoney(null)).andReturn(0.00).anyTimes();
                EasyMock.expectLastCall();

                EasyMock.expect(developersMapper.updateMoney(null, 0.0)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(adminDeveloperBillMapper.insertAdminDeveloperBill(anyObject())).andReturn(true).anyTimes();
                EasyMock.expectLastCall();

                // 使能设置
                EasyMock.replay(userAdminBillMapper);
                EasyMock.replay(orderMapper);
                EasyMock.replay(administratorsMapper);
                EasyMock.replay(parkingSpaceMapper);
                EasyMock.replay(userMapper);
                EasyMock.replay(developersMapper);
                EasyMock.replay(adminDeveloperBillMapper);
                // 接下来调用Service进行测试
                boolean actual = false;
                actual = administratorsService.finishOrder(into1, into2);
                Assert.assertEquals(expect, actual);
                // 进行校验
                EasyMock.verify(administratorsMapper);
                System.out.println("第" + 2 + "次测试通过");
            }
        }
    }

    @Test
    public void FinishOrderWhiteTest() throws IOException {

        ArrayList<String> TestList;
        File directory = new File("");

//        修改密码黑盒测试用例读取
        TestList = new ArrayList<>();
        File file = new File("src\\test\\java\\service\\ldy\\FinishOrderwhite.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; TestList.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }

//        Service类
        AdministratorsServiceImpl administratorsService = new AdministratorsServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

//      Bean类
        Developer_administrator developer_administrator = new Developer_administrator();
        Administrators administrators = new Administrators();
        ParkingSpace parkingSpace = new ParkingSpace();


//        注入DAO
        AdministratorsMapper administratorsMapper = EasyMock.createMock(AdministratorsMapper.class);
        ParkingSpaceMapper parkingSpaceMapper = EasyMock.createMock(ParkingSpaceMapper.class);
        OrderMapper orderMapper = EasyMock.createMock(OrderMapper.class);
        UserAdminBillMapper userAdminBillMapper = EasyMock.createMock(UserAdminBillMapper.class);
        UserMapper userMapper = EasyMock.createMock(UserMapper.class);
        DevelopersMapper developersMapper = EasyMock.createMock(DevelopersMapper.class);
        AdminDeveloperBillMapper adminDeveloperBillMapper = EasyMock.createMock(AdminDeveloperBillMapper.class);


        administratorsService.setOrderMapper(orderMapper);
        administratorsService.setUserAdminBillMapper(userAdminBillMapper);
        administratorsService.setParkingSpaceMapper(parkingSpaceMapper);
        administratorsService.setAdministratorsMapper(administratorsMapper);
        administratorsService.setUserMapper(userMapper);
        administratorsService.setDevelopersMapper(developersMapper);
        administratorsService.setAdminDeveloperBillMapper(adminDeveloperBillMapper);


//        循环测试
        for (int i = 0; i < TestList.size(); i++) {
            if (i == 0) {
                String info = TestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("现在进行第" + 2 + "次测试");
                EasyMock.reset(administratorsMapper);
                // 创建变量及对象
                String line = TestList.get(i);
                String[] data = line.split(",");
                String adminname = data[0];
                String into1 = data[0];
                String into2 = data[1];
                String into3 = data[2];
//                String into4=data[3];
                boolean expect = Boolean.parseBoolean(data[2]);
                Order order = new Order();
                User user = new User();
                user.setUserName("admin");
                user.setMoney(123.3);
                // 记录
                EasyMock.expect(orderMapper.selectOrderById(into1)).andReturn(order).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(parkingSpaceMapper.updateParkSpaceState(3, null)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(userMapper.selectUserByUserId(anyObject())).andReturn(user).anyTimes();
                EasyMock.expectLastCall();

                EasyMock.expect(administratorsMapper.selectAdministratorsByName(into2)).andReturn(administrators).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(userAdminBillMapper.insertUserAdminBill(anyObject())).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(orderMapper.updateOrderState(4, into1)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(userMapper.updateUserMoney(1.2, null)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(administratorsMapper.updateAdministratorsMoney(0.0, into2)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(developersMapper.selectMoney(null)).andReturn(0.00).anyTimes();
                EasyMock.expectLastCall();

                EasyMock.expect(developersMapper.updateMoney(null, 1.0)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                EasyMock.expect(adminDeveloperBillMapper.insertAdminDeveloperBill(anyObject())).andReturn(true).anyTimes();
                EasyMock.expectLastCall();

                // 使能设置
                EasyMock.replay(userAdminBillMapper);
                EasyMock.replay(orderMapper);
                EasyMock.replay(administratorsMapper);
                EasyMock.replay(parkingSpaceMapper);
                EasyMock.replay(userMapper);
                EasyMock.replay(developersMapper);
                EasyMock.replay(adminDeveloperBillMapper);
                // 接下来调用Service进行测试
                boolean actual = false;
                actual = administratorsService.finishOrder(into1, into2);
                Assert.assertEquals(expect, actual);
                // 进行校验
                EasyMock.verify(administratorsMapper);
                System.out.println("第" + 2 + "次测试通过");
            }
        }
    }

    @Test
    public void readfileBlackTest() throws IOException {

        ArrayList<String> TestList;
        File directory = new File("");

//        修改密码黑盒测试用例读取
        TestList = new ArrayList<>();
        File file = new File("src\\test\\java\\service\\ldy\\readfileblack.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; TestList.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }

//        Service类
        AdministratorsServiceImpl administratorsService = new AdministratorsServiceImpl();

//      Bean类
        Developer_administrator developer_administrator = new Developer_administrator();
        Administrators administrators = new Administrators();

//        注入DAO
        ExamineApproveMapper examineApproveMapper = EasyMock.createMock(ExamineApproveMapper.class);
        AdministratorsMapper administratorsMapper = EasyMock.createMock(AdministratorsMapper.class);
        administratorsService.setAdministratorsMapper(administratorsMapper);
        administratorsService.setExamineApproveMapper(examineApproveMapper);


//        循环测试
        for (int i = 0; i < TestList.size(); i++) {
            if (i == 0) {
                String info = TestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("现在进行第" + i + "次测试");
                EasyMock.reset(administratorsMapper);
                // 创建变量及对象
                String line = TestList.get(i);
                String[] data = line.split(",");
                String adminname = data[0];
                String into1 = data[0];
                String into2 = data[1];
                String into3 = data[2];


                boolean expect = Boolean.parseBoolean(data[3]);
                int a = Integer.parseInt(data[0]);
                int b = Integer.parseInt(data[1]);
                int c = Integer.parseInt(data[2]);
                // 记录
                List<ExamineApprove> examineApproveList = new ArrayList<ExamineApprove>();
                ExamineApprove examineApprove = new ExamineApprove();
                examineApproveList.add(examineApprove);
                EasyMock.expect(examineApproveMapper.selectExamineApprove(a, b, c)).andReturn(examineApproveList).anyTimes();
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(administratorsMapper);
                EasyMock.replay(examineApproveMapper);
                // 接下来调用Service进行测试
                boolean actual = false;
                List<ExamineApprove> ad = administratorsService.selectExamineApprove(a, b, c);
                if (ad != null) {
                    actual = true;
                }
                Assert.assertEquals(expect, actual);
                // 进行校验
                EasyMock.verify(administratorsMapper);
                System.out.println("第" + i + "次测试通过");
            }
        }
    }

    @Test
    public void readfileWhiteTest() throws IOException {

        ArrayList<String> TestList;
        File directory = new File("");

//        修改密码黑盒测试用例读取
        TestList = new ArrayList<>();
        File file = new File("src\\test\\java\\service\\ldy\\readfilewhite.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; TestList.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }

//        Service类
        AdministratorsServiceImpl administratorsService = new AdministratorsServiceImpl();

//      Bean类
        Developer_administrator developer_administrator = new Developer_administrator();
        Administrators administrators = new Administrators();

//        注入DAO
        ExamineApproveMapper examineApproveMapper = EasyMock.createMock(ExamineApproveMapper.class);
        AdministratorsMapper administratorsMapper = EasyMock.createMock(AdministratorsMapper.class);
        administratorsService.setAdministratorsMapper(administratorsMapper);
        administratorsService.setExamineApproveMapper(examineApproveMapper);


//        循环测试
        for (int i = 0; i < TestList.size(); i++) {
            if (i == 0) {
                String info = TestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("现在进行第" + i + "次测试");
                EasyMock.reset(administratorsMapper);
                // 创建变量及对象
                String line = TestList.get(i);
                String[] data = line.split(",");
                String adminname = data[0];
                String into1 = data[0];
                String into2 = data[1];
                String into3 = data[2];


                boolean expect = Boolean.parseBoolean(data[3]);
                int a = Integer.parseInt(data[0]);
                int b = Integer.parseInt(data[1]);
                int c = Integer.parseInt(data[2]);
                // 记录
                List<ExamineApprove> examineApproveList = new ArrayList<ExamineApprove>();
                ExamineApprove examineApprove = new ExamineApprove();
                examineApproveList.add(examineApprove);
                EasyMock.expect(examineApproveMapper.selectExamineApprove(a, b, c)).andReturn(examineApproveList).anyTimes();
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(administratorsMapper);
                EasyMock.replay(examineApproveMapper);
                // 接下来调用Service进行测试
                boolean actual = false;
                List<ExamineApprove> ad = administratorsService.selectExamineApprove(a, b, c);
                if (ad != null) {
                    actual = true;
                }
                Assert.assertEquals(expect, actual);
                // 进行校验
                EasyMock.verify(administratorsMapper);
                System.out.println("第" + i + "次测试通过");
            }
        }
    }

    @Test
    public void unreadfileBlackTest() throws IOException {

        ArrayList<String> TestList;
        File directory = new File("");

//        修改密码黑盒测试用例读取
        TestList = new ArrayList<>();
        File file = new File("src\\test\\java\\service\\ldy\\unreadfileblack.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; TestList.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }

//        Service类
        AdministratorsServiceImpl administratorsService = new AdministratorsServiceImpl();

//      Bean类
        Developer_administrator developer_administrator = new Developer_administrator();
        Administrators administrators = new Administrators();


//        注入DAO
        ExamineApproveMapper examineApproveMapper = EasyMock.createMock(ExamineApproveMapper.class);
        AdministratorsMapper administratorsMapper = EasyMock.createMock(AdministratorsMapper.class);
        administratorsService.setAdministratorsMapper(administratorsMapper);
        administratorsService.setExamineApproveMapper(examineApproveMapper);


//        循环测试
        for (int i = 0; i < TestList.size(); i++) {
            if (i == 0) {
                String info = TestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("现在进行第" + i + "次测试");
                EasyMock.reset(administratorsMapper);
                // 创建变量及对象
                String line = TestList.get(i);
                String[] data = line.split(",");
                String adminname = data[0];
                String into1 = data[0];
                String into2 = data[1];
                String into3 = data[2];
                String into4 = data[3];
                String into5 = data[4];
                administrators.setAdministratorsId(into3);


                boolean expect = Boolean.parseBoolean(data[5]);
                int a = Integer.parseInt(data[0]);
                int b = Integer.parseInt(data[1]);
                int c = Integer.parseInt(data[3]);
                int d = Integer.parseInt(data[4]);
                // 记录
                List<ExamineApprove> examineApproveList = new ArrayList<ExamineApprove>();
                ExamineApprove examineApprove = new ExamineApprove();
                examineApproveList.add(examineApprove);
                EasyMock.expect(examineApproveMapper.selectExamineApprove(a, b, c)).andReturn(examineApproveList).anyTimes();

                EasyMock.expect(administratorsMapper.selectAdministratorsByName(into3)).andReturn(administrators).anyTimes();

                EasyMock.expect(examineApproveMapper.selectHisExamineApprove(a, b, into3, c, d)).andReturn(examineApproveList).anyTimes();

                // 使能设置
                EasyMock.replay(administratorsMapper);
                EasyMock.replay(examineApproveMapper);
                // 接下来调用Service进行测试
                boolean actual = false;
                List<ExamineApprove> ad = administratorsService.selectHisExamineApprove(a, b, into3, c, d);
                if (ad != null) {
                    actual = true;
                }
                Assert.assertEquals(expect, actual);
                // 进行校验
                EasyMock.verify(administratorsMapper);
                System.out.println("第" + i + "次测试通过");
            }
        }
    }

    @Test
    public void unreadfileWhiteTest() throws IOException {

        ArrayList<String> TestList;
        File directory = new File("");

//        修改密码黑盒测试用例读取
        TestList = new ArrayList<>();
        File file = new File("src\\test\\java\\service\\ldy\\unreadfilewhite.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            for (String lineTxt = null; (lineTxt = bufferedReader.readLine()) != null; TestList.add(lineTxt)) {
            }
            read.close();
        } else {
            System.out.println("找不到指定的测试数据文件");
        }

//        Service类
        AdministratorsServiceImpl administratorsService = new AdministratorsServiceImpl();

//      Bean类
        Developer_administrator developer_administrator = new Developer_administrator();
        Administrators administrators = new Administrators();


//        注入DAO
        ExamineApproveMapper examineApproveMapper = EasyMock.createMock(ExamineApproveMapper.class);
        AdministratorsMapper administratorsMapper = EasyMock.createMock(AdministratorsMapper.class);
        administratorsService.setAdministratorsMapper(administratorsMapper);
        administratorsService.setExamineApproveMapper(examineApproveMapper);


//        循环测试
        for (int i = 0; i < TestList.size(); i++) {
            if (i == 0) {
                String info = TestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("现在进行第" + i + "次测试");
                EasyMock.reset(administratorsMapper);
                // 创建变量及对象
                String line = TestList.get(i);
                String[] data = line.split(",");
                String adminname = data[0];
                String into1 = data[0];
                String into2 = data[1];
                String into3 = data[2];
                String into4 = data[3];
                String into5 = data[4];
                administrators.setAdministratorsId(into3);


                boolean expect = Boolean.parseBoolean(data[5]);
                int a = Integer.parseInt(data[0]);
                int b = Integer.parseInt(data[1]);
                int c = Integer.parseInt(data[3]);
                int d = Integer.parseInt(data[4]);
                // 记录
                List<ExamineApprove> examineApproveList = new ArrayList<ExamineApprove>();
                ExamineApprove examineApprove = new ExamineApprove();
                examineApproveList.add(examineApprove);
                EasyMock.expect(examineApproveMapper.selectExamineApprove(a, b, c)).andReturn(examineApproveList).anyTimes();

                EasyMock.expect(administratorsMapper.selectAdministratorsByName(into3)).andReturn(administrators).anyTimes();

                EasyMock.expect(examineApproveMapper.selectHisExamineApprove(a, b, into3, c, d)).andReturn(examineApproveList).anyTimes();

                // 使能设置
                EasyMock.replay(administratorsMapper);
                EasyMock.replay(examineApproveMapper);
                // 接下来调用Service进行测试
                boolean actual = false;
                List<ExamineApprove> ad = administratorsService.selectHisExamineApprove(a, b, into3, c, d);
                if (ad != null) {
                    actual = true;
                }
                Assert.assertEquals(expect, actual);
                // 进行校验
                EasyMock.verify(administratorsMapper);
                System.out.println("第" + i + "次测试通过");
            }
        }
    }


    @Test
    public void insertBankcardBlackTest() {
        //        Service类
        BankcardServiceImpl bankcardService = new BankcardServiceImpl();
        //        Bean类
        Bankcard bankcard = new Bankcard();
        //        注入DAO类
        BankcardMapper bankcardMapper = EasyMock.createMock(BankcardMapper.class);
        bankcardService.setBankcardMapper(bankcardMapper);
        //        循环测试
        for (int i = 0; i < insertBankcardBlackTestList.size(); i++) {
            if (i == 0) {
                String info = insertBankcardBlackTestList.get(i);
                System.out.println("现在测试" + info);
            } else {
                System.out.println("第"+i+"次测试");
                EasyMock.reset(bankcardMapper);
                // 创建变量及对象
                String line = insertBankcardBlackTestList.get(i);
                String[] data = line.split(",");

                String cardid = data[0];
                String userid = data[1];
                String bank = data[2];
                boolean expect = Boolean.parseBoolean(data[3]);

                bankcard.setBankcardId(cardid);
                bankcard.setUserId(userid);
                bankcard.setBank(bank);

                System.out.println("输入信息:"+cardid+","+userid+","+bank);

                // 记录                                            //andReturn获取返回结果
                EasyMock.expect(bankcardMapper.insertBankcard(bankcard)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();

                // 使能设置
                EasyMock.replay(bankcardMapper);
                // 接下来调用Service进行测试
                // actual 与上面的 expect对应
                boolean actual = bankcardService.insertBankcard(bankcard);
                //断言，判断返回是否正确
                Assert.assertEquals(expect, actual);
                // 进行校验
                EasyMock.verify(bankcardMapper);

            }
        }
    }

    @Test
    public void insertUserBlackTest() {
        //        Service类
        UserServiceImpl userService = new UserServiceImpl();
        //      Bean类
        User user = new User();
        //        注入DAO
        UserMapper userMapper = EasyMock.createMock(UserMapper.class);
        userService.setUserMapper(userMapper);

//        循环测试
        for (int i = 0; i < insertUserBlackTestList.size(); i++) {
            if (i == 0) {
                String info = insertUserBlackTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                System.out.println("第"+i+"次测试");
                EasyMock.reset(userMapper);
                // 创建变量及对象
                String line = insertUserBlackTestList.get(i);
                String[] data = line.split(",");

                String identity = data[0];
                String name = data[1];
                String sex = data[2];
                String phone = data[3];
                String invitee = data[4];
                System.out.println("输入信息:"+identity+","+name+","+sex+","+phone+","+invitee);
                boolean expect = Boolean.parseBoolean(data[5]);
                user.setUserIdentity(identity);
                user.setUserName(name);
                user.setUserSex(sex);
                user.setUserPhone(phone);
                user.setUserInvitee(invitee);
                // 记录                                            //andReturn获取返回结果
                EasyMock.expect(userMapper.insertUser(user)).andReturn(true).anyTimes();
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(userMapper);
                // 接下来调用Service进行测试
                // actual 与上面的 expect对应
                boolean actual = userService.insertUser(user);
                //断言，判断返回是否正确
                Assert.assertEquals(expect, actual);
                // 进行校验
                EasyMock.verify(userMapper);
            }

        }
    }

    @Test
    public void WuSelectBankcardBlackTest() {
        //        Service类
        BankcardServiceImpl bankcardService = new BankcardServiceImpl();
        //        Bean类
        List<Bankcard> bankcards=new ArrayList<>();
        //        注入DAO类
        BankcardMapper bankcardMapper=EasyMock.createMock(BankcardMapper.class);
        bankcardService.setBankcardMapper(bankcardMapper);
//        循环测试
        for(int i=0;i<WuSelectBankcardBlackTestList.size();i++){
            if(i==0){
                String info=WuSelectBankcardBlackTestList.get(i);
                System.out.println("现在测试"+info);
            }
            else {
                System.out.println("第"+i+"次测试");
                EasyMock.reset(bankcardMapper);
                // 创建变量及对象
                String line=WuSelectBankcardBlackTestList.get(i);
                String[] data=line.split(",");

                String userid=data[0];
                System.out.println("输入信息"+userid);
                int expect =Integer.parseInt(data[1]);

                //记录
                EasyMock.expect(bankcardMapper.selectBankcard(userid)).andReturn(bankcards).anyTimes();
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(bankcardMapper);
                // 接下来调用Service进行测试
                // actual 与上面的 expect对应
                List<Bankcard> bankcards1 = bankcardService.selectBankcard(userid);
                int actual = bankcards1.size();
                //断言，判断返回是否正确
                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(bankcardMapper);
            }
        }
    }

    @Test
    public void WuSelectCouponBlackTest() {
//        Service类
        CouponServiceImpl couponService = new CouponServiceImpl();

//      Bean类
        List<Coupon> coupons=new ArrayList<Coupon>();

//        注入DAO
        CouponMapper couponMapper=EasyMock.createMock(CouponMapper.class);
        couponService.setCouponMapper(couponMapper);

        //        循环测试
        for(int i = 0;i<WuSelectCouponBlackTestList.size();i++){
            if(i == 0){
                String info = WuSelectCouponBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(couponMapper);
                // 创建变量及对象
                String line=WuSelectCouponBlackTestList.get(i);
                String[] data=line.split(",");

                String userid=data[0];
                System.out.println("输入信息:"+userid);
                int expect =Integer.parseInt(data[1]);

                //记录
                EasyMock.expect(couponMapper.selectCoupon(userid)).andReturn(coupons).anyTimes();
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(couponMapper);
                // 接下来调用Service进行测试
                // actual 与上面的 expect对应
                List<Coupon> coupons1 = couponService.selectCoupon(userid);
                int actual = coupons1.size();
                //断言，判断返回是否正确
                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(couponMapper);
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

    public ArrayList setData(String path) throws IOException{
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

    @Test
    public void selectAllSpaceBlackTest() throws Exception {
        // Service类
        UserServiceImpl userService = new UserServiceImpl();

        // Bean类
        ParkingSpace parkSpace = new ParkingSpace();
        List<ParkingSpace> parklist = new ArrayList<>();

        // 注入DAO
        ParkingSpaceMapper parkingSpaceMapper = EasyMock.createMock(ParkingSpaceMapper.class);
        userService.setParkingSpaceMapper(parkingSpaceMapper);

        // 循环测试
        for (int i = 0; i < selectAllSpaceBlackTestList.size(); i++) {
            if (i == 0) {
                String info = selectAllSpaceBlackTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(parkingSpaceMapper);
                // 创建变量及对象
                String line = selectAllSpaceBlackTestList.get(i);
                String[] data = line.split(";");
                String expect1 = data[0];
                String expect2 = data[1];
                parkSpace.setId(expect1);
                parkSpace.setResidentialQuartersId(expect2);
                parklist.add(parkSpace);

                // 记录
                EasyMock.expect(parkingSpaceMapper.selectAllSpace()).andReturn(parklist);;
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(parkingSpaceMapper);
                // 接下来调用Service进行测试
                String actual1,actual2;
                List<ParkingSpace> actual = userService.selectAllSpace();
                if(actual.size()==0){
                    actual1 = null;
                    actual2 = null;
                }else {
                    actual1 = actual.get(0).getId();
                    actual2 = actual.get(0).getResidentialQuartersId();
                }
                Assert.assertEquals(expect1, String.valueOf(actual1));
                Assert.assertEquals(expect2,String.valueOf(actual2));
                // 进行校验
                EasyMock.verify(parkingSpaceMapper);
            }
        }

    }

    /**
     * @Description: 选择所有车位白盒
     * @Param: []
     * @return: void
     * @Author: hym(huangyimiao666@gmail.com)
     * @Date: 10:29 2022/6/4
     */
    @Test
    public void selectAllSpaceWhiteTest() throws Exception {
        // Service类
        UserServiceImpl userService = new UserServiceImpl();

        // Bean类
        ParkingSpace parkSpace = new ParkingSpace();
        List<ParkingSpace> parklist = new ArrayList<>();

        // 注入DAO
        ParkingSpaceMapper parkingSpaceMapper = EasyMock.createMock(ParkingSpaceMapper.class);
        userService.setParkingSpaceMapper(parkingSpaceMapper);

        // 循环测试
        for (int i = 0; i < selectAllSpaceWhiteTestList.size(); i++) {
            if (i == 0) {
                String info = selectAllSpaceWhiteTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(parkingSpaceMapper);
                // 创建变量及对象
                String line = selectAllSpaceWhiteTestList.get(i);
                String[] data = line.split(";");
                String expect1 = data[0];
                String expect2 = data[1];
                parkSpace.setId(expect1);
                parkSpace.setResidentialQuartersId(expect2);
                parklist.add(parkSpace);

                // 记录
                EasyMock.expect(parkingSpaceMapper.selectAllSpace()).andReturn(parklist);;
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(parkingSpaceMapper);
                // 接下来调用Service进行测试
                String actual1,actual2;
                List<ParkingSpace> actual = userService.selectAllSpace();
                if(actual.size()==0){
                    actual1 = null;
                    actual2 = null;
                }else {
                    actual1 = actual.get(0).getId();
                    actual2 = actual.get(0).getResidentialQuartersId();
                }
                Assert.assertEquals(expect1, String.valueOf(actual1));
                Assert.assertEquals(expect2,String.valueOf(actual2));
                // 进行校验
                EasyMock.verify(parkingSpaceMapper);
            }
        }

    }

    /**
     * @Description: 选择所有车位分页黑盒
     * @Param: []
     * @return: void
     * @Author: hym(huangyimiao666@gmail.com)
     * @Date: 10:30 2022/6/4
     */
    @Test
    public void selectAllParkSpaceBlackTest() throws Exception {
        // Service类
        UserServiceImpl userService = new UserServiceImpl();

        // Bean类
        ParkingSpace parkSpace = new ParkingSpace();
        List<ParkingSpace> parklist = new ArrayList<>();

        // 注入DAO
        ParkingSpaceMapper parkingSpaceMapper = EasyMock.createMock(ParkingSpaceMapper.class);
        userService.setParkingSpaceMapper(parkingSpaceMapper);

        // 循环测试
        for (int i = 0; i < selectAllParkSpaceBlackTestList.size(); i++) {
            if (i == 0) {
                String info = selectAllParkSpaceBlackTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(parkingSpaceMapper);
                // 创建变量及对象
                String line = selectAllParkSpaceBlackTestList.get(i);
                String[] data = line.split(";");
                String userPage = data[0];
                String PageSize = data[1];
                String expect1 = data[2];
                String expect2 = data[3];
                parkSpace.setId(expect1);
                parkSpace.setResidentialQuartersId(expect2);
                parklist.add(parkSpace);

                // 记录
                EasyMock.expect(parkingSpaceMapper.selectAllParkSpace(Integer.parseInt(userPage),Integer.parseInt(PageSize))).andReturn(parklist);;
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(parkingSpaceMapper);
                // 接下来调用Service进行测试
                String actual1,actual2;
                List<ParkingSpace> actual = userService.selectAllParkSpace(Integer.parseInt(userPage),Integer.parseInt(PageSize));
                if(actual.size()==0){
                    actual1 = null;
                    actual2 = null;
                }else {
                    actual1 = actual.get(0).getId();
                    actual2 = actual.get(0).getResidentialQuartersId();
                }
                Assert.assertEquals(expect1, String.valueOf(actual1));
                Assert.assertEquals(expect2,String.valueOf(actual2));
                // 进行校验
                EasyMock.verify(parkingSpaceMapper);
            }
        }
    }

    /**
     * @Description: 选择所有车位分页白盒
     * @Param: []
     * @return: void
     * @Author: hym(huangyimiao666@gmail.com)
     * @Date: 10:31 2022/6/4
     */
    @Test
    public void selectAllParkSpaceWhiteTestTest() throws Exception {
        // Service类
        UserServiceImpl userService = new UserServiceImpl();

        // Bean类
        ParkingSpace parkSpace = new ParkingSpace();
        List<ParkingSpace> parklist = new ArrayList<>();

        // 注入DAO
        ParkingSpaceMapper parkingSpaceMapper = EasyMock.createMock(ParkingSpaceMapper.class);
        userService.setParkingSpaceMapper(parkingSpaceMapper);

        // 循环测试
        for (int i = 0; i < selectAllParkSpaceWhiteTestList.size(); i++) {
            if (i == 0) {
                String info = selectAllParkSpaceWhiteTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(parkingSpaceMapper);
                // 创建变量及对象
                String line = selectAllParkSpaceWhiteTestList.get(i);
                String[] data = line.split(";");
                String userPage = data[0];
                String PageSize = data[1];
                String expect1 = data[2];
                String expect2 = data[3];
                parkSpace.setId(expect1);
                parkSpace.setResidentialQuartersId(expect2);
                parklist.add(parkSpace);

                // 记录
                EasyMock.expect(parkingSpaceMapper.selectAllParkSpace(Integer.parseInt(userPage),Integer.parseInt(PageSize))).andReturn(parklist);;
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(parkingSpaceMapper);
                // 接下来调用Service进行测试
                String actual1,actual2;
                List<ParkingSpace> actual = userService.selectAllParkSpace(Integer.parseInt(userPage),Integer.parseInt(PageSize));
                if(actual.size()==0){
                    actual1 = null;
                    actual2 = null;
                }else {
                    actual1 = actual.get(0).getId();
                    actual2 = actual.get(0).getResidentialQuartersId();
                }
                Assert.assertEquals(expect1, String.valueOf(actual1));
                Assert.assertEquals(expect2,String.valueOf(actual2));
                // 进行校验
                EasyMock.verify(parkingSpaceMapper);
            }
        }

    }

    /**
     * @Description: 选择特定id车位黑盒
     * @Param: []
     * @return: void
     * @Author: hym(huangyimiao666@gmail.com)
     * @Date: 10:31 2022/6/4
     */
    @Test
    public void selectParkingSpaceByIdBlackTest() throws Exception {
        // Service类
        ParkingSpaceServiceImpl parkingSpaceService = new ParkingSpaceServiceImpl();

        // Bean类
        ParkingSpace parkSpace = new ParkingSpace();

        // 注入DAO
        ParkingSpaceMapper parkingSpaceMapper = EasyMock.createMock(ParkingSpaceMapper.class);
        parkingSpaceService.setParkingSpaceMapper(parkingSpaceMapper);

        // 循环测试
        for (int i = 0; i < selectParkingSpaceByIdBlackTestList.size(); i++) {
            if (i == 0) {
                String info = selectParkingSpaceByIdBlackTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(parkingSpaceMapper);
                // 创建变量及对象
                String line = selectParkingSpaceByIdBlackTestList.get(i);
                String[] data = line.split(";");
                String parkId = data[0];
                String expect1 = data[1];
                parkSpace.setId(expect1);

                // 记录
                EasyMock.expect(parkingSpaceMapper.selectParkingSpaceById(parkId)).andReturn(parkSpace);;
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(parkingSpaceMapper);
                // 接下来调用Service进行测试
                ParkingSpace actual = parkingSpaceService.selectParkingSpaceById(parkId);
                String actual1 = actual.getId();
                if(actual1.equals("")){
                    actual1 = null;
                }
                Assert.assertEquals(expect1, String.valueOf(actual1));
                // 进行校验
                EasyMock.verify(parkingSpaceMapper);
            }
        }

    }

    /**
     * @Description: 选择特定id车位白盒
     * @Param: []
     * @return: void
     * @Author: hym(huangyimiao666@gmail.com)
     * @Date: 10:31 2022/6/4
     */
    @Test
    public void selectParkingSpaceByIdWhiteTest() throws Exception {
        // Service类
        ParkingSpaceServiceImpl parkingSpaceService = new ParkingSpaceServiceImpl();

        // Bean类
        ParkingSpace parkSpace = new ParkingSpace();

        // 注入DAO
        ParkingSpaceMapper parkingSpaceMapper = EasyMock.createMock(ParkingSpaceMapper.class);
        parkingSpaceService.setParkingSpaceMapper(parkingSpaceMapper);

        // 循环测试
        for (int i = 0; i < selectParkingSpaceByIdWhiteTestList.size(); i++) {
            if (i == 0) {
                String info = selectParkingSpaceByIdWhiteTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(parkingSpaceMapper);
                // 创建变量及对象
                String line = selectParkingSpaceByIdWhiteTestList.get(i);
                String[] data = line.split(";");
                String parkId = data[0];
                String expect1 = data[1];
                parkSpace.setId(expect1);

                // 记录
                EasyMock.expect(parkingSpaceMapper.selectParkingSpaceById(parkId)).andReturn(parkSpace);;
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(parkingSpaceMapper);
                // 接下来调用Service进行测试
                ParkingSpace actual = parkingSpaceService.selectParkingSpaceById(parkId);
                String actual1 = actual.getId();
                if(actual1.equals("")){
                    actual1 = null;
                }
                Assert.assertEquals(expect1, String.valueOf(actual1));
                // 进行校验
                EasyMock.verify(parkingSpaceMapper);
            }
        }

    }

    /**
     * @Description: 选择特定id开发商黑盒
     * @Param: []
     * @return: void
     * @Author: hym(huangyimiao666@gmail.com)
     * @Date: 10:32 2022/6/4
     */
    @Test
    public void selectResidentialQuartersByIdBlackTest() throws Exception {
        // Service类
        UserServiceImpl userService = new UserServiceImpl();

        // Bean类
        ResidentialQuarters residentialQuarters = new ResidentialQuarters();

        // 注入DAO
        ResidentialQuartersMapper residentialQuartersMapper = EasyMock.createMock(ResidentialQuartersMapper.class);
        userService.setResidentialQuartersMapper(residentialQuartersMapper);

        // 循环测试
        for (int i = 0; i < selectResidentialQuartersByIdBlackTestList.size(); i++) {
            if (i == 0) {
                String info = selectResidentialQuartersByIdBlackTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(residentialQuartersMapper);
                // 创建变量及对象
                String line = selectResidentialQuartersByIdBlackTestList.get(i);
                String[] data = line.split(";");
                String parkId = data[0];
                String expect1 = data[1];
                residentialQuarters.setId(expect1);

                // 记录
                EasyMock.expect(residentialQuartersMapper.selectResidentialQuartersById(parkId)).andReturn(residentialQuarters);;
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(residentialQuartersMapper);
                // 接下来调用Service进行测试
                ResidentialQuarters actual = userService.selectResidentialQuartersById(parkId);
                String actual1 = actual.getId();
                if(actual1.equals("")){
                    actual1 = null;
                }
                Assert.assertEquals(expect1, String.valueOf(actual1));
                // 进行校验
                EasyMock.verify(residentialQuartersMapper);
            }
        }

    }

    /**
     * @Description: 选择特定id开发商白盒
     * @Param: []
     * @return: void
     * @Author: hym(huangyimiao666@gmail.com)
     * @Date: 10:32 2022/6/4
     */
    @Test
    public void selectResidentialQuartersByIdWhiteTest() throws Exception {
        // Service类
        UserServiceImpl userService = new UserServiceImpl();

        // Bean类
        ResidentialQuarters residentialQuarters = new ResidentialQuarters();

        // 注入DAO
        ResidentialQuartersMapper residentialQuartersMapper = EasyMock.createMock(ResidentialQuartersMapper.class);
        userService.setResidentialQuartersMapper(residentialQuartersMapper);

        // 循环测试
        for (int i = 0; i < selectResidentialQuartersByIdWhiteTestList.size(); i++) {
            if (i == 0) {
                String info = selectResidentialQuartersByIdWhiteTestList.get(i);
                System.out.println("现在测试:" + info);
            } else {
                EasyMock.reset(residentialQuartersMapper);
                // 创建变量及对象
                String line = selectResidentialQuartersByIdWhiteTestList.get(i);
                String[] data = line.split(";");
                String parkId = data[0];
                String expect1 = data[1];
                residentialQuarters.setId(expect1);

                // 记录
                EasyMock.expect(residentialQuartersMapper.selectResidentialQuartersById(parkId)).andReturn(residentialQuarters);;
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(residentialQuartersMapper);
                // 接下来调用Service进行测试
                ResidentialQuarters actual = userService.selectResidentialQuartersById(parkId);
                String actual1 = actual.getId();
                if(actual1.equals("")){
                    actual1 = null;
                }
                Assert.assertEquals(expect1, String.valueOf(actual1));
                // 进行校验
                EasyMock.verify(residentialQuartersMapper);
            }
        }

    }

    /**
     * @Description: 更新用户状态黑盒
     * @Param: []
     * @return: void
     * @Author: hym(huangyimiao666@gmail.com)
     * @Date: 10:32 2022/6/4
     */
    @Test
    public void updateOrderStateBlackTest() throws Exception {
        // Service类
        UserServiceImpl userService = new UserServiceImpl();

        // Bean类
        Order order = new Order();

        // 注入DAO
        OrderMapper orderMapper = EasyMock.createMock(OrderMapper.class);
        userService.setOrderMapper(orderMapper);

        // 循环测试
        for(int i = 0;i<updateOrderStateBlackTestList.size();i++){
            if(i == 0){
                String info = updateOrderStateBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                EasyMock.reset(orderMapper);
                // 创建变量及对象
                String line = updateOrderStateBlackTestList.get(i);
                String[] data = line.split(";");
                String stateChange = data[0];
                String orderId = data[1];
                String parkId = data[2];
                String csID = data[3];
                String ciID = data[4];
                String state = data[5];

                order.setOrderId(orderId);
                order.setParkingSpaceId(parkId);
                order.setContractInitiator(ciID);
                order.setContractSignatory(csID);
                order.setState(Integer.parseInt(state));
                boolean mock = Boolean.parseBoolean(data[6]);
                boolean expect = Boolean.parseBoolean(data[7]);
                // 记录
                EasyMock.expect(orderMapper.updateOrderState(Integer.parseInt(stateChange),orderId)).andReturn(mock);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(orderMapper);
                // 接下来调用Service进行测试
                boolean actual = userService.updateOrderState(Integer.parseInt(stateChange),orderId);
                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(orderMapper);
            }
        }
    }

    /**
     * @Description: 更新用户状态白盒
     * @Param: []
     * @return: void
     * @Author: hym(huangyimiao666@gmail.com)
     * @Date: 10:32 2022/6/4
     */
    @Test
    public void updateOrderStateWhiteTest() throws Exception {
        // Service类
        UserServiceImpl userService = new UserServiceImpl();

        // Bean类
        Order order = new Order();

        // 注入DAO
        OrderMapper orderMapper = EasyMock.createMock(OrderMapper.class);
        userService.setOrderMapper(orderMapper);

        // 循环测试
        for(int i = 0;i<updateOrderStateWhiteTestList.size();i++){
            if(i == 0){
                String info = updateOrderStateWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                EasyMock.reset(orderMapper);
                // 创建变量及对象
                String line = updateOrderStateWhiteTestList.get(i);
                String[] data = line.split(";");
                String stateChange = data[0];
                String orderId = data[1];
                String parkId = data[2];
                String csID = data[3];
                String ciID = data[4];
                String state = data[5];

                order.setOrderId(orderId);
                order.setParkingSpaceId(parkId);
                order.setContractInitiator(ciID);
                order.setContractSignatory(csID);
                order.setState(Integer.parseInt(state));
                boolean mock = Boolean.parseBoolean(data[6]);
                boolean expect = Boolean.parseBoolean(data[7]);
                // 记录
                EasyMock.expect(orderMapper.updateOrderState(Integer.parseInt(stateChange),orderId)).andReturn(mock);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(orderMapper);
                // 接下来调用Service进行测试
                boolean actual = userService.updateOrderState(Integer.parseInt(stateChange),orderId);
                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(orderMapper);
            }
        }
    }

//    颜炅的测试用例
//登录白盒测试
@Test
public void saleLoginWhiteTest() {
    //        Service类
    DeveloperServiceImpl developerService = new DeveloperServiceImpl();

    //      Bean类
    Developer_administrator developer_administrator = new Developer_administrator();

    //        注入DAO
    DeveloperMapper developerMapper = EasyMock.createMock(DeveloperMapper.class);
    DevelopersMapper developersMapper=EasyMock.createMock(DevelopersMapper.class);
    developerService.setDeveloperMapper(developerMapper);
    developerService.setDevelopersMapper(developersMapper);


    //        循环测试
    for(int i = 0;i<loginWhiteTestList.size();i++){
        if(i == 0){
            String info = loginWhiteTestList.get(i);
            System.out.println("现在测试:"+info);
        }
        else{
            System.out.println("第"+i+"次测试");
            EasyMock.reset(developerMapper);
            EasyMock.reset(developersMapper);
            // 创建变量及对象
            String line = loginWhiteTestList.get(i);
            String[] data = line.split(",");
            String username = data[0];
            String password = data[1];
            String state=data[2];
            Developer_administrator expect=null;
            if(data[3].equals("1"))
                expect = developer_administrator;
            // 记录
            if(i==2) EasyMock.expect(developerMapper.login(username,password)).andReturn(null);
            else EasyMock.expect(developerMapper.login(username,password)).andReturn(developer_administrator);
            EasyMock.expectLastCall();
            EasyMock.expect(developersMapper.selectState(developer_administrator.getDeveloperId())).andReturn(state);
            EasyMock.expectLastCall();
            // 使能设置
            EasyMock.replay(developerMapper);
            EasyMock.replay(developersMapper);
            // 接下来调用Service进行测试
            Developer_administrator actual = developerService.login(username,password);
            Assert.assertEquals(expect,actual);
            // 进行校验
            EasyMock.verify(developerMapper);

        }
    }
}
    //登录黑盒测试
    @Test
    public void saleLoginBlackTest() {
        //        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

        //      Bean类
        Developer_administrator developer_administrator = new Developer_administrator();

        //        注入DAO
        DeveloperMapper developerMapper = EasyMock.createMock(DeveloperMapper.class);
        DevelopersMapper developersMapper=EasyMock.createMock(DevelopersMapper.class);
        developerService.setDeveloperMapper(developerMapper);
        developerService.setDevelopersMapper(developersMapper);


        //        循环测试
        for(int i = 0;i<loginBlackTestList.size();i++){
            if(i == 0){
                String info = loginBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(developerMapper);
                EasyMock.reset(developersMapper);
                // 创建变量及对象
                String line = loginBlackTestList.get(i);
                String[] data = line.split(",");
                String username = data[0];
                String password = data[1];
                String state=data[2];
                Developer_administrator expect=null;
                if(data[3].equals("1"))
                    expect = developer_administrator;
                // 记录
                EasyMock.expect(developerMapper.login(username,password)).andReturn(developer_administrator);
                EasyMock.expectLastCall();
                EasyMock.expect(developersMapper.selectState(developer_administrator.getDeveloperId())).andReturn(state);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(developerMapper);
                EasyMock.replay(developersMapper);
                // 接下来调用Service进行测试
                Developer_administrator actual = developerService.login(username,password);
                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(developerMapper);

            }
        }
    }

    //添加车位白盒测试
    @Test
    public void addparkWhiteTest() {
        //        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

        //        注入DAO
        ParkingSpaceMapper parkingSpaceMapper=EasyMock.createMock(ParkingSpaceMapper.class);
        developerService.setParkingSpaceMapper(parkingSpaceMapper);


        //        循环测试
        for(int i = 0;i<addparkWhiteTestList.size();i++){
            if(i == 0){
                String info = addparkWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(parkingSpaceMapper);
                // 创建变量及对象
                String line = addparkWhiteTestList.get(i);
                String[] data = line.split("/");
                String residentialQuartersId = data[0];
                String address = data[1];
                String price=data[2];
                String pid=data[3];
                Boolean expect = Boolean.valueOf(data[4]);
                // 记录
                EasyMock.expect(parkingSpaceMapper.insertParkSpace(anyObject())).andReturn(true);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(parkingSpaceMapper);
                // 接下来调用Service进行测试
                boolean actual = developerService.insertParkSpace(residentialQuartersId,address,price,pid);
                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(parkingSpaceMapper);

            }
        }
    }
    //添加车位黑盒测试
    @Test
    public void addparkBlackTest() {
        //        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

        //        注入DAO
        ParkingSpaceMapper parkingSpaceMapper=EasyMock.createMock(ParkingSpaceMapper.class);
        developerService.setParkingSpaceMapper(parkingSpaceMapper);


        //        循环测试
        for(int i = 0;i<addparkBlackTestList.size();i++){
            if(i == 0){
                String info = addparkBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(parkingSpaceMapper);
                // 创建变量及对象
                String line = addparkBlackTestList.get(i);
                String[] data = line.split("/");
                String residentialQuartersId = data[0];
                String address = data[1];
                String price=data[2];
                String pid=data[3];
                Boolean expect = Boolean.valueOf(data[4]);
                // 记录
                EasyMock.expect(parkingSpaceMapper.insertParkSpace(anyObject())).andReturn(true);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(parkingSpaceMapper);
                // 接下来调用Service进行测试
                boolean actual = developerService.insertParkSpace(residentialQuartersId,address,price,pid);
                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(parkingSpaceMapper);

            }
        }
    }

    //商家入驻白盒测试
    @Test
    public void addexamineWhiteTest() {
        //        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

        //      Bean类
        ExamineApprove examineApprove=new ExamineApprove();
        //        注入DAO
        ExamineApproveMapper examineApproveMapper=EasyMock.createMock(ExamineApproveMapper.class);
        developerService.setExamineApproveMapper(examineApproveMapper);


        //        循环测试
        for(int i = 0;i<addexamineWhiteTestList.size();i++){
            if(i == 0){
                String info = addexamineWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(examineApproveMapper);
                // 创建变量及对象
                String line = addexamineWhiteTestList.get(i);
                String[] data = line.split("/");
                String id = data[0];
                String developer_id = data[1];
                String developer_name=data[2];
                Boolean expect = Boolean.valueOf(data[3]);
                // 记录
                EasyMock.expect(examineApproveMapper.insertExamineApprove(anyObject())).andReturn(true);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(examineApproveMapper);
                // 接下来调用Service进行测试
                boolean actual = developerService.insertExamineApprove(id,developer_id,developer_name);
                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(examineApproveMapper);

            }
        }
    }
    //商家入驻黑盒测试
    @Test
    public void addexamineBlackTest() {
        //        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

        //      Bean类
        ExamineApprove examineApprove=new ExamineApprove();
        //        注入DAO
        ExamineApproveMapper examineApproveMapper=EasyMock.createMock(ExamineApproveMapper.class);
        developerService.setExamineApproveMapper(examineApproveMapper);


        //        循环测试
        for(int i = 0;i<addexamineBlackTestList.size();i++){
            if(i == 0){
                String info = addexamineBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(examineApproveMapper);
                // 创建变量及对象
                String line = addexamineBlackTestList.get(i);
                String[] data = line.split("/");
                String id = data[0];
                String developer_id = data[1];
                String developer_name=data[2];
                Boolean expect = Boolean.valueOf(data[3]);
                // 记录
                EasyMock.expect(examineApproveMapper.insertExamineApprove(anyObject())).andReturn(true);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(examineApproveMapper);
                // 接下来调用Service进行测试
                boolean actual = developerService.insertExamineApprove(id,developer_id,developer_name);
                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(examineApproveMapper);

            }
        }
    }

    //添加活动白盒测试
    @Test
    public void addactivityWhiteTest() {
        //        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

        //      Bean类
        Activity activity=new Activity();

        //        注入DAO
        ActivityMapper activityMapper = EasyMock.createMock(ActivityMapper.class);
        developerService.setActivityMapper(activityMapper);


        //        循环测试
        for(int i = 0;i<addactivityWhiteTestList.size();i++){
            if(i == 0){
                String info = addactivityWhiteTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(activityMapper);
                // 创建变量及对象
                String line = addactivityWhiteTestList.get(i);
                String[] data = line.split("/");
                String activity_name=data[0];
                Integer activity_content=null;
                if (!data[1].equals(""))
                    activity_content=Integer.parseInt(data[1]);
                String activity_category=data[2];
                Double activity_discount=Double.parseDouble(data[3]);
                String did=data[4];
                String activity_residential_quarters_id=data[5];
                Boolean expect=Boolean.valueOf(data[6]);
                // 记录
                EasyMock.expect(activityMapper.addActivity(anyObject())).andReturn(true);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(activityMapper);
                // 接下来调用Service进行测试
                Boolean actual =developerService.addActivity(activity_name,activity_content,activity_category,activity_discount,did,activity_residential_quarters_id);

                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(activityMapper);

            }
        }
    }
    //添加活动黑盒测试
    @Test
    public void addactivityBlackTest() {
        //        Service类
        DeveloperServiceImpl developerService = new DeveloperServiceImpl();

        //      Bean类
        Activity activity=new Activity();

        //        注入DAO
        ActivityMapper activityMapper = EasyMock.createMock(ActivityMapper.class);
        developerService.setActivityMapper(activityMapper);


        //        循环测试
        for(int i = 0;i<addactivityBlackTestList.size();i++){
            if(i == 0){
                String info = addactivityBlackTestList.get(i);
                System.out.println("现在测试:"+info);
            }
            else{
                System.out.println("第"+i+"次测试");
                EasyMock.reset(activityMapper);
                // 创建变量及对象
                String line = addactivityBlackTestList.get(i);
                String[] data = line.split("/");
                String activity_name=data[0];
                Integer activity_content=null;
                if (!data[1].equals(""))
                    activity_content=Integer.parseInt(data[1]);
                String activity_category=data[2];
                Double activity_discount=Double.parseDouble(data[3]);
                String did=data[4];
                String activity_residential_quarters_id=data[5];
                Boolean expect=Boolean.valueOf(data[6]);
                // 记录
                EasyMock.expect(activityMapper.addActivity(anyObject())).andReturn(true);
                EasyMock.expectLastCall();
                // 使能设置
                EasyMock.replay(activityMapper);
                // 接下来调用Service进行测试
                Boolean actual =developerService.addActivity(activity_name,activity_content,activity_category,activity_discount,did,activity_residential_quarters_id);

                Assert.assertEquals(expect,actual);
                // 进行校验
                EasyMock.verify(activityMapper);

            }
        }
    }
}
