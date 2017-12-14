package com.mantono.aoc

import java.io.File
import java.nio.file.Files

fun main(args: Array<String>)
{
	val instructions: MutableList<Short> = Files.readAllLines(File("input").toPath())
			.asSequence()
			.map { it.toShort() }
			.toMutableList()

	println(computeInstructions(instructions))
}

tailrec fun computeInstructions(instructions: MutableList<Short>, index: Int = 0, steps: Int = 0): Int
{
	if(index < 0 || index > instructions.lastIndex) return steps
	val jump: Int = instructions[index].toInt()
	val goto: Int = index + jump
	instructions[index]++
	return computeInstructions(instructions, goto, steps + 1)
}