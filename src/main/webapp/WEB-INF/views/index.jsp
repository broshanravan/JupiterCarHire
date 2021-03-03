
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link
		href="https://fonts.googleapis.com/css?family=Josephin
		+Sansheet&display=swap"/>
		<link rel="stylesheet" href="styles/style1.css"/>
        <title>Welcome</title>
    </head>
    <body>
		<!-- <p>${errorMessage}</p> -->
		<form action ="/start.do" method="POST">

		<center>
		<h1>Jupiter Car Hire</h1>
		<h3>Welcome to our application.<br/>Please use one on the following options to serve the customers or update vehicle freet for the company</h3>

		</center>

		<div <div style="display: inline-block; text-align: right; width: 100%">
				<label for="date">date:</label>
		</div>

		<center>
			<table>

				<tr>
					<td width ="50"><h3 for="vehicleDetailsLbl">Bookings</h3></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>

				<tr height="40px">
					<td></td>
					<td><label for="bookingNumLbl">Booking Number</label></td>
					<td><input type="text" id="bookingNum"/></td>
					<td>
						<div class="btn-wrapper">
							<button class="btn" action ="findBookingByNum">
								<span class="btn-text-one">Find Booking</span>
							</button>
						</div>
					</td>
				</tr>



				<tr height="40px">
					<td></td>
					<td><label for="regLbl">Vehicle Registration</label></td>
					<td><input type="text" id="vehicleReg"/></td>
					<td>
						<div class="btn-wrapper">
							<button class="btn" action= "findBookingByReg">
								<span class="btn-text-one">Find Booking</span>
							</button>
						</div>
					</td>
				</tr>

				<tr>
					<td width ="50"><h3 for="customerLbl">Customers:</h3></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>


				<tr height="40px" >
					<td></td>
					<td><label for ="emailLbl">Customer Email</label></td>
					<td><input type="text" id="email"/></td>
					<td>
						<div class="btn-wrapper" action ="findCustomerByEmail">
							<button class="btn">
								<span class="btn-text-one">find Customer</span>
							</button>
						</div>
					</td>
				</tr>



				<tr>
					<td width ="50"><h3 for="vehicleDetailsLbl">Vehicles:</h3></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>

				<tr height="40px" >
					<td></td>
					<td><label for ="CompanyNameLbl">Registration Number</label></td>
					<td><input type="text" id="registrationNum"/></td>
					<td>
							<div class="btn-wrapper">
								<button class="btn" action="findVehicleByReg">
									<span class="btn-text-one">find Vehicle</span>
								</button>
							</div>
					</td>
				</tr>
			</table>

			</center>
		</form>
    </body>
</html>
