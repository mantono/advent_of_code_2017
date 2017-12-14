package com.mantono.aoc

import java.util.*

fun main(args: Array<String>)
{
	val inputList = CircularList((0 .. 255).toMutableList())
	val lengthList = LinkedList(listOf(14,58,0,116,179,16,1,104,2,254,167,86,255,55,122,244))
	val result = knotHash(inputList, lengthList)
	println(result[0] * result[1])
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