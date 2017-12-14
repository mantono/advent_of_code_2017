package com.mantono.aoc

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReversedIndexTest
{
	@Test
	fun testReversedIndexInListSizeBounds1()
	{
		val i = reversedIndexOf(0, 3, 5)
		assertEquals(2, i)
	}

	@Test
	fun testReversedIndexInListSizeBounds2()
	{
		val i = reversedIndexOf(1, 3, 5)
		assertEquals(1, i)
	}

	@Test
	fun testReversedIndexInListSizeBounds3()
	{
		val i = reversedIndexOf(2, 3, 5)
		assertEquals(0, i)
	}

	@Test
	fun testReversedIndexOutOfListSizeBounds1()
	{
		val i = reversedIndexOf(3, 4, 5)
		assertEquals(1, i)
	}

	@Test
	fun testReversedIndexOutOfListSizeBounds2()
	{
		val i = reversedIndexOf(4, 4, 5)
		assertEquals(0, i)
	}
}