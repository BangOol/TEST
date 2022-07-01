<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
	<div id = "dovList"></div>
	<script>
		$.ajax({
			url :"req",
			method :"post",
			asnyc : false,
			data : JSON.stringify({first_name:"gildong", last_name:"kim"}),
			contentType : "json", //보내는 parameter가 json String
			dataType :"json",
			success :function(result){
				console.log("결과는")
				console.log(result);
			}
			
		})
		console.log("요청")
	</script>
</body>
</html>
