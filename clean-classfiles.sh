#/bin/sh
CLASSES=$(find materialjfx/ -name "*.class" -type f -printf "%p ")
for CLASS in ${CLASSES}; do rm ${CLASS}; done
