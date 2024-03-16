document.addEventListener("DOMContentLoaded",function(){
	var questions = document.querySelectorAll(".fq");
	
	questions.forEach((que, qindex)=>{
		que.addEventListener("click",()=>{
			
			var answers = document.querySelectorAll(".fa");
			answers.forEach((ans,aindex)=>{
				if(qindex == aindex){
					// 해당 답변 보이게 해줘야함.
					ans.style.display = "block";
				}
				else{
					//나머지 답변 가리게.
					ans.style.display = "none";
				}
			});
			
		});
	});
});