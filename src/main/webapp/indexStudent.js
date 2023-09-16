/**
 * 
 */
document.getElementById("nav-icon3").addEventListener("click", toggle);

function toggle() {
	let navIcon = document.getElementById("nav-icon3");
	navIcon.classList.toggle('open')
}

function initPageStudent() {
	axios.get(
		"FindAllCourses"
	).then(function(response) {
		if (response == null || response.data == null || response.data.length == 0) {
			showEmptyResult({ title: "No hay cursos que mostrarNo hay cursos disponibles", body: "Actualmente no tenemos cursos para ofrecerte" })
		} else {
			printCourses(response.data);
		}
	}).catch(function(error) {
		console.log(error);
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
	    <button class="btn btn-outline-dark" type="button" onclick="enrollInCourse(this)">Matrículate</button>
	    <input type="hidden" id="courseId" value="${course.courseId}"/>
	  </div>
	</div>`;
	}
	resultHtml = resultHtml + '</div>';

	divResult.innerHTML = resultHtml;
}

function enrollInCourse(event) {
	// Coge el elemento padre (quien contiene el boton) y dentro de él busca un elemento con id courseId
	let courseId = event.parentElement.querySelector("#courseId").value
		axios.post(
			"EnrollCourse",
			null,
			{ params: { courseId : courseId}})
			.then(function(response) {
				printCourses(response.data);
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