import ntru.{NTRU, NTRUParameters}

object NTRUEncryption {

  def main(args: Array[String]): Unit = {

    // กำหนดค่าพารามิเตอร์การเข้ารหัส
    val parameters = NTRUParameters.generateParameters(4096)

    // แปลงข้อความ "สวัสดีชาวโลก" เป็นจุดในตาข่าย
    val message = "สวัสดีชาวโลก".getBytes.map(_.toByte)
    val plaintext = NTRU.encode(message, parameters)

    // เข้ารหัสจุดในตาข่าย
    val ciphertext = NTRU.encrypt(plaintext, parameters)

    // ถอดรหัสจุดในตาข่าย
    val decrypted = NTRU.decrypt(ciphertext, parameters)

    // แปลงจุดในตาข่ายกลับเป็นข้อความ
    val decryptedMessage = decrypted.map(_.toChar).mkString

    // แสดงข้อความที่ถอดรหัสได้
    println(decryptedMessage)
  }
}