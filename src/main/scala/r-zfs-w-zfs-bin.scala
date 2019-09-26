import io.archivesunleashed._
import io.archivesunleashed.df._

sc.setLogLevel("INFO")

val df_pdf = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractPDFDetailsDF();
val res_pdf = df_pdf.select($"bytes", $"extension").saveToDisk("bytes", "/au-zfs/output/binaries/pdf/r-zfs-w-zfs-pdf", "extension")

val df_audio = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractAudioDetailsDF();
val res_audio = df_audio.select($"bytes", $"extension").saveToDisk("bytes", "/au-zfs/output/binaries/audio/r-zfs-w-zfs-audio", "extension")

val df_video = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractVideoDetailsDF();
val res_video = df_video.select($"bytes", $"extension").saveToDisk("bytes", "/au-zfs/output/binaries/video/r-zfs-w-zfs-video", "extension")

val df_image = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractImageDetailsDF();
val res_image = df_image.select($"bytes", $"extension").saveToDisk("bytes", "/au-zfs/output/binaries/image/r-zfs-w-zfs-image", "extension")

val df_ss = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractSpreadsheetDetailsDF();
val res_ss = df_ss.select($"bytes", $"extension").saveToDisk("bytes", "/au-zfs/output/binaries/spreadsheet/r-zfs-w-zfs-spreadsheet", "extension")

val df_pp = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractPresentationProgramDetailsDF();
val res_pp = df_pp.select($"bytes", $"extension").saveToDisk("bytes", "/au-zfs/output/binaries/presentation-program/r-zfs-w-zfs-presentation-program", "extension")

val df_word = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractWordProcessorDetailsDF();
val res_word = df_word.select($"bytes", $"extension").saveToDisk("bytes", "/au-zfs/output/binaries/word-processor/r-zfs-w-zfs-word-processor", "extension")

val df_txt = RecordLoader.loadArchives("/au-zfs/data/*gz", sc).extractTextFilesDetailsDF();
val res_txt = df_txt.select($"bytes", $"extension").saveToDisk("bytes", "/au-zfs/output/binaries/text/r-zfs-w-zfs-text", "extension")

sys.exit
