/**
 * 
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


	function formatJsonToSeries(data) {
	    jsonData = JSON.parse(data);  //把后台传来的数据转来JSON格式
	    console.log("TQ:"+jsonData);
	    //jsonData是二维数组，因为实体类ChartSeries的字段data也是个list
//	    for (x in jsonData) {  //遍历JSON格式的数组取元素, x代表下标
//	        for (y in jsonData[x].data) {                
//	             alert(jsonData[x].occurTime[y]) ;//依次获取 
//	             alert(jsonData[x].data[y]);
//	             $().val(jsonData[x].questId);
//	     		 $().val(data.questSubjct);
//	     		 $().val(data.questA);
//	     		 $().val(data.questB);
//	     		 $().val(data.questC);
//	     		 $().val(data.questD);
//	        }
//	    }
	}
}
