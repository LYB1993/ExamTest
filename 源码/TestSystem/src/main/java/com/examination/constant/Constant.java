package com.examination.constant;



public class Constant {
	//////////////////////////
	public final static String TABLENAME_ExamPage = "T_ExamPage";
	public static final String COLUMNNAME_EXAMPAGE_UNIQUEID = "N_ExamPage_UniqueId";
	public static final String COLUMNNAME_EXAMPAGE_EXAMNAME= "C_ExamPage_ExamName";
	public static final String COLUMNNAME_EXAMPAGE_CHOICENUM= "N_ExamPage_ChoiceNum";
	public static final String COLUMNNAME_EXAMPAGE_CHOCESCORE= "N_ExamPage_ChoiceScore";
	public static final String COLUMNNAME_EXAMPAGE_JDNUM= "N_ExamPage_JDNum";
	public static final String COLUMNNAME_EXAMPAGE_JDSCORE= "N_ExamPage_JDscore";
	public static final String COLUMNNAME_EXAMPAGE_TESTTIME= "N_ExamPage_TestTime";
	public static final String COLUMNNAME_EXAMPAGE_DIF= "N_ExamPage_Dif";
	/////////////////////////////////////////
	public static final String TABLENAME_AnswerSheet = "T_AnswerSheet";
	public static final String COLUMNNAME_ANSWERSHEET_ID = "N_AnswerSheet_Id";
	public static final String COLUMNNAME_ANSWERSHEET_USERCODE = "C_AnswerSheet_UserCode";
	public static final String COLUMNNAME_ANSWERSHEET_EXAMNAME= "C_AnswerSheet_ExamName";
	public static final String COLUMNNAME_ANSWERSHEET_CHOICEANSWER= "C_AnswerSheet_ChoiceAnswer";
	public static final String COLUMNNAME_ANSWERSHEET_OTHERANSWER= "C_AnswerSheet_OtherAnswer";
	///////////////////////////
	public static final String TABLENAME_Error = "T_Error";
	public static final String COLUMNNAME_ERROR_ID = "N_Error_id";
	public static final String COLUMNNAME_ERROR_EXAMNAME= "N_Error_ExamName";
	public static final String COLUMNNAME_ERROR_SUB= "C_Error_Sub";
	public static final String COLUMNNAME_ERROR_USERCODE= "C_Error_UserCode";
	public static final String COLUMNNAME_ERROR_NUM= "N_Error_Num";
	///////////////////////////////
	public static final String TABLENAME_ExamChoice = "T_ExamChoice";
	public static final String COLUMNNAME_EXAMCHOICE_ID = "N_ExamChoice_Id";
	public static final String COLUMNNAME_EXAMCHOICE_EXAMNAME= "C_ExamChoice_ExamName";
	public static final String COLUMNNAME_EXAMCHOICE_CHOICEID= "N_ExamChoice_ChoiceId";
	public static final String COLUMNNAME_EXAMCHOICE_CHOICESCORE= "N_ExamChoice_ChoiceScore";
	public static final String COLUMNNAME_EXAMCHOICE_NIQUEID= "N_ExamChoice_uniqueid";
	///////////////////////////////
	public static final String TABLENAME_ExamJd = "T_ExamJd";
	public static final String COLUMNNAME_EXAMJD_ID = "N_ExamJd_Id";
	public static final String COLUMNNAME_EXAMJD_EXAMNAME= "C_ExamJd_ExamName";
	public static final String COLUMNNAME_EXAMJD_JDID= "N_ExamJd_JdId";
	public static final String COLUMNNAME_EXAMJD_JDSCORE= "N_ExamJd_JdScore";
	public static final String COLUMNNAME_EXAMJD_NIQUEID= "N_ExamJd_uniqueid";
	///////////////////////////////
	public static final String TBALENAME_Questions = "T_Questions";
	public static final String COLUMNNAME_QUESTIONS_ID = "N_Questions_QuestId";
	public static final String COLUMNNAME_QUESTIONS_BELONG = "C_Questions_QuestBelong";
	public static final String COLUMNNAME_QUESTIONS_ANSWER = "C_Questions_QuestAnswer";
	public static final String COLUMNNAME_QUESTIONS_SCORE= "N_Questions_QuestScore";
	public static final String COLUMNNAME_QUESTIONS_SUBJECT = "C_Questions_QuestSubject";
	public static final String COLUMNNAME_QUESTIONS_QUESTA = "C_Questions_QuestA";
	public static final String COLUMNNAME_QUESTIONS_QUESTB = "C_Questions_QuestB";
	public static final String COLUMNNAME_QUESTIONS_QUESTC = "C_Questions_QuestC";
	public static final String COLUMNNAME_QUESTIONS_QUESTD = "C_Questions_QuestD";
	/////////////////////////////
	public static final String TBALENAME_QuestScore = "T_Score";
	public static final String COLUMNNAME_QUESTSCORE_ID = "N_Score_Id";
	public static final String COLUMNNAME_QUESTSCORE_EXAMNAME= "C_Score_ExamName";
	public static final String COLUMNNAME_QUESTSCORE_EXAMTIME= "D_Score_ExamTime";
	public static final String COLUMNNAME_QUESTSCORE_SNO= "N_Score_Sno";
	public static final String COLUMNNAME_QUESTSCORE_USERNAME= "C_Score_UserName";
	public static final String COLUMNNAME_QUESTSCORE_SCORE= "N_Score_Score";
	//////////////////////////
	public static final String TABLENAME_User = "T_User";
	public static final String COLUMNNAME_USER_ID = "N_User_Id";
	public static final String COLUMNNAME_USER_CODE = "C_User_Code";
	public static final String COLUMNNAME_USER_PWD = "C_User_Pwd";
	public static final String COLUMNNAME_USER_NO = "N_User_No";
	public static final String COLUMNNAME_USER_NAME = "C_User_Name";
	public static final String COLUMNNAME_USER_IDENTITY = "C_User_Identity";
	public static final String COLUMNNAME_USER_NUMCARD = "C_User_NumCard";
	public static final String COLUMNNAME_USER_EMAIL = "C_User_Email";
	public static final String COLUMNNAME_USER_PHONENUM = "C_User_PhoneNum";
	public static final String COLUMNNAME_USER_IMAGEPATH = "C_User_ImagePath";
	public static final String COLUMNNAME_USER_EXAMNUM = "N_User_ExamNum";
	
	
	
	
	//BelongDAOJdbclmpl类中所使用到的常量
	public final static String sql_belongdao_selectExamPage = "select "+COLUMNNAME_EXAMPAGE_EXAMNAME+" from "+TABLENAME_ExamPage+" group by "+COLUMNNAME_EXAMPAGE_EXAMNAME;
	public final static String sql_belongdao_deleteByExamPageName_delete1 = "delete from "+TABLENAME_ExamPage+" where "+COLUMNNAME_EXAMPAGE_EXAMNAME+" = ?";
	public final static String sql_belongdao_deleteByExampageName_delete2 = "delete from "+TABLENAME_ExamChoice+" where "+COLUMNNAME_EXAMCHOICE_EXAMNAME+" = ?";
	
