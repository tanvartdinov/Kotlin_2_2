import java.time.LocalDateTime

object WallService {
    private var posts = emptyArray<Post>()
    private var nextId = 1

    fun add(post: Post): Post {
        posts += post.copy(id = nextId)
        nextId++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        val index = posts.indexOfFirst { current -> post.id == current.id }
        return if (index == -1) {
            false
        } else {
            posts[index] = post
            true
        }
    }


}