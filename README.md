# 原校园蒲行项目

### 项目展示地址：[点我进入](http://120.78.83.14:8090)

### 项目后台管理地址：[点我进入](http://120.78.83.14:8090/manage/)

>### 后台账号test 密码test（这个用户只有只读权限）

```shell
所有子项目都部署在同一台服务器上，服务器是阿里云的学生机，不禁打，请大神手下留情。。
用的是阿里云的ubuntu镜像，两个前端部署在nginx上，前台后端部署在tomcat上，SpringBoot项目则直接运行
```

前端源码仓库：[xypx-front](https://github.com/zxk1997/xypx-front)

------
```java
由于历史原因(当年新版本开发到一半项目就卒了)蒲行前台和前台后端存在不少bug。(旧版本代码太乱不想放上来)
整个后台都是近期为了能组成一个完整的项目而重写的，写的急而且是为了展示用，所以没考虑太多，应该会有不少bug。
```

## xypx-manage：校园蒲行后台

##### 技术集成：Spring Boot(Spring、Spring MVC、Mybatis、Druid)、Mysql



## xypx-normal：原园蒲行项目(单体版)

##### 技术集成：Spring、Spring MVC、Mybatis、Spring Session（Redis）、Druid、Mysql

- 项目的session由Spring Sessioin持久化到Redis
- 项目图片服务器原来是用七牛云，七牛云改版后需要太多手续，就用Spring Boot和MongoDB GridFs做了一个简陋的图片服务器
- 前端页面由当时的创业伙伴编写，部署在服务器上的是第二个版本，只有基本功能，并未实现所有功能，且有不少BUG(比如搜索功能，后端功能经过测试是没问题的)
- 为了部署在服务器，在原项目的基础上有小改动



## xypx-minifilesys：简陋的图片服务器

##### 技术集成：Spring Boot(Spring、Spring MVC)、MongoDB

这项目主要是暂时代替图片服务器，只有上传图片和读取的功能


