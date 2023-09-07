/**
 * 
 */
document.getElementById("findCourse").addEventListener("keyup", findCourseByName);

function findCourseByName() {
	let textBox = document.getElementById("findCourse").value;
	if(textBox != "") {
		axios.post(
			"SearchCourseName",
			null,
			{params: {searchName: textBox}} ).then(function(response) {
				printCourses(response.data);
			}).catch(function(error) {
				console.log(error);
			});
		}
	}
		

function printCourses(courses) {
	let divResult = document.getElementById("listResultCourses");
	let resultHtml = '<div><ul>';
	for(let course of courses) {
		resultHtml = resultHtml + `<li><span>Nombre del curso: </span>${courses.name}</li>`;
	}
	resultHtml = resultHtml + '</ul></div>';
	
	divResult.innerHTML = resultHtml;
}	
	
