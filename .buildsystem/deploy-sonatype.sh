#!/usr/bin/env bash
cd $(dirname $0)/..

if [ -z "$SONATYPE_USERNAME" ]; then
  echo "error: please set SONATYPE_USERNAME environment variable"
  exit 1
fi

if [ -z "$SONATYPE_PASSWORD" ]; then
  echo "error: please set SONATYPE_PASSWORD environment variable"
  exit 1
fi

if [ -z "$GPG_PASSPHRASE" ]; then
  echo "error: please set GPG_PASSPHRASE environment variable"
  exit 1
fi

if [ -z "$GIT_TAG_NAME" ]; then
  echo "not on a tag -> no deploy needed"
else
  echo "on a tag -> deploy release version $GIT_TAG_NAME"
  ./gradlew assemble
  ./gradlew :android-material-icons:publishReleasePublicationToOSSHRRepository
fi
