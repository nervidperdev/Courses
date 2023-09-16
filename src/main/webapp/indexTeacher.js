/**
 * 
 */

document.getElementById("findCourse").addEventListener("keyup", findCourseByName);
document.getElementById("nav-icon3").addEventListener("click", toggle);
document.getElementById("modalClose").addEventListener("click", closeModal);

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
		  <img class="card-img-top" alt="${course.name}_image" src="${course.imageUrl}"/>
		  <div class="card-body cardBody">
		    <h5 class="card-title cardTitle">${course.name}</h5>
			<input class="btn btn-outline-dark" type="button" value="ALUMNOS MATRICULADOS" onclick="findStudentsByCourse(this)"/>
		    <input class="btn btn-outline-dark" type="button" value="FINALIZAR CURSO" onclick = "finishCourse(this)"/>
			<input type="hidden" id="inputHidden" value="${course.courseId}"/>
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

function printStudents(students) {
	let studentsModal = document.getElementById('studentsModal');
	let studentsBody = studentsModal.querySelector('.modal-body');
	let resultHTML = "";

	if (students.length > 0) {
		resultHTML = "<ol>";
		for (let student of students) {
			resultHTML = resultHTML + `
			<li> ${student.name} ${student.surname}</li>
		`;
		}

		resultHTML = resultHTML + "</ol>";
	} else {
		resultHTML = "<p>Este curso no tiene estudiantes matriculados.<p/>"
	}

	studentsBody.innerHTML = resultHTML;

	new bootstrap.Modal(studentsModal, {}).show();
}

function closeModal() {
	let studentsModal = document.getElementById('studentsModal');
	bootstrap.Modal.getInstance(studentsModal).hide();
}


function findStudentsByCourse(event) {
	let input = event.parentElement.querySelector("#inputHidden").value;
	axios.post(
		"FindStudentByCourse",
		null,
		{ params: { courseId: input } }).then(function(response) {
			printStudents(response.data);
		}).catch(function(error) {
			console.log(error);
		});

}

function finishCourse(event) {
	let input = event.parentElement.querySelector("#inputHidden").value;
	axios.put(
		"FinishCourse",
		null,
		{ params: { courseId: input } }).then(function(response) {
			if (response.status == 204) {
				// curso se modifico bien

			} else {
				//hubo error

			}
		}).catch(function(error) {
			console.log(error);
		});

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