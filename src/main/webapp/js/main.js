$(document).ready(function() {
	setSearchTypeAndSearch("all");
});

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
	}
}

function searchPoemById() {
	var value = $("input[name='searchPoemByIdInput']").val();
	search("/id/"+value, 0);
}

function searchPoemByBookAndPoemNumber() {
	var bookNum = $("input[name='searchPoemByBookNumInput']").val();
	var poemNum = $("input[name='searchPoemByPoemNumInput']").val();
	search("/num/"+bookNum+"/"+poemNum, 0);
}

function searchPoemByAuthor(page) {
	var author = $("input[name='searchPoemByAuthorInput']").val();
	search("/author/"+author, page);
}

function searchPoemAll(page) {
	search("/all", page);
}

function search(suffixURL, page) {
	if(page == 0)
		url = "tang"+suffixURL;
	else
		url = "tang"+suffixURL+"/"+page;
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

function clearTable() {
	$("tbody").empty();
	$(".table").hide();
}

function setSearchTypeAndSearch(searchType) {
	// all author id num
	$("input[name='searchType']").val(searchType);
	setPagination(1);
}