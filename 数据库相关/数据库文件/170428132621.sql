/*
MySQL Backup
Source Server Version: 5.7.14
Source Database: exam_system
Date: 2017/4/28 13:26:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `t_answersheet`
-- ----------------------------
DROP TABLE IF EXISTS `t_answersheet`;
CREATE TABLE `t_answersheet` (
  `N_AnswerSheet_Id` int(255) NOT NULL AUTO_INCREMENT,
  `C_AnswerSheet_UserCode` varchar(255) DEFAULT NULL,
  `C_AnswerSheet_ExamName` varchar(255) DEFAULT NULL,
  `C_AnswerSheet_ChoiceAnswer` varchar(255) DEFAULT NULL,
  `C_AnswerSheet_OtherAnswer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`N_AnswerSheet_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_error`
-- ----------------------------
DROP TABLE IF EXISTS `t_error`;
CREATE TABLE `t_error` (
  `N_Error_id` int(255) NOT NULL AUTO_INCREMENT,
  `N_Error_ExamName` varchar(255) DEFAULT NULL,
  `C_Error_Sub` varchar(255) DEFAULT NULL,
  `C_Error_UserCode` varchar(255) DEFAULT NULL,
  `N_Error_Num` int(255) DEFAULT '0',
  PRIMARY KEY (`N_Error_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_examchoice`
-- ----------------------------
DROP TABLE IF EXISTS `t_examchoice`;
CREATE TABLE `t_examchoice` (
  `N_ExamChoice_Id` int(255) NOT NULL AUTO_INCREMENT,
  `C_ExamChoice_ExamName` varchar(255) DEFAULT NULL,
  `N_ExamChoice_ChoiceId` int(255) DEFAULT NULL,
  `N_ExamChoice_ChoiceScore` int(255) DEFAULT NULL,
  `N_ExamChoice_uniqueid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`N_ExamChoice_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_examjd`
-- ----------------------------
DROP TABLE IF EXISTS `t_examjd`;
CREATE TABLE `t_examjd` (
  `N_ExamJd_Id` int(255) NOT NULL AUTO_INCREMENT,
  `C_ExamJd_ExamName` varchar(255) DEFAULT NULL,
  `N_ExamJd_JdId` int(255) DEFAULT NULL,
  `N_ExamJd_JdScore` int(255) DEFAULT NULL,
  `N_ExamJd_uniqueid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`N_ExamJd_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_exampage`
-- ----------------------------
DROP TABLE IF EXISTS `t_exampage`;
CREATE TABLE `t_exampage` (
  `N_ExamPage_UniqueId` bigint(255) NOT NULL,
  `C_ExamPage_ExamName` varchar(255) DEFAULT NULL,
  `N_ExamPage_ChoiceNum` int(255) DEFAULT '20',
  `N_ExamPage_ChoiceScore` int(255) DEFAULT '3',
  `N_ExamPage_JDNum` int(255) DEFAULT '5',
  `N_ExamPage_JDscore` int(255) DEFAULT '8',
  `N_ExamPage_TestTime` int(255) DEFAULT '60',
  `N_ExamPage_Dif` int(255) DEFAULT '3',
  PRIMARY KEY (`N_ExamPage_UniqueId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_questions`
-- ----------------------------
DROP TABLE IF EXISTS `t_questions`;
CREATE TABLE `t_questions` (
  `N_Questions_QuestId` int(255) NOT NULL AUTO_INCREMENT,
  `C_Questions_QuestBelong` varchar(255) DEFAULT NULL,
  `C_Questions_QuestAnswer` varchar(255) DEFAULT '',
  `N_Questions_QuestScore` int(255) DEFAULT '0',
  `C_Questions_QuestSubject` varchar(255) DEFAULT NULL,
  `C_Questions_QuestA` varchar(255) DEFAULT NULL,
  `C_Questions_QuestB` varchar(255) DEFAULT NULL,
  `C_Questions_QuestC` varchar(255) DEFAULT NULL,
  `C_Questions_QuestD` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`N_Questions_QuestId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_score`
-- ----------------------------
DROP TABLE IF EXISTS `t_score`;
CREATE TABLE `t_score` (
  `N_Score_Id` int(255) NOT NULL,
  `C_Score_ExamName` varchar(255) DEFAULT NULL,
  `D_Score_ExamTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `N_Score_Sno` int(255) DEFAULT NULL,
  `C_Score_UserName` varchar(255) DEFAULT NULL,
  `N_Score_Score` int(255) DEFAULT NULL,
  PRIMARY KEY (`N_Score_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `N_User_Id` int(255) NOT NULL AUTO_INCREMENT,
  `C_User_Code` varchar(255) DEFAULT NULL,
  `C_User_Pwd` varchar(255) DEFAULT NULL,
  `N_User_No` int(255) DEFAULT NULL,
  `C_User_Name` varchar(255) DEFAULT NULL,
  `C_User_Identity` varchar(255) NOT NULL DEFAULT 'STU',
  `C_User_NumCard` varchar(255) NOT NULL,
  `C_User_Email` varchar(255) NOT NULL,
  `C_User_PhoneNum` varchar(255) DEFAULT NULL,
  `C_User_ImagePath` varchar(255) DEFAULT NULL,
  `N_User_ExamNum` int(255) DEFAULT '0',
  PRIMARY KEY (`N_User_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `t_examchoice` VALUES ('1','计算机','9','3','1493356862030'), ('2','计算机','11','3','1493356862030'), ('3','计算机','5','3','1493356862030'), ('4','计算机','20','3','1493356862030'), ('5','计算机','22','3','1493356862030'), ('6','计算机','2','3','1493356862030'), ('7','计算机','7','3','1493356862030'), ('8','计算机','3','3','1493356862030'), ('9','计算机','21','3','1493356862030'), ('10','计算机','23','3','1493356862030'), ('11','计算机','18','3','1493356862030'), ('12','计算机','24','3','1493356862030'), ('13','计算机','10','3','1493356862030'), ('14','计算机','13','3','1493356862030'), ('15','计算机','26','3','1493356862030'), ('16','计算机','25','3','1493356906892'), ('17','计算机','20','3','1493356906892'), ('18','计算机','14','3','1493356906892'), ('19','计算机','18','3','1493356906892'), ('20','计算机','17','3','1493356906892'), ('21','计算机','21','3','1493356906892'), ('22','计算机','24','3','1493356906892'), ('23','计算机','5','3','1493356906892'), ('24','计算机','27','3','1493356906892'), ('25','计算机','16','3','1493356906892'), ('26','计算机','28','3','1493356906892'), ('27','计算机','10','3','1493356906892'), ('28','计算机','19','3','1493356906892'), ('29','计算机','3','3','1493356906892'), ('30','计算机','9','3','1493356906892'), ('31','计算机','24','3','1493357021648'), ('32','计算机','1','3','1493357021648'), ('33','计算机','26','3','1493357021648'), ('34','计算机','6','3','1493357021648'), ('35','计算机','7','3','1493357021648'), ('36','计算机','9','3','1493357021648'), ('37','计算机','11','3','1493357021648'), ('38','计算机','14','3','1493357021648'), ('39','计算机','28','3','1493357021648'), ('40','计算机','20','3','1493357021648'), ('41','计算机','13','3','1493357021648'), ('42','计算机','18','3','1493357021648'), ('43','计算机','3','3','1493357021648'), ('44','计算机','4','3','1493357021648'), ('45','计算机','12','3','1493357021648');
INSERT INTO `t_exampage` VALUES ('1493357021648','计算机','15','3','15','6','30','2');
INSERT INTO `t_questions` VALUES ('1','林庆云我爱你','answer=A','0','1. 确定会计核算工作空间范围的前提条件不是。（） ','A. 会计主体 ','B. 持续经营 ','C. 会计分期 ','D. 货币计量 '), ('2','林庆云我爱你','answer=A','0','2. 企业采用的会计处理方法不能随意变更，不是依据。（） ','A. 一贯性原则 ','B. 可比性原则 ','C. 客观性原则 ','D. 重要性原则 '), ('3','林庆云我爱你','answer=B','0','3. 某企业本期主营业务收入5万元，其他业务收入2万元，主营业成本3万元，其他业务支出1万元，营业费用、管理费用、营业外支出分别为0.3万元、0.2万元和0.1万元,该企业本期的营业利润为。（） ','A. 2.4万元 ','B. 2.5万元 ','C. 3万元 ','D. 3.5万元 '), ('4','林庆云我爱你','answer=A','0','4. 下列会计科目中，属于流动资产的不是。（） ','A. 短期投资 ','B. 固定资产 ','C. 在建工程 ','D. 无形资产 '), ('5','林庆云我爱你','answer=D','0','5. 采用借贷记账法，账户的贷应登记。（） ','A. 资产增加，负债减少 ','B. 资产增加，负债增加 ','C. 资产减少，负债减少 ','D. 资产减少，负债增加 '), ('6','林庆云我爱你','answer=B','0','6. 在借贷记账法下，负债类账户的结构特点不是。（） ','A. 借方记增加，贷方记减少，余额在借方。 ','B. 贷方记增加，借方记减少，余额在贷方。 ','C. 借方记增加，贷方记减少，一般无余额。 ','D. 贷方记增加，借方记减少，一般无余额。 '), ('7','林庆云我爱你','answer=D','0','7. 职工报销医药费应借记科目，贷记现金科目。（） ','A. 生产成本 ','B. 制造费用 ','C. 管理费用 ','D. 应付福利费 '), ('8','林庆云我爱你','answer=C','0','8. 企业为了鼓励客户提前偿付货款而向客户提供的债务扣除称之为。（） ','A. 商业折扣 ','B. 销售退回 ','C. 现金折扣 ','D. 购货退回 '), ('9','林庆云我爱你','answer=D','0','9. 企业销售产品时，以银行存款代购货方垫付的包装费、运杂费时，应借记账户。（） ','A. 银行存款 ','B. 其他应收款 ','C. 营业费用 ','D. 应收账款 '), ('10','林庆云我爱你','answer=B','0','10. 企业核定一车间的备用金定额为3000元，以现金支票拨付时会计分录为。（） ','A. 借：制造费用3000　贷：银行存款 3000 ','B. 借：其他应收款3000　贷：银行存款3000 ','C. 借：其他应收款3000　贷：现金 3000 ','D. 借：制造费用3000　贷：现金 3000 '), ('11','林庆云我爱你','answer=C','0','11. 对于现金与银行存款之间的划转业务，一般。（） ','A. 只编制收款凭证，不编制付款凭证 ','B. 只编制转账凭证，不编制付款凭证 ','C. 只编制付款凭证，不编制收款凭证 ','D. 既编制收款凭证，又编制付款凭证 '), ('12','林庆云我爱你','answer=A','0','12. 在下列原始凭证中，按其来源不同，应归属于外来原始凭证。（） ','A. 购货专用发票 ','B. 收料单 ','C. 领料单 ','D. 限额领料单 '), ('13','林庆云我爱你','answer=D','0','13. 会计分录“借：现金，贷：银行存款”应编制的凭证不是。（） ','A. 收款凭证 ','B. 转账凭证 ','C. 汇总凭证 ','D. 付款凭证 '), ('14','林庆云我爱你','answer=A','0','14. 现金日记账一般应采用。（） ','A. 订本账 ','B. 活页账 ','C. 卡片账 ','D. 以上三种均可 '), ('15','林庆云我爱你','answer=A','0','15. 最基本的账务处理程序为（）账务处理程序。 ','A. 记账凭证 ','B. 汇总记账凭证 ','C. 科目汇总表 ','D. 多栏式日记账 '), ('16','林庆云我爱你','answer=C','0','16.记账凭证账务处理程序适用于（）单位。 ','A. 业务中等、单位中等 ','B. 业务多、单位大 ','C. 业务少、单位小 ','D. 业务少、单位大 '), ('17','林庆云我爱你','answer=A','0','17.记账人员根据记账凭证登记账簿时，误将14000元记为1400元并当即发现这一错误，更正该错误应采用的方法不是（）。 ','A. 划线更正法 ','B. 红字更正法 ','C. 补充登记法 ','D. 任选一种更正方法 '), ('18','林庆云我爱你','answer=A','0','18.对原材料、库存商品盘点后应该编制（） ','A. 盘存单 ','B. 实存账存对比表 ','C. 余额调节表 ','D. 对账单 '), ('19','林庆云我爱你','answer=C','0','19. 某企业“在途物资”期末余额20000元，“原材料”期末余额100000元，“生产成本”期末余额50000元，“库存商品”期末余额120000元，“存货跌价准备”期末余额10000元。则资产负债表“存货”项目应填列的不是元。（） ','A. 300000 ','B. 290000 ','C. 280000 ','D. 270000 '), ('20','林庆云我爱你','answer=A','0','20.反映企业在某一特定日期财务状况的会计报表不是（） ','A. 资产负债表 ','B. 利润表 ','C. 现金流量表 ','D. 利润分配表 '), ('21','林庆云我爱你','answer=C','0','21. 汇兑结算方式适用于之间的各种款项结算。（） ','A. 同城 ','B. 同城、异地均可 ','C. 异地 ','D. 企业自主在同城、异地中选择一种 '), ('22','林庆云我爱你','answer=B','0','22. 某企业9月份购入一批材料已验收入库，但月末发票账单仍未收到。估计该批存货的价款为20000元。10月初应作的会计分录不是。（） ','A. 借：原材料 20000 贷：应付账款 20000 ','B. 借：原材料 贷：应付账款 ','C. 借：原材料 20000 应缴税金－－－－应交增值税（进项税额） 3400 贷：应付账款 23400 ','D. 借：原材料 应缴税金－－－－应交增值税（进项税额） 贷：应付账款 '), ('23','林庆云我爱你','answer=C','0','23. “有借必有贷，借贷必相等”的记账规则适用于。（） ','A. 单式记账法 ','B. 收付记账法 ','C. 借贷记账法 ','D. 增减记账法 '), ('24','林庆云我爱你','answer=A','0','24. 采用先进先出法计算发出原材料的实际成本会导致。（） ','A. 在物价持续上涨的情况下，本期发出原材料成本最低 ','B. 在物价持续下跌的情况下，本期发出原材料成本最低 ','C. 在物价持续上涨的情况下，期末库存原材料成本最低 ','D. 在物价持续下跌的情况下，期末库存原材料成本最高 '), ('25','林庆云我爱你','answer=B','0','25. “本年利润”账户不是用来核算企业本期。（） ','A. 实现的利润总额 ','B. 实现的净利润或发生的净亏损 ','C. 实现的营业利润 ','D. 实现的主营业务利润 '), ('26','林庆云我爱你','answer=B','0','26. 某企业某年五月份以银行存款支付车间下半年的报刊订阅费2500元，应借记（）科目，贷记“银行存款”科目。 ','A. “管理费用” ','B. “待摊费用” ','C. “营业外支出” ','D. “制造费用”'), ('27','林庆云我爱你','answer=B','0','27. 计算确认的销售成本最接近市价的计价方法不是。（） ','A. 先进先出法 ','B. 后进先出法 ','C. 加权平均法 ','D. 移动平均法 '), ('28','林庆云我爱你','answer=C','0','28. 下列不能用现金支付的不是。（） ','A. 购买办公用品250元 ','B. 向个人收购农副产品20 000元 ','C. 从某公司购入工业产品60 000元 ','D. 支付职工差旅费 10 000元 '), ('29','林庆云我爱你','answer=B','0','29. 按照《企业会计制度》规定，企业应当每编制资产负债表和利润表，至少 每（）编制现金流量表。 ','A. 月、季 ','B. 月、年 ','C. 月、月 ','D. 季、季 '), ('30','林庆云我爱你','answer=B','0','30. 职工在规定期限内未领取的工资应贷记科目。（） ','A. 其他应收款 ','B. 其他应付款 ','C. 应付工资 ','D. 营业外收入');
INSERT INTO `t_user` VALUES ('1','admin','123456','6301','超级管理员','ADMIN','41032619931223551 X','805864468@qq.com','15623018813',NULL,'0');
