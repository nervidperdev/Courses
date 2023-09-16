/* 
	Constants
*/
const searchAllCoursesId = "-1";

/*
	Add Listeners
 */
document.getElementById("select").addEventListener("change", buscarCategory);
document.getElementById("findCourse").addEventListener("keyup", findCourseByName);
document.getElementById("nav-icon3").addEventListener("click", toggle);

function toggle() {
	let navIcon = document.getElementById("nav-icon3");
	navIcon.classList.toggle('open')
}


/*
	Functions
 */

function loadAllCourses() {
	axios.get(
		"FindAllCourses"
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

function loadCategories() {
	axios.get("CoursesCategory").then(function(response) {
		console.log(response);
		let categorySelect = document.getElementById("select");
		let options = "";
		// Añadimos todos los cursos como primera posicion al array para poder buscar sin filtro
		let categories = [{ categoryId: searchAllCoursesId, nameCategory: "Todos los cursos" }]
			.concat(response.data);

		for (let category of categories) {
			options = options +
				`<option value="${category.categoryId}">${category.nameCategory}</option>`;
		}
		categorySelect.innerHTML = options;
	}).catch(function(error) {
		console.log(error);
	})
}

function buscarCategory() {
	let categoryId = document.getElementById("select").value;

	if (categoryId == searchAllCoursesId) {
		// Pedimos todos los cursos
		loadAllCourses();
	} else {
		// Buscamos por id de categoria
		if (categoryId != "") {
			axios.post(
				"FindCoursesByCategory",
				null,
				{ params: { searchCategory: categoryId } }
			).then(function(response) {
				if (response == null || response.data == null || response.data.length == 0) {
					showEmptyResult({ title: "No hay cursos que mostrar", body: "No tenemos resultados para mostrar, inténtalo con otra búsqueda" })
				} else {
					printCourses(response.data);
				}
			}).catch(function(error) {
				console.log(error);
				showEmptyResult({ title: "No hay cursos que mostrar", body: "No tenemos resultados para mostrar, inténtalo con otra búsqueda" })
			});
		}

	}
}

function findCourseByName() {
	let textBox = document.getElementById("findCourse").value;
	if (textBox != "") {
		axios.post(
			"SearchCourseName",
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

function printCourses(courses) {
	let divResult = document.getElementById("searchResult");
	let resultHtml = '<div class="courseContainer">';
	for (let course of courses) {
		resultHtml = resultHtml + `
    <div class="card" style="width: 18rem;">
	  <img class="card-img-top" alt="${course.name}_image" src="${course.imageUrl}"/>
	  <div class="card-body">
	    <h5 class="card-title cardTitle">${course.name}</h5>
	  </div>
	</div>`;
	}
	resultHtml = resultHtml + '</div>';

	divResult.innerHTML = resultHtml;
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

function initPage() {
	loadCategories();
	loadAllCourses();
}