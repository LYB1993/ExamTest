var WINDOW_WIDTH=220;
var WINDOW_HEIGHT=30;
var RADIUS=0.5;
var MARGINTOP=0;
var MARGINLEFT=60;
var examTime = parseInt(document.getElementById("examTime").value);
console.log(examTime);
const endTime=new Date(new Date().getFullYear(),new Date().getMonth(),new Date().getDate(),new Date().getHours(),new Date().getMinutes()+examTime,0);
var curShowTimeSeconds=0;
var stop;
var balls=[];
const colors=["#000000","#000000","#000000","#000000","#000000","#000000"
,"#000000","#000000","#000000","#000000"];
	window.onload=function(){
		console.log("考试界面");
		firstone();
		var canvas=document.getElementById("canvas");
		var context=canvas.getContext("2d");
		canvas.width=WINDOW_WIDTH;
		canvas.height=WINDOW_HEIGHT;
		curShowTimeSeconds=getCurShowTimeSeconds();
		stop = setInterval(function(){
			render(context);
			update();
			},50);
	}
	function getCurShowTimeSeconds(){
	var curTime=new Date();
	
	var ret=endTime.getTime()-curTime.getTime();
	ret=Math.round(ret/1000);

	return ret>=0?ret:0;
	}
	function update(){
		var nextShowTimeSeconds=getCurShowTimeSeconds();
		if(nextShowTimeSeconds == 0){
			window.clearInterval(stop);
			location.href = "toAnswer.do";
		}
		var nextHours=parseInt(nextShowTimeSeconds/3600);
		var nextMinutes=parseInt((nextShowTimeSeconds-nextHours*3600)/60);
		var nextSeconds=nextShowTimeSeconds%60;
		var curHours=parseInt(curShowTimeSeconds/3600);
		var curMinutes=parseInt((curShowTimeSeconds-curHours*3600)/60);
		var curSeconds=curShowTimeSeconds%60;
			if(nextSeconds!=curSeconds){
					if(parseInt(curHours/10)!=parseInt(nextHours/10)){
							addBalls(MARGINLEFT+0,MARGINTOP,parseInt(curHours/10));
						}
					if(parseInt(curHours%10)!=parseInt(nextHours%10)){
							addBalls(MARGINLEFT+15*(RADIUS+1),MARGINTOP,parseInt(curHours%10));
						}
					if(parseInt(curMinutes/10)!=parseInt(nextMinutes/10)){
							addBalls(MARGINLEFT+39*(RADIUS+1),MARGINTOP,parseInt(curMinutes/10));
						}
					if(parseInt(curMinutes%10)!=parseInt(nextMinutes%10)){
							addBalls(MARGINLEFT+54*(RADIUS+1),MARGINTOP,parseInt(curMinutes%10));
						}
					if(parseInt(curSeconds/10)!=parseInt(nextSeconds/10)){
							addBalls(MARGINLEFT+78*(RADIUS+1),MARGINTOP,parseInt(curSeconds/10));
						}
					if(parseInt(curSeconds%10)!=parseInt(nextSeconds%10)){
						addBalls(MARGINLEFT+93*(RADIUS+1),MARGINTOP,parseInt(nextSeconds%10));
						}
					curShowTimeSeconds=nextShowTimeSeconds;
			}
				updateBalls();
	}
		function updateBalls(){
			for(i=0;i<balls.length;i++){
				balls[i].x+=balls[i].vx;
				balls[i].y+=balls[i].vy;
				balls[i].vy+=balls[i].g;
				if(balls[i].y>=WINDOW_HEIGHT-RADIUS){
					balls[i].y=WINDOW_HEIGHT-RADIUS;
					balls[i].vy=-balls[i].vy*0.66;
				}
			}
		}
		function addBalls(x,y,num){
				for(var i=0;i<digit[num].length;i++){
						for(var j=0;j<digit[num][i].length;j++){
								if(digit[num][i][j]==1){
									var aBall={x:x+j*2*(RADIUS+1)+(RADIUS+1),
											y:y+i*2*(RADIUS+1)+(RADIUS+1),
											g:1.5+Math.random(),
											vx:x,
											vy:y,
									}
									balls.push(aBall);
								}
						}
				}
		}
		function render(cxt){
			cxt.clearRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
			var hours=parseInt(curShowTimeSeconds/3600);
			var minutes=parseInt((curShowTimeSeconds-hours*3600)/60);
			var seconds=curShowTimeSeconds%60;
			renderDigist(MARGINLEFT, MARGINTOP,parseInt(hours/10),cxt);
			renderDigist(MARGINLEFT+15*(RADIUS+1),MARGINTOP,parseInt(hours%10),cxt);
			renderDigist(MARGINLEFT+30*(RADIUS+1),MARGINTOP,10,cxt);
			renderDigist(MARGINLEFT+39*(RADIUS+1),MARGINTOP,parseInt(minutes/10),cxt);
			renderDigist(MARGINLEFT+54*(RADIUS+1),MARGINTOP,parseInt(minutes%10),cxt);
			renderDigist(MARGINLEFT+69*(RADIUS+1),MARGINTOP,10,cxt);
			renderDigist(MARGINLEFT+78*(RADIUS+1),MARGINTOP,parseInt(seconds/10),cxt);
			renderDigist(MARGINLEFT+93*(RADIUS+1),MARGINTOP,parseInt(seconds%10),cxt);
			    for(var i=0;i<balls.length;i++){
			    cxt.fillStyle=balls[i].color;
			    cxt.beginPath();
			    cxt.arc(balls[i].x,balls[i].y,RADIUS,0,0,true);
			    cxt.closePath();
			    cxt.fill();
			    }
	}
	function renderDigist(x,y,num,cxt){
		cxt.fillStyle="rgb(255,0,0)";
		for(var i=0;i<digit[num].length;i++){
		for(var j=0;j<digit[num][i].length;j++){
		if(digit[num][i][j]==1){
		cxt.beginPath();
		cxt.arc(x+j*2*(RADIUS+1)+(RADIUS+1),y+i*2*(RADIUS+1)+(RADIUS+1),RADIUS,0,2*Math.PI);
		cxt.closePath();
		cxt.fill(); 
	}
}
}
}