<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<script>
	var winF,popW;
	$(document).ready(function(){
		winF = new dhtmlXWindows();
		winF.attachViewportTo("winVP");
		popW = winF.createWindow("win1",20,30,320,300);
		
		//popW.hide(); 
		popW.hideAll();
		
		popW.setText("Login"); 
		winF.center();
		
		var formObj = [
			{type:"settings", offsetTop:12,name:"connectionInfo",labelAlign:"left"},
			{type:"label",name:"label", label:"", list:[
				{type:"input",name:"uiID", label:"아이디 : ",required:true},
				{type:"password",name:"uiPwd", label:"비밀번호 : ",required:true}
			]},
		
			{type: "block", blockOffset: 0, list: [
				{type:"label",name:"label", label:"", list:[
					{type: "button", name:"loginBtn",value: "로그인"},
					{type: "newcolumn"},
					{type: "button", name:"cancelBtn",value: "취소"},
					{type: "newcolumn"},
					{type: "button", name:"signupBtn",value: "회원가입"}					
				]}			
			]}
		];
		
		var form = popW.attachForm(formObj,true);
      
		form.attachEvent("onButtonClick",function(id){
			
			if(id=="loginBtn"){
				if(form.validate()){					
					form.send("${root}/user/login", "post",callback);					
				}
			}else if(id=="cancelBtn"){
				form.clear();
			}else if(id=="signupBtn"){
	            location.href="${pPath}/user/join";
			}
		});
		
		
		/*var insertPopW = winF.createWindow("win2",20,30,320,300);
		
		var insertFormObj = [{type:"settings", offsetTop:12, name:"connectionInfo", labelAlign:"left"},				
			{type:"input", name:"uiName", label:"이름", required:true},
			{type:"input", name:"uiID", label:"아이디", required:true},
			{type:"input", name:"uiPwd", label:"패스워드", vaildate:"ValidInteger", required:true},
			{type:"input", name:"uiEmail", label:"이메일", required:true},
			{type:"input", name:"admin", label:"관리자권한설정", required:true},		
			
			{type:"block", blockOffset:0, list:[
				{type:"button", name:"saveBtn", value:"저장"},
				{type:"newcolumn"},
				{type:"button", name:"cancelBtn", value:"취소"}
			]}
						
		];
		
		insertPopW.button("close").hide();
		insertPopW.button("minmax").hide();
		insertPopW.button("park").hide();
		insertPopW.setText("SingUp"); 
		var insertForm = insertPopW.attachForm(insertFormObj,true);*/
		
		
		
		
	});
   
	function callback(loader, res){
		if(loader.xmlDoc.status == 200){
			var res = JSON.parse(res);
			alert(res.msg);
			if(res.biz){
				document.location.href="${pPath}/db/main";
			}
		}else{  
			console.log(res);
		}
	}
	   
</script>
<body>
   <div id="winVP"></div>
</body>
</html>