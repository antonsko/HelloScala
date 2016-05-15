package MartinTryouts

/**
  * Created by anton.skovorodko on 05/03/2016.
  */
abstract class Nat {
  def isZero: Boolean
  def prev: Nat
  def next = new Succ(this)
  def +(that: Nat): Nat
  def -(that: Nat): Nat
}

object Zero extends Nat {
  def isZero: Boolean = true
  def prev: Nat = throw new Error("Zero.prev")
  def +(that: Nat) = that
  def -(that: Nat) = if (that.isZero) this else throw new Error("Zero.-")
}

class Succ(n: Nat) extends Nat {
  def isZero: Boolean = false
  def prev = n
  def +(that: Nat) = new Succ(n + that)
  def -(that: Nat) = if (that.prev.isZero) this else n - that.prev
}

object Run {
  val z = Zero.next
  println("Penao number:" + z.next)
}