function btnResizeClick(){
	//부모 크기 변경
	opener.resizeTo(100, 100);
	//To는 절대위치 By는 상대위치를 기준으로
}

function btnMoveClick(){
	//부모 위치 변경
	opener.moveTo(0, 0);
	
}

function btnOpenerCloseClick(){
	//부모 윈도우 닫기
	opener.close();
}

window.addEventListener("load", function(){
	var btnResize = document.getElementById("btn-resize");
	var btnMove = document.getElementById("btn-move");
	var btnOpenerClose = document.getElementById("btn-opener-close");
	
	btnResize.onclick = btnResizeClick;
	btnMove.onclick = btnMoveClick;
	btnOpenerClose.onclick = btnOpenerCloseClick;
	});