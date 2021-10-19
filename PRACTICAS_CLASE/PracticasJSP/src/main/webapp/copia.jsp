<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	int nums;
	boolean primo = true;
	for(int i = 1; i <= 100; i++){
		nums = (int)(Math.random()*(101-1)+1);
		/* out.print(nums + " - "); */
	
		for(int p = 2; p < nums; p++){
			if(nums%p == 0){
				primo = false;
			}
		}
		if(primo){%>
			<div style="red"> <% out.print(nums); %>  </div>
<%
		}else {%>
			<div style="color:green"> <% out.print(nums); %>  </div>
		<%
		}
	}
%>

</body>
</html>