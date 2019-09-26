import io.archivesunleashed._
import io.archivesunleashed.df._

sc.setLogLevel("INFO")

val df_pdf = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractPDFDetailsDF();
val res_pdf = df_pdf.select($"bytes", $"extension").saveToDisk("bytes", "/mnt/xfs/output/binaries/pdf/r-xfs-w-xfs-pdf", "extension")

val df_audio = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractAudioDetailsDF();
val res_audio = df_audio.select($"bytes", $"extension").saveToDisk("bytes", "/mnt/xfs/output/binaries/audio/r-xfs-w-xfs-audio", "extension")

val df_video = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractVideoDetailsDF();
val res_video = df_video.select($"bytes", $"extension").saveToDisk("bytes", "/mnt/xfs/output/binaries/video/r-xfs-w-xfs-video", "extension")

val df_image = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractImageDetailsDF();
val res_image = df_image.select($"bytes", $"extension").saveToDisk("bytes", "/mnt/xfs/output/binaries/image/r-xfs-w-xfs-image", "extension")

val df_ss = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractSpreadsheetDetailsDF();
val res_ss = df_ss.select($"bytes", $"extension").saveToDisk("bytes", "/mnt/xfs/output/binaries/spreadsheet/r-xfs-w-xfs-spreadsheet", "extension")

val df_pp = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractPresentationProgramDetailsDF();
val res_pp = df_pp.select($"bytes", $"extension").saveToDisk("bytes", "/mnt/xfs/output/binaries/presentation-program/r-xfs-w-xfs-presentation-program", "extension")

val df_word = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractWordProcessorDetailsDF();
val res_word = df_word.select($"bytes", $"extension").saveToDisk("bytes", "/mnt/xfs/output/binaries/word-processor/r-xfs-w-xfs-word-processor", "extension")

val df_txt = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractTextFilesDetailsDF();
val res_txt = df_txt.select($"bytes", $"extension").saveToDisk("bytes", "/mnt/xfs/output/binaries/text/r-xfs-w-xfs-text", "extension")

sys.exit
