import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.math.exp

class WallServiceTest {
    private lateinit var firstPost: Post
    private lateinit var secondPost: Post
    private lateinit var thirdPost: Post

    @Before
    fun clearBeforeTest() {
        WallService.clear()
        firstPost = Post(
            id = 124,
            ownerId = 23421,
            date = 1716448325,
            text = "Это первый пост",
            copyright = Copyright(23421, "vk.com/23421", "Анвартдинов Тимур", "user")
        )
        secondPost = firstPost.copy(text = "Это второй пост")
        thirdPost = firstPost.copy(text = "Это третий пост")
    }

    @Test
    fun add_nextIdNotEqualsInitialValue() {
        WallService.add(firstPost)
        val actual = WallService.add(secondPost).id
        val expected = 1

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun update_successPostWithExistingId() {
        WallService.add(firstPost)
        WallService.add(secondPost)
        WallService.add(thirdPost)

        val actual = WallService.update(
            secondPost.copy(id = 1, text = "Измененный текст второго поста")
        )

        Assert.assertTrue(actual)
    }

    @Test
    fun update_FailedPostWithNotExistingId() {
        WallService.add(firstPost)
        WallService.add(secondPost)
        WallService.add(thirdPost)

        val actual = WallService.update(
            secondPost.copy(id = 5, text = "Измененный текст шестого поста")
        )

        Assert.assertFalse(actual)
    }
}