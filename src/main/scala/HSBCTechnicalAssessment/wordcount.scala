package HSBCTechnicalAssessment

import org.apache.spark.{SparkConf, SparkContext}



object wordcount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("wordcount").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    //val lines = scala.io.Source.fromFile("D:\\BigData\\Spark\\Spark-20200202T155625Z-001\\Spark\\wordcount.txt").getLines()

    // val map = lines.flatMap(e=>e.split("\"[\\w,.!?]\""))
    val lines = sc.textFile("D:\\BigData\\Spark\\Spark-20200202T155625Z-001\\Spark\\wordcount.txt")
    println(System.nanoTime())
    System.currentTimeMillis()
    System.nanoTime()

    println(lines.getNumPartitions)
    //println("word count = >",
    lines.flatMap(e => e.split("[\\s,;.]+")).map(e => (e, 1)).reduceByKey(_ + _).filter(e => e._1 == "vidhata").foreach(println)


  }

}
