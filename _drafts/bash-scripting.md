---
layout: post
title: "Bash Scripting"
categories: cheatsheet
subtitle: lamer
---

```bash
# get most recent file, better than `ls -t | head -1`
files=(*) newest=${files[0]}
for f in "${files[@]}"; do
  if [[ $f -nt $newest ]]; then
    newest=$f
  fi
done
```
