/**
 * 
 */

 function visibility() { 
	 let inputStudent = document.getElementById("inputStudent")
	 let divRegistro = document.getElementById("registerStudent");
	
	 if(inputStudent.checked) {
		 divRegistro.style.display="block";
		 
	 } else {
		 divRegistro.style.display ="none";
		 
	 }
 }