	//QuestDAOJdbcImpl类中所使用的常量
	public final static String sql_questdao_random_ChoiceMaxNum ="SELECT Max("+COLUMNNAME_QUESTIONS_ID+") maxnum from "+TBALENAME_Questions;
	public final static String sql_questdao_random_ChoiceMinNum = "SELECT Min("+COLUMNNAME_QUESTIONS_ID+") minnum from "+TBALENAME_Questions;
	public final static String sql_questdao_random_jdMaxNum = "SELECT Max("+COLUMNNAME_EXAMJD_ID+") maxnum from "+TBALENAME_Questions;
	public final static String sql_questdao_random_jdMinNum ="SELECT Max("+COLUMNNAME_EXAMJD_ID+") mixnum from "+TBALENAME_Questions;
	public final static String sql_questdao_random_insertQuestToExamQuset = "insert into "+TABLENAME_ExamChoice
																		+ " ("+COLUMNNAME_EXAMCHOICE_EXAMNAME+","
																		+ COLUMNNAME_EXAMCHOICE_CHOICEID+","
																		+ COLUMNNAME_EXAMCHOICE_CHOICESCORE+","
																		+ COLUMNNAME_EXAMCHOICE_NIQUEID+") "
																		+ "value (?,?,?,?)";
	
	public final static String sql_questdao_random_selectquestInquestions = "select * from "+TABLENAME_ExamChoice+" tq,"
																							+ TBALENAME_Questions+" qs"
																							+ " where tq."+COLUMNNAME_EXAMCHOICE_CHOICEID+" = "
																							+ "qs."+COLUMNNAME_QUESTIONS_ID
																							+ " and tq."+COLUMNNAME_EXAMCHOICE_EXAMNAME+" = ?";
	public final static String sql_questdao_findAllquest = "select * from "+TBALENAME_Questions+" ORDER BY "+COLUMNNAME_QUESTIONS_ID;
	//QuestScoreDAOJdbcImpl类使用的常量
	public final static String sql_questscoredao_findBySno = "select * from "+TBALENAME_QuestScore+" where "+COLUMNNAME_QUESTSCORE_SNO+"= ?";
	public final static String sql_questscoredao_addScore = "insert into "+TBALENAME_QuestScore
																	+ " ("+COLUMNNAME_QUESTSCORE_EXAMNAME+","
																	+ COLUMNNAME_QUESTSCORE_SNO+","
																	+ COLUMNNAME_QUESTSCORE_USERNAME+","
																	+ COLUMNNAME_QUESTSCORE_SCORE+")values(?,?,?,?)";
	public final static String sql_questscoredao_findByCode= "select * from "+TABLENAME_AnswerSheet+" where "+COLUMNNAME_ANSWERSHEET_USERCODE+" = ?";
	public final static String sql_questscoredao_addAnswerSheet = "insert into "+TABLENAME_AnswerSheet
																	+ " ("+COLUMNNAME_ANSWERSHEET_USERCODE+","
																	+ COLUMNNAME_ANSWERSHEET_EXAMNAME+","
																	+ COLUMNNAME_ANSWERSHEET_CHOICEANSWER+","
																	+ COLUMNNAME_ANSWERSHEET_OTHERANSWER+") values(?,?,?,?)";
	public final static String sql_questscoredao_findWrongQuest = "SELECT put.* from ("
				+ "SELECT (w."+COLUMNNAME_ERROR_NUM+"/"+"u."+COLUMNNAME_USER_EXAMNUM+") as rate,"
				+ "u."+COLUMNNAME_USER_EXAMNUM+","
				+ "w."+COLUMNNAME_ERROR_ID+","
				+ "w."+COLUMNNAME_ERROR_SUB+","
				+ "w."+COLUMNNAME_ERROR_USERCODE+","
				+ "w."+COLUMNNAME_ERROR_NUM+","
				+ "w."+COLUMNNAME_ERROR_EXAMNAME
				+ " from "+TABLENAME_User+" u,"+TABLENAME_Error+" w"
				+ " where w."+COLUMNNAME_ERROR_USERCODE+" = u."+COLUMNNAME_USER_CODE+") put"
				+ " where put.rate >= ? and put."+COLUMNNAME_ERROR_USERCODE+" = ?";
	
