import io.archivesunleashed._
import io.archivesunleashed.df._

sc.setLogLevel("INFO")

val df_pdf = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractPDFDetailsDF();
val res_pdf = df_pdf.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/mnt/xfs/output/df/pdf/r-zfs-w-xfs-pdf")

val df_audio = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractAudioDetailsDF();
val res_audio = df_audio.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/mnt/xfs/output/df/audio/r-zfs-w-xfs-audio")

val df_video = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractVideoDetailsDF();
val res_video = df_video.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/mnt/xfs/output/df/video/r-zfs-w-xfs-video")

val df_image = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractImageDetailsDF();
val res_image = df_image.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"width", $"height", $"md5").orderBy(desc("md5")).write.csv("/mnt/xfs/output/df/image/r-zfs-w-xfs-image")

val df_ss = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractSpreadsheetDetailsDF();
val res_ss = df_ss.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/mnt/xfs/output/df/spreadsheet/r-zfs-w-xfs-spreadsheet")

val df_pp = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractPresentationProgramDetailsDF();
val res_pp = df_pp.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/mnt/xfs/output/df/presentation-program/r-zfs-w-xfs-presentation-program")

val df_word = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractWordProcessorDetailsDF();
val res_word = df_word.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/mnt/xfs/output/df/word-processor/r-zfs-w-xfs-word-processor")

val df_txt = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractTextFilesDetailsDF();
val res_txt = df_txt.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/mnt/xfs/output/df/text/r-zfs-w-xfs-text")

sys.exit

