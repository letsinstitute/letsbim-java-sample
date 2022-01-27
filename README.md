# 功能介绍

本示例基于LETSBIM提供的服务端API和Thymeleaf模板引擎实现了.rvt文件的在线浏览，基本流程如下：
1. 调用服务端API实现文件上传
2. 调用服务端API发起文件转换
3. 调用服务端API查询转换结果
4. 待转换成功后，调用服务端API获取ViewToken，实现模型预览

# 技术框架
* 后端语言：java
* 后端框架：springboot2.6.2
* Java构建和依赖管理工具：maven
* JDK版本：JDK1.8
* 前端语言：html、js、css
* 模板引擎：thymeleaf
* 开发环境：IntelliJ IDEA


# 如何在本地运行？
### 1、使用git下载源代码

```
git clone https://github.com/letsinstitute/letsbim-java-sample.git
```

### 2、修改application.properties

必须通过[创建应用](https://open.letsbim.cn/console/appAdmin)得到自己的appKey和appSecret,然后再修改application.properties中letsim.sdk.appKey和letsbim.sdk.appSecret的，
最后程序才能正常运行。

```
# APP_Key
letsim.sdk.appKey=HiDpSywWxMg9R4b0
# APP_Secret
letsbim.sdk.appSecret=X0&gjf@08#uT4jrz4BpnjU$kq9MUct0HkEg5
```
### 3、使用Maven编译
运行com.letsbim.sample包路径下的Application，默认端口8080

### 4、在网页中运行
```
http://localhost:8080/
```

### 5、登录页的用户名密码随机输入，没经过校验  

如有任何疑问请加入LetsBIM轻量化引擎技术交流QQ群784619842
我们有专业的团队为您解惑





