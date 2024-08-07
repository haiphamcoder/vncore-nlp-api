#!/usr/bin/env bash
BASE_DIR=$(dirname $(readlink -e $0))/..

LOG_LEVEL=info
JAVA_HEAP_MAX=-Xmx16384m

MAIN_JAR=target/VnCoreNLP-0.0.1-SNAPSHOT.jar

echo $BASE_DIR
echo $MAIN_JAR

while (true)
do
java -Dlogging.level.root=$LOG_LEVEL \
     -Dlog4j2.formatMsgNoLookups=true \
     $JAVA_HEAP_MAX \
     -jar $MAIN_JAR
echo "sleeping 2 seconds before continuous...."
sleep 2s
done