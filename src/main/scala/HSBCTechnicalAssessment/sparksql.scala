package HSBCTechnicalAssessment

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object sparksql {

  val conf = new SparkConf()


  val spark = SparkSession.builder().master("local").appName("test1")
    .config(conf = conf).config("spark.eventLog.enabled", true).config("spark.eventLog.dir", "D:\\BigData\\sparklogs").getOrCreate()
  val sc = spark.sparkContext
  sc.setLogLevel("ERROR")




}