	public final static String sql_questscoredao_addWrongQuest_Select = "select "+COLUMNNAME_ERROR_ID+","
																				+COLUMNNAME_ERROR_EXAMNAME+","
																				+COLUMNNAME_ERROR_SUB+","
																				+COLUMNNAME_ERROR_USERCODE+","
																				+COLUMNNAME_ERROR_NUM+" "
																				+"from "+TABLENAME_Error+" "
																				+"where "+COLUMNNAME_ERROR_SUB+"=?";
	public final static String sql_questscoredao_addWrongQuest_Insert = "insert into "
																		+TABLENAME_Error+"("
																		+COLUMNNAME_ERROR_EXAMNAME+","
																		+COLUMNNAME_ERROR_SUB+","
																		+COLUMNNAME_ERROR_USERCODE+")"
																		+" values(?,?,?)";
	public final static String sql_questscoredao_addWrongQuest_Update = "update "+TABLENAME_Error
																		+" set "+COLUMNNAME_ERROR_NUM+"=?"
																		+" where "+COLUMNNAME_ERROR_ID+"=?";
	//UploadDAOJdbclmpl类使用的常量
	public final static String sql_uplodadao_uploadMySQL = "insert into "+TBALENAME_Questions
															+ " ("+COLUMNNAME_QUESTIONS_BELONG+","
															+ COLUMNNAME_QUESTIONS_ANSWER+","
															+ COLUMNNAME_QUESTIONS_SUBJECT+","
															+ COLUMNNAME_QUESTIONS_QUESTA+","
															+ COLUMNNAME_QUESTIONS_QUESTB+","
															+ COLUMNNAME_QUESTIONS_QUESTC+","
															+ COLUMNNAME_QUESTIONS_QUESTD+")"
															+" values(?,?,?,?,?,?,?)";
	public final static String sql_uplodadao_uploadOneQuestToMySQL = "insert into "+TBALENAME_Questions
															+ " ("+COLUMNNAME_QUESTIONS_SCORE+","
															+ COLUMNNAME_QUESTIONS_BELONG+","
															+ COLUMNNAME_QUESTIONS_ANSWER+","
															+ COLUMNNAME_QUESTIONS_SUBJECT+","
															+ COLUMNNAME_QUESTIONS_QUESTA+","
															+ COLUMNNAME_QUESTIONS_QUESTB+","
															+ COLUMNNAME_QUESTIONS_QUESTC+","
															+ COLUMNNAME_QUESTIONS_QUESTD+")"
															+ " values(?,?,?,?,?,?,?,?)";
	public final static String sql_uplodadao_addExamPage = "insert into "+TABLENAME_ExamPage
															+ " ("+COLUMNNAME_EXAMPAGE_UNIQUEID+","
															+ COLUMNNAME_EXAMPAGE_EXAMNAME+","
															+ COLUMNNAME_EXAMPAGE_CHOICENUM+","
															+ COLUMNNAME_EXAMPAGE_CHOCESCORE+","
															+ COLUMNNAME_EXAMPAGE_JDNUM+","
															+ COLUMNNAME_EXAMPAGE_JDSCORE+","
															+ COLUMNNAME_EXAMPAGE_TESTTIME+","
															+ COLUMNNAME_EXAMPAGE_DIF+")"
															+ " values(?,?,?,?,?,?,?,?)";
	
