import com.mantono.aoc.computeInstructions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountInstructionTest
{
	@Test
	fun testCountInstructionsPart1()
	{
		val input: MutableList<Short> = mutableListOf(0, 3, 0, 1, -3)
		val jumps: Int = computeInstructions(input, Int.MAX_VALUE)
		assertEquals(5, jumps)
	}

	@Test
	fun testCountInstructionsPart2()
	{
		val input: MutableList<Short> = mutableListOf(0, 3, 0, 1, -3)
		val jumps: Int = computeInstructions(input, 3)
		assertEquals(10, jumps)
	}
}