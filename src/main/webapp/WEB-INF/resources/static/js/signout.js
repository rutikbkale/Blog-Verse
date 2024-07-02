function signout() {
    swal({
        title: 'Sign out?',
        text: 'Are you sure you want to sign out?',
        icon: 'warning',
        buttons: {
            cancel: {
                text: 'Cancel',
                visible: true,
                closeModal: true
            },
            confirm: {
                text: 'Sign Out',
                closeModal: true
            }
        }
    }).then((willSignOut) => {
        if (willSignOut) {
            window.location.href = '../home';
        }
    });
}
