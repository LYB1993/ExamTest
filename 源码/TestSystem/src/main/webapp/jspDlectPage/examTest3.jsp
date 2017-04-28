<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
   <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Page</title>
	<script type="text/javascript">
	 
	  function radioChange(tag){
		  var str = tag.value;
		  
	  }
	
	</script>
	<style type="text/css">
	li{
		list-style-type:none;
	}
	div{
			border:1px solid #000;
			
		}
	#index {
		position: relative;
		height: auto;
		width: 836px;
		margin-top: 100px;
		margin-right: auto;
		margin-left: auto;
		margin-bottom: 100px;
		}
	#questions{
		float: left;
		height: 430px;
		width: 750px;
		margin-top: 20px;
		margin-right: 100px;
		margin-left: 100px;
		margin-bottom: 45px;
		}
	#quest {
		margin-top: 46px;
		margin-right: auto;
		margin-left: auto;
		margin-bottom: 104px;
		padding: 20px;
		height: auto;
		width: 400px;
	}
	
	.answer {
	margin-top: auto;
	margin-left: 0px;
	margin-bottom: auto;
	padding: 5px;
	height: 30px;
	width: 90px;
	float: right;
	margin-right: 123px;
}
	#cc input{
		width:100%;
		height:100%;
		background: #FF7300;
	}
</style>
</head>
<body background="img/bg2.jpg">
<div class="index" id="index">	
  <div class="quest" id="quest">
  <form  id="answer"action="toExamAnser.do" method="post">
  <c:forEach items="${request }" var="quests">
  	<ul>
  		<li>
  			<div class="t_num">${quests.questId }&nbsp;${quests.questSubjct }</div>
  			<div class="question"></div>
  			<div class="t_select">
  				<ul>
  					<li>
						<span><input id="1_A" name="${quests.questId }" type="radio" value="A" onchange="radioChange(this)"/> A.</span><span class="ans">${quests.questA }</span>
  					</li>
  					<li>
  						<span><input id="1_B" name="${quests.questId }" type="radio" value="B" onchange="radioChange(this)"/> B.</span><span class="ans">${quests.questB }</span>
  					</li>
					<li>
						<span><input id="1_C" name="${quests.questId }" type="radio" value="C" onchange="radioChange(this)"/> C.</span><span class="ans">${quests.questC }</span>
					</li>
					<li>
						<span><input id="1_D" name="${quests.questId }" type="radio" value="D" onchange="radioChange(this)"/> D.</span><span class="ans">${quests.questD }</span>
					</li>
  				</ul>
  			</div>
  		</li>
  		
  	</ul>
  	</c:forEach>
  	</form>
  	
  </div>
  <div class="answer" id="cc"><input type="submit" value="Answer" onclick="document.getElementById('answer').submit();"></div>
</div>
</body>
</html>