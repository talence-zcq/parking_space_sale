package com.service.impl;

import com.bean.ParkingSpace;
import com.bean.ResidentialQuarters;
import com.bean.User;
import com.dao.OrderMapper;
import com.dao.ParkingSpaceMapper;
import com.dao.ResidentialQuartersMapper;
import com.dao.UserMapper;
import com.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sushuai
 * @date 2019/03/03/23:02
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ParkingSpaceMapper parkingSpaceMapper;
    @Autowired
    private ResidentialQuartersMapper residentialQuartersMapper;
    @Autowired
    private OrderMapper orderMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void setParkingSpaceMapper(ParkingSpaceMapper parkingSpaceMapper) {
        this.parkingSpaceMapper = parkingSpaceMapper;
    }

    public void setResidentialQuartersMapper(ResidentialQuartersMapper residentialQuartersMapper) {
        this.residentialQuartersMapper = residentialQuartersMapper;
    }

    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public User selectUserByUserName(String username) {
        return userMapper.selectUserByUserName(username);
    }

    @Override
    public User selectUserByUserId(String userIdentity) {
        return userMapper.selectUserByUserName(userIdentity);
    }

    @Override
    public User userLogin(String username,String password){return userMapper.userLogin(username,password);};

    @Override
    public boolean insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public boolean insertUserPassword(User user){ return userMapper.insertUserPassword(user);};

    @Override
    public User selectNameById(String userIdentity){ return userMapper.selectNameById(userIdentity);}

    @Override
    public boolean updateUserInfo(User user){return userMapper.updateUserInfo(user);};

    @Override
    public boolean updateUserMoney(double money,String userName){return userMapper.updateUserMoney(money,userName);};

    @Override
    public User userAuthentication(String userResidentialQuarters,String userBuildingNumber,String userHouseNum){return userMapper.userAuthentication(userResidentialQuarters,userBuildingNumber,userHouseNum);};

    //????????????
    @Override
    @Transactional
    public List<ParkingSpace> selectParkingSpace(int pageNum, int pageSize, String search, String did){
        return parkingSpaceMapper.selectParkSpace(pageNum,pageSize,search,did);
    }

    //????????????2
    @Override
    @Transactional
    public List<ParkingSpace> selectAllParkSpace(int pageNum,int pageSize){return parkingSpaceMapper.selectAllParkSpace(pageNum,pageSize);};

    //????????????
    @Override
    @Transactional
    public List<ParkingSpace> selectAllSpace(){return parkingSpaceMapper.selectAllSpace();};

    @Override
    public ResidentialQuarters selectResidentialQuartersById(String did){return residentialQuartersMapper.selectResidentialQuartersById(did);};

    @Override
    public boolean updateOrderState(int state,String orderId){return orderMapper.updateOrderState(state,orderId);};


}
