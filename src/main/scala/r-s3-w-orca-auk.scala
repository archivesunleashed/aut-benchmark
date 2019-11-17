import io.archivesunleashed._
import io.archivesunleashed.app._
import io.archivesunleashed.matchbox._

sc.setLogLevel("INFO")

sc.hadoopConfiguration.set("fs.s3a.impl", "org.apache.hadoop.fs.s3a.S3AFileSystem")
sc.hadoopConfiguration.setInt("fs.s3a.connection.maximum", 100)
sc.hadoopConfiguration.set("fs.s3a.access.key", "")
sc.hadoopConfiguration.set("fs.s3a.secret.key", "")

val statusCodes = Set("200")

val validPages = RecordLoader
  .loadArchives("s3a://au-data-large/", sc)
  .keepValidPages()
  .keepHttpStatus(statusCodes)

validPages
  .map(r => ExtractDomain(r.getUrl))
  .countItems()
  .saveAsTextFile("/store/scratch/nruest/benchmark/auk/all-domains/output")

validPages
  .map(r => (r.getCrawlDate, r.getDomain, r.getUrl, RemoveHTML(RemoveHttpHeader(r.getContentString))))
  .saveAsTextFile("/store/scratch/nruest/benchmark/auk/all-text/output")

val links = validPages
  .map(r => (r.getCrawlDate, ExtractLinks(r.getUrl, r.getContentString)))
  .flatMap(r => r._2.map(f => (r._1, ExtractDomain(f._1).replaceAll("^\\\\s*www\\\\.", ""), ExtractDomain(f._2).replaceAll("^\\\\s*www\\\\.", ""))))
  .filter(r => r._2 != "" && r._3 != "")
  .countItems()
  .filter(r => r._2 > 5)

WriteGraph.asGraphml(links, "/store/scratch/nruest/benchmark/auk/gephi/r-xfs-w-xfs-auk-gephi.graphml")

sys.exit
