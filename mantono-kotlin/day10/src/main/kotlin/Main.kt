package com.mantono.aoc

import java.io.File
import java.nio.file.Files
import java.util.*

val end: ByteArray = byteArrayOf(17, 31, 73, 47, 23)

fun main(args: Array<String>)
{
	val file = File("input").toPath()
	val inputAscii: ByteArray = Files.readAllBytes(File("input").toPath())
	val completeInputAscii: CircularList<Byte> = CircularList((inputAscii + end).toMutableList())
	completeInputAscii.forEach { println(it) }

	val inputInts: List<Int> = Files.readAllLines(file)
			.map { it.split(",") }
			.flatMap { it }
			.map { it.toInt() }

	val inputList = CircularList((0 .. 255).toMutableList())
	val lengthList = LinkedList(inputInts)
	val result = knotHash(inputList, lengthList)
	println(result[0] * result[1])

	knotHash(completeInputAscii, lengthList, 64)
			.partition {  }
}

tailrec fun <T> knotHash(
		input: CircularList<T>,
	 	lengths: Deque<Int>,
		repeat: Int = 1,
		index: Int = 0,
		skipSize: Int = 0
): List<T>
{
	if(lengths.isEmpty()) return input
	val indices = index .. (index + lengths.first - 1)
	for(i in 1 .. repeat)
	{
		val slice = input.slice(indices)
		slice.reversed().forEachIndexed { sliceIndex, n ->
			input[index + sliceIndex] = n
		}
	}

	val nextIndex = index + lengths.pop() + skipSize
	return knotHash(input, lengths, repeat, nextIndex, skipSize + 1)
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

	fun slice(indices: IntRange): List<T> = indices.map { this[it] }
}