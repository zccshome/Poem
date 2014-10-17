$(document).ready(function() {
	// The first time we search by search type all.
	setSearchTypeAndSearch("all");
});

/**
 * Search poem of a certain page, getting search type from hidden input.
 * @param page
 */
function searchPoem(page) {
	var searchType = $("input[name='searchType']").val();
	switch(searchType) {
		case "all":
			searchPoemAll(page);
			break;
		case "author":
			searchPoemByAuthor(page);
			break;
		case "id":
			searchPoemById();
			break;
		case "num":
			searchPoemByBookAndPoemNumber();
			break;
		case "pattern":
			searchPoemByPattern(page);
			break;
	}
}

/**
 * Search by ID.
 */
function searchPoemById() {
	var value = $("input[name='searchPoemByIdInput']").val();
	search("/id/"+value, 0);
}

/**
 * Search by book and poem number.
 */
function searchPoemByBookAndPoemNumber() {
	var bookNum = $("input[name='searchPoemByBookNumInput']").val();
	var poemNum = $("input[name='searchPoemByPoemNumInput']").val();
	search("/num/"+bookNum+"/"+poemNum, 0);
}

/**
 * Search by author of a certain page.
 * @param page
 */
function searchPoemByAuthor(page) {
	var author = $("input[name='searchPoemByAuthorInput']").val();
	search("/author/"+author, page);
}

function searchPoemByPattern(page) {
	var pattern = $("input[name='searchPoemByPatternInput']").val();
	url = "alldynasty/pattern/"+page;
	$.ajax({
		url: url,
		type: "GET",
		contentType: "application/json",
		data: {"pattern": pattern},
		dataType:"json",
		success: function(poem) {
			var html  = $("#poemTemplate").render(poem);
			$("tbody").append(html);
			$(".table").show();
		}
	});
	
}

/**
 * Search all of a ceratin page.
 * @param page
 */
function searchPoemAll(page) {
	search("/all", page);
}

/**
 * The function sends an AJAX request to the server.
 * @param suffixURL
 * @param page
 */
function search(suffixURL, page) {
	if(page == 0)
		url = "alldynasty"+suffixURL;
	else
		url = "alldynasty"+suffixURL+"/"+page;
	
	$.ajax({
		url: url,
		type: "GET",
		contentType: "application/json",
		dataType:"json",
		success: function(poem) {
			var html  = $("#poemTemplate").render(poem);
			$("tbody").append(html);
			$(".table").show();
		}
	});
}

/**
 * Clear the table.
 */
function clearTable() {
	$("tbody").empty();
	$(".table").hide();
}

/**
 * HTML pages search by calling this function.
 * @param searchType
 * @returns
 */
function setSearchTypeAndSearch(searchType) {
	// all author id num pattern
	$("input[name='searchType']").val(searchType);
	return setPagination(1);
}