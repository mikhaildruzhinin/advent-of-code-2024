package ru.mikhaildruzhinin.aoc

import scala.io.Source

object Day1 {

  private val dropIndices = (i: Iterator[(Int, Int)]) => i.map(_._1)

  private val pairFromInput: String => (Iterator[Int], Iterator[Int]) = input => {
    val p = input
      .split("\n")
      .iterator
      .flatMap(_.split(" {3}"))
      .zipWithIndex
      .map(x => (x._1.toInt, x._2))
      .partition(x => x._2 % 2 == 0)

    (dropIndices(p._1), dropIndices(p._2))
  }

  private val sortElements = (i: Iterator[Int]) => i.toSeq.sorted

  def calculateTotalDistance(input: String): Int = {

    val pair = pairFromInput(input)

    sortElements(pair._1)
      .zip(sortElements(pair._2))
      .map(x => (x._1 - x._2).abs)
      .sum
  }

  def calculateSimilarityScore(input: String): Int = {

    val pair = (pairFromInput(input)._1.toSeq, pairFromInput(input)._2.toSeq)

    pair._1
      .zip(pair._1.map(x => pair._2.count(_ == x)))
      .map(x => x._1 * x._2)
      .sum
  }

  def main(args: Array[String]): Unit = {
    val input = Source.fromResource("input1.txt").mkString
    println(calculateTotalDistance(input))
    println(calculateSimilarityScore(input))
  }

}
