import io.archivesunleashed._
import io.archivesunleashed.df._

RecordLoader.loadArchives("/mnt/vol1/data_sets/environnement-qc/warcs", sc).webgraph()
  .groupBy(RemovePrefixWWWDF(ExtractDomainDF($"src")).as("src"), RemovePrefixWWWDF(ExtractDomainDF($"dest")).as("dest"))
  .count()
  .filter($"count" > 5)
  .write.csv("/mnt/vol1/derivative_data/tmp/df/links-all")

sys.exit
