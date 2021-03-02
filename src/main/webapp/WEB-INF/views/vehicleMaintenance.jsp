<!DOCTYPE html>
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link
		href="https://fonts.googleapis.com/css?family=Josephin
		+Sansheet&display=swap"/>
		<link rel="stylesheet" href="styles/style.css"/>
        <title>vehicle details</title>
    </head>
    <body>
		<!-- <p>${errorMessage}</p> -->
		<form action ="/vehicle.do" method="POST">
			<center><h1>Vehicle Details Maintenance</h1></center>
			<div <div style="display: inline-block; text-align: right; width: 100%">
				<label for="date">date:</label>
			</div>

			<table>

				<tr height="40px">
					<td><label for ="registrationLbl">Registration</label></td>
					<td><input type="text" id="registration" val;ue="${registration}"/></td>
				</tr>
				<tr height="40px" >
					<td><label for="vehicleTypeLbl">Vehicle Type</label></td>

					<td>
							<select name="vehicleTypeBox" id="vehicleType" value="${vehicleType}">
								<option value="selectType">Please select</option>
								<option value="largeVan">large Van</option>
								<option value="Estate">Estate car</option>
								<option value="Car">Car</option>
							</select>
					</td>

				</tr>

				<tr height="40px">
					<td><label for="engineSizeLbl">Engine Size</label></td>
					<td><input type="text" id="engineSize" value="${engineSize}"/></td>
				</tr>
				<tr height="40px" >
					<td><label for ="dailyRentalPriceLbl">Daily Rental Price</label></td>
					<td><input type="text" id="dailyRentalPrice" value="${dailyRentalPrice}"/></td>
				</tr>
			</table>

			<center>
					<table>
						<tr height="40px">
							<td>
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
										<span class="btn-text-one">Remove</span>
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