import io.archivesunleashed._
import io.archivesunleashed.df._

sc.setLogLevel("INFO")

sc.hadoopConfiguration.set("fs.s3a.impl", "org.apache.hadoop.fs.s3a.S3AFileSystem")
sc.hadoopConfiguration.setInt("fs.s3a.connection.maximum", 100)
sc.hadoopConfiguration.set("fs.s3a.access.key", "")
sc.hadoopConfiguration.set("fs.s3a.secret.key", "")
sc.hadoopConfiguration.set("fs.s3a.endpoint", "")

val df_pdf = RecordLoader.loadArchives("s3a://JIMMYLIN-au-warcs-small/", sc).pdfs();
val res_pdf = df_pdf.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("/mnt/xfs/output/df/pdf/r-rados-w-xfs")

val df_audio = RecordLoader.loadArchives("s3a://JIMMYLIN-au-warcs-small/", sc).audio();
val res_audio = df_audio.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("/mnt/xfs/output/df/audio/r-rados-w-xfs")

val df_video = RecordLoader.loadArchives("s3a://JIMMYLIN-au-warcs-small/", sc).videos();
val res_video = df_video.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("/mnt/xfs/output/df/video/r-rados-w-xfs")

val df_image = RecordLoader.loadArchives("s3a://JIMMYLIN-au-warcs-small/", sc).images();
val res_image = df_image.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"width", $"height", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("/mnt/xfs/output/df/image/r-rados-w-xfs")

val df_ss = RecordLoader.loadArchives("s3a://JIMMYLIN-au-warcs-small/", sc).spreadsheets();
val res_ss = df_ss.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("/mnt/xfs/output/df/spreadsheet/r-rados-w-xfs")

val df_pp = RecordLoader.loadArchives("s3a://JIMMYLIN-au-warcs-small/", sc).presentationProgramFiles();
val res_pp = df_pp.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("/mnt/xfs/output/df/presentation-program/r-rados-w-xfs")

val df_word = RecordLoader.loadArchives("s3a://JIMMYLIN-au-warcs-small/", sc).wordProcessorFiles();
val res_word = df_word.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("/mnt/xfs/output/df/word-processor/r-rados-w-xfs")

val df_txt = RecordLoader.loadArchives("s3a://JIMMYLIN-au-warcs-small/", sc).textFiles();
val res_txt = df_txt.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("/mnt/xfs/output/df/text/r-rados-w-xfs")

sys.exit
