function makeTable(elem) {
	// table border = 1인 테이블을 생성함
	//var 변수를 선언한는 것과 아닌 것의 차이(변수의 호이스팅)
	/*
	 * var <- 함수의 젤 위에 있다고 생각하기(함수 스코프)
	 * let/const <- block 스코프(권장)
	 * 
	 * 스코프 : 영역
	 * var 변수를 생략하면 전역변수처럼 사용하게 된다(윈도우 객체처럼 생각이 된다)
	 * 
	 * 그래서 나중에 변수의 영역도 잘 생각을 해줘야한다
	 */
	$table = $("<table border=1>");

	for (var i = 0; i < 1; i++) {

		//$를 붙이면 jquery 변수이며, 객체 사용을 쉽게 할 수 있다
		//tr이라는 태그를 만들었다
		$tr = $("<tr>");
		console.log("eq(0)");
		console.log(elem.eq(0).children().prop("tagName"));
		for (var j = 0; j < elem.eq(0).children().length; j++) {

			$td = $("<td>").append(elem.eq(0).children().eq(j).prop("tagName"));
			$tr.append($td);

		}

		console.log($tr);
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