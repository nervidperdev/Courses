/**
 * 
 */

document.getElementById("findCourse").addEventListener("keyup", findCourseByName);
document.getElementById("nav-icon3").addEventListener("click", toggle);

function toggle() {
	let navIcon = document.getElementById("nav-icon3");
	navIcon.classList.toggle('open')
}


function loadAllCourses() {
	axios.get(
		"FindCoursesByTeacher"
	).then(function(response) {
		if (response == null || response.data == null || response.data.length == 0) {
			showEmptyResult({ title: "No hay cursos que mostrar", body: "No tenemos cursos disponibles" });
		} else {
			printCourses(response.data);
		}
	}).catch(function(error) {
		console.log(error);
		showEmptyResult({ title: "No hay cursos que mostrar", body: "No tenemos cursos disponibles" });
	});
}

function printCourses(courses) {
	let divResult = document.getElementById("searchResult");
	let resultHtml = '<div class="courseContainer">';
	for (let course of courses) {
		resultHtml = resultHtml + `
    <div class="card" style="width: 18rem;">
	  <img class="card-img-top" alt="${course.name}_image" src="https://images.unsplash.com/photo-1501504905252-473c47e087f8?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=320&q=80"/>
	  <div class="card-body cardBody">
	    <h5 class="card-title cardTitle">${course.name}</h5>
		<input class="btn btn-outline-dark" type="button" value="ALUMNOS MATRICULADOS"/>
	    <input class="btn btn-outline-dark" type="button" value="FINALIZAR CURSO"/>
	  </div>
	</div>`;
	}
	resultHtml = resultHtml + '</div>';

	divResult.innerHTML = resultHtml;
}

function findCourseByName() {
	let textBox = document.getElementById("findCourse").value;
	if (textBox != "") {
		axios.post(
			"SearchCoursesForTeacherByName",
			null,
			{ params: { searchName: textBox } }).then(function(response) {
				if (response == null || response.data == null || response.data.length == 0) {
					showEmptyResult({ title: "No hay cursos que mostrar", body: "No tenemos resultados para mostrar, inténtalo con otra búsqueda" })
				} else {
					printCourses(response.data);
				}
			}).catch(function(error) {
				console.log(error);
				showEmptyResult({ title: "No hay cursos que mostrar", body: "No tenemos resultados para mostrar, inténtalo con otra búsqueda" })
			});
	} else {
		loadAllCourses();
	}
}

function showEmptyResult(emptyMessage) {
	let divResult = document.getElementById("searchResult");
	divResult.innerHTML = `
		<div class="container">
			<div class="h-50 p-5 bg-body-tertiary border rounded-3 emptyResult">
	          <h2>${emptyMessage.title}</h2>
	          <p>${emptyMessage.body}</p>
	        </div>
		</div>
		`
}

function initPageTeacher() {
	loadAllCourses();
}