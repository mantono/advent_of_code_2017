package com.mantono.aoc

import java.util.*

fun main(args: Array<String>)
{
	val result = knotHash(mutableListOf(0, 1, 2, 3, 4), LinkedList(listOf(3, 4, 1, 5)))
	println(result)
}

tailrec fun knotHash(
		input: MutableList<Int>,
	 	lengths: Deque<Int>,
		index: Int = 0,
		skipSize: Int = 0
): List<Int>
{
	if(lengths.isEmpty()) return input
	val indices = index .. lengths.first
	val slice = input.slice(indices)
	slice.reversed().forEachIndexed { sliceIndex, n ->

		input[index + sliceIndex] = n
	}

	val nextIndex = index + lengths.pop() + skipSize
	return knotHash(input, lengths, nextIndex, skipSize + 1)
}

private fun wrapAndSlice(input: MutableList<Int>, indices: IntRange, index: Int)
{

}

private fun slice(input: MutableList<Int>, indices: IntRange, index: Int)
{
	val slice = input.slice(indices)
	slice.reversed().forEachIndexed { sliceIndex, n ->
		input[index + sliceIndex] = n
	}
}