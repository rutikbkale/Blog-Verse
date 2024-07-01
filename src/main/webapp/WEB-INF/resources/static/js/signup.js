document.addEventListener('DOMContentLoaded', function () {
    var msgValue = document.getElementById('msg').value.trim();
    if (msgValue) {
        swal({
            title: "Registered Successfully !",
            icon: "success",
        }).then((value) => {
            window.location = "signin";
        });
    } else {
        swal({
            title: "Failed To Register!",
            icon: "error",
        }).then((value) => {
            window.location = "signup";
        });
    }
});
