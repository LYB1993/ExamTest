/**
 * 根据题目来显示下一题、上一题和提交按钮
 */
var examNum = 0;
var examSum = parseInt(document.getElementById("examSum").value);
function buttonDisable(){
	$("#returnNextone").attr("disabled",true);
	$("#nextOne").attr("disabled",true);
	$("#endExam").attr("disabled",true);
	if(examNum==(examSum+1)){
		examNum--;
		$("#nextOne").attr("disabled",true);
		$("#returnNextone").attr("disabled",false);
		$("#endExam").attr("disabled",false);
	}else if(1<examNum && examNum<(examSum+1)){
		$("#nextOne").attr("disabled",false);
		$("#returnNextone").attr("disabled",false);
	}else if(examNum<=1){
		$("#nextOne").attr("disabled",false);
		$("#returnNextone").attr("disabled",true);
	}else{
		$("#nextOne").attr("disabled",true);
	}
	console.log("总"+examSum+"题");
	console.log("第"+examNum+"题");
	$("#examnum").html("第"+examNum+"题/总"+examSum+"题")
}

/**
 * 初始化加载第一道题目
 */
function firstone(){ 
	examNum++;
	buttonDisable();
	$.ajax({
		url:"firstone.do",
		type:"post",
		dataType:"json",
		success:function(data){
			$("#sub").html(data.questSubjct);
			$("#QA").html(data.questA);
			$("#QB").html(data.questB);
			$("#QC").html(data.questC);
			$("#QD").html(data.questD);
			$("#radio1").attr("name",data.questId);
			$("#radio2").attr("name",data.questId);
			$("#radio3").attr("name",data.questId);
			$("#radio4").attr("name",data.questId);
			console.log('请求第一条数据成功 ' + data.questSubjct);
			
		},
		error:function(data){
			console.log('请求第一条数据失败：'+data);
		}	
	});
}


/**
 * 点击下一题的js方法
 */
function nextone(){
	console.log('请求后台服务器：下一题');
	var radio_choice = $(":radio:checked").val()
	
	$.ajax({
		url:'next.do',
		type:'post',
		data:{
			choice:radio_choice
		},
		dataType:'json',
		success:function(data){
			examNum++;				
			buttonDisable();
			$("#sub").html(data.questSubjct);
			$("#QA").html(data.questA);
			$("#QB").html(data.questB);
			$("#QC").html(data.questC);
			$("#QD").html(data.questD);
			$("#radio1").attr("name",data.questId);
			$("#radio2").attr("name",data.questId);
			$("#radio3").attr("name",data.questId);
			$("#radio4").attr("name",data.questId);
			console.log('请求下一题成功 ' + data.questSubjct);
			
		},
		error:function(data){
			console.log('请求下一题失败：'+data.responseText);
			if(data.responseText=='end'){
				examNum++;
				buttonDisable();
			}
		}	
	});
}
/**
 * 点击返回上一题的js方法
 * @returns
 */
function returnnextone(){
	console.log('请求后台服务器数据：上一题');
	var radioval = $("#radio1").value;
	$.ajax({
		url:'returnnext.do',
		type:'post',
		data:{
		},
		dataType:'json',
		success:function(data){
			examNum--;
			buttonDisable();
			$("#sub").html(data.questSubjct);
			$("#QA").html(data.questA);
			$("#QB").html(data.questB);
			$("#QC").html(data.questC);
			$("#QD").html(data.questD);
			$("#radio1").attr("name",data.questId);
			$("#radio2").attr("name",data.questId);
			$("#radio3").attr("name",data.questId);
			$("#radio4").attr("name",data.questId);
			console.log('请求上一题成功 ' + data.questSubjct);
			
		},
		error:function(data){
			console.log('请求上一题失败：'+data);
		}	
	});
}
