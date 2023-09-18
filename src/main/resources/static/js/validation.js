/*$(document).ready (function () {  
 $('#first_form').submit (function (e) {  
    e.preventDefault();  
    var first_name = $('#first_name').val();  
    var last_name = $('#last_name').val();  
    var email = $('#email').val();  
    var password = $('#password').val();  
	var number = $('#number').val();  
  	$(".error").remove();  
	if (first_name.length < 1) {  
      $('#first_name').after('<span class="error">This field is required</span>');  
    }  
	if (number.length < 1) {  
      $('#number').after('<span class="error">This field is required</span>');  
    }  
    if (last_name.length < 1) {  
      $('#last_name').after('<span class="error">This field is required</span>');  
    }  
    if (email.length < 1) {  
      $('#email').after('<span class="error">This field is required</span>');  
    } else {  
      var regEx = /^[A-Z0-9][A-Z0-9._%+-]{0,63}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/;  
      var validEmail = regEx.test(email);  
      if (!validEmail) {  
        $('#email').after('<span class="error">Enter a valid email</span>');  
      }  
    }  
    if (password.length < 8) {  
      $('#password').after('<span class="error">Password must be at least 8 characters long</span>');  
    }  
  });  */
  
  $(document).ready(function () {
 
    // Validate Username
    $("#usercheck").hide();
    let usernameError = true;
    $("#usernames").keyup(function () {
        validateUsername();
    });
 
    function validateUsername() {
        let usernameValue = $("#usernames").val();
        if (usernameValue.length == "") {
            $("#usercheck").show();
            usernameError = false;
            return false;
        } else if (usernameValue.length < 3 || usernameValue.length > 10) {
            $("#usercheck").show();
            $("#usercheck").html("**length of username must be between 3 and 10");
            usernameError = false;
            return false;
        } else {
            $("#usercheck").hide();
        }
    }
 
    // Validate Email
    const email = document.getElementById("email");
    email.addEventListener("blur", () => {
        let regex =
        /^([_\-\.0-9a-zA-Z]+)@([_\-\.0-9a-zA-Z]+)\.([a-zA-Z]){2,7}$/;
        let s = email.value;
        if (regex.test(s)) {
            email.classList.remove("is-invalid");
            emailError = true;
        } else {
            email.classList.add("is-invalid");
            emailError = false;
        }
    });
 
    // Validate Password
    $("#passcheck").hide();
    let passwordError = true;
    $("#password").keyup(function () {
        validatePassword();
    });
    function validatePassword() {
        let passwordValue = $("#password").val();
        if (passwordValue.length == "") {
            $("#passcheck").show();
            passwordError = false;
            return false;
        }
        if (passwordValue.length < 3 || passwordValue.length > 10) {
            $("#passcheck").show();
            $("#passcheck").html(
                "**length of your password must be between 3 and 10"
            );
            $("#passcheck").css("color", "red");
            passwordError = false;
            return false;
        } else {
            $("#passcheck").hide();
        }
    }
 
    // Validate Confirm Password
    $("#conpasscheck").hide();
    let confirmPasswordError = true;
    $("#conpassword").keyup(function () {
        validateConfirmPassword();
    });
    function validateConfirmPassword() {
        let confirmPasswordValue = $("#conpassword").val();
        let passwordValue = $("#password").val();
        if (passwordValue != confirmPasswordValue) {
            $("#conpasscheck").show();
            $("#conpasscheck").html("**Password didn't Match");
            $("#conpasscheck").css("color", "red");
            confirmPasswordError = false;
            return false;
        } else {
            $("#conpasscheck").hide();
        }
    }
 
    // Submit button
    $("#submitbtn").click(function () {
        validateUsername();
        validatePassword();
        validateConfirmPassword();
        validateEmail();
        if (
            usernameError == true &&
            passwordError == true &&
            confirmPasswordError == true &&
            emailError == true
        ) {
            return true;
        } else {
            return false;
        }
    });
});