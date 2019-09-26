import io.archivesunleashed._
import io.archivesunleashed.df._

sc.setLogLevel("INFO")

val df_pdf = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractPDFDetailsDF();
val res_pdf = df_pdf.select($"bytes", $"extension").saveToDisk("bytes", "/au-zfs/output/binaries/pdf/r-xfs-w-zfs-pdf", "extension")

val df_audio = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractAudioDetailsDF();
val res_audio = df_audio.select($"bytes", $"extension").saveToDisk("bytes", "/au-zfs/output/binaries/audio/r-xfs-w-zfs-audio", "extension")

val df_video = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractVideoDetailsDF();
val res_video = df_video.select($"bytes", $"extension").saveToDisk("bytes", "/au-zfs/output/binaries/video/r-xfs-w-zfs-video", "extension")

val df_image = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractImageDetailsDF();
val res_image = df_image.select($"bytes", $"extension").saveToDisk("bytes", "/au-zfs/output/binaries/image/r-xfs-w-zfs-image", "extension")

val df_ss = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractSpreadsheetDetailsDF();
val res_ss = df_ss.select($"bytes", $"extension").saveToDisk("bytes", "/au-zfs/output/binaries/spreadsheet/r-xfs-w-zfs-spreadsheet", "extension")

val df_pp = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractPresentationProgramDetailsDF();
val res_pp = df_pp.select($"bytes", $"extension").saveToDisk("bytes", "/au-zfs/output/binaries/presentation-program/r-xfs-w-zfs-presentation-program", "extension")

val df_word = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractWordProcessorDetailsDF();
val res_word = df_word.select($"bytes", $"extension").saveToDisk("bytes", "/au-zfs/output/binaries/word-processor/r-xfs-w-zfs-word-processor", "extension")

val df_txt = RecordLoader.loadArchives("/mnt/xfs/data/*gz", sc).extractTextFilesDetailsDF();
val res_txt = df_txt.select($"bytes", $"extension").saveToDisk("bytes", "/au-zfs/output/binaries/text/r-xfs-w-zfs-text", "extension")

sys.exit
