# 线上车位销售系统
### 采用框架
- IDEA开发，JAVA编写，SSM框架
- 包管理使用Maven
- 采用Tomcat9.0.45服务器
- 数据库采用Mysql，可通过根目录下的.sql文件一键导入
- 前端部分使用axis上传合同签名
- 其余则是正常的bootstrap前端模板框架

### 使用方法
- git clone到相应文件夹
- 在mysql中配置相应数据库，仓库名称为parking_space_online_marketing
- 修改\src\main\resources下的jdbc配置文件，配置对应的用户名和密码
- 运行Tomcat服务器即可

### 项目详情
src中有两个文件夹main和test，其中：
- mian是程序主代码
  - Da中是后台管理员的代码
  - Qiang中是开发商的代码
  - Miao中是用户端的代码
- test是测试代码
  - 其中每一个文件夹都代表了该小组成员测试的部分
  - 测试工具使用了Junit、Easymock
  - 对每个service层和controller层的函数各进行了一次黑盒测试和白盒测试

### 相关课程
软件工程、 JAVAEE、 软件测试

### 课设文档报告
暂未发布