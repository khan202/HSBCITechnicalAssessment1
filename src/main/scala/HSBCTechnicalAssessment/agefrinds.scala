package HSBCTechnicalAssessment

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object agefrinds {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    val spark = SparkSession.builder().master("local").config(conf = conf).appName("age friends").getOrCreate()
    val sc = spark.sparkContext
    val lines = sc.textFile("C:\\Users\\imran\\Desktop\\friends.txt").cache()

   // lines.foreach(println)

    val linesmap = lines.map(e => {
      val w = e.split(",")
      val age = w(0).toInt
      val friends = w(1).toFloat
      (age, friends)
    }).cache()
   // linesmap.foreach(println)
    val res1 = linesmap.aggregateByKey((0.0f, 0))((a1: (Float, Int), a2: (Float)) =>
      (a1._1 + a2, a1._2 + 1), (f1: (Float, Int), f2: (Float, Int)) => (f1._1 + f2._1, f1._2 + f2._2))//.foreach(println)
    res1.map(e => (e._1, (e._2._1/e._2._2))).foreach(println)
    //


    val avgValue = linesmap.mapValues((_, 1)).reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2)).mapValues{ case (sum, count) => (1.0 * sum) / count }
    .collectAsMap()
    avgValue.foreach(println)
  }


}
