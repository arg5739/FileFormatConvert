<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>File format conversion</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script>
	$(function() {
		$(document)
				.ready(
						function() {
							$('#from-list').empty();
							showfromOptions()

							$("#from-list").change(function() {
								$('#to-list').empty();
								$
								.ajax({
									type : "GET",
									url : "http://localhost:8085/FileFormatConverterWS/rest/options/to/"+ $('#from-list :selected').text(),

									success : function(data) {
										alert
										var dataJson = $
												.parseJSON(data);
										$('#to-list')
										.append(
												new Option(
														"",
														""));
										for (var i = 0; i < dataJson.length; i++) {
											$('#to-list')
													.append(
															new Option(
																	dataJson[i],
																	dataJson[i]));
										}
									}
								});
							});

							function showfromOptions() {
								$
										.ajax({
											type : "GET",
											url : "http://localhost:8085/FileFormatConverterWS/rest/options/from",

											success : function(data) {
												
												var dataJson = $
														.parseJSON(data);
												$('#from-list')
												.append(
														new Option(
																"",
																""));
									
												for (var i = 0; i < dataJson.length; i++) {
													$('#from-list')
															.append(
																	new Option(
																			dataJson[i],
																			dataJson[i]));
												}
											}
										});

							}
						});
		
		
		$("#to-list").change(function() {
			var url = "http://localhost:8085/FileFormatConverterWS/rest/convert/param/"+ $('#from-list :selected').text()+"/";
			
			url = url +  $('#to-list :selected').text()
			 
			  
			  $("#formSend").attr("action", url);
			  $("#formSend")[0].submit();
		});


		 /* $("#submit")
				.click(
						function() {
							
							var from = $("#from-list option:selected").val();
							var to = $("#to-list option:selected").val()

							var url = "http://localhost:8085/FileFormatConverterWS/rest/convert/param/"
									+ from + "/" + to;
							var formData = new FormData($('form'));
							$
							.ajax({
								type : "POST",
								url : url,
								data : formData,
								success : function(data) {
									alert(data);
								}
							});
						}); */
		
	});
</script>
</head>
<body>
	<!--  
	<form
		action="http://localhost:8085/FileFormatConverterWS/rest/convert/param/doc/pdf"
		method="POST" enctype="multipart/form-data">
-->
	<form id="formSend" method="POST" enctype="multipart/form-data">
		<Table>
			<tr>
				<td>Input format:</td>
				<td><select id="from-list">

				</select></td>
			</tr>
			<tr>
				<td>Output format:</td>
				<td><select id="to-list"></td>
			</tr>
			<tr>
				<td>Upload File:</td>
				<td><input type="file" name="file" id="fileSubmit" size="40"></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="Submit"
					id="submit"></td>
			</tr>
		</Table>
	</form>
</body>
</html>
