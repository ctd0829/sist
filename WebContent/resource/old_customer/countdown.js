function init(){
	var btnCntDw = document.getElementById("btn-countdown");
	btnCntDw.onclick = btnOnClick;
}

var timerID = null;

function btnOnClick(){
	
	//count();
	//1초 = 1000ms
	//setTimeout(count, 1000);//1초 후에
	if(timerID == null)
		timerID = setInterval(count, 1000);//1초 마다

}

function count(){
	var lblCount = document.getElementById("lbl-count");
	var count = parseInt(lblCount.innerText);
	
	if(count > 0)
		lblCount.innerText = --count;
	else{
		//취소
		clearInterval(timerID);
		timerID = null;
	}
		
	//alert(lblCount.innerText); // 60
}

window.onload = init;