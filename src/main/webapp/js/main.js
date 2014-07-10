$(document).ready(function() {
	clearTable();
});

function searchPoemById() {
	var value = $("input[name='searchPoemByIdInput']").val();
	$.ajax({
		url: "tang/id/"+value,
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