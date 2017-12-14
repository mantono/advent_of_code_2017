import com.mantono.aoc.computeInstructions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountInstructionTest
{
	@Test
	fun testCountInstructions()
	{
		val input: MutableList<Short> = mutableListOf(0, 3, 0, 1, -3)
		val jumps: Int = computeInstructions(input)
		assertEquals(5, jumps)
	}
}