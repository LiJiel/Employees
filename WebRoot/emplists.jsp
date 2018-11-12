<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="/Employees/css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							<s:date name="#session.date" format="yyyy-MM-dd HH:mm:ss"/>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome<s:property value="#session.username"/>!
					</h1>
				
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Salary
							</td>
							<td>
								Age
							</td>
							<td>
								Operation
							</td>
						</tr>
						<s:iterator value="#session.list" status="sta">
							<tr 
								<s:if test="#sta.count%2!=0">
									class="row1"
								</s:if>
								<s:if test="#sta.count%2==0">
									class="row2"
								</s:if>
							>
								<td><s:property value="id"/></td>
								<td><s:property value="name"/></td>
								<td><s:property value="salary"/></td>
								<td><s:property value="age"/></td>
								<td>
								<a href="<s:url action='sh_deleteEm' namespace='/p2'></s:url>?show.id=<s:property value="id"/>">delete emp</a>&nbsp;<a href="/Employees/update.jsp?id=<s:property value='id'/>&name=<s:property value='name'/>&salary=<s:property value='salary'/>&age=<s:property value='age'/>">update emp</a>
								</td>
							</tr>
						</s:iterator>
					</table>
					<p>
						<input type="button" class="button" value="Add Employee" onclick="location='/Employees/add.jsp'"/>
					</p>
				
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
