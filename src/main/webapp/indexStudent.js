/**
 * 
 */
document.getElementById("nav-icon3").addEventListener("click", toggle);
document.getElementById("enrollErrorModal").addEventListener("click", closeModal);
document.getElementById("enrollSuccessModal").addEventListener("click", closeSuccessModal);

function toggle() {
	let navIcon = document.getElementById("nav-icon3");
	navIcon.classList.toggle('open')
}

function initPageStudent() {
	axios.get(
		"FindAllCoursesPageStudent"
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
	  <img class="card-img-top" alt="${course.name}_image" src="${course.imageUrl}"/>
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
				let isUserEnrolled = response.data["userEnrolled"];
				if(isUserEnrolled) {
					let successModal = document.getElementById('enrollSuccessModal');
					new bootstrap.Modal(successModal, {}).show();
					initPageStudent();
				} else {
					let enrollErrorModal = document.getElementById('enrollErrorModal');
					new bootstrap.Modal(enrollErrorModal, {}).show();
				}
			}).catch(function(error) {
				console.log(error);
				let enrollErrorModal = document.getElementById('enrollErrorModal');
				new bootstrap.Modal(enrollErrorModal, {}).show();
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

function closeModal() {
	let modal = document.getElementById('enrollErrorModal');
	bootstrap.Modal.getInstance(modal).hide();
}

function closeSuccessModal() {
	let modal = document.getElementById('enrollSuccessModal');
	bootstrap.Modal.getInstance(modal).hide();
}
