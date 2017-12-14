package com.mantono.aoc

import java.util.*

fun main(args: Array<String>)
{
	val inputList = CircularList(mutableListOf(0, 1, 2, 3, 4))
	val lengthList = LinkedList(listOf(3, 4, 1, 5))
	val result = knotHash(inputList, lengthList)
	println(result)
}

tailrec fun knotHash(
		input: CircularList<Int>,
	 	lengths: Deque<Int>,
		index: Int = 0,
		skipSize: Int = 0
): List<Int>
{
	if(lengths.isEmpty()) return input
	val indices = index .. (index + lengths.first - 1)
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

fun reversedIndexOf(i: Int, subListSize: Int, listSize: Int): Int
{
	return ((subListSize - 1) - i) % listSize
}

// 3 -> 1
// 4 -> 0

class CircularList<T>(private val list: MutableList<T> = ArrayList()): MutableList<T> by list
{
	override operator fun get(index: Int): T = list[index % this.size]
	override operator fun set(index: Int, element: T): T
	{
		val previous = list[index % this.size]
		list[index % this.size] = element
		return previous
	}

	override fun toString(): String
	{
		return this.joinToString(separator = ", ")
	}

	fun slice(indices: IntRange): List<T>
	{
		if(indices.endInclusive <= lastIndex)
			return subList(indices.start, indices.endInclusive + 1)
		return indices.map { this[it] }.toList()
	}
}