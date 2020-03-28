package HSBCTechnicalAssessment

import scala.io.StdIn._


object timeinseconds {
  def main(args: Array[String]): Unit = {

    // This will convert a String with time to total seconds.

    val time1 = System.currentTimeMillis()
    println(time1)


    val timeSec = time1/1000
    println(timeSec)
    //println("Enter a time with colons between the values of hours, minutes, and seconds.")
    /*val time = readLine()


    val firstColon = time.indexOf(":")
    print("------------------------------------------")
    println(firstColon)
    val secondColon = time.lastIndexOf(":")
    print("------------------------------------------")
    println(secondColon)


    val hours = time.substring(0, firstColon).toInt
    print("------------------------------------------")
    println(hours)
    val minutes = time.substring(firstColon + 1, secondColon).toInt
    print("------------------------------------------")
    println(minutes)
    val seconds = time.substring(secondColon + 1).toInt
    print("------------------------------------------")
    println(seconds)

   val totalSeconds = hours * 3600 + minutes * 60 + seconds
    println("------------------------------------------")
    println(totalSeconds)*/
  }
}