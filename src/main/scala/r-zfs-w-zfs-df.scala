import io.archivesunleashed._
import io.archivesunleashed.df._

sc.setLogLevel("INFO")

val df_pdf = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractPDFDetailsDF();
val res_pdf = df_pdf.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/au-zfs/output/df/pdf/r-zfs-w-zfs-pdf")

val df_audio = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractAudioDetailsDF();
val res_audio = df_audio.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/au-zfs/output/df/audio/r-zfs-w-zfs-audio")

val df_video = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractVideoDetailsDF();
val res_video = df_video.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/au-zfs/output/df/video/r-zfs-w-zfs-video")

val df_image = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractImageDetailsDF();
val res_image = df_image.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"width", $"height", $"md5").orderBy(desc("md5")).write.csv("/au-zfs/output/df/image/r-zfs-w-zfs-image")

val df_ss = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractSpreadsheetDetailsDF();
val res_ss = df_ss.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/au-zfs/output/df/spreadsheet/r-zfs-w-zfs-spreadsheet")

val df_pp = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractPresentationProgramDetailsDF();
val res_pp = df_pp.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/au-zfs/output/df/presentation-program/r-zfs-w-zfs-presentation-program")

val df_word = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractWordProcessorDetailsDF();
val res_word = df_word.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/au-zfs/output/df/word-processor/r-zfs-w-zfs-word-processor")

val df_txt = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractTextFilesDetailsDF();
val res_txt = df_txt.select($"url", $"filename", $"extension", $"mime_type_web_server", $"mime_type_tika", $"md5").orderBy(desc("md5")).write.csv("/au-zfs/output/df/text/r-zfs-w-zfs-text")

sys.exit

