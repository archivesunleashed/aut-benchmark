# AUT Benchmark

## Machine

```
r5d.4xlarge
  - 16 virtual cores
  - 128G RAM
  - 2 x 300G ephemeral mount points
```

## Setup

```
sudo mkdir /mnt/xfs

sudo zpool create au-zfs /dev/nvme1n1
sudo mkfs -t xfs

sudo chown -hR ubuntu:ubuntu /au-zfs /mnt/xfs

cd /au-zfs
mkdir data tmp output/auk/all-text output/auk/all-domains output/auk/gephi output/binaries/audio output/binaries/image output/binaries/pdf output/binaries/spreadsheet output/binaries/word-processor output/binaries/presentation-program output/binaries/text output/binaries/video output/df/audio output/df/image output/df/pdf output/df/spreadsheet output/df/word-processor output/df/presentation-program output/df/text output/df/video

cd /mnt/xfs
mkdir data tmp output/auk/all-text output/auk/all-domains output/auk/gephi output/binaries/audio output/binaries/image output/binaries/pdf output/binaries/spreadsheet output/binaries/word-processor output/binaries/presentation-program output/binaries/text output/binaries/video output/df/audio output/df/image output/df/pdf output/df/spreadsheet output/df/word-processor output/df/presentation-program output/df/text output/df/video

```

## Jobs

### AUK

#### r-xfs-w-xfs

```bash
rm -rf /mnt/xfs/output/auk; cd /mnt/xfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-xfs-auk-01.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-xfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-xfs-auk-01.log; rm -rf /mnt/xfs/output/auk; cd /mnt/xfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-xfs-auk-02.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-xfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-xfs-auk-02.log; rm -rf /mnt/xfs/output/auk; cd /mnt/xfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-xfs-auk-03.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-xfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-xfs-auk-03.log; rm -rf /mnt/xfs/output/auk; cd /mnt/xfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-xfs-auk-04.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-xfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-xfs-auk-04.log; rm -rf /mnt/xfs/output/auk; cd /mnt/xfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-xfs-auk-05.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-xfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-xfs-auk-05.log; rm -rf /mnt/xfs/output/auk; cd /mnt/xfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*
```

#### r-xfs-w-zfs

```bash
rm -rf /au-zfs/output/auk; cd /au-zfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /au-zfs/tmp; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-zfs-auk-01.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/au-zfs/tmp -Djava.io.tmpdir=/au-zfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-zfs-auk-01.log; rm -rf /au-zfs/output/auk; cd /au-zfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /au-zfs/tmp; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-zfs-auk-02.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/au-zfs/tmp -Djava.io.tmpdir=/au-zfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-zfs-auk-02.log; rm -rf /au-zfs/output/auk; cd /au-zfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /au-zfs/tmp; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-zfs-auk-03.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/au-zfs/tmp -Djava.io.tmpdir=/au-zfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-zfs-auk-03.log; rm -rf /au-zfs/output/auk; cd /au-zfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /au-zfs/tmp; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-zfs-auk-04.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/au-zfs/tmp -Djava.io.tmpdir=/au-zfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-zfs-auk-04.log; rm -rf /au-zfs/output/auk; cd /au-zfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /au-zfs/tmp; /usr/bin/time -o ~/aut-benchmark/times/r-xfs-w-zfs-auk-05.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/au-zfs/tmp -Djava.io.tmpdir=/au-zfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-xfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-xfs-w-zfs-auk-05.log; rm -rf /au-zfs/output/auk; cd /au-zfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /au-zfs/tmp
```

#### r-zfs-w-zfs

```bash
rm -rf /au-zfs/output/auk;  cd /au-zfs/output;  mkdir -p auk/all-text auk/all-domains auk/gephi;  rm -rf /au-zfs/tmp/*;  /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-zfs-auk-01.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/au-zfs/tmp -Djava.io.tmpdir=/au-zfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-zfs-auk-01.log;  rm -rf /au-zfs/output/auk;  cd /au-zfs/output;  mkdir -p auk/all-text auk/all-domains auk/gephi;  rm -rf /au-zfs/tmp/*;  /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-zfs-auk-02.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/au-zfs/tmp -Djava.io.tmpdir=/au-zfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-zfs-auk-02.log;  rm -rf /au-zfs/output/auk;  cd /au-zfs/output;  mkdir -p auk/all-text auk/all-domains auk/gephi;  rm -rf /au-zfs/tmp/*;  /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-zfs-auk-03.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/au-zfs/tmp -Djava.io.tmpdir=/au-zfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-zfs-auk-03.log;  rm -rf /au-zfs/output/auk;  cd /au-zfs/output;  mkdir -p auk/all-text auk/all-domains auk/gephi;  rm -rf /au-zfs/tmp/*;  /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-zfs-auk-04.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/au-zfs/tmp -Djava.io.tmpdir=/au-zfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-zfs-auk-04.log;  rm -rf /au-zfs/output/auk;  cd /au-zfs/output;  mkdir -p auk/all-text auk/all-domains auk/gephi;  rm -rf /au-zfs/tmp/*;  /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-zfs-auk-05.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/au-zfs/tmp -Djava.io.tmpdir=/au-zfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-zfs-auk.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-zfs-auk-05.log;  rm -rf /au-zfs/output/auk;  cd /au-zfs/output;  mkdir -p auk/all-text auk/all-domains auk/gephi;  rm -rf /au-zfs/tmp/*
```

#### r-zfs-w-xfs

```bash
rm -rf /mnt/xfs/output/auk; cd /mnt/xfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-xfs-auk-01.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-xfs-auk-.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-xfs-auk-01.log; rm -rf /mnt/xfs/output/auk; cd /mnt/xfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-xfs-auk-02.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-xfs-auk-.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-xfs-auk-02.log; rm -rf /mnt/xfs/output/auk; cd /mnt/xfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-xfs-auk-03.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-xfs-auk-.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-xfs-auk-03.log; rm -rf /mnt/xfs/output/auk; cd /mnt/xfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-xfs-auk-04.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-xfs-auk-.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-xfs-auk-04.log; rm -rf /mnt/xfs/output/auk; cd /mnt/xfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*; /usr/bin/time -o ~/aut-benchmark/times/r-zfs-w-xfs-auk-05.txt -v ~/spark-2.4.4-bin-hadoop2.7/bin/spark-shell --master local[*] --driver-memory 125g --conf spark.local.dir=/mnt/xfs/tmp -Djava.io.tmpdir=/mnt/xfs/tmp --jars ~/aut-0.18.0-fatjar.jar -i ~/aut-benchmark/src/main/scala/r-zfs-w-xfs-auk-.scala 2>&1 | tee ~/aut-benchmark/logs/r-zfs-w-xfs-auk-05.log; rm -rf /mnt/xfs/output/auk; cd /mnt/xfs/output; mkdir -p auk/all-text auk/all-domains auk/gephi; rm -rf /mnt/xfs/tmp/*
```

### Binaries

#### r-xfs-w-xfs

```bash
```

#### r-xfs-w-zfs

```bash
```

#### r-zfs-w-zfs

```bash
```

#### r-zfs-w-xfs

```bash
```

### DataFrames

#### r-xfs-w-xfs

```bash
```

#### r-xfs-w-zfs

```bash
```

#### r-zfs-w-zfs

```bash
```

#### r-zfs-w-xfs

```bash
```

## Results

https://docs.google.com/spreadsheets/d/1ZBDc5O0yZ52PLoh-SynbJJmWSHoemQIn0FyQMb5IMZE/edit?usp=sharing
