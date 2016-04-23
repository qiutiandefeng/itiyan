/**
 * 在线考试页面的倒计时功能
 */

function Timer(startTime, endTime ,show) {
    this.startDate = new Date(startTime);
    this.endDate = new Date(endTime);
    this.startTime = this.startDate.getTime();
    this.endTime = this.endDate.getTime() - this.startTime;
    this.countDownTime = this.endTime;
    this.show = show;
}

Timer.prototype.start = function () {
    this.countDown();
};

Timer.prototype.countDown = function () {
    this.countDownTime -= 1000;
    var time = new Date(this.countDownTime), that = this;
    var h = time.getUTCHours();
    var m = time.getUTCMinutes();
    var s = time.getUTCSeconds();
    if(parseInt(h) < 10){
    	h = "0"+h;
    }
    if(parseInt(m) < 10){
    	m = "0"+m;
    }
    if(parseInt(s) < 10){
    	s = "0"+s;
     }
    $('#hour').text(h);
    $('#minute').text(m);
    $('#second').text(s);
    this.timer = setTimeout(function () {
        that.countDown.call(that);
    }, 1000);
  
    if(this.show != "1"){ // 表示考试时间到
        if(parseInt(this.countDownTime) <= 0){
        	clearTimeout(this.timer);
        	$(".sfm").text("答卷时间结束！");
        	// 自动交卷
        	saveAnswer(3); // 自动保存当前答案
        }
    }else{
    	if(parseInt(this.countDownTime) <= 0){ // 可以开始考试了
    		clearTimeout(this.timer);
    		$('#sureTime').modal('hide');
        	curtDown("startime","endtime","divdown1");
        }else{
        	$('#sureTime').modal({backdrop: 'static', keyboard: false});
        	$('#sureTime').modal('show');
        }
    }
};

function curtDown(stime,etime,show){
	var endtime= $("#"+etime).val(); // 考试结束结束时间
	var nowtime= $("#"+stime).val(); // 服务器现在的时间
   
	var a = new Timer(nowtime, endtime, show);
	a.start();
}
   			