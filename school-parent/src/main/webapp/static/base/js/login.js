function login(){
	var username = document.getElementById("inputEmail").value;
	var userpwd = document.getElementById("inputPassword").value;
	if (""!=username && ""!=userpwd){
		ajaxLogin(username,userpwd);
	}else{
		alert("用户名或密码错误！");
	}
}

function ajaxLogin(name,pwd){
	$.ajax({
		type : 'POST',
		url : "/user/login/verify",
		data : {
			"account" : name,
			"passward":pwd
		},
		success : function(data) {
			if(true==data.success){
				window.location.href="/manage/home";	
			}else{
				alert(data.message);
			}
		}
	});
}
function ajaxLogout(name,pwd){
	$.ajax({
		type : 'POST',
		url : "/user/logout",
		success : function(data) {
			if(true==data.success){
				window.location.href="/";	
			}else{
				alert(data.message);
			}
		}
	});
}
