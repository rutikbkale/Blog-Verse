document.addEventListener('DOMContentLoaded', function () {
    const msgElement = document.getElementById('msg');
    if (msgElement) {
        const msg = msgElement.value.trim();
        console.log(msg)
        if (msg === 'done') {
            swal({
                title: "Successfully Edited!",
                icon: "success",
            }).then((value) => {
                window.location = "user/dashboard"; // Ensure this matches your actual dashboard path
            });
        } else if (msg === 'error') {
            swal({
                title: "Failed Edit!",
                text: "Invalid credentials. Please try again.",
                icon: "error",
            });
        }
    }
});
