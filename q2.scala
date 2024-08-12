object q2 extends App {

  if (args.length != 1) { 
    println("Provide one number.")
  } else {
    try {

      val num = args(0).toInt

      val findCategory: Int => String = n => n match {
        case n if n % 3 == 0 && n % 5 == 0 => "Multiple of 3 and 5"
        case n if n % 3 == 0 => "Multiple of 3"
        case n if n % 5 == 0 => "Multiple of 5"
        case _ => "Not a multiple of 3 or 5"
      }

      println(findCategory(num))
    } catch {
      case _: NumberFormatException => println("Invalid input")
    }
  }
}


