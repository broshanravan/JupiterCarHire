<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link
		href="https://fonts.googleapis.com/css?family=Josephin
		+Sansheet&display=swap"/>
		<link rel="stylesheet" href="style.css"/>
        <title>Booking</title>

    </head>
    <body>

		<form action ="/booking.do" method="POST">
			<center><h1>Vehicle Booking</h1></center>
			<div style="display: inline-block; text-align: right; width: 100%">
				<h4>Date: <span id="datetime"></span></h4>

			<script>
			var dt = new Date();
			document.getElementById("datetime").innerHTML = (("0"+dt.getDate()).slice(-2)) +"/"+
			(("0"+(dt.getMonth()+1)).slice(-2)) +"/"+ (dt.getFullYear());
			</script>
		</div>

			<h3 for="velicletDetaildLbl">Vehicle Details:</h3>
			<table>
				<tr height="40px" >
					<td " ><label for="vehicleTypeLbl">Vehicle Type</label></td>

					<td>
							<select name="vehicleTypeBox" id="vehicleType">
								<option value="selectType">Please select</option>
								<option value="largVan">larg Van</option>
								<option value="Estate">Estate car</option>
								<option value="Car">Car</option>
							</select>
					</td>

				</tr>

				<tr height="40px">
					<td><label for="dayNumLbl">Number of Days</label></td>
					<td>
						<select name="dayNumberBox" id="dayNum">
								<option value="o">Please select</option>
								<option value="1">one</option>
								<option value="2">Two</option>
								<option value="3">Three</option>
								<option value="5">Five</option>
								<option value="6">Six</option>
								<option value="7">Seven</option>
								<option value="8">Eight</option>
								<option value="9">Nine</option>
								<option value="10">Ten</option>
						</select>
					</td>
				</tr>
			</table>

			<h3 for="custDetaildLbl">Customer Details:</h3>
			<div class ="myDiv">
			<table>
					<tr height="40px">
						<td><label for="titleLba">Title</label></td>
						<td>
								<select name ="titlr" id="title">
									<option value="selectTtle">Please select</option>
									<option value="Mr">Mr</option>
									<option value="Mrs">Mrs</option>
									<option value="Miss">Miss</option>
									<option value="Ms">Ms</option>
								</select>
						</td>

						<td><label for ="firstNsmeLbl">First Name</label></td>
						<td><input type="text" id="firstName"/></td>

						<td><label for="surnameLbl">Surname</label></td>
						<td><input type="text" id="surname"/></td>

						<td><label for ="CompanyNameLbl">Company Name</label></td>
						<td><input type="text" id="CompanyNam"/></td>
					</tr>


			</table>
			</div>
			<h3 for="addressLbl">Address:</h3>
			<div class ="myDiv">
				<table>

									<tr height="40px">
										<td><label for="houseNumLbl">House Number</label></td>
										<td><input type="text" id="houseNum"/></td>

										<td><label for="houseNameeLbl">House Name</label></td>
										<td><input type="text" id="houseName"/></td>
									</tr>

									<tr height="40px">
										<td><label for="addlLbl">Adresse</label></td>
										<td><input type="text" id="add1Fld"/></td>

										<td><label for="add2lbl"></label></td>
										<td><input type="text" id="add2Fld"/></td>
									</tr>

									<tr height="40px">
										<td ><label for="townLbl">Post Town</label></td>
										<td><input type="text" id="townFld"/></td>

										<td><label for="postCodeLbl">Post Code</label></td>
										<td><input type="text" id="postCodeFld"/></td>
									</tr>

									<tr height="40px">
										<td><label for="telLbl">Telephone Number</label></td>
										<td><input type="text" id="tellFld"/></td>
									</tr>
									<tr height="40px">
										<td><label for="blnk1">&emsp;</label></td>
										<td><label for="blnk2">&emsp;</label></td>
									</tr>

				</table>
			</div>

			<h3 for="paymentLbl">Payment:</h3>
			<div class ="myDiv">
				<table>
						<tr height="40px">
							<td><label for="total">Total Due &#163;</label></td>
							<td><input type="text" id="total"/></td>

							<td><label for="sp1">&emsp;</label></td>

							<td><label for="depositLbl">Deposit &#163;</label></td>
							<td><input type="text" id="depositFld"/></td>

							<td><label for="sp2"&emsp;</label></td>

							<td><label for="balance">Balance &#163;</label></td>
							<td><input type="text" id="balance"/></td>
						<tr>
				</table>
			</div>
			<br/><br/><br/>
			<center>

					<table>
						<tr height="40px">
							<td>
								<!--<input type="button" value="create" name="submit1" onClick="submitMe( this.form )"> -->
								<div class="btn-wrapper">
									<button class="btn">
										<span class="btn-text-one">Create</span>
									</button>
								</div>
							</td>
							<td><label for="sp1">&emsp;</label></td>
							<td><label for="sp1">&emsp;</label></td>
							<td>
								<div class="btn-wrapper">
									<button class="btn">
										<span class="btn-text-one">Update</span>
									</button>
								</div>

							</td>

							<td><label for="sp1">&emsp;</label></td>
							<td><label for="sp1">&emsp;</label></td>

							<td>
								<div class="btn-wrapper">
									<button class="btn">
										<span class="btn-text-one">Close</span>
									</button>
								</div>
							</td>

							<td><label for="sp1">&emsp;</label></td>
							<td><label for="sp1">&emsp;</label></td>

							<td>
								<div class="btn-wrapper">
									<button class="btn">
										<span class="btn-text-one">Cancel</span>
									</button>
								</div>
							</td>
						</tr>
					</table>

			</center>
		</form>
    </body>
</html>