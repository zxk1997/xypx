# 原校园蒲行项目

## xypx-normal：原园蒲行项目(单体版)

##### 技术集成：Spring、Spring MVC、Mybatis、Spring Session（Redis）、Druid、Mysql

- 项目的session由Spring Sessioin持久化到Redis
- 项目图片服务器原来是用七牛云，七牛云改版后需要太多手续，就用Spring Boot和MongoDB GridFs做了一个简陋的图片服务器
- 前端页面由当时的创业伙伴编写，部署在服务器上的是第二个版本，只有基本功能，并未实现所有功能，且有不少BUG(比如搜索功能，后端功能经过测试是没问题的)
- 为了部署在服务器，在原项目的基础上有小改动



## xypx-minifilesys：简陋的图片服务器

##### 技术集成：Spring Boot(Spring、Spring MVC)、MongoDB

这项目主要是暂时代替图片服务器，只有上传图片和读取的功能



## xypx-manage：校园蒲行后台

##### 用到的技术：Spring Boot(Spring、Spring MVC、Mybatis、Druid)、Mysql