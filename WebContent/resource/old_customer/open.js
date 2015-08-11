var win = null; //전역변수

function btnNewTabClick(){
	// 새탭 띄우기
	//alert("test");
	win = open("open2.html");
}

function btnNewWinClick(){
	//새창 띄우기
	win = open("open2.html", "_blank", "width = 500px, height = 400px");
	
}

function btnCloseWinClick(){
	// 자식창 닫기
	//win.close();
	//현재창(부모)닫기 close(); or window.close()
	close();
}

window.addEventListener("load", function(){
	var btnNewTab = document.getElementById("btn-new-tab");
	var btnNewWin = document.getElementById("btn-new-win");
	var btnCloseWin = document.getElementById("btn-close-win");
	
	btnNewTab.onclick = btnNewTabClick;
	btnNewWin.onclick = btnNewWinClick;
	btnCloseWin.onclick = btnCloseWinClick;
	});