Some(12L)
1.0E6

def f(x:Boolean, y:Boolean) = if (x) y else false
f(true, true)
f(false, true)
f(true, false)
f(false, false)

val fruits : List[String] = List("apples", "oranges", "mangoes")
val vegs : List[String] = List("tomatoes", "carrots")

fruits.length
fruits.last
fruits.init
fruits take 1
fruits drop 2
fruits(1)
fruits apply 1
fruits ++ vegs
fruits ::: vegs
fruits.reverse
fruits updated(2, "NULL")
fruits indexOf "apples"
fruits contains "apples"
fruits :: vegs

val pairs = List("XO", "X1", "X2") zip List("Y0", "Y1", "Y2")

for{
  i <- 1 until 2
  j <- 1 until 3
} yield (i, j)
//} yield (i)

Set("a", "b", "b")