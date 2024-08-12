object q1 extends App {

  def encrypt(shift: Int, str: String): String = {
    var cipher = ""

    for (letter <- str) {
      val base = if (letter.isUpper) 'A' else 'a'
      val newLetter = (letter.toInt - base.toInt + shift) % 26
      cipher += (newLetter + base.toInt).toChar
    }

    cipher
  }

  def decrypt(shift: Int, str: String): String = {
    var cipher = ""

    for (letter <- str) {
      val base = if (letter.isUpper) 'A' else 'a'
      val newLetter = (letter.toInt - base.toInt - shift) % 26
      cipher += (newLetter + base.toInt).toChar
    }

    cipher
  }

  def cipher(
      function: (Int, String) => String,
      str: String,
      shift: Int
  ): String = {
    function(shift, str)
  }

  
  println(cipher(encrypt, "Ayanga", 5)) 
  println(cipher(decrypt, "Fdfslf", 5))
}
