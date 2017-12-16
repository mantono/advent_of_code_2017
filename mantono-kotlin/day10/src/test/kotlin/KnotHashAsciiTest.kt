import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KnotHashAsciiTest
{
	@Test
	fun testEmptyInput()
	{
		val result = knotHashAscii("")
		assertEquals("a2582a3a0e66e6e86e3812dcb672a272", result)
	}

	@Test
	fun testAoC2017()
	{
		val result = knotHashAscii("AoC 2017")
		assertEquals("33efeb34ea91902bb2f59c9920caa6cd", result)
	}
}