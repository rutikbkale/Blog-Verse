document.addEventListener('DOMContentLoaded', function () {
    var msgValue = document.getElementById('msg').value.trim();
    if (msgValue == true) {
        swal({
            title: "Login Successfully !",
            icon: "success",
        }).then((value) => {
            window.location = "user/dashboard";
        });
    } else {
        swal({
            title: "Failed To Login!",
            icon: "error",
        }).then((value) => {
            window.location = "signin";
        });
    }
});