	public final static String sql_uploaddao_findByexamName = "select * from "+TABLENAME_ExamPage +" where "+ COLUMNNAME_EXAMPAGE_EXAMNAME +"= ?";
	//UserDAOJdbcImpl使用的常量
	public final static String sql_userdao_findByUserCode = "select * from "+TABLENAME_User+" where "+ COLUMNNAME_USER_CODE+"=?";
	public final static String sql_userdao_addUser = "insert into "+TABLENAME_User
															+ " ("+COLUMNNAME_USER_CODE+","
															+ COLUMNNAME_USER_PWD+","
															+ COLUMNNAME_USER_NAME+","
															+ COLUMNNAME_USER_NO+","
															+ COLUMNNAME_USER_NUMCARD+","
															+ COLUMNNAME_USER_PHONENUM+","
															+ COLUMNNAME_USER_EMAIL+") values(?,?,?,?,?,?,?)";
	public final static String sql_userdao_editUser ="update "+TABLENAME_User+" set "
														+ COLUMNNAME_USER_NAME+" = ?,"
														+ COLUMNNAME_USER_PWD+" = ?,"
														+ COLUMNNAME_USER_NUMCARD+" = ?,"
														+ COLUMNNAME_USER_PHONENUM+" = ?, "
														+ COLUMNNAME_USER_EMAIL+" = ?"
														+ " where "+COLUMNNAME_USER_ID+" = ?";
	
	public final static String sql_userdao_selectAll = "select * from "+TABLENAME_User;
	public final static String sql_userdao_delectUser = "delete from "+TABLENAME_User+" where "+ COLUMNNAME_USER_CODE+" = ?";
	public final static String sql_userdao_findpwd = "select "+ COLUMNNAME_USER_PWD+" from "+TABLENAME_User+" where "+ COLUMNNAME_USER_NUMCARD+" = ?";
	public final static String sql_userdao_addExamNum_select = "select "+ COLUMNNAME_USER_EXAMNUM+" from "+TABLENAME_User+" where "+ COLUMNNAME_USER_CODE+" = ?";
	public final static String sql_userdao_addExamNum_update = "update "+TABLENAME_User+" set "+ COLUMNNAME_USER_EXAMNUM+" = ? where "+ COLUMNNAME_USER_CODE+" = ?";
	
	
	//请在下方添加增加功能的sql语句，上方sql语句为项目必备sql，如非必要，请不要修改
	
	//添加上传图片的sql
	public final static String sql_userdao_updateImage = "update "+TABLENAME_User+" set "
														+ COLUMNNAME_USER_IMAGEPATH+" = ?"
														+ " where "+COLUMNNAME_USER_ID+" = ?";
	
	
	
}
