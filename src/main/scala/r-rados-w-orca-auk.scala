import io.archivesunleashed._
import io.archivesunleashed.app._
import io.archivesunleashed.matchbox._

sc.setLogLevel("INFO")

sc.hadoopConfiguration.set("fs.s3a.impl", "org.apache.hadoop.fs.s3a.S3AFileSystem")
sc.hadoopConfiguration.setInt("fs.s3a.connection.maximum", 100)
sc.hadoopConfiguration.set("fs.s3a.access.key", "")
sc.hadoopConfiguration.set("fs.s3a.secret.key", "")
sc.hadoopConfiguration.set("fs.s3a.endpoint", "")

val validPages = RecordLoader
  .loadArchives("s3a://JIMMYLIN-5467/", sc)
  .keepValidPages()

validPages
  .map(r => ExtractDomainRDD(r.getUrl))
  .countItems()
  .saveAsTextFile("/store/scratch/nruest/web_archives/winnipeg/5467/all-domains/output")

validPages
  .map(r => (r.getCrawlDate, r.getDomain, r.getUrl, RemoveHTMLRDD(RemoveHTTPHeaderRDD(r.getContentString))))
  .saveAsTextFile("/store/scratch/nruest/web_archives/winnipeg/5467/all-text/output")

val links = validPages
  .map(r => (r.getCrawlDate, ExtractLinksRDD(r.getUrl, r.getContentString)))
  .flatMap(r => r._2.map(f => (r._1, ExtractDomainRDD(f._1).replaceAll("^\\\\s*www\\\\.", ""), ExtractDomainRDD(f._2).replaceAll("^\\\\s*www\\\\.", ""))))
  .filter(r => r._2 != "" && r._3 != "")
  .countItems()
  .filter(r => r._2 > 5)

WriteGraph.asGraphml(links, "/store/scratch/nruest/web_archives/winnipeg/5467/gephi/output.graphml")

sys.exit
