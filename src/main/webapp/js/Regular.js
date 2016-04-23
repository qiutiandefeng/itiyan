function IDCard(idcard){
	 reg =/^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
     if(!reg.test(idcard)){
    	 return false;
     }	
     return true;
}

function passwordReg(password){
	 reg =/^[a-zA-Z0-9_]{3,20}$/; 0
	 if(!reg.test(password)){
		 return false;
	 }	
	 return true;
}