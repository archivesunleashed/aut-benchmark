import io.archivesunleashed._
import io.archivesunleashed.df._

sc.setLogLevel("INFO")

sc.hadoopConfiguration.set("fs.s3a.access.key", "")
sc.hadoopConfiguration.set("fs.s3a.secret.key", "")

val df_pdf = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractPDFDetailsDF();
val res_pdf = df_pdf.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("s3a://au-df/pdf/r-xfs-w-s3a")

val df_audio = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractAudioDetailsDF();
val res_audio = df_audio.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("s3a://au-df/audio/r-xfs-w-s3a")

val df_video = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractVideoDetailsDF();
val res_video = df_video.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("s3a://au-df/video/r-xfs-w-s3a")

val df_image = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractImageDetailsDF();
val res_image = df_image.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"width", $"height", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("s3a://au-df/image/r-xfs-w-s3a")

val df_ss = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractSpreadsheetDetailsDF();
val res_ss = df_ss.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("s3a://au-df/spreadsheet/r-xfs-w-s3a")

val df_pp = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractPresentationProgramDetailsDF();
val res_pp = df_pp.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("s3a://au-df/presentation-program/r-xfs-w-s3a")

val df_word = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractWordProcessorDetailsDF();
val res_word = df_word.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("s3a://au-df/word-processor/r-xfs-w-s3a")

val df_txt = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractTextFilesDetailsDF();
val res_txt = df_txt.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.format("csv").option("header","true").mode("Overwrite").save("s3a://au-df/text/r-xfs-w-s3a")

sys.exit

