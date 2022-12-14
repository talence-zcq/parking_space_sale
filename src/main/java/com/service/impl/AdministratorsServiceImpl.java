package com.service.impl;

import com.bean.*;
import com.dao.*;
import com.event.DeveloperRegisterAfterEvent;
import com.service.AdministratorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdministratorsServiceImpl implements AdministratorsService {
    @Autowired
    private AdministratorsMapper administratorsMapper;
    @Autowired
    private DevelopersMapper developersMapper;
    @Autowired
    private ExamineApproveMapper examineApproveMapper;
    @Autowired
    private DeveloperMapper developerMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminDeveloperBillMapper adminDeveloperBillMapper;
    @Autowired
    private ParkingSpaceMapper parkingSpaceMapper;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private UserAdminBillMapper userAdminBillMapper;

    public void setAdministratorsMapper(AdministratorsMapper administratorsMapper) {
        this.administratorsMapper = administratorsMapper;
    }

    public void setDevelopersMapper(DevelopersMapper developersMapper) {
        this.developersMapper = developersMapper;
    }

    public void setExamineApproveMapper(ExamineApproveMapper examineApproveMapper) {
        this.examineApproveMapper = examineApproveMapper;
    }

    public void setDeveloperMapper(DeveloperMapper developerMapper) {
        this.developerMapper = developerMapper;
    }

    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void setAdminDeveloperBillMapper(AdminDeveloperBillMapper adminDeveloperBillMapper) {
        this.adminDeveloperBillMapper = adminDeveloperBillMapper;
    }

    public void setParkingSpaceMapper(ParkingSpaceMapper parkingSpaceMapper) {
        this.parkingSpaceMapper = parkingSpaceMapper;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void setUserAdminBillMapper(UserAdminBillMapper userAdminBillMapper) {
        this.userAdminBillMapper = userAdminBillMapper;
    }

    @Override
    public Administrators selectAdministratorsByName(String administratorsName) {
        return administratorsMapper.selectAdministratorsByName(administratorsName);
    }

    @Override
    public boolean updateAdministratorsMoney(double money, String administratorsName) {
        Administrators administrators;
        administrators=administratorsMapper.selectAdministratorsByName(administratorsName);
        double moneys=administrators.getMoney()+money;
        return administratorsMapper.updateAdministratorsMoney(moneys,administratorsName);
    }

    @Override
    public boolean registerAdministrators(String administratorsName, String administratorsPassword) {
        Administrators administrators=new Administrators();
        administrators.setAdministratorsName(administratorsName);
        administrators.setAdministratorsPassword(administratorsPassword);
        long  timeNew =  System.currentTimeMillis()/ 10000000; // 6??????????????????
        String OR="AD"+timeNew;
        administrators.setAdministratorsId(OR);
        administrators.setMoney(0);
        return administratorsMapper.insertAdministrators(administrators);

    }

    @Override
    public boolean addDevelopers(String developerId, String developerName) {
        Developers developers =new Developers();
        developers.setState("??????");
        developers.setDeveloperId(developerId);
        developers.setDeveloperName(developerName);
        developers.setMoney(0);
        return developersMapper.insertDevelopers(developers);
    }

    @Override
    public boolean addDeveloper_administrator(String developerId) {
        Developer_administrator developer_administrator=new Developer_administrator();
        developer_administrator.setRole("?????????");
        developer_administrator.setPassword("123");
        developer_administrator.setDeveloperId(developerId);
        //??????ID???,??????????????????id??????
        developer_administrator.setId(developerId);
        return developerMapper.insertDeveloper_administrator(developer_administrator);
    }

    @Override
    public boolean updateAdministratorsMoneyMinus(double money, String administratorsName) {
        Administrators administrators;
        administrators=administratorsMapper.selectAdministratorsByName(administratorsName);
        double moneys=administrators.getMoney()-money;
        return administratorsMapper.updateAdministratorsMoney(money, administratorsName);
    }

    @Override
    public boolean cancelOrder(String orderId,String administratorsName) {
        //??????????????????
        Order order=new Order();
        order=orderMapper.selectOrderById(orderId);
        double deposit=order.getDeposit();
        String userName=order.getContractSignatory();
        String pid=order.getParkingSpaceId();
        //??????????????????
        if(parkingSpaceMapper.updateParkSpaceState(1,pid)){
            System.out.println("????????????????????????");
        }
        else {
            System.out.println("????????????????????????");
        }

        //??????????????????
        User user = new User();
        user=userMapper.selectUserByUserId(userName);
        double userMoney=user.getMoney();
        double moneys=1.2;
        moneys=userMoney+deposit;
        //???????????????????????????
        Administrators administrators = new Administrators();
        administrators=administratorsMapper.selectAdministratorsByName(administratorsName);
        double adminMoney=1.2;
        adminMoney=administrators.getMoney()-deposit;
        String adminId=administrators.getAdministratorsId();
        //?????????????????????????????????
        UserAdminBill userAdminBill=new UserAdminBill();
        //??????ID???
        long  timeNew1 =  System.currentTimeMillis()/ 1000; // 10??????????????????
        String UDB="UDB"+timeNew1;
        userAdminBill.setId(UDB);
        userAdminBill.setType("????????????");
        userAdminBill.setMoney(deposit);
        userAdminBill.setSnederId(userName);
        userAdminBill.setReceiverId(adminId);
        userAdminBill.setOrderId(orderId);
        Date now = new Date();
        userAdminBill.setTime(now);
        if(userAdminBillMapper.insertUserAdminBill(userAdminBill)){
            System.out.println("???????????????????????????????????????");
        }
        if(orderMapper.updateOrderState(5,orderId)&&userMapper.updateUserMoney(moneys,userName)&&administratorsMapper.updateAdministratorsMoney(adminMoney,administratorsName)){
            System.out.println("??????????????????");
            System.out.println("????????????????????????");
            System.out.println("???????????????????????????");
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public boolean timeoutOrder(String orderId, String administratorsName) {
        return false;
    }

    @Override
    public boolean finishOrder(String orderId, String administratorsName) {
        //??????????????????
        Order order=new Order();
        order=orderMapper.selectOrderById(orderId);
        double deposit=order.getDeposit();
        double finalPrice=order.getFinalPrice();
        String developerName=order.getContractInitiator();
        String userName=order.getContractSignatory();
        String pid=order.getParkingSpaceId();
        //??????????????????
        if(parkingSpaceMapper.updateParkSpaceState(3,pid)){
            System.out.println("????????????????????????");
        }
        else {
            System.out.println("????????????????????????");
        }
        //??????????????????
        Administrators administrators = new Administrators();
        administrators=administratorsMapper.selectAdministratorsByName(administratorsName);
        String adminId=administrators.getAdministratorsId();
        double adminMoney =administrators.getMoney()-deposit*0.95+finalPrice*0.05;
        double developerMoney=deposit*0.95+finalPrice*0.95;
        double dMoney=developersMapper.selectMoney(developerName);
        double summoney=dMoney+developerMoney;
        //??????????????????
        if(developersMapper.updateMoney(developerName,summoney)){
            System.out.println(developerMoney);
            System.out.println("????????????????????????");
        }
        //?????????????????????????????????????????????
        Date now = new Date();
        AdminDeveloperBill adminDeveloperBill=new AdminDeveloperBill();
        adminDeveloperBill.setReceiverId(developerName);
        adminDeveloperBill.setSenderId(adminId);
        adminDeveloperBill.setTime(now);
        adminDeveloperBill.setType("????????????");
        adminDeveloperBill.setOrderId(orderId);
        //??????ID???
        long  timeNew =  System.currentTimeMillis()/ 1000; // 10??????????????????
        String ADB="ADB"+timeNew;
        adminDeveloperBill.setId(ADB);
        adminDeveloperBill.setMoney(deposit*0.95+finalPrice*0.95);
        //????????????????????????
        UserAdminBill userAdminBill=new UserAdminBill();
        //??????ID???
        long  timeNew1 =  System.currentTimeMillis()/ 1000; // 10??????????????????
        String UDB="UDB"+timeNew1;
        userAdminBill.setId(UDB);
        userAdminBill.setType("????????????");
        userAdminBill.setMoney(finalPrice);
        userAdminBill.setSnederId(userName);
        userAdminBill.setReceiverId(adminId);
        userAdminBill.setOrderId(orderId);
        userAdminBill.setTime(now);
        if(userAdminBillMapper.insertUserAdminBill(userAdminBill)){
            System.out.println("???????????????????????????????????????");
        }
        if(orderMapper.updateOrderState(4,orderId)&&administratorsMapper.updateAdministratorsMoney(adminMoney,administratorsName)&&adminDeveloperBillMapper.insertAdminDeveloperBill(adminDeveloperBill)){
            System.out.println("??????????????????");
            System.out.println("??????????????????");
            System.out.println("?????????????????????????????????????????????");
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public List<ExamineApprove> selectExamineApprove(int pageNum, int pageSize, int state) {
        return examineApproveMapper.selectExamineApprove(pageNum,pageSize,state);
    }

    @Override
    public List<ExamineApprove> selectHisExamineApprove(int pageNum, int pageSize, String adminId, int state1, int state2) {
        Administrators administrators=new Administrators();
        administrators=administratorsMapper.selectAdministratorsByName(adminId);
        String id=administrators.getAdministratorsId();
        return examineApproveMapper.selectHisExamineApprove(pageNum,pageSize,id,state1,state2);
    }

    @Override
    public boolean unpassfile(int state, String eId,String adminName) {
        Administrators administrators=new Administrators();
        administrators=administratorsMapper.selectAdministratorsByName(adminName);
        String id=administrators.getAdministratorsId();
        return examineApproveMapper.updateExamineApproveState(1,eId,id);
    }

    @Override
    public boolean passfile(int state, String eId,String adminName) {
        ExamineApprove examineApprove=new ExamineApprove();
        examineApprove=examineApproveMapper.selectExamineApproveById(eId);
        //??????????????????????????????ID?????????
        String developerId=examineApprove.getDeveloperId();
        String developerName=examineApprove.getDeveloperName();
        //???????????????
        Developers developers =new Developers();
        developers.setState("??????");
        developers.setDeveloperId(developerId);
        developers.setDeveloperName(developerName);
        developers.setMoney(0);
        //??????????????????????????????????????????
        System.out.println("????????????");
        applicationContext.publishEvent(new DeveloperRegisterAfterEvent(developerId));
        //developersMapper.insertDevelopers(developers);
        //????????????????????????
        Developer_administrator developer_administrator=new Developer_administrator();
        developer_administrator.setRole("?????????");
        developer_administrator.setPassword("123");
        developer_administrator.setDeveloperId(developerId);
        developer_administrator.setId(developerId);
        //developerMapper.insertDeveloper_administrator(developer_administrator);
        //????????????????????????
        //examineApproveMapper.updateExamineApproveState(2,eId);
        Administrators administrators=new Administrators();
        administrators=administratorsMapper.selectAdministratorsByName(adminName);
        String id=administrators.getAdministratorsId();
        return (developersMapper.insertDevelopers(developers)&&developerMapper.insertDeveloper_administrator(developer_administrator)&&examineApproveMapper.updateExamineApproveState(2,eId,id));

    }

    @Override
    public List<Developers> selectDevelopers(int pageNum, int pageSize) {
        return developersMapper.selectDevelopers(pageNum,pageSize);
    }

    @Override
    public boolean unseal(String state,String dId) {
        return developersMapper.updateDevelopersState("??????",dId);
    }

    @Override
    public boolean seal(String dId) {
        return developersMapper.updateDevelopersState("??????",dId);
    }

    @Override
    public boolean offline(String dId) {
        return developersMapper.deleteDevelopers(dId);
    }

    @Override
    public void sendMail(String developerid) {
        System.out.println("????????????");
        //System.out.println(developerid);
        applicationContext.publishEvent(new DeveloperRegisterAfterEvent(developerid));
    }


}
