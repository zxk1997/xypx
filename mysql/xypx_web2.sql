-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2019-03-18 09:32:45
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

-- --------------------------------------------------------

--
-- 表的结构 `px_act_rec`
--

CREATE TABLE IF NOT EXISTS `px_act_rec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` varchar(32) NOT NULL COMMENT '活动/讲座id',
  `at` int(11) NOT NULL COMMENT '0活动 1讲座',
  `index` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

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

-- --------------------------------------------------------

--
-- 表的结构 `px_manage_user`
--

CREATE TABLE IF NOT EXISTS `px_manage_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u` varchar(16) NOT NULL COMMENT '账号',
  `p` varchar(16) NOT NULL COMMENT '密码',
  `role` varchar(10) NOT NULL COMMENT '角色(admin,normal)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- 表的结构 `px_tag_act`
--

CREATE TABLE IF NOT EXISTS `px_tag_act` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `i` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

-- --------------------------------------------------------

--
-- 表的结构 `px_tag_pers`
--

CREATE TABLE IF NOT EXISTS `px_tag_pers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `i` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

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

-- --------------------------------------------------------

--
-- 表的结构 `px_user_auth_file`
--

CREATE TABLE IF NOT EXISTS `px_user_auth_file` (
  `uid` varchar(32) NOT NULL,
  `url` varchar(100) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
