-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2019-03-12 02:59:33
-- 服务器版本： 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `xypx_web2`
--
CREATE DATABASE IF NOT EXISTS `xypx_web2` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `xypx_web2`;

-- --------------------------------------------------------

--
-- 表的结构 `px_act`
--

CREATE TABLE IF NOT EXISTS `px_act` (
  `id` varchar(32) NOT NULL COMMENT '活动id',
  `title` varchar(50) NOT NULL COMMENT '活动标题',
  `address` varchar(200) NOT NULL COMMENT '活动地址',
  `phone` varchar(11) NOT NULL COMMENT '手机号码',
  `s` datetime NOT NULL COMMENT '活动开始时间',
  `e` datetime NOT NULL COMMENT '活动结束时间',
  `ps` datetime NOT NULL COMMENT '报名开始时间',
  `pe` datetime NOT NULL COMMENT '报名结束时间',
  `placard` varchar(100) NOT NULL COMMENT '海报地址',
  `plimit` int(11) NOT NULL COMMENT '活动人数上限',
  `summary` varchar(100) NOT NULL COMMENT '活动简述',
  `content` text NOT NULL COMMENT '活动内容',
  `time` datetime NOT NULL COMMENT '活动添加的时间',
  `status` int(11) NOT NULL COMMENT '活动状态(0：待审核 1：审核通过 -1：审核不通过 -2:草稿)',
  `rm` varchar(100) DEFAULT NULL COMMENT '报名后提示信息',
  `uid` varchar(32) NOT NULL COMMENT '发布者id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `px_act`
--

INSERT INTO `px_act` (`id`, `title`, `address`, `phone`, `s`, `e`, `ps`, `pe`, `placard`, `plimit`, `summary`, `content`, `time`, `status`, `rm`, `uid`) VALUES
('0076593d7194420593cadabe8c4170e5', '软件创新工作室2017最强招新', '深职院', '15778522721', '2017-09-01 00:00:00', '2017-11-30 00:00:00', '2017-09-01 10:43:53', '2019-12-31 10:44:01', 'http://img.xypuxing.com/bb2a3aa4-c7ea-450b-8a35-c115b3cc1777.png', 30, '-', '<p style="text-align: center;">  <strong>\n    <span style="font-size: 32.0px;">软件创新工作室</span></strong> </p>\n <p style="text-align: center;">  <img\n    src="http://img.xypuxing.com/4be4c0bf-3a6b-4e20-82da-499a37f9f90f.png"\n  alt="" /> </p>\n <p>  <br /> </p>\n <p>  <br /> </p>\n <p>  <strong>\n    <span style="font-size: 14.0px;">社团简介：</span></strong> </p>\n <p>  </p>\n<p>   <span>\n    <span>软件创新工作室由计算机工程学院副院长徐人凤老师，于</span></span>\n  <span>2004</span>\n  <span>\n    <span>年</span></span>\n  <span>12</span>\n  <span>\n    <span>月</span></span>\n  <span>23</span>\n  <span>\n    <span>日创立。</span></span>  </p>\n  <p>   <span>\n    <span>针对项目开发能力较强并有意从事项目开发的学生，</span></span>  </p>\n  <p>   <span>\n    <span>希望通过工作室的成立更进一步地锻炼其研究性学习能力和创新能力，</span></span>  </p>\n  <p>   <span>\n    <span>为学生提供一个良好的开发环境和辅导环境。主要培养：</span></span>\n  <span></span>  </p>\n  <p>   <span>1.</span>\n  <span>\n    <span>独立项目开发能力：公众平台小程序开发、游戏开发等</span></span>\n  <span></span>  </p>\n  <p>   <span>2.</span>\n  <span>\n    <span>自学编程能力：</span>C<span>语言、</span>\n    <span>C#</span>\n    <span>、</span>\n    <span>Java</span>\n    <span>等高级语言编程</span></span>\n  <span></span>  </p>\n  <p>   <span>3.</span>\n  <span>\n    <span>美工设计能力：</span>Ps<span>图片处理，</span>\n    <span>Ae</span>\n    <span>视频制作等</span></span>\n  <span></span>  </p>\n  <p>   <span>4.</span>\n  <span>\n    <span>信息安全维护能力：黑客攻防、渗透技术等</span></span>\n  <span></span>  </p>\n  <p>   <span>5.</span>\n  <span>\n    <span>还有丰富的社团生活：海边游玩、一起看电影、集体聚餐等</span></span>  </p>\n  <p>   <span></span>  </p>\n  <p>   <span></span>  </p>\n <strong>\n  <span style="font-size: 14.0px;">指导老师：</span></strong>\n <p></p>\n <p>  肖正兴 </p>\n <p>  <strong>\n    <span style="font-size: 14.0px;">办公室：</span></strong> </p>\n <p>  日新楼中309 </p>\n <p>  <br /> </p>\n <p>  <br /> </p>\n <p style="text-align: center;">  <img\n    src="http://img.xypuxing.com/d9e2a107-dea6-40b3-8679-6cc7e5c9b86c.JPG"\n  alt="" /> </p>\n <p style="text-align: center;">  <img\n    src="http://img.xypuxing.com/6cf18cfa-e64f-45d0-abb1-6e85e66580d7.jpg"\n  alt="" /> </p>\n <p style="text-align: center;">  <img\n    src="http://img.xypuxing.com/14d20584-0363-4cfa-8d77-124db04eb77c.jpg"\n  alt="" /> </p>\n <p>  <br /> </p>\n <p>  <br /> </p>\n <p style="text-align: center;">  <strong>\n    <span style="font-size: 32.0px;">加入软创，从此颠覆你的视界观</span></strong> </p>\n <p style="text-align: center;">  <img\n    src="http://img.xypuxing.com/bc0bb5fb-3f77-4a7b-95fd-00c20740259d.jpg"\n  alt="" /> </p>', '2017-09-01 20:51:04', 1, NULL, '1426c6bc735943d2a7c28bc46b064470'),
('0d8c51d617f54156a190504f3a313343', '深职航协带你飞~~~', '深职院西丽湖校区', '13632680894', '2017-09-01 00:00:00', '2018-09-01 00:00:00', '2017-09-01 10:43:53', '2019-12-31 10:44:01', 'http://img.xypuxing.com/5cfe4d72-fead-43d7-afe6-c93378172091.png', 99999, '-', '<p class="MsoNormal" align="center" style="text-align: center;">  <span style="font-size: 18.0px;">你还记得小时候的梦想吗？</span>\n  <span></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span style="font-size: 18.0px;">飞上天空，遨游太空</span>\n  <span></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span style="font-size: 18.0px;">小时候的梦想肯定要现在来实现啊</span>\n  <span></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span\n  style="font-size: 18.0px;"> </span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span\n  style="font-size: 18.0px;"> </span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span style="font-size: 18.0px;">是不是一脸懵逼？</span>\n  <span></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span style="font-size: 18.0px;">那就让我大发慈悲的告诉你吧</span>\n  <span></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span style="font-size: 18.0px;">深职航协带你实现梦想</span>\n  <span></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span\n  style="font-size: 18.0px;"> </span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span\n  style="font-size: 18.0px;"> </span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span style="font-size: 18.0px;">深职航协，无人机的基地</span>\n  <span></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span style="font-size: 18.0px;">有塑料无人机，</span>\n  <span></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span style="font-size: 18.0px;">有自己做成的无人机，</span>\n  <span></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span style="font-size: 18.0px;">有DIY</span>\n  <span style="font-size: 18.0px;">的迷你无人机，</span>\n  <span></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span style="font-size: 18.0px;">看图！！！</span>\n  <span></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span\n      style="font-size: 18.0px;"> <img\n      src="http://img.xypuxing.com/8431f66c-c867-46bf-a6af-e89126d279d7.jpg"\n  alt="" /></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span\n  style="font-size: 18.0px;"> </span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">\n  <span></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span\n      style="font-size: 18.0px;"> <img\n      src="http://img.xypuxing.com/f663ae2e-6c95-47ab-94d3-4a1350da8344.jpg"\n  alt="" /></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span\n  style="font-size: 18.0px;"> </span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span style="font-size: 18.0px;">是不是很酷炫，很有</span>\n  <span style="font-size: 18.0px;">feel</span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span style="font-size: 18.0px;">想飞的你还不赶快过来</span>\n  <span></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span style="font-size: 18.0px;">让我们遨游天空</span>\n  <span></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span\n  style="font-size: 18.0px;"> </span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span\n  style="font-size: 18.0px;"> </span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span style="font-size: 18.0px;">协会指导老师是陈昊老师</span>\n  <span></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span\n  style="font-size: 18.0px;"> </span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span\n  style="font-size: 18.0px;"> </span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span style="font-size: 18.0px;">想知道更多的搜索“深职航协”添加微信公众号</span>\n  <span></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">  <span style="font-size: 18.0px;">或者扫码加入新生群</span>\n  <span></span> </p>\n <img\n  src="http://img.xypuxing.com/7a862ee3-6435-4424-8fd8-46a6fab30399.jpg" alt="" />\n<br />\n <p class="MsoNormal" align="center" style="text-align: center;">  <span\n  style="font-size: 18.0px;"> </span> </p>', '2017-09-01 01:19:38', 1, NULL, '28f4f297ce9a4c2da28a4be05aaf4c67'),
('153114b78fae44e2a39c354f792bbdae', '大数据技术与应用协会招新', '深圳职业技术学院东校区', '13509662864', '2017-08-31 00:00:00', '2017-12-31 00:00:00', '2017-09-01 10:43:53', '2019-12-31 10:44:01', 'http://img.xypuxing.com/99a56ccf-1813-4809-9b2c-f45723cf712e.jpg', 999, '-', '<div>    <p class="MsoNormal" align="left">\r\n          大数据技术与应用协会成立于2017年，是一个以“学习大数据技术，紧跟技术潮流”为宗旨，以“学无止境，与时俱进”为口号，面向全校对大数据相关技术感兴趣的在校大学生而成立的非商业性质学生技术协会。大数据又称为巨量资料，指需要新处理模式才能具有更强的决策力、洞察力和<a\r\n        href="http://baike.sogou.com/lemma/ShowInnerLink.htm?lemmaId=352342&amp;ss_c=ssc.citiao.link">流程优化</a>能力的海量、高增长率和多样化的信息资产。大数据有4大特点，即大量、高速、多样、高价值。\r\n      </p>    <p class="MsoNormal" align="left">\r\n        协会以技术学习为核心，通过学习、交流、培训、实践等活动形式，打造一个开放的、合作的、有生命力的学生组织，充分发挥学生创造性，提高学生自主学习能力，提升个人专业素养和职业竞争力。\r\n      </p>    <p class="MsoNormal" align="left">          </p>    <div\r\n        class="MsoNormal" align="center" style="text-align: center;">\r\n        <hr />    </div>    <p class="MsoNormal" align="center"\r\n        style="text-align: center;">     <b>首届泰迪招聘信息分析与展示大赛</b>\r\n        <b></b>    </p>    <p class="MsoNormal" align="left">      \r\n      </p>    <p class="MsoNormal" align="left">     <b></b>    </p>\r\n        <p class="MsoNormal" align="left">\r\n        <b>这次活动中，不同专业的学生通过招聘信息的分析，进一步了解所在专业的职业生涯，对专业方向了解得更透彻，同时学生能在比赛中了解并进一步剖析自身的求职竞争能力，巩固专业知识，提高相关素质，促进其求职观念的改变，引导其对求职能力的培养。</b>\r\n      </p>    <p class="MsoNormal" align="left">     <b>\r\n          <img\r\n            src="http://img.xypuxing.com/c09152e1-cea4-454b-ab31-22373aec6dd4.jpg"\r\n            alt="" style="height: auto;width: 738.0px;" />\r\n          <img\r\n            src="http://img.xypuxing.com/098c63c8-0334-4c2a-97bc-26659bcb9c09.jpg"\r\n            alt="" style="height: auto;width: 738.0px;" />\r\n          <br /> </b>    </p>    <p class="MsoNormal" align="left">\r\n        <b>在这里，我们会提供各种大数据的学习资源与实时热点。和同学们一同打开大数据这一新潮世界~新社团的成立离不开各大同学的支持，如果你也对大数据充满浓厚兴趣，欢迎关注我们，让我们一同进军大数据新时代！</b>\r\n      </p>    <p class="MsoNormal" align="left">     <b>\r\n          <img\r\n            src="http://img.xypuxing.com/3e7086c6-5cc3-4760-b9ff-7e7e191af4da.jpg"\r\n            alt="" style="height: auto;width: 738.0px;" />\r\n          <br /> </b>    </p>    <p class="MsoNormal" align="left">\r\n        <b>关注公众号以及加入我们的新生群，了解更多详细信息哦！</b>    </p>    <p\r\n        class="MsoNormal" align="left">     <img\r\n          src="http://img.xypuxing.com/f75a53dc-60c0-4cc2-8d3a-7c9a2ac6b765.jpg"\r\n          alt="" style="height: auto;width: 738.0px;" />\r\n        <img\r\n          src="http://img.xypuxing.com/59cc45f9-70f3-4a56-bede-70b28f98d34b.jpg"\r\n          alt="" style="height: auto;width: 738.0px;" />    </p>    <p\r\n        class="MsoNormal" align="left">     <b>师姐在这里等着你的到来哦！</b>    </p>\r\n        <p class="MsoNormal" align="left">     <b>\r\n          <img\r\n            src="http://img.xypuxing.com/4f9ce2a8-b756-4f53-8e78-e93907268824.jpg"\r\n            alt="" style="height: auto;width: 738.0px;" />\r\n          <br /> </b>    </p>   </div>', '2017-08-31 22:52:00', 1, NULL, '4ded95aede74469f9edc6a664b8b6f0a'),
('1deccd2173fb45259cfdf0425a719444', '是范德萨发的发', '阿士大夫士大夫士大夫', '13641416680', '2019-03-11 17:25:00', '2019-03-22 17:10:00', '2019-03-11 17:50:00', '2019-03-28 21:10:00', 'http://120.78.83.14:2000/get/7e4c984d-149c-4a70-b4fd-23b00b4ee42f', 123, '水电费打算分', '啥地方萨德分', '2019-03-11 17:13:07', 0, NULL, 'd248519fae6d4625b195ac24c0cb9fae'),
('24a551cf45724544ab47ed7e857112d4', 'project工作室迎接新生啦', '深圳职业技术学院（东校区）', '15602909691', '2017-08-27 00:00:00', '2017-10-31 00:00:00', '2017-09-01 10:43:53', '2019-12-31 10:44:01', 'http://img.xypuxing.com/c6296d49-cb1d-474e-a7fd-f5f9eb868f97.png', 999, '-', '<p class="MsoNormal" style="text-align: center;">   <img\n    src="http://img.xypuxing.com/143b3804-aa77-4580-ad40-d85e229d676e.jpg"\n    alt="" width="150" height="150" title="" /> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">    </p>\n <p class="MsoNormal" align="center" style="text-align: center;">\n     <span style="font-size: 32.0px;">Project工作室</span> </p>\n <div class="MsoNormal" align="center" style="text-align: center;">\n  <hr /> </div>\n <p class="MsoNormal" align="left">    </p>\n <p class="MsoNormal" align="left">  <b>\n    <span style="font-size: 24.0px;">社团介绍：</span></b> </p>\n <p class="MsoNormal" align="left">  <span style="font-size: 18.0px;">社团成立于</span>\n  <span style="font-size: 18.0px;">2016</span>\n  <span\n  style="font-size: 18.0px;">年，我们的方向是面向实际的项目工程，培养高素质技能人才。重点教学云计算平台搭建、虚拟桌面、云存储等各类云应用开发、部署、维护及安全保障的能力；促进高职院校信息管理、网络专业课程建设，促进学生专业核心技能和职业核心能力的同步提高，提升毕业生的就业水平。</span> </p>\n <p class="MsoNormal" align="left">  <b>\n    <span style="font-size: 24.0px;">指导老师：</span></b> </p>\n <p class="MsoNormal" align="left">  <span\n  style="font-size: 16.0px;">易海博</span> </p>\n <p class="MsoNormal" align="left">  <b>\n    <span style="font-size: 24.0px;">办公室</span>\n    <span style="font-size: 24.0px;">:</span></b> </p>\n <p class="MsoNormal" align="left">  <span style="font-size: 16.0px;">深职院东区日新楼中</span>\n  <span style="font-size: 16.0px;">401</span> </p>\n <div class="MsoNormal" align="center" style="text-align: center;">\n  <hr /> </div>\n <p class="MsoNormal" align="left">    </p>\n <p class="MsoNormal" style="text-indent: 18.05pt;">  <span style="font-size: 24.0px;">\n    <strong>社团荣誉单！ ！ ！</strong></span> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">    </p>\n <p class="MsoNormal" align="left" style="text-indent: 21.0pt;">  <span\n  style="font-size: 18.0px;">1、2017年全国职业院校技能大赛云计算技术与应用荣获国赛一等奖第一名（其实一名选手社长李锦升）</span> </p>\n <p class="MsoNormal" align="left" style="text-indent: 21.0pt;">  <span style="font-size: 18.0px;">2、</span>\n  <span style="font-size: 18.0px;">2017</span>\n  <span\n  style="font-size: 18.0px;">年全国职业院校技能大赛云计算技术与应用广东省选拔赛一等奖（其实一名选手社长李锦升）</span> </p>\n <p class="MsoNormal" align="left" style="text-indent: 21.0pt;">  <span\n  style="font-size: 18.0px;">3、校创客项目第一名</span> </p>\n <p class="MsoNormal" align="left" style="text-indent: 21.0pt;">  <span\n  style="font-size: 18.0px;">4、广东省职业院校技能大赛大数据开发与应用广东省选拔赛二等奖（有一名成员）</span> </p>\n <p class="MsoNormal" align="left" style="text-indent: 21.0pt;">  <span\n  style="font-size: 18.0px;">5、首届移动互联创客大赛三等奖</span> </p>\n <p class="MsoNormal" align="left" style="text-indent: 21.0pt;">  <span style="font-size: 18.0px;">6、深圳职业技术学院“挑战杯”五四青年科技作品竞赛三等奖</span>\n  <span style="font-size: 18.0px;"> </span>\n  <span style="font-size: 18.0px;"></span>\n  <span style="font-size: 18.0px;"></span>\n  <span style="font-size: 18.0px;"></span>\n  <span style="font-size: 18.0px;"></span>\n  <span style="font-size: 18.0px;"></span> </p>\n <p class="MsoNormal" align="left" style="text-indent: 21.0pt;">  <span\n  style="font-size: 18.0px;">7、2017年广东省大学生计算机设计大赛决赛二等奖</span> </p>\n <p class="MsoNormal" align="left" style="text-indent: 21.0pt;">  <span\n  style="font-size: 18.0px;">8、2017年第五届深职院“挑战杯”五四青年科技作品竞赛自然科学类三等奖</span> </p>\n <p class="MsoNormal" align="left" style="text-indent: 21.0pt;">  <span\n      style="font-size: 18.0px;">9、2017年<span\n  style="color: rgb(67,67,67);">第七届蓝桥杯软件创业团队赛</span>荣获三等奖</span> </p>\n <div class="MsoNormal" align="center" style="text-align: center;">\n  <hr /> </div>\n <p class="MsoNormal" align="left" style="text-align: center;">  <span style="font-size: 16.0px;">\n    <img\n      src="http://img.xypuxing.com/14d97409-ad81-4ccc-94c2-55965a11f096.jpg"\n      alt="" width="600" height="450" title="" />\n    <br /> </span> </p>\n <p class="MsoNormal" align="left" style="text-align: center;">  <span style="font-size: 16.0px;">\n    <img\n      src="http://img.xypuxing.com/98ee286c-e223-495a-a226-571288e32217.jpg"\n      alt="" width="600" height="450" title="" />\n    <br /> </span> </p>\n <p class="MsoNormal" align="left" style="text-align: center;">  <span style="font-size: 16.0px;">\n    <img\n      src="http://img.xypuxing.com/6e672df6-4280-4ede-a240-af88798f4bc4.jpg"\n      alt="" width="600" height="800" title="" />\n    <br /> </span> </p>\n <p class="MsoNormal" align="left" style="text-align: center;">  <span style="font-size: 16.0px;">\n    <img\n      src="http://img.xypuxing.com/03adf31b-f4f0-449a-9ee9-78f95f1e17c9.jpg"\n      alt="" width="600" height="450" title="" />\n    <br /> </span> </p>\n <p class="MsoNormal" align="left" style="text-align: center;">  <span style="font-size: 16.0px;">\n    <img\n      src="http://img.xypuxing.com/26a89f3b-b237-4024-933f-d27ebc22c6e8.jpg"\n      alt="" width="600" height="800" title="" />\n    <br /> </span> </p>\n <p class="MsoNormal" align="left" style="text-align: center;">  <span style="font-size: 16.0px;">\n    <img\n      src="http://img.xypuxing.com/d9a2d646-58d7-4b6a-b471-60dbbe7d9864.png" alt="" />\n    <br /> </span> </p>\n <p class="MsoNormal" align="left">  <span style="font-size: 16.0px;">\n    <br /> </span> </p>\n <p class="MsoNormal" align="left">  <span style="font-size: 16.0px;">\n    <br /> </span> </p>\n <p class="MsoNormal" align="left">  <span\n  style="font-size: 16.0px;"></span> </p>\n <hr />\n <br />\n <p class="MsoNormal" align="left">  <span style="font-size: 16.0px;">Project工作室的成立主要对象是</span>\n  <b>\n    <span\n  style="font-size: 16.0px;">对做项目感兴趣、想通过做项目提升自己专业能力的同学.</span></b> </p>\n <p class="MsoNormal" align="left">  <span style="font-size: 32.0px;">本社团发布各种项目信息，并指导学生做项目，教予项目知识，提升学生的专业能力。</span>\n  <span style="font-size: 32.0px;"> </span> </p>\n <p class="MsoNormal" align="left">  <br /> </p>\n <p class="MsoNormal" align="left">  <br /> </p>\n <p class="MsoNormal" align="right" style="text-align: right;">  <b>\n    <span style="font-size: 32.0px;">有兴趣的同学，点击报名，加入我们吧</span>\n    <span style="font-size: 32.0px;">!</span></b> </p>\n <p class="MsoNormal" align="right" style="text-align: right;">  <b>\n    <span style="font-size: 32.0px;">大学生活从这里开始</span>\n    <span style="font-size: 32.0px;">!!!</span></b> </p>\n <p class="MsoNormal" align="left">  <span\n  style="font-size: 32.0px;"> </span> </p>\n <p class="MsoNormal">    </p>\n <p class="MsoNormal">    </p>\n <p class="MsoNormal">    </p>\n <p class="MsoNormal">    </p>\n <p class="MsoNormal">    </p>\n <p class="MsoNormal">    </p>\n <p class="MsoNormal">    </p>\n <p class="MsoNormal">    </p>\n <p class="MsoNormal">    </p>\n <p class="MsoNormal">    </p>\n <p class="MsoNormal">    </p>\n <p class="MsoNormal">    </p>\n <p class="MsoNormal">    </p>\n <p class="MsoNormal">    </p>\n <p class="MsoNormal">    </p>\n <p class="MsoNormal">    </p>', '2017-08-29 16:13:52', 1, NULL, 'e254a5665adb4c7496873bacb1354b1b'),
('43e28cd7ecc24ce093df16c038c01837', '信息安全协会', '深圳职业技术学院(东校区)', '15989498228', '2017-09-12 00:00:00', '2017-10-31 00:00:00', '2017-09-01 10:43:53', '2019-12-31 10:44:01', 'http://img.xypuxing.com/e161be81-7ca0-4fec-8d31-3b46c6067982.jpg', 999, '-', '<p>  模拟渗透大赛: </p>\n <p>  </p>\n<p class="MsoNormal">\n  普及信息安全基本知识，同时促进同学们的信息安全理论素养和实际动手能力，提高同学们的信息安全意识，从中激发自己才能，为信息安全行业做出贡献。  </p>\n <img\n  src="http://img.xypuxing.com/5f228ad1-94af-4bc5-a8f0-4a86a45e707d.jpg" alt="" />\n<img\n  src="http://img.xypuxing.com/ef053df2-b8b3-48b3-ae22-7a564bf00203.jpg" alt="" />\n<img\n  src="http://img.xypuxing.com/be8a2591-4813-4c57-9043-769d0452feaa.jpg"\n  alt="" width="960" height="540" title="" />\n<img\n  src="http://img.xypuxing.com/73ba65d3-3bd0-4194-9fcd-ec169a993873.jpg" alt="" />\n <p></p>\n <p>  欢迎加入我们 </p>', '2017-09-12 11:56:15', 1, NULL, '1a65cc0625a048108328b2432a09dea3'),
('4711c532a89943399637d468313796e3', '深职院校园蒲公英招募有志之士~！', '深圳职业技术学院东校区日新楼中', '15602909691', '2017-09-21 00:00:00', '2017-09-28 00:00:00', '2017-09-01 10:43:53', '2019-12-31 10:44:01', 'http://img.xypuxing.com/987c006a46e243ba8ea1d5411d65f686', 999, '-', '<span style="font-size: 32.0px;">校园蒲行招新啦！！</span>\n<br />\n <span style="font-size: 18.0px;font-family: &quot;Microsoft YaHei&quot;;">校园蒲行，致力于改善大学生生活方式，建设智慧校园，幸福校园的数据中心。校园蒲行平台致力于服务每个大学生。</span>\n<span style="font-family: &quot;Microsoft YaHei&quot;;font-size: 18.0px;">在校园蒲行，你能学习到的不仅仅是社团技能，还可以提前接触公司的节奏，了解公司的运转，体验公司的发展，尝试公司的项目。我们诚挚邀请志同道合的你们，跟我们一起共同进步，共同学习，共同维护、发展校园蒲行。</span>\n<br />\n <p>  <span style="font-size: 32.0px;">赶紧进行了解报名吧！！！</span> </p>\n <p>  <span style="font-size: 32.0px;">\n    <br /> 市场部<br /> 蒲行活动的策划及组织，制定及实施市场推广活动，实施品牌规划和品牌形象建设。<br />\n    招新要求：具有明锐的市场洞察力，性格开朗、热情。具有一定的活动策划、公关经验。有强烈的责任心，思维活跃，富有创新精神，团队意识。<br />\n    <br /> 设计部<br /> 蒲行官网页面重构设计，各大活动海报宣传物设计、蒲行宣传片制作等蒲行门面设计工作。<br />\n    招新要求：有较为专业的美感，有毅力，具有很强的学习热情（要学习并快速掌握PS、AI、PR、AE等制作软件），工作稳重，有强烈的责任心，富有创新精神，团队意识。<br />\n    <br /> 推广部<br /> 负责创作蒲行公众号推文，编写海报宣传文案等工作，以及微信公众号的日常运营管理。<br />\n    招新要求：经常浏览当下热点时事，拥有时代潮流前沿思想，具有较强的语言组织和写作能力,勤奋好学，有强烈的责任心，富有创新精神，团队意识。<br />\n    <br /> </span> </p>\n <p style="text-align: center;">  <span style="font-size: 32.0px;">\n    <img src="http://img.xypuxing.com/b5a641d6609f46c0958c80bd83f74786" alt="" />\n    <br /> </span> </p>\n <p style="text-align: center;">  <span style="font-size: 32.0px;">\n    <img src="http://img.xypuxing.com/81813850347b44c1ac72a6bedfaf279d" alt="" />\n    <br /> </span> </p>', '2017-09-21 21:54:29', 1, NULL, 'e254a5665adb4c7496873bacb1354b1b'),
('53bb1e8ddacd43e68f94be529ed8aa39', '计算机创新工作室2017新力量招新！', '深职院', '13592849499', '2017-09-01 00:00:00', '2017-11-30 00:00:00', '2017-09-01 10:43:53', '2019-12-31 10:44:01', 'http://img.xypuxing.com/8816d924-8ff0-4c4d-b8b0-418706e98d72.jpg', 999, '-', '<p style="text-align: center;">  <img\n    src="http://img.xypuxing.com/bcccc955-1991-42b2-8aaf-243a5ae1f747.jpg"\n  alt="" /> </p>\n <p style="text-align: center;">  <br /> </p>\n <p style="text-align: left;">  <span style="font-size: 18.0px;">\n    <strong>社团简介：</strong></span> </p>\n <p style="text-align: left;">  <span style="font-size: 18.0px;"></span>\n  <span\n    style="font-size: 18.0px;">计算机创新工作室成立于2009年，是一个依托计算机学院应用专业，专注开展关于软件/硬件编程、MPU研发、平面设计与网页设计等领域学习、研究工作的科技创新型社团 ！社团会定期组建队伍参加校外比赛检验能力，如“中国软件杯”、“蓝桥杯”等。计算机创新工作室致力于为每一个学生打造技术平台，在这里有最优质的学习氛围，在这里有优质的资源帮助每一个成员实现自我价值，我们期待有你的加入！</span>\n  <span style="font-size: 18.0px;"></span> </p>\n <p style="text-align: left;">  <br /> </p>\n <p style="text-align: left;">  <span style="font-size: 18.0px;">\n    <strong>指导老师：</strong></span> </p>\n <p style="text-align: left;">  <span\n  style="font-size: 18.0px;">马亲民</span> </p>\n <p style="text-align: left;">  <br /> </p>\n <p style="text-align: left;">  <span style="font-size: 18.0px;line-height: 27.0px;">\n    <b>社团办公室：</b></span> </p>\n <p style="text-align: left;">  <span\n  style="font-size: 18.0px;line-height: 27.0px;">深职院东区日新楼南300</span> </p>\n <p style="text-align: left;">  <span style="font-size: 16.0px;">\n    <br /> </span> </p>\n <p style="text-align: center;">  <span style="font-size: 16.0px;">\n    <img\n      src="http://img.xypuxing.com/679f78dc-e3e8-49e6-a995-daf2879f74fe.jpg" alt="" />\n    <br /> </span> </p>\n <p style="text-align: left;">  <span style="font-size: 16.0px;">\n    <br /> </span> </p>\n <p style="text-align: center;">  <span style="font-size: 24.0px;">\n    <strong>加入计创，大神带你飞！</strong></span> </p>\n <p style="text-align: center;">  <span style="font-size: 18.0px;">\n    <strong>\n      <img\n        src="http://img.xypuxing.com/5c06d2cd-ce8c-4e56-b7b5-8e038379fc03.jpg" alt="" />\n      <br /> </strong></span> </p>\n <p style="text-align: center;">  <br /> </p>', '2017-09-03 12:00:49', 1, NULL, 'e7699c7f4b724864a70e2e3a4ab6d6fc'),
('63b7f49573de45f78223ab6446d4cf58', '初步第一次测试_修改', '这是地址', '13612345678', '2017-09-27 22:24:00', '2017-10-27 22:24:00', '2017-09-13 00:00:00', '2019-12-31 10:44:01', 'http:www.sdfsdf', 123, '这是简述内容', '这是活动内容', '2017-10-12 11:22:42', 1, '这是提示内容', 'testuid'),
('643d65c803954b71b661efe2aa2b2132', '测试活动api', '这是地址', '13612345677', '2017-09-27 22:24:00', '2017-10-27 22:24:00', '2017-09-27 22:24:00', '2019-12-31 10:44:01', 'www.海报.com', 100, '这是简述内容', '这是活动内容似懂非懂', '2017-10-15 00:02:35', 1, '成功后的提示信息', 'testuid'),
('6bc704d6e95f482a94137f93d5e429db', '测试标题', '这是地址', '13612345678', '2017-09-27 22:24:00', '2017-10-27 22:24:00', '2017-09-13 00:00:00', '2019-12-31 10:44:01', 'http:www.sdfsdf', 123, '这是简述内容', '这是活动内容', '2017-10-08 14:24:08', 1, NULL, 'testuid'),
('6d0d0e19cdda43b3876cfec4310f331e', 'M3 X 蒲行 一线互联网公司笔试面试体验', '广东省深圳市南山区沙河西路深圳职业技术学院（东校区）南门', '15602909691', '2017-11-27 13:59:00', '2017-11-29 23:55:00', '2017-11-27 13:59:00', '2019-12-31 10:44:01', 'http://img.xypuxing.com/3309bcb6c14e491883859745d42752cb', 20, '08年离开迅雷放弃腾讯offer进入创业公司带领并培养技术团队，11年开始以个人名义正式收徒，早期徒弟们现在已经是各公司的技术总监和主程，13年开始长期支持企业技术服务、团队搭建和人才引荐。', '<p style="text-align: left;">  <span style="color: rgb(108,105,105);">\n    <strong>\n      <span style="color: rgb(255,41,65);font-size: 24.0px;">\n        <span style="font-size: 24.0px;">校园蒲行</span></span></strong></span>\n  <span style="color: rgb(108,105,105);">联合</span>\n  <span style="color: rgb(108,105,105);">\n    <strong>\n      <span style="color: rgb(255,41,65);font-size: 24.0px;">MONTH3</span></strong></span>\n  <span style="color: rgb(108,105,105);">共同打造一个全面的咨询平台，只要同时关注</span>\n  <strong>\n    <span style="color: rgb(255,41,65);font-size: 24.0px;">校园</span></strong>\n  <span style="">\n    <strong>蒲行</strong></span>\n  <span style="color: rgb(108,105,105);">和</span>\n  <strong>\n    <span style="color: rgb(255,41,65);font-size: 24.0px;">MONTH3</span></strong>\n  <span style="color: rgb(108,105,105);">公众号即可免费</span>\n  <strong>\n    <span style="color: rgb(255,41,65);font-size: 24.0px;">获得BAT大公司笔试面试资料</span></strong>\n  <span style="color: rgb(108,105,105);">并且有机会</span>\n  <strong>\n    <span style="color: rgb(255,41,65);font-size: 24.0px;">加入群聊进行筛选</span></strong>\n  <span style="color: rgb(108,105,105);">，</span>\n  <strong>\n    <span style="color: rgb(255,41,65);font-size: 24.0px;">获得前迅雷工程师、创业公司CTO组织进行有限名额的模拟面试和面试诊断机会</span></strong>\n  <span style="color: rgb(108,105,105);">，并</span>\n  <strong>\n    <span style="color: rgb(255,41,65);font-size: 24.0px;">获得在职大公司CTO的面试指导</span></strong>\n  <span style="color: rgb(108,105,105);">，帮助你们临门一脚踏入企业，</span>\n  <span style="">\n    <strong>获得4k-9k的高薪就职机会</strong></span>\n  <span style="color: rgb(108,105,105);">，还可以获得机会通过内推哦。</span> </p>\n <p style="text-align: left;">  <span style="color: rgb(108,105,105);">\n    <br /> </span> </p>\n <p style="text-align: center;">  <span style="color: rgb(108,105,105);">\n    <img src="http://img.xypuxing.com/21e2d4dbb5dd48f5805b3a31622fa27d" alt="" />\n    <br /> </span> </p>\n <p style="text-align: left;">  <b>\n    <span\n  style="">MONTH3创始人，迅雷看看、迅雷社区早期核心团队成员。08年离开迅雷放弃腾讯offer进入创业公司带领并培养技术团队，11年开始以个人名义正式收徒，早期徒弟们现在已经是各公司的技术总监和主程，13年开始长期支持企业技术服务、团队搭建和人才引荐。</span></b> </p>\n <p style="text-align: left;">  <b>\n    <br /> </b> </p>\n <p style="text-align: left;">  <b>\n    <span\n  style="">十年前，Tan离开迅雷进入创业公司担任CTO，发现传统院校和培训机构毕业的人才，普遍不具备动手开发能力。为了节约创业前期的成本，开始尝试带学徒上手，逐渐发现一个新手只要愿意学、学的对，即便没有基础，三个月时间，足以上手开发。自那时开始，则十年如一日地，摸索出可标准化的三个月成长方法。</span></b> </p>\n <p style="text-align: left;">  <b>\n    <br /> </b> </p>\n <p style="text-align: left;">  <b>\n    <span\n  style="">如今深圳市三个月在线教育科技有限公司在深圳出发，在南山区设立M3学习体验馆，进行限量的线下开班，体验真实的互联网开发者工作气氛，择优参与新项目团队孵化。</span></b> </p>\n <p style="text-align: left;">  <b>\n    <br /> </b> </p>\n <p style="text-align: left;">  <b>\n    <span\n  style="">正在研发自己的在线编程工具，将方法融入工具，创造一个编程的虚拟世界，让用户线上进行教育互动有近乎线下学习的体验，并打破了线下地域的限制！</span></b> </p>\n <p style="text-align: left;">  <span style="background-color: rgb(255,255,255);font-size: 24.0px;">\n    <span style="font-size: 24.0px;">\n      <b>      </b></span></span> </p>\n <p style="text-align: left;">  <b>\n    <span style="font-size: 24.0px;">     </span></b> </p>\n <div style="text-align: left;">  <b>\n    <br /> </b> </div>', '2017-11-27 14:01:01', 1, NULL, 'e254a5665adb4c7496873bacb1354b1b'),
('7300b430040e4fb39a7b47efa8480f2f', '智信：PS零基础入门', '深职院东区信息楼101', '13286682921', '2017-11-29 15:00:00', '2018-01-03 19:00:00', '2017-11-27 19:45:00', '2019-12-31 10:44:01', 'http://img.xypuxing.com/d0fe156a9507421fba608b5a98c09dd2', 0, '技术大牛带你从小白进阶到大神！', '<p class="MsoNormal" align="center" style="text-align: center;">  <b>\n    <span style="font-size: 32.0px;">PS</span></b>\n  <b>\n    <span style="font-size: 32.0px;">课程教学大纲</span>\n    <span></span></b> </p>\n <p class="MsoNormal" align="center" style="text-align: center;">\n  <b> </b> </p>\n <blockquote>  <blockquote>   <p class="MsoListParagraph"\n      style="margin-left: 18.0pt;text-indent: -18.0pt;">    <span\n        style="font-size: 16.0px;">1.    PScc2017精简版界面介绍及普通操作</span>\n    </p>  </blockquote>  <blockquote>   <p class="MsoListParagraph"\n      style="margin-left: 18.0pt;text-indent: -18.0pt;">    <span\n        style="font-size: 16.0px;">2.    选择工具和选区工具（套索，魔棒）</span>   </p>\n  </blockquote>  <blockquote>   <p class="MsoListParagraph"\n      style="margin-left: 18.0pt;text-indent: -18.0pt;">    <span\n        style="font-size: 16.0px;">3.    图像修复（利用工具</span>\n      <span style="font-size: 16.0px;">P</span>\n      <span style="font-size: 16.0px;">图）</span>   </p>  </blockquote>\n    <blockquote>   <p class="MsoListParagraph"\n      style="margin-left: 18.0pt;text-indent: -18.0pt;">    <span\n        style="font-size: 16.0px;">4.    调整图层（曲线，色相……）</span>   </p>\n  </blockquote>  <blockquote>   <p class="MsoListParagraph"\n      style="margin-left: 18.0pt;text-indent: -18.0pt;">    <span\n        style="font-size: 16.0px;">5.    图层样（投影，内发光……）</span>   </p>\n  </blockquote>  <blockquote>   <p class="MsoListParagraph"\n      style="margin-left: 18.0pt;text-indent: -18.0pt;">    <span\n        style="font-size: 16.0px;">6.    工具详解（其他工具的介绍……）</span>   </p>\n  </blockquote>  <blockquote>   <p class="MsoListParagraph"\n      style="margin-left: 18.0pt;text-indent: -18.0pt;">    <span\n        style="font-size: 16.0px;">7.    路径（钢笔及设计……）</span>   </p>\n  </blockquote>  <blockquote>   <p class="MsoListParagraph"\n      style="margin-left: 18.0pt;text-indent: -18.0pt;">    <span\n        style="font-size: 16.0px;">8.    通道与蒙版，滤镜</span>   </p>\n  </blockquote>  <blockquote>   <p class="MsoListParagraph"\n      style="margin-left: 18.0pt;text-indent: -18.0pt;">    <span\n        style="font-size: 16.0px;">9.    设计方向？暂定</span>   </p>   <p\n      class="MsoListParagraph"\n      style="margin-left: 18.0pt;text-indent: -18.0pt;">    <span style="font-size: 16.0px;">\n        <br /> </span>   </p>   <p class="MsoListParagraph"\n      style="margin-left: 18.0pt;text-indent: -18.0pt;">    <span\n      style="font-size: 24.0px;">    学了PS可以做什么？</span>   </p>   <p\n      class="MsoListParagraph"\n      style="margin-left: 18.0pt;text-indent: -18.0pt;">    <span style="font-size: 16.0px;">\n        <span style="font-size: 24.0px;">    </span>\n        <span style="font-size: 24.0px;">    </span>\n        <span style="font-size: 24.0px;">    </span>\n        <span style="font-size: 24.0px;">    </span>\n        <span style="font-size: 24.0px;">    </span>\n        <span style="font-size: 24.0px;">    </span>\n        <span style="font-size: 24.0px;">                                             答：各种酷炫的东西！</span>\n        <br /> </span>   </p>   <p class="MsoListParagraph"\n      style="margin-left: 18.0pt;text-indent: -18.0pt;">    <span style="font-size: 16.0px;">\n        <span style="font-size: 24.0px;">\n          <br /> </span></span>   </p>   <p class="MsoListParagraph"\n      style="margin-left: 18.0pt;text-indent: -18.0pt;">    <span\n      style="font-size: 24.0px;">可以先上花瓣、千图、包图网看看各类精美素材哦~报名参加者还有机会获得海量免费素材包，快快点击报名吧！</span>\n    </p>  </blockquote> </blockquote>\n <p class="MsoListParagraph"\n  style="margin-left: 18.0pt;text-indent: -18.0pt;">  <span></span> </p>\n <p class="MsoListParagraph"\n  style="margin-left: 18.0pt;text-indent: -18.0pt;">  <span></span> </p>\n <p class="MsoListParagraph"\n  style="margin-left: 18.0pt;text-indent: -18.0pt;">  <span></span> </p>\n <p class="MsoListParagraph"\n  style="margin-left: 18.0pt;text-indent: -18.0pt;">  <span></span> </p>\n <p class="MsoListParagraph"\n  style="margin-left: 18.0pt;text-indent: -18.0pt;">  <span></span> </p>\n <p class="MsoListParagraph"\n  style="margin-left: 18.0pt;text-indent: -18.0pt;">  <span></span> </p>\n <p class="MsoListParagraph"\n  style="margin-left: 18.0pt;text-indent: -18.0pt;">  <span></span> </p>\n <p class="MsoListParagraph"\n  style="margin-left: 18.0pt;text-indent: -18.0pt;">  <span></span> </p>\n <p class="MsoListParagraph"\n  style="margin-left: 18.0pt;text-indent: -18.0pt;">  <span></span> </p>', '2017-11-27 19:48:11', 0, NULL, 'd45c76230bd440318d2ba307aab25737'),
('a315c270b12e4b738bf6ded65a7d628c', '智能信息处理协会招新啦！！', '深圳职业技术学院东校区日新楼南6休息室', '15602313703', '2017-08-27 00:00:00', '2017-12-01 00:00:00', '2017-09-01 10:43:53', '2019-12-31 10:44:01', 'http://img.xypuxing.com/d1d0acac-475a-4d60-92b8-49fa4aeeff7b.jpg', 999, '-', '<p>\r\n	<span style="color:#333333;font-family:&quot;font-size:14px;line-height:24px;background-color:#FFFFFF;">智能信息处理协会致力于构建一个无边界的IT技术交流圈。定时举办与开展专业讲座、专业大赛等活动，寒暑期常与协会合作企业开办专业学习特训营，为学员们丰富专业知识和职业素养提供良好的机会与条件。协会项目开发主要以团队为主，贴合企业开发模式，为每一个学员找准定位。积极鼓励和帮助协会成员申请创客项目、创新工程等项目学习机会。</span> \r\n</p>\r\n<p style="text-align:center;">\r\n	<span style="color:#333333;font-family:&quot;font-size:14px;line-height:24px;background-color:#FFFFFF;"><img src="http://img.xypuxing.com/911ec2c5-33d2-4c24-8228-e20866c487e5.jpg" alt="" /><img src="http://img.xypuxing.com/54e5aa20-a32f-43f0-bfab-2f07f444e1d9.jpg" alt="" /></span> \r\n</p>\r\n<p style="text-align:center;">\r\n	<span style="color:#333333;font-family:&quot;font-size:14px;line-height:24px;background-color:#FFFFFF;"><img src="http://img.xypuxing.com/5caffc3c-7634-46d9-ab76-7b5b1ea2aa5c.jpg" alt="" width="400" height="400" title="" align="" /><br />\r\n</span> \r\n</p>\r\n<p>\r\n	<span style="color:#333333;font-family:&quot;font-size:14px;line-height:24px;background-color:#FFFFFF;">指导老师</span> \r\n</p>\r\n<p>\r\n	<span style="color:#333333;font-family:&quot;font-size:14px;line-height:24px;background-color:#FFFFFF;">赵志强 &nbsp;连国云<br />\r\n<br />\r\n<br />\r\n协会办公室<br />\r\n东区日新楼南6休息室<br />\r\n<br />\r\n<br />\r\n主要研究方向<br />\r\nWEB前端 &nbsp;WEB后端 &nbsp;智能硬件<br />\r\n<br />\r\n</span> \r\n</p>\r\n<p>\r\n	<span style="color:#333333;font-family:&quot;font-size:14px;line-height:24px;background-color:#FFFFFF;"><span style="color:#333333;font-family:&quot;font-size:14px;line-height:24px;background-color:#FFFFFF;">智协，为构建优质的学术交流圈不断努力着，期待智协未来建设也有你的身影！</span><br />\r\n</span> \r\n</p>\r\n<p>\r\n	<span style="color:#333333;font-family:&quot;font-size:14px;line-height:24px;background-color:#FFFFFF;"><br />\r\n</span> \r\n</p>', '2017-08-29 13:37:13', 1, NULL, 'f195bce867d94750bbbd6b0943aac922'),
('b221f0fc9bf841189fa17b3c46565349', '这是测试标题啊', '时发生地方', '13612345678', '2017-11-30 18:50:00', '2017-12-07 11:35:00', '2017-11-13 13:35:00', '2019-12-31 10:44:01', 'http://img.xypuxing.com/a23382717cd741039b273e35310397ff', 0, '0', '方式地方上的<img\n  src="http://img.xypuxing.com/edb9f21ac34f434c950ad23b76d96c6a" alt="" />', '2017-11-11 11:46:29', 0, NULL, 'e6c2b0a9154547238f884131ae32cd89'),
('c4ac179a1eee4c0b8f80c4b5b722240f', '计算机工程学院律委棋牌活动', '深职院东校区足球场', '15602313703', '2017-10-01 00:00:00', '2017-10-02 23:59:00', '2017-09-01 10:43:53', '2019-12-31 10:44:01', 'http://img.xypuxing.com/d4d1a22026aa4792a8aabbc817d8d76d', 40, '-', '<div style="text-align: center;">  <span\n  style="line-height: 1.5;font-size: 32.0px;">一起组队狼人杀?</span> </div>\n <div style="text-align: center;">  <span\n  style="line-height: 1.5;font-size: 32.0px;">和陌生人PKuno?</span> </div>\n <div style="text-align: center;">  <span\n  style="line-height: 1.5;font-size: 32.0px;">非竞技是玩跳棋、五子棋、飞行棋?</span> </div>\n <div style="text-align: center;">  <span\n  style="line-height: 1.5;font-size: 32.0px;">我们提供机会，你们来吃喝玩乐</span> </div>\n <div style="text-align: center;">  <span\n  style="line-height: 1.5;font-size: 32.0px;">一起欢度国庆。</span> </div>\n <div style="text-align: center;">  <span\n  style="line-height: 1.5;font-size: 32.0px;">地点:东区足球场 </span> </div>\n <div style="text-align: center;">  <span\n  style="line-height: 1.5;font-size: 32.0px;">时间:10月2号19.00-21.00</span> </div>\n <p style="text-align: center;">  <span\n  style="line-height: 1.5;font-size: 32.0px;">要提前报名哦</span> </p>\n <p style="text-align: center;">  <span style="line-height: 1.5;font-size: 32.0px;">\n    <img src="http://img.xypuxing.com/d9c8daf5492b4a85bd23cc00eb866835" alt="" />\n    <br /> </span> </p>\n <p style="text-align: center;">  <span style="line-height: 1.5;font-size: 32.0px;">\n    <img src="http://img.xypuxing.com/5c911b376b12432ab962ef5817b2967a" alt="" />\n    <br /> </span> </p>', '2017-10-01 10:46:49', 1, NULL, 'e254a5665adb4c7496873bacb1354b1b'),
('sdfsdf', '测试标题', '这是地址', '13612345678', '2017-09-27 22:24:00', '2017-10-27 22:24:00', '2017-09-13 00:00:00', '2019-12-31 10:44:01', 'http:www.sdfsdf', 123, '这是简述内容', '这是活动内容', '2017-10-08 12:33:50', 0, NULL, '');

-- --------------------------------------------------------

--
-- 表的结构 `px_act_rec`
--

CREATE TABLE IF NOT EXISTS `px_act_rec` (
  `id` int(11) NOT NULL,
  `aid` varchar(32) NOT NULL COMMENT '活动/讲座id',
  `at` int(11) NOT NULL COMMENT '0活动 1讲座',
  `index` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `px_act_rec`
--

INSERT INTO `px_act_rec` (`id`, `aid`, `at`, `index`) VALUES
(0, '63b7f49573de45f78223ab6446d4cf58', 0, 0);

-- --------------------------------------------------------

--
-- 表的结构 `px_act_review`
--

CREATE TABLE IF NOT EXISTS `px_act_review` (
  `id` int(11) NOT NULL DEFAULT '0',
  `uid` varchar(32) NOT NULL COMMENT '用户id',
  `aid` varchar(32) NOT NULL COMMENT '活动id',
  `content` text NOT NULL COMMENT '评论内容',
  `goodTag` int(11) DEFAULT '0' COMMENT '点赞标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `px_act_tag`
--

CREATE TABLE IF NOT EXISTS `px_act_tag` (
  `aid` varchar(32) NOT NULL COMMENT '活动/讲座id',
  `t` int(11) NOT NULL COMMENT '标签类型(0：活动标签，1：用户群体标签)',
  `tid` int(11) NOT NULL COMMENT '标签id',
  `at` int(11) NOT NULL COMMENT '活动类型(0:活动 1：讲座)',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `aid` (`aid`,`t`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

--
-- 转存表中的数据 `px_act_tag`
--

INSERT INTO `px_act_tag` (`aid`, `t`, `tid`, `at`, `id`) VALUES
('6bc704d6e95f482a94137f93d5e429db', 0, 1, 0, 1),
('6bc704d6e95f482a94137f93d5e429db', 0, 2, 0, 2),
('6bc704d6e95f482a94137f93d5e429db', 1, 1, 0, 3),
('63b7f49573de45f78223ab6446d4cf58', 0, 1, 0, 4),
('63b7f49573de45f78223ab6446d4cf58', 1, 1, 0, 5),
('63b7f49573de45f78223ab6446d4cf58', 1, 3, 0, 6),
('d388bd7a8a4847d6a42b7ea81bad67aa', 0, 1, 1, 7),
('d388bd7a8a4847d6a42b7ea81bad67aa', 1, 1, 1, 8),
('d388bd7a8a4847d6a42b7ea81bad67aa', 1, 2, 1, 9),
('d388bd7a8a4847d6a42b7ea81bad67aa', 1, 3, 1, 10),
('643d65c803954b71b661efe2aa2b2132', 0, 1, 0, 11),
('643d65c803954b71b661efe2aa2b2132', 1, 2, 0, 12),
('1deccd2173fb45259cfdf0425a719444', 0, 2, 0, 13),
('1deccd2173fb45259cfdf0425a719444', 1, 1, 0, 14);

-- --------------------------------------------------------

--
-- 表的结构 `px_lctr`
--

CREATE TABLE IF NOT EXISTS `px_lctr` (
  `id` varchar(32) NOT NULL COMMENT '活动id',
  `title` varchar(50) NOT NULL COMMENT '活动标题',
  `address` varchar(200) NOT NULL COMMENT '活动地址',
  `phone` varchar(11) NOT NULL COMMENT '手机号码',
  `s` datetime NOT NULL COMMENT '活动开始时间',
  `e` datetime NOT NULL COMMENT '活动结束时间',
  `ps` datetime NOT NULL COMMENT '报名开始时间',
  `pe` datetime NOT NULL COMMENT '报名结束时间',
  `placard` varchar(100) NOT NULL COMMENT '海报地址',
  `plimit` int(11) NOT NULL COMMENT '活动人数上限',
  `summary` varchar(100) NOT NULL COMMENT '活动简述',
  `content` text NOT NULL COMMENT '活动内容',
  `time` datetime NOT NULL COMMENT '活动添加的时间',
  `status` int(11) NOT NULL COMMENT '活动状态(0：待审核 1：审核通过 -1：审核不通过 -2：草稿)',
  `rm` varchar(100) DEFAULT NULL COMMENT '报名后提示信息',
  `lb` int(11) DEFAULT '0' COMMENT '讲座章',
  `uid` varchar(32) NOT NULL COMMENT '发布者id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `px_lctr`
--

INSERT INTO `px_lctr` (`id`, `title`, `address`, `phone`, `s`, `e`, `ps`, `pe`, `placard`, `plimit`, `summary`, `content`, `time`, `status`, `rm`, `lb`, `uid`) VALUES
('d388bd7a8a4847d6a42b7ea81bad67aa', '修改讲座标题', '这是地址', '13612345678', '2017-09-27 22:24:00', '2017-10-27 22:24:00', '2017-09-13 00:00:00', '2017-10-27 22:24:00', 'http:www.sdfsdf', 123, '这是简述内容', '这是活动内容', '2017-10-12 11:30:02', 1, '这是提示内容', 0, 'testuid');

-- --------------------------------------------------------

--
-- 表的结构 `px_tag_act`
--

CREATE TABLE IF NOT EXISTS `px_tag_act` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `i` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `px_tag_act`
--

INSERT INTO `px_tag_act` (`id`, `name`, `i`) VALUES
(1, '技术', 0),
(2, '管理', 0);

-- --------------------------------------------------------

--
-- 表的结构 `px_tag_pers`
--

CREATE TABLE IF NOT EXISTS `px_tag_pers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `i` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `px_tag_pers`
--

INSERT INTO `px_tag_pers` (`id`, `name`, `i`) VALUES
(1, '开朗', 0),
(2, '内向', 0),
(3, '闷骚', 0);

-- --------------------------------------------------------

--
-- 表的结构 `px_user`
--

CREATE TABLE IF NOT EXISTS `px_user` (
  `id` varchar(32) NOT NULL COMMENT '用户id',
  `u` varchar(16) NOT NULL COMMENT '用户账号',
  `p` varchar(100) NOT NULL COMMENT '用户密码',
  `nickname` varchar(16) NOT NULL COMMENT '用户昵称',
  `icon` varchar(100) NOT NULL COMMENT '用户头像',
  `status` int(11) NOT NULL COMMENT '用户状态',
  `openid` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `px_user`
--

INSERT INTO `px_user` (`id`, `u`, `p`, `nickname`, `icon`, `status`, `openid`, `time`) VALUES
('02bca85e00614c00b89d642bb0709b99', '17240485', '5da694a39e702a0188dd6df2e7e75e8b', '张祺', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('04536d86882f4d8dae3a3bad2aaa19f3', '16240273', '9e0dbe0657ee9ca9a935f6cb1a6b5a67', '吴雪君', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('05797d2fbcaf47c29f1323a24e8aa750', '17240075', 'c765bb76514e6829d0723c134d57b31a', '杨雯意', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('058874cfea9a4437a4a068b06755b2fd', '17240076', '9dc9eefbfef5e83669b980f864f07d82', '魏健', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('06889ecddf27492c87caef7c9e1f8f5f', '16240247', '5608f00d6b213977f0b640ce8afc5b8d', '庄斯炀', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('06f9f501750945f3b67581f387a0cc67', '17010799', 'f3d6779be66230a9703d694a82b09bfc', '张康颖', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('073d669c22924ddb83a2b550626c40ff', '16030473', 'db510c5d848e9912099d97160e666763', '王俐璎', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('07758f3f181a46039d954c61fcd83728', '17010181', 'e7df4ae72bec3e4d33515d24700dba7c', '赖泳杰', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('08e007d3ee234c58bad21eedfd7c678c', 'abc123', '5b3eac2d6a214fec81f3c6921b561f53', 'test1111', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-10 23:39:16'),
('0b9733e8678a455b8062c9d3ff47d6b3', '17010808', 'b758b8ade8cf955e31d6d7f7d8905a74', '冯雪桃', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('0be2509a3b2449e5b291b6b7b01e275d', '17240288', 'e93f7c7c4adc689611e30c70fbaa56d0', '叶楠', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('0be2b2cf191f4e95b70cf31e37465bf9', '14020681', '9d380cf856efab418375c4a7ab07db73', '姜伟', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('0e15c132fcf247cebae278d6dfe16f7a', '17010088', '26247b715e991fe2e73a16f3838ef8ae', '陈东耀', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('0e4f5c36709346719c88b23de1d4e332', '17010307', '2f8fb2edaaf586dbba56134ca8db97e6', '李金铃', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('0e509b9ee3204fbcbaf944ae4e05666c', 'QQ1935161313', 'a5ee7fe2d11bd9616b12943e0657ceae', '校园蒲行', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, 'oZGZb0bjCDz-0c6ZlBFgR21GQkb4', '2017-11-13 22:40:25'),
('0ecee4fd83944710bc4b25b5513a7780', '17240502', 'e6aada9cb17fadb57be3d0d7a3798b27', '骆恒泰', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('0edefafee0e4403b80fc378307e88977', '17240019', '889d9eeefc1561a69ba90e3591636b26', '张杰怡', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('1', 'a', 'a', 'test2', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('1103c5ad03794310991e159ed1862165', '17010462', 'cc312b9c501a83264579e9aa4f2d51c7', '梁春玲', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('128ffc39328241ca8578f5623a6fc29a', '17010896', '9183b3d27c978cd86222cd04bbb12392', '马伟伟', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('13cad542dc42475b834841b49f83cf62', '17010813', 'c05722e69db4d692f53c3d573b73d71d', '刘鉴锋', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('1426c6bc735943d2a7c28bc46b064470', '16240678', 'b37fb5056321f50893d3c2b9f0220a1e', '韦富', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('153d9202135f498a80da6a77a8da4ad9', '17240341', '80d9d46ee36d6622fe78cb41235fca5f', '刘镇邦', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('1612878843e5431d90bf2aed7928fe57', '17250680', '1f43844726ec6a932ba627c21c7f3fac', '陈雨琪', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('16cef13f1b7c455f9879130d52cdc0a7', '17010090', '32bc0540f8bc1750179a1d56ead065e7', '丁淼霖', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('16f8deb5bd6944ce87a01543b77e0926', '16240258', '5dc107b8f7ad3eebe5289d216bd0a202', '陈镇浩', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('17a12926a40a45b1b3731c49e75322ad', '17020394', '1299ffb9f73eaad9364b9cb1a3b9ea46', '梁进武', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('17d76f30a95f4ddc8385f2c05ab25eca', '17240484', '527ad1cfb42c4ee1f724d42b7b4abdcb', '吴柳源', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('186c5b416d22484b9e01fef6a95c578b', '17240453', 'e5cd2f8927201bf476a3ed3e8c64b50d', '江础吉', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('1992af108e574554a51d5877069a76cf', '17250749', '24be29ca66057bb2103ab175a192ab61', '方金颖', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('1a65cc0625a048108328b2432a09dea3', '16240542', '6bcbc7827567512d1e012e15f4c40efc', '余茂森', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('1b21f9b40dd74c3dbd3eee24f40a8023', '17240616', 'bcc09e6f87988a54cbde7522c9b1f0eb', '陈灿锋', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('1c2b89af17744d779801982b45d6faca', 'test123abc', 'a2e04e2f67ef11cf4d11a5cafa868c0c', 'abcd', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-10 23:42:49'),
('1ccce5e2f6b64907a96774b1e6bd5c9c', '17240532', 'dd49330ba42c48cc213a5ca11dd7e54d', '余紫祥', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('208e2657d1214741928b8cdc5fccd333', '17010309', '43dee32e9763547ea0df37be4bc955e1', '李嵘', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('211a4b754fcd4d5fa139a3ab653f62b8', '17240472', '1ff32b220f79dd340152e7571eb0929a', '潘淑珍', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('2146a9be9cab489093c042b9d45087ab', '16240375', '2da828dfa1883ee2d92074d734cb32f2', '陈苑珊', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('217a35e20f5647de9b1dc65b27d1f0c8', '17240301', 'e98f5d558f78e8cc479886bb7b7564bb', '周伟华', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('23373cb3174542a39e360c8f67a5cd9f', '17010464', 'db03fd3748fbbe4fa5fc9396df4112f8', '曾榕芝', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('2347fae4db4f45699a402ad38cc739ca', '16240419', 'ca46c8dffd8be6bf64d5c8e84522cad8', '吴汉梃', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('237b20050cdc45b0a30e0345f58a7474', '15170075', '4d2b102c784080d4f84d41e7bbb9ee9a', '孙芷旋', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('2545e962140948268445334dfb76c04f', 'abcd12345', '1e9dda7346fc2f5cd0395715041c53b3', 'abcd1234', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-10 23:44:51'),
('2548d332df6b4aa1ab6daee9ddbf8a17', 'test12', '07366d42ba71c47693aab70d83dde4c8', '试试咯啊', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, 'oZGZb0QmZSGlK5rQWTzbD3FANBKU', '2017-11-03 19:24:46'),
('27a0d16d0c21409fa61ed13fc523bf28', '17240286', 'a0b3aa8a31e69d442aee25a5155a61c0', '邓嘉伟', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('28f4f297ce9a4c2da28a4be05aaf4c67', '16020187', '05bff46664e52af277d146947f4adbe1', '吴晓南', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('294222d001614b16a71db1a0f32f93ca', '17010838', '59901006d3bf29c1e452139322ea65b5', '刘佳涛', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('2b7733bf60844c909feef060b086e279', 'test123456', '183cbaeb9750c215614bf96645ce285b', 'hahahah', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-10 12:23:30'),
('2ced121338c34830ad0b5f93bc94be14', '17010814', '84e48e86a343eac55e030e19f9ade87f', '王艾梓', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('2fbd23838f594c15a050dd6ecb2b1f0c', '17010367', 'ac809ed3da35be22c5db5f9b2d2e5e0b', '沈健全', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('3096b5f676bf4970ab850e2ace6f4812', '17240295', '113ff829e5ef5990fdfdbcf1c0fab48a', '林木权', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('31ba453943cc49af9703ecfe2b241475', '17080402', '2d6bdd86c43cdf0eda05dd0d4f1d525e', '谢玉其', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('336cce38cf094a8389df737db0e6165d', '16240414', 'ab55a7eb0d5449650f3c0eaede864cdf', '黄烽恒', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('3383dccf3fb74ea3b5c7c8208bdbb37f', 'lwj123', '44f3f080f9587d9a43b4620a5f517d57', 'lwj11', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-14 17:48:14'),
('341a069f022a48939e1e8dce4304fdf3', '17240450', '8c287bcbd33a5b535045dc173adf13e7', '张晓杰', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('3782d5e25a374b2cbc30c2ad14d5e593', 'test20', 'e8e2030effd80e38eb4172b17bc81f72', '我是来测试的', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-10 23:20:28'),
('37e72237ac4444f3888bafe7e3bf34d4', '17010805', '8c3f817f04b4e3bdd60a8c90d23d2346', '陈泽娴', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('38a2da9256bd4937b3c12798ab7aed7b', '17240307', 'd8fb38f0e16907b3035d88f94540b3a4', '刘钦豪', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('39ffd0c6e61040198814f2188bf4218c', '17240600', '9d19f9412eb19d5089dc54e133331152', '李惠', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('3a717635e54c4f318b4d693d83008f45', '16240428', 'd6ddf28966caaee40e5f0f711b4c1771', '杨鸿生', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('3cedd92204f44eb59fa627418c30cd6d', '17010292', 'c8371484d16d9cd47af0c3f224300201', '黄东鸿', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('3d423a5dbcfb483ca9ecb81bc200bfdb', '17020627', 'ccd6ecac8b2aee34182f61705fbdc665', '朱惠州', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('3d94a2cfb6a946efbce5ac199c5b5ffd', '17240290', '324c60c9ce6356bb0b009d2c51e58e4d', '谢剑雄', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('3dd35d8166304482ba05a28b5833f315', '17010797', 'd33ac5ce017d82e6e77d77744b6475d9', '叶文', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('407fd4f518da42f8b266f5b8e62a996c', '17240309', '87ebd8445f34f078252ce354d219ecb6', '徐斌斌', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('409feb5875f54ea288bd61e5680a5507', '17240322', '6ae369700988c661c01211b1f96d3417', '冯杨洋', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('40f6c96563ac44238bb8cdcfd1508133', '17240274', '5b7be5781268d8004e6825b405b8c9ec', '刘陶坤', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('417c3a95de5a43428d9e681b771e6bd9', '17240027', '034670e11db8a9ae54df541301d040ac', '邱培洲', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('430169ede219410b8a86284fe67b2c25', '15240469wwy', 'd56957e2cf63b7acfebea4642986a110', 'wwyww', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2018-04-30 13:43:22'),
('437eb92b505f400b9de89e5e2961bdac', '15240398', 'fbd6cbcb2cfb17d2d4f3e003cacf0985', '洪建川', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('43d13db6220246ac9a04d8cefe6a6fa4', '17240300', 'c6598adde1e02f64eacb6bb81767ec7d', '陈诗华', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('45127358e3f74d73a9f9e2baf5a65aeb', '17010461', '470ae6b79a914b7760363a16d27f07e9', '邱俊峰', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('4535df2a720b4f8cb0381e0581f566cd', '17010503', '45fb4c1eb796358bdf5a5fe5063c3b98', '温鑫达', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('45e1e1b9969e4917b2b23efe3a4808e0', '17010454', 'dcf97d14cfd699d2c81c89226b078320', '靳翌阳', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('4758fa5f63e64fdc9ecd36447ac2511e', '17240503', '0203f622870d08de6d85604ff105b02a', '梁俊鑫', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('49468e7042dc49f4939af56ad6102818', 'test11111', '2b1a0b67fffefdca67f50d11ff68646c', 'hahaahha', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, '2017-11-10 12:20:44'),
('4b15361e55c5476bb101bc4f6d8382a7', '17240433', '29955f6c8944abf06f7e8a194425bb6b', '邵雅镟', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('4ded95aede74469f9edc6a664b8b6f0a', '16240232', 'affb2b2f9d1287de4713db893c23459d', '林曙霞', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('4e0372836f594d58b2f7375ef62be3c1', '17010107', '38a145012d23b5d0b252a5427178fdc7', '黄浩栋', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('4ffc94a26a1549c9876417a5c9ccddba', '17010453', 'de930bc3c11587b9fe9df407d9d323af', '陈泓颖', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('53349c370ebc45498be1b4285f231be5', '17240665', '88b9b33473d0ce2ac10140158b3daccd', '黄符宗', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('539d0b3570b7441da1e07ebf5390dc06', 'abcd123', 'c827f2afb2634d57bca8029c0bf654b7', 'abc123', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-10 23:41:22'),
('53a948bfc9e84a5585d9ee33a4e7cc89', '17240320', 'c99df9d931cd2df845b7b3ddfcfd4e15', '何宇星', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('542437698b194d1ca747d4db05d197a9', '17240470', '608e1bcc99a61beb4d7c282c9d45d284', '李立恒', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('54bed5e8aad34809a8995134a5c06aa4', '17240445', 'eec9347454b8d10c25cf9f53eec3e04e', '陈秋明', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('55b2a48d622b4595a6fadeb683d22420', '15010495', '3d0195223bdfe5ef89b53fe3db60ea8b', '何伟杰', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('58045a106be34b08806e76cc6f2ce869', 'Project2017', '2d7f66ac4af00a2fd8428c94009b097b', 'Project', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-29 08:24:27'),
('585e4753c7564e9fa1af5cea5260a095', '17010233', 'd6e01d150f845a10c9a2db6ba4fc842d', '刘硕', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('5ac425784e81419783d90a0472e76c10', '17020624', '05daf0cdf3db06945bd43321216060c9', '罗楚轩', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('5cb66e83f2cd49dfb3fbef3d8b7a299a', '17010076', 'caca3f3f4afc102bf9cdac118e792490', '缪兆基', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('5ce3b5ca0343462da3a4cf7781fdaeb0', '17240152', '7f714a386b1a073d831bd16b34227e90', '张子健', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('5ceaf90f0cb04ce2a7dc4296cd752b58', '17240393', '75bea89484fbe46a19280be1704adccb', '肖振辉', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('5f0ed2c5d9af46a28b714e251c53f4cf', '17010885', 'df88c5a95e10697bd7727384b5d9cbae', '金王亮', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('5f7c1f4b87fb43f0bb2f58f2c9328c91', '17240135', '01e7ba9a96e38529debc1a2990ce312e', '黄玉婷', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('6088f3c62e2c4904bcff424f21915c6d', 'abc1231', '17379e7e62979531e5ce210be4b17f86', '噜啦啦了吧', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2019-03-11 06:55:33'),
('63233cb85def49ab99a5c3e935a949ad', '17010819', '0996bb135514080ac3d86beece225994', '陈楚婷', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('634526f2977d411ea5e144d265e981d5', '17240327', 'a553e67a3cd0c50f0fe06a93d7eb5439', '陈金宏', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('63c896898934414da9e297565d997f2a', 'test14', '4913758d73fbba38ccae48e207c90ef6', '6666', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-03 19:28:36'),
('64ba92e49ed447f89bc117120e9addce', 'test11', '322fb2bb2b4de1d05962a4110c471a11', 'imtest', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, '2017-10-22 11:15:47'),
('65a508666cde4d4ab694e28c482d8677', 'abcd123456', '22d37af4c5c817586c544977ca62c8bd', 'qqqqq', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-10 23:47:19'),
('674953ddc9134aad82946eb14657bb30', '16240688', 'f37cc9cea3fb9c0bd4484fe2d10c864b', '孙聪', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('6764018e83ec47e0b8c78e3177f97059', '16010188', '7f456e60fb0c3c2cda150cee444fb104', '谢杰峰', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('678a648868854226b8c11af37367ed80', 'test123', '8a88f4fffd2ab1d26ec1f5b1c0603533', 'test123', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2019-03-11 06:38:48'),
('68097044a08245c5a6de0292a4271049', '17060335', '11539126728fdd11db4cfdb4e5215486', '叶许鑫', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('68bb0e63a32d4247b10a21fbe32387e8', '17240396', 'a1cced03fdb39fe702ae188199b64ee1', '梁文贤', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('6a6c7fea86cd4cfd95766d295f20fe67', '17240312', '74dab8552bdf1dd66a3d14b7d63aadd3', '李骏诚', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('6b8b2c73af1a488b9c95bd72027eb89c', '17240478', '34e7ced14b91a21496451d45df7b2ed7', '黄岳龙', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('6dcfb099a05b4ea28e8a07b4beec0cd0', '16240401', '121a8d1e288aa3cb0f11e085164b686b', '刘凯滨', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('6e601060b5124b0185897ae4b7d6e3ba', '16240483', 'ae627cd81090ef9c6c85c633f28afaee', '黄鹏龙', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('6efaa50b17374a93979e350f0a995f51', '17010105', '0e87d6575b89d762420cf1e85fd61a69', '魏鑫平', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('7166aaa56ae44e98bb1192843a8598a1', 'lkb123', '81d898e0bd18d123595b66b18a11d328', '我是爸爸', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-07 17:22:41'),
('76e750bf8f954d9bb57bd8993294cf38', '17240626', 'd8fad5ee9a867d4f67efefb8f90a0c09', '陈冠枢', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('777b6605078f4d89be040005de82238c', '17240072', '2939f9346d2b9cf3e296308767a2c855', '刘子珩', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('78b14159b9ab4cc2829e61e4d17e325e', 'admin123', '3e7c6800970e41c2bd3793a4e0c9033b', 'admin', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-17 09:47:24'),
('78e5753d475448218749197913c49c3d', '17240684', 'e00ad606665ed7b687313396ad3080ec', '王小虎', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('79c5b1738cb744c794375529cbbe1e65', '17010479', 'd0b6b605f38fd11eb915555f9b6d9889', '黄子洵', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('7a9ad12069f443c8a7413a682fd07b88', '17010480', 'f896e01ddc138b10bb987fe38e5729e2', '黄家献', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('7b4d6a6698ff4e1f9927412c5fbaf487', '16240422', '4498367e6ff7657c326a055d603fe3d7', '吴永威', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('7b6388700fed4b9f8ff47f0dcecea3bb', '17010901', '42142a17ac33fafd8c3ef88ac3ddd2e1', '张军虎', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('7c234ccba21d4a21b4c2a5e4f9b8b874', '17010380', 'aa5b7e3e388f9aa218a2fc5a90fbd85e', '莫森贤', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('7da72f1526634af6bd7dbcd18d15c49e', '17240025', '7f744e5d852a0829e8a05e87216f3722', '林伟金', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('8008940747d1470f9e2d8d7204737502', '17240092', 'd2c46db7102390aac241eb35893bbd64', '黄伟焊', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('8041c8b37f024e438c56dd14c0a2d653', '17240523', '97d0329f9d66ff820e3a82a83fd7ee7c', '蔡康盛', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('80fb2d07e282446eb21486b801f80c6b', '17240622', '4e9caaa7de37bc890d6872c5b6c8a631', '杨巧', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('8152ac30a24c40428c45827a3922aa21', 'test888', 'd335151a4ed82ca7bf96e02ad5108ec0', 'test888', 'http://img.xypuxing.com/header.png', 0, NULL, '2019-03-11 07:43:59'),
('81ec7ecab8fc4d3c8a0501a2a780f96a', '17240351', 'c873cf7ae593537941e2e8b2be86c048', '伍金明', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('8227acc2d67e4399b20f1cb1a6203f6c', '17240360', 'd8b52665cea318bc91d1e83b5c63e65f', '陈钰淞', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('83163a4196e044039c6c10c3e6a6371d', '17010180', '527ed372b928cacd5e65c87fed8d229d', '陈李恒', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('83e8d166d8914fa19b8ea75242ab0ba8', '17010489', '682d98f9cd6a59164d3898c0127a7dd3', '马文旺', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('852c16965deb43bcb9270956246b8c36', '17240504', '75ba14df7df1cf16a71aeac1ab86fe49', '王仰浩', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('85a9dc6800ff4b7ba1639e848b934514', '17240147', 'a5d47d73e76754843e5a26b0196c3c58', '陈绍基', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('865bcf18eced42f28f2b495a45882b67', '17240348', '413e8c3e6ec7738f3e0b1e45f4a03e4a', '饶冲', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('87318945db8242478d8df44a9fb2420d', '17240642', 'fc3cabfbb300dce0436525fce0f9ab32', '张木声', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('87a871007b9c43ec89cc7f3ef7e766a8', '16070148', '333bd81b28e6e8b9f1c18bb134b02eec', '张雪瑜', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('8a0be0bb80fd4c63ab6ff57cb090b291', '17010364', 'b9937f4a3ded45190e7cfb848eaa3446', '张嘉棋', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('8a642874ea2a4eaeaa447049c351b85e', '17240660', '2265d4b3a1afd5637aa12d7c46ba16d7', '王鹏程', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('8b5b93eaac374fefaffd10a987e6ef46', '17240673', '11f76136151d325a1f93f30812561b46', '徐彦', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('8b673275975847e2be70c837c194e332', '16120042', 'a38592ec78d07094600a368e91ab977c', '梁润榕', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('8d67c9d958774833bb764dd089f9cb66', '15010339', 'baae1a42a25175faa8458589e0783de6', '汪志浩', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('8f56df2e756043a39af207e1086ed162', '17250429', '46d50a4a29ca57c8a1dbcc785b71010f', '余鑫', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('9170152571144ad08dd3eaa7bbf36069', '17240292', 'fbd8db89305632c0eb938ef9b4a646b0', '张泽雄', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('924508a6f47a43b39365680df90ed5f1', '16240308', '4dda20596b6a41c7a3286605f87f881c', '郑聪颖', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('9307f7cf36a242c9918cfbcb7f365344', '17240641', '4408b418db11576ee40336cb02948861', '张璇', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('93805c028cd54cd79449739ec27a344f', '17240296', 'c60efe2a16adacc13fe3145449d45927', '李文隆', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('939a635bb9cf4a26a86f95bd76f4453c', '15010540', '64631c9f0d91d482a0d88e209180a008', '莫金海', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('9530a3343ece451bbbc592e7c66c91d9', '17010655', 'a9b0f8cc5c36b561de31302d3b8e5800', '纪泽斌', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('96a66bd5daa249c28f5f971e73c09b9d', '17240203', '26311b3e810f30b3e3b68b3091717690', '杨泽展', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('97eb79f26cfa49db9ab02146deaaa9d7', '13020719', 'f21e2b29f3c7ecb70b48772f21e8f7d2', '龙清泉', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('984c60ca8a4e4c2288b5e0199c278fa1', '17240316', 'c4b7a7e6ec35334d919adc013b8934a1', '胡琪', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('9aae526b1e664c9c80fde751d788a5a1', '16240389', '1e68c10da5444b7b2369b05d0b63f28b', '郑晓莹', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('9ab7983e5f764387ab964ef279b94629', '17010459', '1e60ef2278b960641b1aea3da0943151', '徐巧敏', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('9be54248aaa940dd83a1b6a376c805b8', '16010489', 'af75b4133c4ea9bb7df5f1dcbb2a9494', '吴晓旋', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('9f2c83ff01154ed78a1348908c0fad99', '15240334', '716eedc333e14fca377e6df6aba1a4f7', '韦耿林', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('9fc1589d8fd64f05bed5630b3d943914', '17010484', 'ead9f773e1094d9ca3bf3906c8e0c950', '王晓婷', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('a017c1f46b704af495f919a436fe5cf8', '17240643', 'd4104316b9a239ccc1a7da634cf6d3e0', '彭燕玲', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('a2335ff061e54008908c6b8aacd88a2e', '17240577', '37b79a16ac2aa222a9c5c84c8edc6381', '刘威', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('a26c7b6b59934ad98bdd1bdea5ee3358', '17240306', '16e67bb7090c55e0126c62570116433e', '蔡嘉成', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('a2879d1a6bc24b869dccfa8213e0a329', '17240587', 'c7728c6dcb0dcfbbae25d6817ae63e81', '叶申', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('a3eaaca0c2104673afb3fd7a8ed213b3', '17010079', '1b4c327323b781a29d62f99795e559f7', '赖奕鸿', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('a43be341022a4107a8ef895d71a2876f', '17010466', '25fe758f9d5fdf3557b4faf9dfc8c492', '陈志刚', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('a580bd70f1f1434f9db280d71a7cd53d', '14010029', '71e981efbe57d9af507d895a3080cfee', '钟易霖', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('a6b27d7632dc448eb4896151b2347a94', '17010465', '2c55335ea83b7e113720647221d87869', '陈浩林', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('a73eeba628ad45fbb53ad2112279a8fd', '15240469', 'a324d2ae2f95e75b091f04212b710c0f', '王婉宜', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('a99b5764eba44ed0bc766c4493244011', '17010467', '92a85bac8bc5d02c040aee6ca20994fb', '温可妮', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('ab17dff88d354fbea20e77cfb04521cc', '17010656', '23643d700953ba5f8884421594d526b7', '孙冠林', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('ac56bceb93f04961b91a40084a3e464a', '17210022', '49b70d62a48a52ab997c581109bee6aa', '陈嘉仪', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('ac5e950a453d40eb989232403fa30331', '17010089', '4d67bd4534ced4d92bd68848bfb853e5', '康润', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('ae0b79f9581748168813a8c4d8ef01aa', '17240421', '2acce57598130581289cae3b77078ed7', '林晓婷', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('ae971ea26cb5442fb5c0929d1b56bab5', '17240298', '69f7cfda180db3d3fa445558c0c42451', '黄世隆', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('aeeae0b42901496a82b491a801e64a65', '17010795', 'a574e793dae460fd4c1a475aca33dcb0', '曹钰', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('af6fc78759ca4d509214de98582777e6', 'zxk1997', 'ffe9dff0709500e4561e03975fe67dce', '我是名字', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('af835a4cb7fe47f7aab71fc313df5dd6', '17010485', '34a0433cbb7632b78bfc43b057d36fb7', '梁顷', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('b1508fa05b544983a1ce7c077892741f', '17240621', 'cec9e1893e54e24cc0ebdfbd7bad36b4', '程超飞', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('b24485fef6fe46e284c48e5304a31bcd', '17010807', '1be6db5b04570ca153ed3a6921c4a071', '钟倩', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('b2893d7f87c147cdb7161b884f63a52e', '17010798', '78137cae1777db2ced1a4883e5dc69ed', '陈欣燕', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('b3e792cd18f94b9ea4dcd4804ffcc57d', '2017skyhyx', '4c9f2ba3b29e143246682082c87cf219', 'skyhyx', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-29 00:33:33'),
('b4070035599e4661b047d1207716af17', '16240407', 'ea6c5b769a3ef2bbc050e90bdce6c696', '许潮斌', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('b740f9cdb1074e17b823bde91f97b1bf', '17240321', '48b58f452b4edd90587f2e959a5da879', '孙望伊', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('b8b4a9a5fa34419889cca5e464c31c2d', '17010483', 'ab3880571d054bf8d09ffa1849da678b', '蔡晓敏', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('b9d5058193a14eedadb4cc59b27beccb', '17010666', '9633758982d50920afb6a9a07ca4b3a6', '彭家健', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('ba54e00313474f04b095f58c03f60939', '17010282', 'b78872c54716c3d145cfa3ea190a4d1b', '严智文', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('bc369e0221444eaf8f4655becc849352', '17240492', '7123029769020fd82c75ca8ecf26e070', '谭丽欣', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('bc55755f7c4940579af942f337be3f42', '17010828', '935b2d2176f236aee0808188a3abf509', '朱逸晗', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('bcffb8f3c3aa4f0a8c607e86e7e44cbb', '17020631', '8c47b7f2ed07fbffb594e8c097f6ebd0', '黄城炽', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('be681df21acf4a7e83236ebd93b4e445', '17240091', '5fde5bda67090983436ca14dcd1b5800', '董文丽', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('bf3c6c73ec714c41b0567ebbe5895d91', '15240386', 'db9a2b440ffba561ebc2d23f33b921e4', '郑增权', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('c251ae8a80414842abd15ce902d618a9', 'ceshi1', '9419c2f2ac1846d471545b1ae4f1491e', 'ceshi', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-15 23:01:10'),
('c3512b191c4a42b4acc10da61ac1b334', '17010336', 'd9fdc67e97beaee2d93c29afa666a15a', '邱俊铭', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('c4ff44039d8c4e5db9ff858b8b43aa60', '17010230', 'e4c2d84cb4c136634774009388b4e0dd', '郑雯雯', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('c596d0244170473da4182a91d5b9ef60', '17240287', 'f9e0a76f39f9dc1f617bcd1b8dbe5533', '叶巧珊', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('c5ee6e34a0654e29b6f4982b0ca993af', '17240317', '77b267300b91a978528b61baa4a00772', '陈小龙', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('c65f7b1ad23f4868ab6a5b3d8f216fcd', '17240213', '8a38b5edf885f2772c19ae354a27c4c1', '冯芝漫', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('c8c60b63eecd4c7a8f218d05af66ff88', '17240372', '2f697aed74ea022011d50de7743e2239', '钟添柱', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('c8e438d46d3d4f8482e63e38f1f6bd44', '17010488', '6acd0165157d4ccba8e0fcc37a81fa1e', '钟竣恒', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('c943b2cc77574f6ca2eb7b3ecd6fa2a2', '17240557', '507ec0475a739ee1ae4f77554ec234aa', '郑思政', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('ca2a60729e944d9bb49f5c3240ddaf75', 'a123456', 'ecec5dd339519c02701df79071119a1e', 'nihaoa1', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2019-03-11 06:07:23'),
('cc7ac5c522444b2ebee0b22012f37777', '17240319', '6b1bae3092986fdc3675dd064214961f', '刘晓安', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('ccacfa14ceb44085b78bb1bc9be4863f', '16240394', '9621c1e56b474d62a7cab7b49190a950', '张浩', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('cd74296e90854dc9ab29ccea0086eb6d', '14240051', '680da77ee37420604f0097b03affd8c2', '詹礼嘉', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('cdadc8381ae94ffeb533d339ce6dae03', '17010522', 'ce1f995f8310c5b66ec1643a7749c5b0', '李茂延', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('ce0ece00e29d4a029e2d3e300ce34dbc', '17240245', '9fc55ccf32bfa22409aa045b45541526', '钟宝宏', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('d131a7a2ba9a4cddad94fe7a3f5441a2', '17240108', 'ad89be6b117024135daa85fb943eff96', '郑泽伟', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('d19a27589a9247ec8d01a7be6a1e9489', '17240078', '3fc1dcf3c2cf7931be96fb7861618c71', '余锦楷', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('d248519fae6d4625b195ac24c0cb9fae', 'lulala123', '4746191fed3ee8528573fd053991bdbd', '狗崽子啊', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, '2019-03-11 06:49:09'),
('d263b26de7fa49a98d3936819ea5bb76', '15010462', '365491100d8816b3e02f3397fde3fb9c', '陈奕锦', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('d44ce5abb7ac4fb798670f368e1ffc87', '15240451', '7991a56602c5335f580203e220b5b63e', '张文意', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('d45c76230bd440318d2ba307aab25737', '16240364', '1ec319c961db9e443cff771f57179d53', '苏泽健', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('d48068f639754c5893c45b2d355d8d3e', '15010142', '08d41e9b306af9356b578cd9c144506b', '黄东柱', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('d5539731999a4234b1d5fd4f51ef3c15', '17010809', '0c33542559f67360c0ee11d572dcd122', '叶泓滨', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('d608b2f4fbbe49f2bc74530610427761', '17010567', '5b24654d04c8348bff53ec568d99d7c3', '蔡宇桁', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('d64461a96b4a4ac8b4c6b156ae73a00c', '17240511', '59c3553568d6c52bcdf4f6b4d3be6de6', '陶芳志', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('d6ffa99259e34926b36f0343dec01ca0', 'admini123', '89786e892793899780a9b1955af2fcb4', 'admini', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-15 17:09:12'),
('d9d7e367e67a4a2d98b3b611a49bc243', '1234567xiao', 'd540fbbf5238db3f463ab1914f051347', 'YE先生', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-12 00:54:29'),
('db024189b60e419083d462804fb74efa', '16240029', '7b01fb035894c28edef7061b206a199b', '毛国梁', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('dbc673089fca49dca4185df9006259d7', '16240293', '415d7c20b395e56a18968bf64aadd651', '邱根深', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('df603db797884d0bb37ec4498c1347e9', '17240087', 'bf463291e1275998aa0bed2217d3bb97', '罗松镇', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('dfe763d58b1e421691da184f41320b58', '17010379', 'b6dadf5985f6163fd69fb2bb657a7ec4', '陈卓佳', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('e18053bd07da4f1290b8d0402a54f621', '15010056', '84651271f151e7eece9c6820297f8b9b', '蔡昌君', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('e254a5665adb4c7496873bacb1354b1b', '16240396', '6f2e0417880db2a150262093a95691a1', '李锦升', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('e37830d99b924435916d1c2c56fb8560', '17240162', '53aeb536e3a6c2c441eaea3c7e8a68cd', '陈洁彬', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('e38fc3da95d7444cb068eda6baeb0c21', '17010858', '54fc5ec4288041ccd4eb3f04a2e012a3', '陈明坤', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('e40ac7397c254b25bcfdc8df97652af4', '17240310', '1d9abb5a9afa76184b3eca03dbb1f386', '张家庆', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('e446fe2ef27f4360bf239185c582e2e0', '16240286', '55ab4475f0468407167626d0edc46400', '欧振鹏', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('e44bd04174354907842c10b18b8c7d8b', 'test10', 'bb2d4194e16499ec8d855a65d8b8df1c', 'testuser', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, 'oZGZb0R58339spkDVTSYyntg1FpE', '2017-10-22 11:14:40'),
('e46654415ef143bdae21ccabb902d162', '17240424', 'fb0105b1f3b818ef324ad3972324dc62', '杨明鑫', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('e4d021fdfd2f4819b8feb05a98786120', '16240374', 'e01f179c7144333d764ce6b36e4b009c', '肖伟庭', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('e52bb2e6c3f847a39a5aa1a99b8f873e', '17010303', '462c7cfb603eb272f12dc5d5e3f893a0', '冯子芸', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('e6c2b0a9154547238f884131ae32cd89', '16240319', 'ca8d76bc016369c85d034402fde4210c', '郑祥坤', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('e7699c7f4b724864a70e2e3a4ab6d6fc', '16240536', 'd82fb8ec9a42834a4601c94b4f24c85f', '张泳', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('e76a2f135ae4435897feb48192375e28', '17010800', '2f79ceb09111568d4c84a5ff3ddd4385', '关小梅', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('ec4c35b94598491892188c62d3f3d399', '16240249', '0c3afaa2112b4bd5c7e238a63907d3aa', '顾吉娜', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('ec8e856a1e4748fa9aa2e2f137921e9c', '17020829', '833a74f7d7673e27a69cd9472cb5563b', '赖鹏鸣', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('ed1d3e9ca1b2465b9d619c0dbb8364f7', '17240399', '6fc13f2fea9db1fda2867f7d894a0e71', '吴帆', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('edba89b7db0049bbb7932e2a49c150ff', '17240581', '4b49cf9ec68b9a1471f2e2248a23f3e9', '杨琳', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('ef0f65fab7ee4e718a40dae58e605471', '17010320', '27e64ef68de40b26d1f7a591543edae2', '吴侦源', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('ef16261fb47141598bcbde231aea77da', '17240291', '6b8da0236b30e8be7287e7c2eaafef38', '陈桂兰', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('ef2336ab5a3742829af3d7ca6b4c3d28', '17240313', '74754a5983b362a2ce73112cda2f652b', '方子豪', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('f014fc9560b44c92a1a59fd8b115117d', '17240314', '3fce4084c0b5703657a9baf2f883f527', '张慧', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('f01a4df43e4245a498f0530199fedc5d', '16240663', 'e94b4ef04e9205d72100f169a4879cc7', '胡邦柳', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('f195bce867d94750bbbd6b0943aac922', '16240370', '91f898632bffa2899cec08c39f3ffe16', '张壮耿', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('f1ed725559154f6b9b8ecca278b7832c', '16240571', '41ee942c9c45d0a5a5fedd10cfbccb09', '李子健', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('f23255d8fe4b43a4a77497ded677bf61', '17010106', 'da95aa09161f1e3c7db8f759fd30630b', '王佳钦', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('f5ac7fa3c2af45c1b8d6d68dcfbd1f49', '16010678', 'a0c724ea4b6d7fd3fb51481464a22675', '丘振翊', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('f6640d123e794c5e94872a675ba992a0', 'test999', 'd0414f7848df31d7b2934976d108e761', 'test999', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2019-03-11 07:34:44'),
('f701804fc1e94b31980133ba051e4683', 'a370246412', '0094f727d7e618a11111339bae41c474', 'zhangjq', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-11 15:14:30'),
('f92c9cbd5b414e0eaa8a4404d16455b7', '17240074', '8960c5d3ff39877bb639f92921570858', '朱丽云', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('faff745badb9495ab7ae33a4c36bee4f', 'test111', 'e200f72a5a79763440101719e266d1bb', '你好啊啊', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-07 17:15:13'),
('fbcf53b510d847ed8bffade6f7b542aa', 'test456', '394b06c4eb442fc3aa94c94648f09282', 'sjfsd', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, '2017-11-10 23:37:13'),
('fbdc371e5ce54f9b86d18669b5467813', '17010163', '41e4966637b3065331a3f65538e8f2e0', '赖泽锋', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('ff9f18866a9b4166907230ef466f741b', '17240303', '503c104287387febe079f999c93ab236', '黄杰睿', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('testuid', 'test', '123456', '测试用户', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 1, NULL, NULL),
('thisid', 'testuser', '123', '这是名字', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, NULL),
('这是uid', '这是账号', '这是密码', '这是姓名', 'https://avatars2.githubusercontent.com/u/29366999?s=400&v=4', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `px_user_partake`
--

CREATE TABLE IF NOT EXISTS `px_user_partake` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(32) NOT NULL COMMENT '用户id',
  `aid` varchar(32) NOT NULL COMMENT '活动/讲座id',
  `phone` varchar(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `at` int(11) NOT NULL COMMENT '0：活动 1：讲座',
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- 转存表中的数据 `px_user_partake`
--

INSERT INTO `px_user_partake` (`id`, `uid`, `aid`, `phone`, `email`, `at`, `time`) VALUES
(1, 'testuid', '63b7f49573de45f78223ab6446d4cf58', '123456789', '123456@qq.com', 0, '2017-10-15 11:33:10'),
(2, 'testuid', '643d65c803954b71b661efe2aa', '123456789', '123456@qq.com', 0, '2017-10-15 11:33:27'),
(4, '1', '63b7f49573de45f78223ab6446d4cf58', '123456789', '1232qq.com', 0, '2017-10-15 15:11:09');

-- --------------------------------------------------------

--
-- 表的结构 `px_user_relation`
--

CREATE TABLE IF NOT EXISTS `px_user_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT '0' COMMENT '0：黑名单',
  `fid` varchar(32) NOT NULL COMMENT '发起方uid',
  `tid` varchar(32) NOT NULL COMMENT '接收方uid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `px_user_tag`
--

CREATE TABLE IF NOT EXISTS `px_user_tag` (
  `uid` varchar(32) NOT NULL COMMENT '用户id',
  `tid` int(11) NOT NULL COMMENT '标签id',
  KEY `uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `px_user_tag`
--

INSERT INTO `px_user_tag` (`uid`, `tid`) VALUES
('uid', 0),
('uid', 2),
('test', 1),
('test', 32),
('test', 4);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
