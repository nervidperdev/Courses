/* 
	Constants
*/
const searchAllCoursesId = "-1";

/*
	Add Listeners
 */
document.getElementById("select").addEventListener("change", buscarCategory);
document.getElementById("findCourse").addEventListener("keyup", findCourseByName);


/*
	Functions
 */

function loadAllCourses() {
	axios.get(
		"FindAllCourses"
	).then(function(response) {
		printCourses(response.data);
	}).catch(function(error) {
		console.log(error);
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
				printCourses(response.data);
			}).catch(function(error) {
				console.log(error);
			});
		}

	}

}

function printCourses(courses) {
	let divResult = document.getElementById("searchResult");
	let result = "";
	for (let course of courses) {
		result = result +
			`<ul>
			<li> Curso <span>${course.name}</span></li>
         </ul>`;

	}
	divResult.innerHTML = result;
}



function findCourseByName() {
	let textBox = document.getElementById("findCourse").value;
	if (textBox != "") {
		axios.post(
			"SearchCourseName",
			null,
			{ params: { searchName: textBox } }).then(function(response) {
				printCourses(response.data);
			}).catch(function(error) {
				console.log(error);
			});
	}
}


function printCourses(courses) {
	console.log(courses)
	let divResult = document.getElementById("searchResult");
	let resultHtml = '<div><ul>';
	for (let course of courses) {
		resultHtml = resultHtml + `<div class="mb-3">
		<li><span>${course.name}</span></li>
        </div>`;
	}
	resultHtml = resultHtml + '</ul></div>';

	divResult.innerHTML = resultHtml;
}



function initPage() {
	loadCategories();
	loadAllCourses();
}