package Assigment1
import scala.annotation.tailrec
import scala.math.abs


object Assigment1 extends App {
  val daysOfWeek = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

//задание1
  def loop1(strList: List[String]): String = {
    var wd = ""
    for (day <- strList) if (day != strList.last)
      wd += s"$day, "
    else wd+= day
    wd
  }

  def loop2(strList: List[String]): String = {
    var wd = ""
    for (day <- strList if day.startsWith("S"))
      if (day != strList.last) wd += s"$day, " else wd += s"$day"
    //          s += day + ", "
    wd
  }

  def loop3(strList: List[String]): String = {
    var wd = ""
    var i = 0
    while (i < strList.length) {
      if(strList(i) !=strList.last) wd += s"${strList(i)}, " else wd += s"${strList(i)}"

      i += 1
    }
    wd
  }
  println(loop1(daysOfWeek))
  println(loop2(daysOfWeek))
  println(loop3(daysOfWeek))
  //  def main(args: Array[String]): Unit = {

// Задание2

  def rec1(strList: List[String]): String = {
    if (strList.isEmpty) ""
    else strList.head + ", " + rec1(strList.tail) //теил на вызов элементов в листе кроме первого
  }

  def rec2(strList: List[String]): String = {
    if (strList.isEmpty) ""
    else strList.last + ", " + rec2(strList.splitAt(strList.length-1)._1)  //разрезаем на два списка в предпоследнем и берем первый список
  }
  println(rec1(daysOfWeek))
  println(rec2(daysOfWeek))


  // Задание3
  def tailrec(strList: List[String]): String = {
    @tailrec
    def  step( str: List[String], result: String): String = {
      if (str.isEmpty) result
      else step(str.splitAt(1)._2, result + str.head + ", ")
    }
    step(strList, "")
  }

  println(tailrec(daysOfWeek))
  //Задание4

  println(daysOfWeek.foldLeft("")(_ + _ + ", "))

  println(daysOfWeek.foldRight("")(_ + ", " + _))

  println(daysOfWeek.filter(_.startsWith("S")).foldLeft("")(_ + _ + ", ") )

  //Задание 5
  val product = Map("apple" -> 5.0, "potato" -> 2.0, "peach" -> 6.0, "cucumber" -> 4.0)
  val reduction = product.view.mapValues(x => x*0.9).toMap
  println(reduction)
  //Задание 6
  val values = List(0, 1, 2, 3, 4, 5)
  def task6( l: List[Int]): List[Int] = {
    l.map(x => x+1)
  }
  println(task6(values))
//Задание 7
  val number_list = List(1.0, -1.0, 10.0, -4.0, 20.0, -20.0, 30.0, -30.0)
  def abs_value( l: List[Double]): List[Double] = {
    l.filter(_ <= 12 ).filter(_ >= -5).map(x => abs(x))
  }
  println(abs_value(number_list))
//задание 8
  val tuple3 = Tuple3(1.0, true, "task8")
  def task8( l: (Double,Boolean,String) ) ={
    println(l._1, l._2, l._3)
  }
  task8(tuple3)

//Задание 9
  val numbs = List( 0, 1, 2, 3, 5, 10, 20, 33)
  val zero = no_zero(numbs)

  def no_zero( l: List[Int]): List[Int] = {
    if( l.isEmpty ) List()
    else if( l.head != 0 ) List(l.head) ::: no_zero(l.tail)
    else no_zero(l.tail)
  }
  println(zero)


//Задание 10
  val a = Map("Nbd" -> "Scala", "Andrey" -> "Snezhko")
  def opt(z: Option[String]) = z match
  {
    case Some(s) => (s)
    case None => ("no data")
  }
  println(opt(a.get("Nbd")))
  println(opt(a.get("Java")))
  println(a.getOrElse("Sql", "Scala"))
  println(a.getOrElse("Misha", "Snezhko"))

  //}


}