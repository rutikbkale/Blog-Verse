function likedPost(postId, userId) {
    console.log(postId + " " + userId)
    const data = {
        postId: postId,
        userId: userId
    }

    $.ajax({
        url: "../like/doLike",
        data: data,
        success: function (data, textStatus, jqXHR) {
            console.log(data)
        },
        error: function (jqXHR, textStatus, errorThrown) {

        }
    })
}