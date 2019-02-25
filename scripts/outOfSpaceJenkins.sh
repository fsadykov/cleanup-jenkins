#!/usr/bin/env bash

cd "$HOME/workspace" || echo "Can not find workspace folder"

function clean_git() {
  git branch -vv | grep ': gone]'|  grep -v "\*" | awk '{ print $1; }' | xargs -r git branch -d
}

for tmp in $(ls ); do
  echo $tmp
  if [[ -d $tmp ]]; then
    cd $tmp
    if [[ -d .git ]]; then
      git branch -vv | grep ': gone]'|  grep -v "\*" | awk '{ print $1; }'
    fi
  fi
done
