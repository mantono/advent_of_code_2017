package com.mantono.aoc

import java.io.File
import java.nio.file.Files

fun main(args: Array<String>)
{
	val instructions: List<Short> = Files.readAllLines(File("input").toPath())
			.asSequence()
			.map { it.toShort() }
			.toList()

	println(computeInstructions(instructions.toMutableList()))
	println(computeInstructions(instructions.toMutableList(), 3))
}

tailrec fun computeInstructions(instructions: MutableList<Short>, decreaseThreshold: Int = Int.MAX_VALUE, index: Int = 0, steps: Int = 0):
		Int
{
	if(index < 0 || index > instructions.lastIndex) return steps
	val jump: Int = instructions[index].toInt()
	val goto: Int = index + jump
	when(jump >= decreaseThreshold)
	{
		true -> instructions[index]--
		false -> instructions[index]++
	}
	return computeInstructions(instructions, decreaseThreshold, goto, steps + 1)
}