<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./assets/css/style_login.css">
<title>Document</title>
</head>
<body>
	<div class="page">
		<div class="form">
			<div class="form-panel one">
				<h3 style="color: red; text-align: center;"><%
					if (session.getAttribute("error") != null) {
						out.print(session.getAttribute("error"));
					}
				%></h3>
				<div class="form-header">
					<h1>Account Login</h1>
				</div>
				<div class="form-content">
					<form action="login" method="post" name="login">
						<div class="form-group">
							<label for="username">Username</label><input type="text"
								id="username" name="username" required="required" />
						</div>
						<div class="form-group">
							<label for="password">Password</label><input type="password"
								id="password" name="password" required="required" />
						</div>
						<div class="form-group">
							<label class="form-remember"><input type="checkbox" />Remember
								Me</label><a class="form-recovery" href="#">Forgot Password?</a>
						</div>
						<div class="form-group">
							<button type="submit">Log In</button>
						</div>
					</form>
				</div>
			</div>
			<div class="form-panel two"></div>
		</div>
	</div>
</body>
</html>