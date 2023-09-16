/**
 * 
 */
function initPageStudent() {
	axios.get(
		"FindAllCoursesPageStudent"
	).then(function(response) {
		printCourses(response.data);
	}).catch(function(error) {
		console.log(error);
	});
}

function printCourses(courses) {
	let divResult = document.getElementById("searchResult");
	let resultHtml = '<div class="courseContainer">';
	for (let course of courses) {
		resultHtml = resultHtml + `
			<div class="courseCard">
				<img src="https://images.unsplash.com/photo-1501504905252-473c47e087f8?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=320&q=80"/>
				<h4>${course.name}</h4>
				<input type="button" value="MATRICULARSE" onclick="enrollInCourse()"/>
				<input type="hidden" id="courseId" value="${course.courseId}"/>
			</div>
		`;
	}
	resultHtml = resultHtml + '</div>';

	divResult.innerHTML = resultHtml;
}

function enrollInCourse() {
	let courseIdInput = document.getElementById("courseId")
		axios.post(
			"EnrollCourse",
			null,
			{ params: { courseId : courseIdInput.value}})
			.then(function(response) {
				printCourses(response.data);
			}).catch(function(error) {
				console.log(error);
			});
	
}
