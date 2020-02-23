import io.archivesunleashed._
import io.archivesunleashed.app._
import io.archivesunleashed.matchbox._

sc.setLogLevel("INFO")

val validPages = RecordLoader
  .loadArchives("/store/scratch/nruest/web_archives/winnipeg/5467/warcs", sc)
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
