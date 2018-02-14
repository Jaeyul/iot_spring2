<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
    html, body {
        width: 100%;      /*provides the correct work of a full-screen layout*/ 
        height: 100%;     /*provides the correct work of a full-screen layout*/
        overflow: hidden; /*hides the default body's space*/
        margin: 0px;      /*hides the body's scrolls*/
    }      
    div.controls {
         margin: 0px 10px;
         font-size: 14px;
         font-family: Tahoma;
         color: #404040;
         height: 80px;
      }
</style>

<script>

var bodyLayout, subLayout,mygrid,
	aLay, bLay,
	dbTree;

var winF,popW;

dhtmlxEvent(window,"load",function(){
	
	bodyLayout = new dhtmlXLayoutObject(document.body,"3L");
	
	aLay = bodyLayout.cells("a");	
	
	aLay.setWidth(400);
	aLay.setText("Connection Info List");	
	
	
	
	
	
	
	
	
	var aToolbar = aLay.attachToolbar();
	aToolbar.addButton("addcon",1,"add Connector");
	aToolbar.addButton("condb",2,"Connection");
	
	aToolbar.attachEvent("onClick",function(id){
		if(id=="condb"){
			var rowId = dbTree.getSelectedId();			
			if(!rowId){
				alert("접속할 커넥션을 선택해주세요.");
				return;
			}			
			alert(rowId);
			var au = new AjaxUtil("${root}/connection/db_list/" + rowId ,null,"GET","json")
			
			function dbListCB(res){
				if(res.error){
					alert(res.error);
					return;
				}				
				var parentId =  res.parentId;
				for(var map of res.list){
					var id = map.id;
					var text = map.text;
					dbTree.addItem(id, text, parentId);					
				}
				dbTree.openItem(parentId);
			}
						
			au.send(dbListCB);
			
			dbTree.attachEvent("onDblClick", function(id){
				var level = dbTree.getLevel(id);
				if(level==2){
					var text = dbTree.getItemText(id);
					var au = new AjaxUtil("${root}/connection/tables/"+ text + "/" + id ,null,"GET","json")
					
					function databaseListCB(res){
						var parentId = res.parentId;
						var i = 1;
						for(var list of res.list){
							var id = parentId + "_" + (i++);
							var text = list.tableName;
							if(list.tableComment!=""){
								text += "[" + tableComment + "]"; 								
							}
							text += " : " + list.tableSize + ".0KB";								
							dbTree.addItem(id, text, parentId);
						}						
					}					
					au.send(databaseListCB);
					
				}else if(level==3){
					var text = dbTree.getItemText(id);
				}				
			});
			
		}else if(id=="addcon"){
			popW.show();	    	  
		}
	})
	   	   	
	var au = new AjaxUtil("${root}/connection/list",null,"GET","json")
	
	function connectionListCB(res){
		console.log(res.list);
		dbTree = aLay.attachTreeView({
			items: res.list
		});
		dbTree.setImagePath("${rPath}/dx/skins/web/imgs/dhxtree_web");	
		dbTree.enableDragAndDrop(true);			
	}	
	au.send(connectionListCB);
	
	bLay = bodyLayout.cells("b");	
	
	var mytabbar = bLay.attachTabbar({		
		tabs: [ 
			 
	        {
	            id:      "t1",      // tab id
	            text:    "Text",    // tab text
	            width:   null,      // numeric for tab width or null for auto, optional
	            index:   null,      // numeric for tab index or null for last position,opt.
	            active:  true,      // boolean, make tab active after adding, optional
	            enabled: true,     // boolean, false to disable tab on init
	            close:   true       // boolean, render close button on tab, optional
	        }		
		]
	})
	
	var test = mytabbar.tabs("t1").attachEditor();
	
	mytabbar.attachEvent("onTabClick", function(id, lastId){
	    alert(id);
	    
	    alert(test.getContent());
	   
	});

	
	/*var myToolbar = mytabbar.tabs("t1").attachToolbar({
	    icons_path: "imgs/toolbar/icons/",
	    json: "data/json/toolbar.json"
	});*/
	
	
	/*var bToolbar = bLay.attachToolbar();
		bToolbar.addButton("ui",1,"UserInfo");
		bToolbar.addButton("ci",2,"ConnectionInfo");*/
		
				
		
	winF = new dhtmlXWindows();		
	popW = winF.createWindow("win1",20,30,400,500);		
	popW.setText("Add User Info");
		
	var formObj = [];
	
	var insertFormObj = [{type:"settings", offsetTop:12, name:"connectionInfo", labelAlign:"left"},				
		{type:"input", name:"ciName", label:"커넥션", required:true},
		{type:"input", name:"ciUrl", label:"접속URL", required:true},
		{type:"input", name:"ciPort", label:"포트번호", vaildate:"ValidInteger", required:true},
		{type:"input", name:"ciDatabase", label:"데이터베이스", required:true},
		{type:"input", name:"ciUser", label:"유저아이디", required:true},
		{type:"password", name:"ciPwd", label:"비밀번호", required:true},
		{type:"input", name:"uiId", label:"아이디",required:true},
		{type:"input", name:"ciEtc", label:"설명"},
		
		{type:"block", blockOffset:0, list:[
			{type:"button", name:"saveBtn", value:"저장"},
			{type:"newcolumn"},
			{type:"button", name:"cancelBtn", value:"취소"}
		]}		
	];
	
	var form = popW.attachForm(insertFormObj,true);
	popW.hide();		
});





</script>
<body>

</body>
</html>