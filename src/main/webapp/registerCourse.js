/**
 * 
 */
function initRegister() {
	loadCategories();
}
function loadCategories() {
	axios.get("CoursesCategory").then(function(response) {
		console.log(response);
		let categorySelect = document.getElementById("select");
		let options = "";
		let categories = response.data;

		for (let category of categories) {
			options = options +
				`<option value="${category.categoryId}">${category.nameCategory}</option>`;
		}
		categorySelect.innerHTML = options;
	}).catch(function(error) {
		console.log(error);
	})
}