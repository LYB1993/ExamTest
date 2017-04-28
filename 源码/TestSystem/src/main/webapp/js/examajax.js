/**
 * 下一题调用的ajax方法
 */
function nextone(){
	console.log('请求后台服务器：');
	$.ajax({
		url:'next.do',
		type:'post',
		data:{
		},
		dataType:'json',
		success:function(data){

			$("#sub").html(data.questSubjct);
			$("#QA").html(data.questA);
			$("#QB").html(data.questB);
			$("#QC").html(data.questC);
			$("#QD").html(data.questD);
			$("#radio1").attr("name",data.questId);
			$("#radio2").attr("name",data.questId);
			$("#radio3").attr("name",data.questId);
			document.getElementById("radio4").name = data.questId;
			console.log('请求后台服务器成功 ' + data.questSubjct);
			
		},
		error:function(data){
			console.log('请求后台服务器失败：'+data);
		}	
	});
}
/*
 * 上一题调用的ajax方法
 */
function nextone(){
	console.log('请求后台服务器：');
	$.ajax({
		url:'returnnext.do',
		type:'post',
		data:{
		},
		dataType:'json',
		success:function(data){

			$("#sub").html(data.questSubjct);
			$("#QA").html(data.questA);
			$("#QB").html(data.questB);
			$("#QC").html(data.questC);
			$("#QD").html(data.questD);
			$("#radio1").attr("name",data.questId);
			$("#radio2").attr("name",data.questId);
			$("#radio3").attr("name",data.questId);
			document.getElementById("radio4").name = data.questId;
			console.log('请求后台服务器成功 ' + data.questSubjct);
			
		},
		error:function(data){
			console.log('请求后台服务器失败：'+data);
		}
	});
}
