/**
 * 
 */

document.getElementById("inputStudent").addEventListener("change", visibility);
document.getElementById("inputTeacher").addEventListener("change", visibility);

 function visibility() { 
	 let inputStudent = document.getElementById("inputStudent")
	 let divRegistro = document.getElementById("registerStudent");
	
	 if(inputStudent.checked) {
		 divRegistro.classList.remove("hidden");
		 
	 } else {
		 divRegistro.classList.add("hidden");
	 }
 }