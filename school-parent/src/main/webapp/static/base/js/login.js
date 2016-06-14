function login(){
	var username = document.getElementById("inputEmail").value;
	var userpwd = document.getElementById("inputPassword").value;
	if (""!=username && ""!=userpwd){
		//saveInfo(); 
		//window.location.href="MyDesign.html";
    	//return true; 
		ajaxLogin(username,userpwd);
	}else{
		alert("用户名或密码错误！");
	}
}

function ajaxLogin(name,pwd){
	$.ajax({
		type : 'POST',
		url : "/login/user/login/verify",
		data : {
			"account" : name,
			"passward":pwd
		},
		success : function(data) {
			if(true==data.success){
				//alert("token:"+data.message);
				if(typeof(htmlOperateObject)!='undefined' ){					
					htmlOperateObject.jsSetToken(data.message);//c++接口
					//alert("token:"+htmlOperateObject.jsGetToken());
				
				}
				window.location.href="/roomcase/lists?token="+data.message;	
				
			}else{
				alert(data.message);
			}
		}
	});
}
saveInfo = function(){ 
	try{ 
	   var isSave = document.getElementById('chkRememberPwd').checked;   //保存按键是否选中 
	   if (isSave) { 
	    var usernm = document.getElementById('inputEmail').value; 
	    var userpsw = document.getElementById('inputPassword').value; 
	    if(usernm!="" && userpsw!=""){ 
	     SetCookie(usernm,userpsw); 
	    } 
	   }else {   
	    SetCookie("",""); 
	   } 
	}catch(e){ 
	  
	} 
	} 
	  
	function SetCookie(usern,psw){ 
	var Then = new Date()  
	Then.setTime(Then.getTime() + 1866240000000)  
	document.cookie ="username=" + usern + "%%"+psw+";expires="+ Then.toGMTString() ; 
	} 
	  
	  
	function GetCookie(){  
	var nmpsd; 
	var nm; 
	var psd; 
	var cookieString = new String(document.cookie) 
	var cookieHeader = "username=" 
	var beginPosition = cookieString.indexOf(cookieHeader) 
	cookieString = cookieString.substring(beginPosition); 
	var ends=cookieString.indexOf(";"); 
	if (ends!=-1){ 
	   cookieString = cookieString.substring(0,ends); 
	} 
	if (beginPosition>-1){ 
	   nmpsd = cookieString.substring(cookieHeader.length); 
	   if (nmpsd!=""){ 
	    beginPosition = nmpsd.indexOf("%%"); 
	    nm=nmpsd.substring(0,beginPosition); 
	    psd=nmpsd.substring(beginPosition+2); 
	    document.getElementById('inputEmail').value=nm; 
	    document.getElementById('inputPassword').value=psd; 
	    if(nm!="" && psd!=""){ 
	     document.getElementById('chkRememberPwd').checked = true 
	    } 
	   }  
	} 
}

