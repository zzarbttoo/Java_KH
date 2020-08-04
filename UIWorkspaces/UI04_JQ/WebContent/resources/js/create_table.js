function makeTable(elem) {
	// table border = 1인 테이블을 생성함
	$table = $("<table border=1>");

	for (var i = 0; i < 1; i++) {

		$tr = $("<tr>");
		//console.log(elem.eq(0));
		for (var j = 0; j < elem.eq(0).children().length; j++) {

			$td = $("<td>").append(elem.eq(0).children().eq(j).prop("tagName"));
			$tr.append($td);

		}

		// console.log($tr);
		$table.append($tr);

	}

	for (var i = 0; i < elem.length; i++) {

		$tr = $("<tr>");
		//console.log(i);
		//console.log(elem.eq(i).children());
		for (var j = 0; j < elem.eq(i).children().length; j++) {

			$td = $("<td>").append(elem.eq(i).children().eq(j).text());
			$tr.append($td);

		}

		$table.append($tr);

	}

	console.log($table);
	return $table;
}