import io.archivesunleashed._
import io.archivesunleashed.app._
import io.archivesunleashed.matchbox._

sc.setLogLevel("INFO")

val statusCodes = Set("200")

val validPages = RecordLoader
  .loadArchives("/au-zfs/data", sc)
  .keepValidPages()
  .keepHttpStatus(statusCodes)

validPages
  .map(r => ExtractDomain(r.getUrl))
  .countItems()
  .saveAsTextFile("/mnt/xfs/output/auk/all-domains/output")

validPages
  .map(r => (r.getCrawlDate, r.getDomain, r.getUrl, RemoveHTML(RemoveHttpHeader(r.getContentString))))
  .saveAsTextFile("/mnt/xfs/output/auk/all-text/output")

val links = validPages
  .map(r => (r.getCrawlDate, ExtractLinks(r.getUrl, r.getContentString)))
  .flatMap(r => r._2.map(f => (r._1, ExtractDomain(f._1).replaceAll("^\\\\s*www\\\\.", ""), ExtractDomain(f._2).replaceAll("^\\\\s*www\\\\.", ""))))
  .filter(r => r._2 != "" && r._3 != "")
  .countItems()
  .filter(r => r._2 > 5)

WriteGraph.asGraphml(links, "/mnt/xfs/output/auk/gephi/r-zfs-w-xfs-auk-gephi.graphml")

sys.exit
