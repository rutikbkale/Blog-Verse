document.addEventListener('DOMContentLoaded', function () {
    var msgValue = document.getElementById('msg').value.trim();
    if (msgValue === "done") {
        swal({
            title: "Post Added Successfully !",
            icon: "success",
        }).then((value) => {
            window.location = "viewPost";
        });
    } else {
        swal({
            title: "Failed To Register!",
            icon: "error",
        }).then((value) => {
            window.location = "dashboard";
        });
    }
});
