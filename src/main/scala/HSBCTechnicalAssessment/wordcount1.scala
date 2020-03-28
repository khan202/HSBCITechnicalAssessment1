package HSBCTechnicalAssessment
import org.apache.spark.{SparkConf, SparkContext}
object wordcount1 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("wordcount").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    val lines = sc.textFile("D:\\BigData\\Spark\\Spark-20200202T155625Z-001\\Spark\\wordcount.txt")

    lines.flatMap(e => e.split("[\\s,;.]+")).map(e => (e, 1)).reduceByKey(_ + _).foreach(println)


  }

}
