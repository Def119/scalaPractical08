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
      val newLetter = (letter.toInt - base.toInt - shift + 26) % 26 //add 26 again to circularly reach the letter from the end of the alphabet
      cipher += (newLetter + base.toInt).toChar                     //ex: A shift left by 2 => -2 in alphabet, but adding base ascii = 65-2=63 is out of the ascii alphabet range....to get the -2 from the z side of alphabet
                                                                        // add another 26. -2 + 26 = 24 ..... 24 + ascii(a or A) give the letter -2 from z in the ascii table
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
