<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<style>
       /* Main container styling */
       .registration-container {
            width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 2px solid #4CAF50; /* Border color */
            border-radius: 12px;
            background-color: #e8f5e9; /* Light green background */
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            font-family: Arial, sans-serif;
        }

        /* Heading styling */
        .registration-heading {
            text-align: center;
            color: #2e7d32; /* Dark green text color */
            font-size: 24px;
            font-weight: bold;
        }

        /* Input field styling */
        .input-field {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #a5d6a7; /* Light green border */
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
        }

        /* Input field hover and focus effects */
        .input-field:focus {
            border-color: #388e3c; /* Darker green border on focus */
            outline: none;
            box-shadow: 0 0 5px rgba(56, 142, 60, 0.5);
        }

        /* Label styling */
        label {
        align:left;
            font-weight: bold;
            color: #1b5e20; /* Darker green label color */
        }

.button-container {
    display: flex;
    justify-content: space-between;
    width: 100%;
    margin-top: 20px; /* Adds spacing above the button container */
}

/* Shared styles for submit and reset buttons */
input[type="submit"],
input[type="reset"] {
    width: 48%; /* Reduced width to fit side by side */
    padding: 12px;
    font-size: 18px;
    font-weight: bold;
    color: black;
    background-color: lightgreen; /* Green background */
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

/* Submit button hover effect */
input[type="submit"]:hover {
    background-color: #388e3c; /* Darker green on hover */
}

/* Reset button hover effect */
input[type="reset"]:hover {
    background-color: red; /* Darker green on hover */
}


</style>
</head>
<body>
<%@include file="mainnavbar.jsp" %>
<br>
<div class="registration-container">
    <h2 class="registration-heading">Registration Form</h2>
    <form action="insertcustomer" method="post">
        <label for="name">Name:</label>
        <input type="text" name="cname" class="input-field" required><br>

        <label for="gender">Gender:</label>
         <select  name="cgender" class="input-field" required>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Others">Others</option>
            </select>

        <label for="dob">Date of Birth:</label>
        <input type="date"  name="cdob" class="input-field" required><br>

        <label for="email">Email:</label>
        <input type="email" name="cemail" class="input-field" required><br>

        <label for="password">Password:</label>
        <input type="password" name="cpassword" class="input-field" required><br>

        <label for="location">Location:</label>
        <input type="text" name="clocation" class="input-field" required><br>

        <label for="contact">Contact:</label>
        <input type="number"  name="ccontact" class="input-field" required><br>

        <div class="button-container">
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</div>
        
    </form>
</div>
</body>
</html>