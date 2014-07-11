var PAGESIZE = 10;

function firstPage() {
	setPagination(1);
}

function prevPage(num) {
	var currPage = $(".currPage a").html();
	setPagination(parseInt(currPage)-num);
}

function nextPage(num) {
	var currPage = $(".currPage a").html();
	setPagination(parseInt(currPage)+num);
}

function lastPage() {
	setPagination(-1);
}

function setPagination(page) {
	clearTable();
	clearPagination();
	var searchType = $("input[name='searchType']").val();
	var total = 0;
	switch(searchType) {
		case "all":
			total = countPoem("count");
			break;
		case "author":
			var author = $("input[name='searchPoemByAuthorInput']").val();
			total = countPoem("count/"+author);
			break;
		default:
			total = 1;
			break;
	}
	var pageNum = Math.ceil(total / PAGESIZE);
	
	if(page == -1)
		page = pageNum;
	
	searchPoem(page);
	
	if(page <= 1) {
		$(".prevPage").addClass("disabled");
		$(".firstPage").addClass("disabled");
		$(".prev1Page").hide();
	}
	if(page <= 2)
		$(".prev2Page").hide();
	if(page <= 3)
		$(".prev3Page").hide();
	
	if(page >= pageNum) {
		$(".nextPage").addClass("disabled");
		$(".lastPage").addClass("disabled");
		$(".next1Page").hide();
	}
	if(page >= pageNum-1)
		$(".next2Page").hide();
	if(page >= pageNum-2)
		$(".next3Page").hide();
	
	$(".currPage a").html(page);
	if(page >= 3)
		$(".prev2Page a").html(page-2);
	if(page >= 2)
		$(".prev1Page a").html(page-1);
	
	if(page-2 <= pageNum)
		$(".next2Page a").html(page+2);
	if(page-1 <= pageNum)
		$(".next1Page a").html(page+1);
}

function clearPagination() {
	$(".pagination li").removeClass("disabled");
	$(".pagination li").show();
	$(".currPage").addClass("disabled");
}

function countPoem(suffixURL) {
	var count = 0;
	$.ajax({
		url: "tang/"+suffixURL,
		type: "GET",
		async: false,
		contentType: "application/json",
		dataType:"json",
		success: function(data) {
			count = data;
		}
	});
	return count;
}