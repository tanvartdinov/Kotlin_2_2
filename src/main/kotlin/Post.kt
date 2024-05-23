data class Post(
    val id: Int,
    val ownerId: Int,
    val date: Int,
    val text: String,
    val friendsOnly: Boolean = false,
    val comments: CommentsInfo = CommentsInfo(),
    val copyright: Copyright,
    val likes: LikesInfo = LikesInfo(),
    val postType: String = "post",
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false
)
