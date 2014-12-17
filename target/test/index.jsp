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
							//$('#from-list').empty();
							//showfromOptions()

							function showfromOptions() {
								$
										.ajax({
											type : "GET",
											url : "http://localhost:8085/FileFormatConverterWS/rest/options/from",
											success : function(data) {
												var remove = data.replace('[',
														'');
												remove = remove
														.replace(']', '');

												var array = remove.split(',');

												for (var i = 0; i < array.length; i++) {
													$('#from-list').append(
															new Option(
																	array[i],
																	array[i]));
												}
											}
										});

							}
						});

		/* $("#submit")
				.click(
						function() {

							//alert("in submit");
							var request = new FormData();
							var from = $("#from-list option:selected").val();
							var to = $("#to-list option:selected").val()

							var url = "http://localhost:8085/FileFormatConverterWS/rest/convert/param/"
									+ from + "/" + to;
							alert(url);
							$.ajax({
								url : url,
								type : "POST",
								data : request,
								processData : false,
								contentType : false,
								success : function(result) {
									alert("data")
								},
								error : function(xhr, msg) {
									alert("error");
								}
							});
						});
 */
	});
</script>
</head>
<body>
	 <form action="http://localhost:8085/FileFormatConverterWS/rest/convert/param/doc/pdf"
        method="POST" enctype="multipart/form-data" > 
	
		<Table>
			<tr>
				<td>Input format:</td>
				<td><select name="input" id="from-list">
						<option value="xml">XML</option>
						<option value="csv">CSV</option>
						<option value="doc">DOC</option>
						<option value="pdf">PDF</option>
				</select></td>
			</tr>
			<tr>
				<td>Output format:</td>
				<td><select name="output" id="to-list">
						<option value="xml">XML</option>
						<option value="csv">CSV</option>
						<option value="doc">DOC</option>
						<option value="pdf">PDF</option>
				</select></td>
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
