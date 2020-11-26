object Assigment2 extends App {
  //задание 1
  def task1(day: String): String = day match {
    case "Monday" => "work"
    case "Tuesday" => "work"
    case "Wednesday" => "work"
    case "Thursday" => "work"
    case "Friday" => "work"
    case "Saturday" => "weekend"
    case "Sunday" => "weekend"
    case _ => "no such day"
  }

  println("Task1:")
  println(task1("Monday"))
  println(task1("Saturday"))
  println(task1("Cake"))
  //Задание 2
  class BankAccount(private var balance: Double) {

    def this() {
      this(0)
    }

    def deposits(amount: Double): Unit = {
      if (amount > 0) balance = balance + amount
      else throw new Exception("wrong amount input")
    }

    def withdraw(amount: Double): Unit = {
      if (0 < amount && amount <= balance) {
        balance = balance - amount
      } else throw new Exception("wrong amount input")
    }

    def currentBalance: Unit = println("Your current balance is: " + balance)
  }
  println("Task2:")
  val b: BankAccount = new BankAccount()
  b.currentBalance
  b.deposits(20.3)
  b.currentBalance
  b.withdraw(10)
  b.currentBalance
  new BankAccount(1000).currentBalance
  //Задание3
  case class PersonTask3(var firstName: String, var lastName: String) {
    def greeting(person: PersonTask3): Unit = person match {
      case PersonTask3("Andrey", _) => println("Hello, Andrey")
      case PersonTask3(_, "Snizhko") => println("Hello, Andrii")
      case PersonTask3(fn, ln) => println(s"Good Day! $fn $ln")
    }
  }

  println("Task3:")
  val pt3: PersonTask3 = new PersonTask3("John", "Bond")
  pt3.greeting(new PersonTask3("Andrii", "Snizhko"))
  pt3.greeting(new PersonTask3("Andrey", "Snezhko"))
  pt3.greeting(new PersonTask3("Jack", "Johnes"))
  //Задание 4
  println("Task4:")
  def task4(t4: Int => Int, a: Int): Int = t4(t4(t4(a)))
  println(task4(x => x + x, 10))
  //Задание 5
  println("Task5:")


  abstract class Person(private val _firstname:String, private val _lastname:String, private var _taxToPay: Double) {
    def firstname: String = _firstname
    def lastname: String = _lastname
    def taxToPay: Double = _taxToPay
  }

  trait Employee extends Person{
    private var salary:Double = 100500.00

    def salaryG = salary
    def salaryS(newValue: Double): Unit = {
      salary = newValue
    }
    override def taxToPay: Double = 0.2 * salary
  }

  trait Student extends Person{
    override def taxToPay: Double = 0.0
  }

  trait Teacher extends Employee {
    override def taxToPay: Double = 0.1 * salaryG
  }



  object p1 extends Person("Peter", "Pen", _taxToPay = 0) with Employee
  p1.salaryS(5000)
  println(p1.firstname + " " + p1.lastname)
  println(p1.taxToPay)
  object p2 extends Person("Jack", "Johenes", _taxToPay = 0) with Student
  println(p2.firstname + " " + p2.lastname)
  println(p2.taxToPay)
  object p3 extends Person("Ben", "Laptop", _taxToPay = 0) with Teacher
  println(p3.firstname + " " + p3.lastname)
  p3.salaryS(10000)
  println(p3.taxToPay)
  object p4 extends Person("Andrez", "Koir", _taxToPay = 0) with Employee with Student
  println(p4.firstname + " " + p4.lastname)
  p4.salaryS(7000)
  println(p4.taxToPay)
  object p5 extends Person("Mickle", "Swang", _taxToPay = 0) with Student with Employee
  println(p5.firstname + " " + p5.lastname)
  p5.salaryS(9000)
  println(p5.taxToPay)



}
