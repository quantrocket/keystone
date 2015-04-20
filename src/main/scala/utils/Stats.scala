package utils

import breeze.linalg._
import breeze.numerics._

object Stats extends Serializable {
  /**
   * Margin to use for comparing numerical values.
   */
  var thresh = 1e-8

  /**
   * Compares two numbers for approximate equality. Modify margin by setting Stats.thresh.
   *
   * @param a A number.
   * @param b A second number.
   * @return True if the two numbers are within `thresh` of each other.
   */
  def aboutEq(a: Double, b: Double): Boolean = {
    math.abs(a-b) < thresh
  }

  /**
   * Compares two arrays for approximate equality. Modify margin by setting Stats.thresh.
   *
   * @param as A array of numbers.
   * @param bs A second array of numbers.
   * @return True if the two numbers are within `thresh` of each other.
   */
  def aboutEq(as: DenseVector[Double], bs: DenseVector[Double]): Boolean = {
    abs(as-bs).toArray.forall(_ < thresh)
  }

  /**
   * Compares two matrices for approximate equality.
   *
   * @param a A matrix.
   * @param b A second matrix.
   * @return True iff all corresponding elements of the two matrices are within `thresh` of each other.
   */
  def aboutEq(a: DenseMatrix[Double], b: DenseMatrix[Double]): Boolean = {
    require(a.rows == b.rows && a.cols == b.cols, "Matrices must be the same size.")

    abs(a-b).toArray.forall(_ < thresh)
  }

}