function likedPost(postId, userId) {
    console.log(postId + " " + userId);
    let likeCounterElement = document.getElementById(`like-counter-${postId}`);

    $.ajax({
        url: "../doLike?postId=" + postId + "&userId=" + userId,
        dataType: 'json', // Expect JSON response
        success: function (data) {
            // Update the like counter with the new value
            likeCounterElement.textContent = data;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.error('Error:', textStatus, errorThrown);
        }
    });
}
