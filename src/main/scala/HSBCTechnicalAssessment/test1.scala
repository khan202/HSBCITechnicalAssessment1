package HSBCTechnicalAssessment

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import java.util.Properties


object test1 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()


    val spark = SparkSession.builder().master("local").appName("test1")
      .config(conf = conf).config("spark.eventLog.enabled", true).config("spark.eventLog.dir", "D:\\BigData\\sparklogs").getOrCreate()
    val sc = spark.sparkContext
    sc.setLogLevel("ERROR")

    val data = spark.read.option("header", true)
      .option("inferschema", true)
      .option("delimiter", ",").csv("D:\\BigData\\data-master\\student.csv")

    data.show()


    val data2 = data.dropDuplicates()
   // val colNames = Seq("name", "course", "score")
    val colNames = data.columns.toSeq
   print( colNames)
    val data1 = data2.na.fill("qqq", colNames)


    val res1 = data1.groupBy("course").max("score")
    data1.join(res1, data1("course") === res1("course") && data1("score") === res1("max(score)"), "leftsemi").show()


  }

}
