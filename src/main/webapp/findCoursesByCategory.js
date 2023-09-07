/**
 * 
 */
function buscarCategory () {
	let categorySelect = document.getElementById("select").value;
	if(TxtBusqueda != ""){
		axios.post(
		"FindCoursesByCategory", 
		null, 
		{params: {searchCategory: categorySelect }}
	).then(function (response) { 
		printCategory(response.data);
	}).catch(function (error){ 
		console.log(error);
	});
  }	
}

function printCategory (coursesCategory) {
	console.log(lista);
	let divResult = document.getElementById("ListResultCategory"); //hacer el div en jsp
	let resultList = "";
	for (let category of coursesCategory ) {
		resultList = resultList + 
		`<ul>
			<li> Curso <span>${course.name}</span></li>
         </ul>`;
         
	}
	divResult.innerHTML = textoCategory;
}