# 原校园蒲行项目

### xypx-normal：原园蒲行项目(单体版)

##### 用到的框架：Spring、Spring MVC、Mybatis、Spring Session（Redis）

- 项目的session由Spring Sessioin持久化到Redis，方便日后拓展
- 项目图片服务器原来是用七牛云，七牛云改版后需要太多手续，就用Spring Boot和MongoDB GridFs做了一个简陋的图片服务器



#### xypx-minifilesys：简陋的图片服务器

##### 用到的框架：Spring Boot、MongoDB

这项目主要是暂时代替图片服务器，只有上传图片和读取的功能