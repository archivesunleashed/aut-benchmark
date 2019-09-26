## AUT Benchmark

Let me know if this looks sane (I kicked the tire a bit today, and set things up on a machine, then terminated it):

```
r5d.4xlarge
  - 16 virtual cores
  - 128G RAM
  - 2 x 300G ephemeral mount points
```

Format, and mount the two ephemeral devices like this (note, these are *not* EBS devices):

```
sudo mkdir /mnt/zfs
sudo mkdir /mnt/xfs

mkfs -t xfs

cd /mnt/zfs
mkdir data tmp output/auk/all-text output/auk/all-domains output/auk/gephi output/binaries/audio output/binaries/image output/binaries/pdf output/binaries/spreadsheet output/binaries/word-processor output/binaries/presentation-program output/binaries/text output/binaries/video output/df/audio output/df/image output/df/pdf output/df/spreadsheet output/df/word-processor output/df/presentation-program output/df/text output/df/video

cd /mnt/xfs
mkdir data tmp output/auk/all-text output/auk/all-domains output/auk/gephi output/binaries/audio output/binaries/image output/binaries/pdf output/binaries/spreadsheet output/binaries/word-processor output/binaries/presentation-program output/binaries/text output/binaries/video output/df/audio output/df/image output/df/pdf output/df/spreadsheet output/df/word-processor output/df/presentation-program output/df/text output/df/video

```

Copy the data up (100-200G of GeoCities WARCs that I'd identify and provide a md5/sha1 inventory) and run 3-5 jobs for each of these (I'd do the 3 standard auk jobs, binary extraction, and dataframe csvs):

```
/usr/bin/time -o ~/au-benchmark/times/r-xfs-w-xfs-01.txt -v spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --local.dir /mnt/xfs/tmp --packages "io.archivesunleashed:aut:0.18.0" -i r-xfs-w-xfs.scala 2>&1 | tee ~/au-benchmark/logs/r-xfs-w-xfs-01.log

r-xfs-w-xfs-auk.scala
r-xfs-w-xfs-bin.scala
r-xfs-w-xfs-df.scala
r-xfs-w-zfs-auk.scala
r-xfs-w-zfs-bin.scala
r-xfs-w-zfs-df.scala
r-zfs-w-xfs-auk.scala
r-zfs-w-xfs-bin.scala
r-zfs-w-xfs-df.scala
r-zfs-w-zfs-auk.scala
r-zfs-w-zfs-bin.scala
r-zfs-w-zfs-df.scala

```

Then, w/r/t ZFS, I presume we should just do a RAID 0, single device pool, and specifically call that out in the article?
