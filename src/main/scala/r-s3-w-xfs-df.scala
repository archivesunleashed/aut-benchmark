import io.archivesunleashed._
import io.archivesunleashed.df._

sc.setLogLevel("INFO")

sc.hadoopConfiguration.set("fs.s3a.impl", "org.apache.hadoop.fs.s3a.S3AFileSystem")
sc.hadoopConfiguration.setInt("fs.s3a.connection.maximum", 100)
sc.hadoopConfiguration.set("fs.s3a.access.key", "")
sc.hadoopConfiguration.set("fs.s3a.secret.key", "")

val df_pdf = RecordLoader.loadArchives("s3a://au-warcs/", sc).extractPDFDetailsDF();
val res_pdf = df_pdf.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("/mnt/xfs/output/df/pdf/r-s3a-w-s3a")

val df_audio = RecordLoader.loadArchives("s3a://au-warcs/", sc).extractAudioDetailsDF();
val res_audio = df_audio.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("/mnt/xfs/output/df/audio/r-s3a-w-s3a")

val df_video = RecordLoader.loadArchives("s3a://au-warcs/", sc).extractVideoDetailsDF();
val res_video = df_video.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("/mnt/xfs/output/df/video/r-s3a-w-s3a")

val df_image = RecordLoader.loadArchives("s3a://au-warcs/", sc).extractImageDetailsDF();
val res_image = df_image.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"width", $"height", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("/mnt/xfs/output/df/image/r-s3a-w-s3a")

val df_ss = RecordLoader.loadArchives("s3a://au-warcs/", sc).extractSpreadsheetDetailsDF();
val res_ss = df_ss.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("/mnt/xfs/output/df/spreadsheet/r-s3a-w-s3a")

val df_pp = RecordLoader.loadArchives("s3a://au-warcs/", sc).extractPresentationProgramDetailsDF();
val res_pp = df_pp.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("/mnt/xfs/output/df/presentation-program/r-s3a-w-s3a")

val df_word = RecordLoader.loadArchives("s3a://au-warcs/", sc).extractWordProcessorDetailsDF();
val res_word = df_word.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("/mnt/xfs/output/df/word-processor/r-s3a-w-s3a")

val df_txt = RecordLoader.loadArchives("s3a://au-warcs/", sc).extractTextFilesDetailsDF();
val res_txt = df_txt.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("/mnt/xfs/output/df/text/r-s3a-w-s3a")

sys.exit
