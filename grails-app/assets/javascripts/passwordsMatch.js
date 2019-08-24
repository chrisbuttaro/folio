

$('#secondPassword').focusout(function checkPasswordMatch() {
    var password = $("#password").val();
    var confirmPassword = $("#secondPassword").val();

    if (password != confirmPassword)
        $("#divCheckPasswordMatch").html("Passwords do not match!");
    else
        $("#divCheckPasswordMatch").html("Passwords match.");
});