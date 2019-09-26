import io.archivesunleashed._
import io.archivesunleashed.df._

sc.setLogLevel("INFO")

val df_pdf = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractPDFDetailsDF();
val res_pdf = df_pdf.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/au-zfs/output/df/pdf/r-xfs-w-zfs-pdf")

val df_audio = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractAudioDetailsDF();
val res_audio = df_audio.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/au-zfs/output/df/audio/r-xfs-w-zfs-audio")

val df_video = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractVideoDetailsDF();
val res_video = df_video.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/au-zfs/output/df/video/r-xfs-w-zfs-video")

val df_image = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractImageDetailsDF();
val res_image = df_image.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"width", $"height", $"md5").orderBy(desc("md5")).write.csv("/au-zfs/output/df/image/r-xfs-w-zfs-image")

val df_ss = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractSpreadsheetDetailsDF();
val res_ss = df_ss.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/au-zfs/output/df/spreadsheet/r-xfs-w-zfs-spreadsheet")

val df_pp = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractPresentationProgramDetailsDF();
val res_pp = df_pp.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/au-zfs/output/df/presentation-program/r-xfs-w-zfs-presentation-program")

val df_word = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractWordProcessorDetailsDF();
val res_word = df_word.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/au-zfs/output/df/word-processor/r-xfs-w-zfs-word-processor")

val df_txt = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractTextFilesDetailsDF();
val res_txt = df_txt.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/au-zfs/output/df/text/r-xfs-w-zfs-text")

sys.exit

