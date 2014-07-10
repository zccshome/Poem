$(document).ready(function() {
	clearTable();
});

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