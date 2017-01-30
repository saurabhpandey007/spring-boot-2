<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>Detail</title>
	<link rel="stylesheet" href="/css/detail.css" type="text/css">
</head>
<body>
		<div class="centered">
			<h2>Run Job Details Of Job Id ${requestScope.JobId}</h2>
			<div>
				<c:choose>
                    <c:when test="${JobDetails eq null}">
                       <h3>No Data found!</h3>
                    </c:when>
                    <c:otherwise>
						<table>
								
								<tr>
								    <th>STATUS</th>
								    <th>LOWER TIME</th> 
								    <th>UPPER TIME</th>
								    <th>START TIME</th>
								    <th>END TIME</th>
					  			</tr>
					  			
							<c:forEach items="${requestScope.JobDetails}" var="Job">
								<tr>
									<td>
									${Job.status}
									</td>
									<td>
									<fmt:formatDate value="${Job.lowerTime}" pattern="dd-MMM-yyyy | hh:mm:ss"/>
									</td>
									<td>
									<fmt:formatDate value="${Job.upperTime}" pattern="dd-MMM-yyyy | hh:mm:ss"/>
									</td>
									<td>
									<fmt:formatDate value="${Job.fromTime}" pattern="dd-MMM-yyyy | hh:mm:ss"/>
									</td>
									<td>
									<fmt:formatDate value="${Job.toTime}" pattern="dd-MMM-yyyy | hh:mm:ss"/>
									</td>
								</tr>
							</c:forEach>
						
						</table>
				</c:otherwise>
                </c:choose>
			</div>
		</div>
</body>
</html>
