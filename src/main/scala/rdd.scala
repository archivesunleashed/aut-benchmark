import io.archivesunleashed._
import io.archivesunleashed.matchbox._
import io.archivesunleashed.util._

RecordLoader.loadArchives("/mnt/vol1/data_sets/environnement-qc/warcs", sc)
  .keepValidPages()
  .flatMap(r => ExtractLinksRDD(r.getUrl, r.getContentString))
  .map(r => (ExtractDomainRDD(r._1).removePrefixWWW(), ExtractDomainRDD(r._2).removePrefixWWW()))
  .filter(r => r._1 != "" && r._2 != "")
  .countItems()
  .filter(r => r._2 > 5)
  .saveAsTextFile("/mnt/vol1/derivative_data/tmp/rdd/links-all")

sys.exit
