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
sudo mkdir /mnt/xfs

mkfs -t xfs

cd /au-zfs
mkdir data tmp output/auk/all-text output/auk/all-domains output/auk/gephi output/binaries/audio output/binaries/image output/binaries/pdf output/binaries/spreadsheet output/binaries/word-processor output/binaries/presentation-program output/binaries/text output/binaries/video output/df/audio output/df/image output/df/pdf output/df/spreadsheet output/df/word-processor output/df/presentation-program output/df/text output/df/video

cd /mnt/xfs
mkdir data tmp output/auk/all-text output/auk/all-domains output/auk/gephi output/binaries/audio output/binaries/image output/binaries/pdf output/binaries/spreadsheet output/binaries/word-processor output/binaries/presentation-program output/binaries/text output/binaries/video output/df/audio output/df/image output/df/pdf output/df/spreadsheet output/df/word-processor output/df/presentation-program output/df/text output/df/video

```

Copy the data up (100-200G of GeoCities WARCs that I'd identify and provide a md5/sha1 inventory) and run 3-5 jobs for each of these (I'd do the 3 standard auk jobs, binary extraction, and dataframe csvs):

## AUK

### r-xfs-w-xfs

```bash
/usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-xfs-auk-01.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-xfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-xfs-auk-01.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-xfs-auk-02.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-xfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-xfs-auk-02.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-xfs-auk-03.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-xfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-xfs-auk-03.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-xfs-auk-04.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-xfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-xfs-auk-04.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-xfs-auk-05.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-xfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-xfs-auk-05.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*;
```

### r-xfs-w-zfs

```bash
/usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-zfs-auk-01.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-zfs-auk-01.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-zfs-auk-02.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-zfs-auk-02.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-zfs-auk-03.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-zfs-auk-03.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-zfs-auk-04.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-zfs-auk-04.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-zfs-auk-05.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-zfs-auk-05.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*;
```

### r-zfs-w-zfs

```bash
/usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-zfs-auk-01.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-zfs-auk-01.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-zfs-auk-02.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-zfs-auk-02.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-zfs-auk-03.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-zfs-auk-03.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-zfs-auk-04.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-zfs-auk-04.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-zfs-auk-05.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-zfs-auk-05.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*;
```

### r-zfs-w-xfs

```bash
/usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-xfs-auk-01.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-xfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-xfs-auk-01.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-xfs-auk-02.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-xfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-xfs-auk-02.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-xfs-auk-03.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-xfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-xfs-auk-03.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-xfs-auk-04.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-xfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-xfs-auk-04.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-xfs-auk-05.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[16] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-xfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-xfs-auk-05.log; rm -rf /mnt/xfs/aut; cd /mnt/xfs; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*;
```

## Binaries

### r-xfs-w-xfs

```bash
```

### r-xfs-w-zfs

```bash
```

### r-zfs-w-zfs

```bash
```

### r-zfs-w-xfs

```bash
```




## DataFrames

### r-xfs-w-xfs

```bash
```

### r-xfs-w-zfs

```bash
```

### r-zfs-w-zfs

```bash
```

### r-zfs-w-xfs

```bash
```
