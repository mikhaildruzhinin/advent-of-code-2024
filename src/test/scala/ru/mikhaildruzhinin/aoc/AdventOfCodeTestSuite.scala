package ru.mikhaildruzhinin.aoc

import org.scalatest.funsuite.AnyFunSuite

class AdventOfCodeTestSuite extends AnyFunSuite {
  test("day 1.1") {
    val input: String = """3   4
                          |4   3
                          |2   5
                          |1   3
                          |3   9
                          |3   3""".stripMargin

    val result: Int = Day1.calculateTotalDistance(input)
    val expected: Int = 11
    assert(result == expected)
  }

  test("day 1.2") {
    val input: String = """3   4
                          |4   3
                          |2   5
                          |1   3
                          |3   9
                          |3   3""".stripMargin

    val result = Day1.calculateSimilarityScore(input)
    val expected: Int = 31
    assert(result == expected)
  }
}
