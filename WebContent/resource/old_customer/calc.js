function init(){
	var btnSum = document.getElementById("btn-sum");
	btnSum.onclick = btnSumClick;
}

function btnSumClick(){
	var x = document.getElementById("txt-x").value;
	var y = document.getElementById("txt-y").value;
	var sum = document.getElementById("txt-sum");
	
	sum.value = parseInt(x) + parseInt(y);

	//alert("test");
	
}

window.onload=init;