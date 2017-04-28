package com.examination.cotroller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examination.dao.QuestDAO;
import com.examination.dao.UploadDAO;
import com.examination.entity.ExamPage;
import com.examination.entity.TestQuestions;
/**
 * 这个类用于文件的上传，用来生成题目
 * @author 
 *
 */
@SuppressWarnings("restriction")
@Controller
public class UploadController {

	@Resource(name="uploadDAO")
	private UploadDAO uploadDAO;
	@Resource(name="questDAO")
	private QuestDAO questDAO;
	
	
	@ExceptionHandler
	public String toExamgrowExeception(Exception ex){
		
		if(ex instanceof Exception){
			System.out.println("Exception:"+this.getClass().getName()+"   Exception is:"+ex.getMessage());
			return "error";
		}
		return "error";
	}
	
	
	@RequestMapping("UploadTXTFile.do")
	public void uploadfile(HttpServletRequest request,HttpServletResponse reponse){
		List<TestQuestions> list = new ArrayList<TestQuestions>();
		File storeFile = null;
		boolean isadd = false;
		final String UPLOAD_DIRECTORY = "upload";
		final int MEMORY_THRESHOLD = 1024*1024*3;
		final int MAX_FILE_SIZE = 1024*1024*5;
		final int MAX_REQUEST_SIZE = 1024*1024*5;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(MEMORY_THRESHOLD);	 
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);	
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);
		String uploadPath = request.getSession().getServletContext().getRealPath("")+File.separator+UPLOAD_DIRECTORY;
		File uploadDIR = new File(uploadPath);
		if(!uploadDIR.exists()){
			uploadDIR.mkdir();
		}
		try {
			List<FileItem> formItems = upload.parseRequest(request);
			if(formItems != null&&formItems.size()>0){
				for(FileItem item:formItems){
					if(!item.isFormField()){
						String fileName = new File(item.getName()).getName();
						String filePath = uploadPath+File.separator+fileName;
						storeFile = new File(filePath);
						System.out.println(storeFile);
						try {
							item.write(storeFile);
						} catch (Exception e) {
							
							e.printStackTrace();
						}
						
					}
				}
			}
			list = uploadDAO.readFile(storeFile);
			isadd = uploadDAO.uploadMySQL(list);
			if(isadd){
				request.setAttribute("message","文件上传成功!!");
				request.getRequestDispatcher("/toExamgrow.do").forward(request, reponse);
			}else{
				request.setAttribute("message", "文件上传失败!!");
				request.getRequestDispatcher("/toExamgrow.do").forward(request, reponse);
			}		
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@RequestMapping("oneQuestion.do")
	public void oneQuestion(HttpServletRequest request,HttpServletResponse reponse){
		Integer questScore = Integer.valueOf(request.getParameter("score"));
		String questSubjct = request.getParameter("sub");
		String questA =  request.getParameter("qa");
		String questB =  request.getParameter("qb");
		String questC =  request.getParameter("qc");
		String questD =  request.getParameter("qd");
		String questAnswer = request.getParameter("an");
		String questBelongTo = request.getParameter("belong");
		TestQuestions tq = new TestQuestions(questScore, questSubjct, questA, questB, questC, questD, questBelongTo, questAnswer);
		Integer dateid = (int) new Date().getTime();
		if(tq.getQuestId()==null){
			tq.setQuestId(dateid);			
		}
		if(tq.getQuestScore()==null){
			tq.setQuestScore(5);
		}
		boolean isadd = uploadDAO.uploadOneQuestToMySQL(tq);
		System.out.println(isadd);
		try {
			if(isadd){
				request.setAttribute("message2","题目上传成功!!");
				request.getRequestDispatcher("/toExamgrow.do").forward(request, reponse);
			}else{
				request.setAttribute("message2", "题目上传失败!!");
				request.getRequestDispatcher("/toExamgrow.do").forward(request, reponse);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	/**
	 * 创建一套考题，包含选择题数目，简答数目
	 * 
	 * @return 试卷显示页面（examTest.jsp）
	 */
	@RequestMapping("addExamTest.do")
	public String addExamTest(HttpServletRequest request){
		Integer choiceScore = Integer.valueOf(request.getParameter("choiceScore"));
		Integer choiceNum = Integer.valueOf(request.getParameter("choiceNum"));
		Integer jdNum = Integer.valueOf(request.getParameter("jdNum"));
		Integer jdScore = Integer.valueOf(request.getParameter("jdScore"));
		String examName = request.getParameter("examName");
		Integer examDif = Integer.valueOf(request.getParameter("examDif"));
		Integer examTime = Integer.valueOf(request.getParameter("examTime"));
		if(examDif.equals(null)){
			examDif = 5;
		}
		if(examTime.equals(null)){
			examTime = 60;
		}
		long examId = System.currentTimeMillis();
		ExamPage exampage = new ExamPage(examName, choiceNum, choiceScore, jdNum, jdScore, examDif, examTime, examId);
		uploadDAO.addExamPage(exampage);
		questDAO.randomlyGenerated(exampage);
		return "redirect:toExamdelete.do";
		
	}
}
