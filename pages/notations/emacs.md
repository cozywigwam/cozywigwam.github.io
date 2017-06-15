---
title: "Emacs"
layout: notation
description: Er, Spacemacs
path: "/emacs/"
---


# get around


## quick reference/favorites/main


### misc/hard to remember

Layouts <-> Perspectives <-> iTerm2 tabs

Workspaces <-> Eyebrowse <-> tmux windows or vim tabs

|||
|-|-|
| `SPC x w d`         | `osx-dictionary-search-pointer`          |
| `M-h`, `M-l`        | `org-metaright`, like `<M-right>`        |
| `amen`              | escape holy-mode                         |
| `set-initial-state` | gimme normal, not iedt                   |
| `F5`                | [in helm locate] open dired              |
| `C-x M-:`           | `repeat-complex-command`                 |
| `SPC v`             | `er-expand-region`                       |
| `C-M-SPC`           | `mark-sexp`                              |
| `C-p`               | `evil-paste-pop`                         |
| -                   | `evil-set-initial-state`                 |
| `SPC r e`           | `evil-show-registers`                    |
| `SPC m g h`         | `helm-css-scss`                          |
| `C-S-o`             | [in dired] (custom) open in external app |
| `SPC b e`           | delete full buffer contents              |
| `SPC w u`           | `winner-undo`                            |
| `C-x C-b`           | (in helm) resume different helm buffer   |
| `SPC h d m`         | `spacemacs/describe-mode`                |
| `C-c >`, `C-c <`    | [in helm] next/prev file                 |


### buffers/files

|||
|-|-|
| `SPC p h` | `helm-projectile`                                   | recent, buffers, files          |
| `SPC f r` | `helm-recentf`                                      | recent files                    |
| `SPC p r` | `helm-projectile-recentf`                           | project recent files            |
| `SPC p b` | `helm-projectile-switch-to-buffer`                  | project buffers                 |
| `SPC B b` | `spacemacs-layouts/non-restricted-buffer-list-helm` | global buffers                  |
| `SPC f j` | `dired-jump`                                        | dired to file                   |
| `SPC p p` | `helm-projectile/switch-project`                    | projects                        |
| `SPC p F` | `helm-projectile-find-file-dwim`                    | find file with dwim             |
| `SPC f L` | `helm-locate`                                       | like `find ` -type f -name [x]` |
| `SPC /`   | `spacemacs/helm-project-smart-do-search`            | ag from project root            |
| `SPC s f` | `spacemacs/helm-files-smart-do-search`              | ag from current/arbitrary dir   |
| `SPC f D` | `spacemacs/delete-current-buffer-file`              | delete current buffer           |
| `C-]`     | [in helm find dir] `helm-ff-run-toggle-basename`    |                                 |


### get to dired

|||
|-|-|
| `SPC f j` | `dired-jump`                                        | dired at current file                           |
| `SPC p d` | `helm-projectile-find-ini includes recentf          | &nbsp;                                          |
| `C-x b`   | `helm-buffers-list`                                 | &nbsp;                                          |
| `SPC b W` | `spacemacs/goto-buffer-workspace`                   | go to where that buffer is displayed (if it is) |
| `SPC B b` | `spacemacs-layouts/non-restricted-buffer-list-helm` | &nbsp;                                          |


### projects

|||
|-|-|
| `SPC p`   | projects                           |
| `SPC p b` | `helm-projectile-switch-to-buffer` |


### files

|||
|-|-|
| `SPC f f` | `helm-find-files`                | open files (helm)         |
| `SPC f F` | `spacemacs/helm-find-files`      | open files (helm)         |
| `SPC f r` | `helm-recentf`                   | recent files (helm)       |
| `C-c p e` | `projectile-recentf`             | recent files (projectile) |
| `SPC p r` | `helm-projectile-recentf `       |                           |
| `SPC p f` | `helm-projectile-find-file`      |                           |
| `SPC p F` | `helm-projectile-find-file-dwim` | find file with dwim       |


# help

|||
|-|-|
| `SPC h m`            | helm man-woman                                      |
| `emacs --no-desktop` | restart when desktop is borked                      |
| `[`, `]`             | back/forward                                        |
| `SPC h`              | help                                                |
| `SPC h k`            | show top level keys                                 |
| `SPC h d`            | describe...                                         |
| `SPC h d c`          | ...char                                             |
| `SPC h d k`          | ...key                                              |
| `SPC h d f`          | ...function                                         |
| `SPC h d m`          | ...mode (with keybindings)                          |
| `SPC h d t`          | ...theme                                            |
| `SPC h d v`          | `describe-variable`                                 |
| `SPC h SPC`          | lookup doc, layers, packages, dotfile, toggles, faq |
| `SPC ?`              | `helm-descbinds`                                    |
| `C-h e`              | see startup error messages                          |

In info:

|||
|-|-|
| `<f1> ?` | `help-for-help` |


# search

|||
|-|-|
| `SPC /`             | search project - spacemacs/helm-project-smart-do-search    |
| `SPC s f`           | ag (smart-do-search) from current (or arbitrary) directory |
| `SPC s s`           | ag current file (swoop)                                    |
| `SPC s b`           | ag open buffers                                            |
| `helm-ag`           | ag and then helm the results                               |
| `helm-ag-this-file` | " this file                                                |
| `SPC *`             | search project at point                                    |
| `g;`                | go to last edit                                            |
| `gf`                | go to file at point                                        |
| `\s-`               | white space [ ] (<Tab> and <Space>)                        |
| `\S-`               | non-white characters [^ ] (not <Tab> and <Space>)          |

Delete/remove trailing whitespace:

|||
|-|-|
| `SPC x d w` | `delete-trailing-whitespace` |

Delete/remove unwanted/empty/blank lines:

|||
|-|-|
| `C-x C-o`     | `delete-blank-lines` |
| `flush-lines` |                      |

|||
|-|-|
| `:g/^$/d`     |
| `:v/./d`      |
| `:g/^\s-*$/d` |
| `:v/\S-/d`    |

Break opening HTML tags to new line:

|||
|-|-|
| `:%s/<\([:alpha:]\)/<\n<\1` |

regex and character classes and syntax classes: [Emacs Wiki](https://www.emacswiki.org/emacs/RegularExpression)


# interface

|||
|-|-|
| `SPC T M` | maximize                                       |
| `f11`     | `spacemacs/toggle-frame-fullscreen-non-native` |


## Default


### popwin-el

<a href="https://github.com/m2ym/popwin-el" alt="popwin GitHub" target="_blank">GitHub</a>

Customization examples from a <a href="https://github.com/syl20bnr/spacemacs/issues/6649" alt="popwin customizations" target="_blank">GitHub issue</a>:

    (push '("*Help*" :dedicated t :position right :stick t :noselect t :width 0.3)
          popwin:special-display-config)

> Because push adds the entry to the beginning, it overrides the existing "**Help**" entry that appears later in the alist. A cleaner approach is to modify the entry in-place. If you want to change the height of help windows:

    (plist-put (cdr (assoc "*Help*" popwin:special-display-config))
               :height 0.25)

> If you want to change an entire entry:

    (setcdr (assoc "*Help*" popwin:special-display-config)
            '(:dedicated t :position right :stick t :noselect t :width 0.3))


## Alternatives

-   [Purpose](https://github.com/bmag/emacs-purpose)
-   [Shackle](https://github.com/wasamasa/shackle)


# buffer narrowing

|||
|-|-|
| `C-x n`   | prefix            |
| `C-x n d` | narrow to block   |
| `C-x n e` | narrow to element |
| `C-x n r` | narrow to region  |
| `C-x n s` | narrow to subtree |
| `C-x n w` | widen             |
| `SPC n w` | widen             |


# layouts

"Perspectives" is managing layouts.

|||
|-|-|
| `SPC l`     | `spacemacs/layouts-transient-state/body ` |      |
| `SPC C-s a` | `persp-load-state-from-file`              | load |


## formatting/indenting/auto-format/autoformat

|||
|-|-|
| `C-M-\`   | indent-region                          |
| `C-x TAB` | indent-rigidly                         |
| `TAB`     | indent-for-tab-command                 |
| `M-)`     | move-past-close-and-reindent           |
| `>>`      | shifts right `evil-shift-width` amount |

    (setq standard-indent 2)
    (setq tab-width 2)
    (my-setup-indent 2)

|||
|-|-|
| `SPC , t 2` | set                                                     |
| `SPC = j`   | format                                                  |
| `SPC t h i` | `spacemacs/toggle-highlight-indentation`                |
| `SPC t h c` | `spacemacs/toggle-highlight-indentation-current-column` |

|||
|-|-|
| `C-x h`                     | select all                                  |
| `M-S-;`                     | eval-experssion                             |
| `M-x list-packages`         | see all packages                            |
| `q`                         | exit debugger                               |
| `g c c`                     | toggle comment                              |
| `SPC t n`                   | line numbers                                |
| `SPC t r`                   | relative line numbers                       |
| `SPC tab`                   | alternate buffer                            |
| `SPC f y`                   | kill/get path & filename                    |
| `SPC f j` + `SPC f y` + `q` | kill/get path only (from dired)             |
| `SPC r y`                   | see kill ring                               |
| `SPC r r`                   | see registers, different format than `:reg` |
| `SPC x w d`                 | `osx-dictionary-search-pointer`             |


## bookmarks

|||
|-|-|
| `C-x r M`, `SPC r M` [custom] | bookmark-set-no-overwrite | set bookmark   |
| `C-x r l`, `SPC r L` [custom] | `bookmark-bmenu-list`     | bookmark list  |
| `SPC f b`, `SPC r b` [custom] | `helm-filtered-bookmarks` | helm bookmarks |

In **Bookmark List**:

|||
|-|-|
| `?`             | help                                              |
| `d`, `x`        | like dired, mark and delete                       |
| `RET`, `1`, `2` | different ways to open                            |
| `C-o`           | switch other window to this bookmark              |
| `r`             | rename                                            |
| `R`             | relocate                                          |
| `t`             | toggle info                                       |
| `s`             | save default bookmark file, prefix to non-default |
| `l`             | load bookmark file                                |


## registers

Registers can hold text, rectangles, positions, window configurations, and buffer-local undo points.

|||
|-|-|
| `SPC r r`                     | `helm-register`                         | register list |
| `C-x r w`, `SPC r w` [custom] | `window-configuration-to-register`      | store         |
| `C-x r j`, `SPC r j` [custom] | `jump-to-register`                      | restore       |
| `C-x r u`                     | `undo-tree-save-state-to-register`      |               |
| `C-x r U`                     | `undo-tree-restore-state-from-register` |               |


## marks

|||
|-|-|
| `SPC t \`` | `spacemacs/toggle-evil-visual-mark-mode` |


## tabs/indents

tab-width: [manual](https://www.gnu.org/software/emacs/manual/html_node/emacs/Text-Display.html#Text-Display)


# modes

<a href="http://ergoemacs.org/emacs/emacs_minor_mode.html" alt="Ergo Emacs minor modes" target="_blank">Ergo Emacs</a>

manual 23.3 <a href="https://www.gnu.org/software/emacs/manual/html_node/emacs/Choosing-Modes.html" target="_blank" alt="Choosing File Modes">Choosing File Modes</a>

|||
|-|-|
| `SPC h d m`        | `spacemacs-describe-mode`            | describe mode |
| `C-h v major-mode` | see current major mode               |               |
| `M-: major-mode`   | see current major mode               |               |
| `M-x normal-mode`  | revert to the buffer's original mode |               |


## JSON

|||
|-|-|
| `C-c C-f` | beautify/auto-format TODO bind/normalize this |


# Windows

|||
|-|-|
| `SPC w d`       | delete                    |
| `SPC w h/j/k/l` | move                      |
| `SPC w m`       | toggle maximize           |
| `SPC v/V/s/S`   | split or split with focus |


# shells


## term

|||
|-|-|
| `C-c C-j` | switch to line mode |
| `C-c C-k` | switch to char mode |


## eshell

|||
|-|-|
| `C-p`, `C-n`         | previous/next input [custom] |
| `M-p`, `M-n`         | previous/next match          |
| `C-c C-p`, `C-c C-n` | previous/next prompt         |


## man/woman

|||
|-|-|
| `(customize-group 'man)` |


# neotree

|||
|-|-|
| `SPC p t`       | start at project root |        |
| `SPC f t`, `f3` | toggle                |        |
| `J`, `K`        | navigate down/up      |        |
| `H`, `L`        | navigate siblings     |        |
| `R`             | make root             |        |
| `               | `                     | vsplit |
| `-`             | split                 |        |
| `s`             | toggle hidden         |        |


# dired

[Quick ref PDF](<https://www.gnu.org/software/emacs/refcards/pdf/dired-ref.pdf>)

|||
|-|-|
| `K`, `gr`   | hide/kill and show/revert       |                              |
| `w`         | `dired-copy-filename-as-kill`   | copy filename                |
| `SPC u 0 w` | copy filename with full path    |                              |
| `o`         | open in other window            |                              |
| `C-o`       | open in new window              |                              |
| `+`         | `dired-create-directory`        | create directory             |
| `i`         | `dired-maybe-insert-subdir`     | insert sub-directory         |
| `m` & `u`   | mark & unmark                   |                              |
| `* !`       | `dired-unmark-all-files`        | unmark all                   |
| `t`         | toggle all                      |                              |
| `* s`       | mark all                        |                              |
| `* /`       | mark directories                |                              |
| `* .`       | mark extensions                 |                              |
| `* @`       | mark symlinks                   |                              |
| `* / t`     | mark all files                  |                              |
| `% g`       | mark files that contain REGEXP  |                              |
| `d`         | mark for deletion               |                              |
| `x`         | `dired-do-flagged-delete`       | delete deletion-marked files |
| `!`         | run shell command               |                              |
| `SPC f f`   | new file (at current directory) |                              |
| `C`         | copy                            |                              |
| `R`         | rename/move                     |                              |
| `D`         | delete                          |                              |
| `S`         | symlink                         |                              |
| `g`         | refresh ("read aGain")          |                              |
| `l`         | relist file at point            |                              |
| `s`         | sort toggle                     |                              |
| `(`         | toggle details                  |                              |
| `A`         | search marked                   |                              |
| `C-x C-q`   | switch to wdired                |                              |
| `C-c C-c`   | save wdired changes             |                              |
| `(`         | toggle details                  |                              |
| `J`         | find files from here            |                              |
| `C-x M-o`   | hide/toggle uninteresting files |                              |

Use default `^` to go up, but use custom `U` to go up from the current physical directory. Use `U`, `v` to change from being inside a symlinked-dir path to the physical path. (Missing attribution.)

      ;; Same as `dired-up-directory', except for wrapping with `file-truename'.
      ;; ref. https://emacs.stackexchange.com/questions/29908/dired-up-to-parent-directory-on-symlink/29910
      (defun my-dired-up-directory (&optional other-window)
        "Run Dired on parent directory of current directory.
    Follows symlinks for current directory.
    Find the parent directory either in this buffer or another buffer.
    Creates a buffer if necessary.
    If OTHER-WINDOW (the optional prefix arg), display the parent
    directory in another window."
        (interactive "P")
        (let* ((dir  (file-truename (dired-current-directory)))
               (up   (file-name-directory (directory-file-name dir))))
          (or (dired-goto-file (directory-file-name dir))
              ;; Only try dired-goto-subdir if buffer has more than one dir.
              (and (cdr dired-subdir-alist)  (dired-goto-subdir up))
              (progn (if other-window (dired-other-window up) (dired up))
                     (dired-goto-file dir)))))
    
    (define-key dired-mode-map (kbd "U") 'my-dired-up-directory)


# keybindings

[Spacemacs Guide](<https://github.com/syl20bnr/spacemacs/wiki/Keymaps-guide>)

|||
|-|-|
| `evil-insert-state-map` |

    ;; these are the same... they are preceded with SPC
    (evil-leader/set-key ",h" 'eyebrowse-prev-winow-config')
    (spacemacs/set-leader-keys "'" 'projectile-run-term)


# color

|||
|-|-|
| `custom-enabled-themes` | [variable]      |                   |
| `(get-faces (point))`   | all faces       |                   |
| `,fh`                   | `describe-face` | [custom shortcut] |


# markdown

|||
|-|-|
| `orgtbl-mode`        | "hijacks" tab. |
| `SPC m N`, `SPC m P` | next/prev link |


# org-mode


## syntax

[Markup for rich export (manual)](http://orgmode.org/org.html#Markup)

    [[https://example.com][link example]]
    
    *bold*, /italic/, _underline_, =verbatim=, `code`, +strike-through+


## keys/basics

|||
|-|-|
| `C-c C-l`                    | `org-insert-link`                                             | insert link                                                            |
| `C-c .`                      | `org-time-stamp`                                              | insert stamp                                                           |
| `< s <tab>`                  | [snippet] expands `#+BEGIN_SRC` ... `#+END_SRC` ('s' for src) |                                                                        |
| `C-c C-o`                    | `org-open-at-point`                                           | open at point                                                          |
| `SPC x o`                    | `link-hint-open-link`                                         | open link                                                              |
| `org-version`                | version                                                       |                                                                        |
| `<S-tab>`                    | cycle all                                                     |                                                                        |
| `C-c C-p` & `C-c C-n`        | prev/next headline                                            |                                                                        |
| `C-c C-f` & `C-c C-b`        | prev/next same-level headline                                 |                                                                        |
| `C-c C-u`                    | up level                                                      |                                                                        |
| `M-h`, `M-l`                 | `org-metaright`, like `<M-right>`                             |                                                                        |
| `M-<ret>`                    | new headline or list elements                                 |                                                                        |
| `C-<ret>`                    | new same-level headline below current headline group          |                                                                        |
| `M-<up>` & `M-<down>`        | move subtree or list element                                  |                                                                        |
| `M-<left>` & `M-<right>`     | promote/demote heading or list element                        |                                                                        |
| `M-S-<left>` & `M-S-<right>` | promote/demote heading or list element                        |                                                                        |
| `: [[http://example.com][ex]]`                       | use `:` at ^ to preserve no-formatting                        |                                                                        |
| `C-c -`                      | `org-ctrl-c-minus`                                            | rotate list state (`org-cycle-list-bullet`) or other, context-senstive |


## todos

|||
|-|-|
| `S-M-<ret>`                    | new TODO                |
| `C-c C-t` & `S-<right>/<left>` | rotate/cycle TODO state |


## capture template placeholders

Jonathan Magen's talk on [youtube](https://www.youtube.com/watch?v=KdcXu_RdKI0)

|||
|-|-|
| `%U`       | inactive timestamp                                             |
| `%^{Name}` | prompt/read                                                    |
| `%a`       | annotation `org-store-link` (takes you back to where you were) |
| `%i`       | active region                                                  |
| `%?`       | final cursor position                                          |

org-protocol-capture-html on [github](<https://github.com/alphapapa/org-protocol-capture-html>)

> With this, you can capture HTML content directly into Org, converted into Org syntax with Pandoc.
>
> For example, to capture your comment into Org, I just highlight it in Pentadactyl (Firefox), press "cc", and Emacs pops up a capture buffer with your comment inserted into the capture template. Or if I press "ch", it passes it through Pandoc, converting HTML lists, tables, headings, code blocks, etc. into their Org counterparts.
>
> I also just added support for python-readability, so if I press "cr", the URL of the page is sent to python-readability, which gets the article content (just like the good ol' Readability bookmarklet), then passes it through Pandoc, and then places it into the capture template.


## code blocks/babel

[manual 14 - Working with source code](http://orgmode.org/manual/Working-with-source-code.html#Working-with-source-code)

In order to `ctrl-c-ctrl-c` (execute) a code block, it needs to be in `org-babel-load-languages`:

    (org-babel-do-load-languages
     'org-babel-load-languages
     '((python . t)
       (emacs-lisp . t)
       (js . t)
       (shell . t)))

Change how `ctrl-c-ctrl-c` windows behave:

    (setq org-src-window-setup 'current-window)

[org-babel.readthedocs.io](https://org-babel.readthedocs.io/en/latest/eval/)

[header arguments for code blocks](http://orgmode.org/manual/Code-block-specific-header-arguments.html#Code-block-specific-header-arguments)

|||
|-|-|
| `C-c C-c`   | evaluate                             |
| `C-c '`     | open/close major mode editing buffer |
| `SPC t C-c` | [custom] toggle no-eval on/off       |

    #+BEGIN_SRC js
    let test = [1, 2];
    console.log(Math.max(...test));
    #+END_SRC

Evaluation controls: `org-confirm-babel-evaluate`, `org-babel-no-eval-on-ctrl-c-ctrl-c`.

|||
|-|-|
| `SPC t C-c` | [custom] `my-toggle-org-babel-no-eval-ctrl-c` |

    (defun my-toggle-org-babel-no-eval-ctrl-c()
      (interactive)
      (if (eq org-babel-no-eval-on-ctrl-c-ctrl-c nil)
        (setq org-babel-no-eval-on-ctrl-c-ctrl-c 't)
        (setq org-babel-no-eval-on-ctrl-c-ctrl-c nil)))
    
    (spacemacs/set-leader-keys "t C-c" 'my-toggle-org-babel-no-eval-ctrl-c)

`setenv "NODE_PATH"` specifically to `/org/node_modules`: [link](<http://rwx.io/blog/2016/03/09/org-with-babel-node-updated/>). Install babel presets to `/org`, symlink `/org/node_modules/babel-cli/bin/babel-node.js` as `org-babel-node` to path.

    let obj = {
      fruit: "apple",
      veggie: "kale",
      meat: "tofu"
    }
    
    let { fruit, ...restItem } = obj;
    
    console.log(fruit);
    console.log(restItem);


## export


### basics

|||
|-|-|
| `C-c C-e #`          | insert default export options from template |
| `#+OPTIONS: toc:nil` | don't export table of contents              |

To prevent exporting a node use an `#+EXCLUDE_TAGS` option of `no_export`, and add `:no_export:` after the heading/node.


### links

[WORG publishing org-mode -> HTML](http://orgmode.org/worg/org-tutorials/org-publish-html-tutorial.html)

[WORG org -> jekyll](http://orgmode.org/worg/org-tutorials/org-jekyll.html)

[happyblogger](https://github.com/bmaland/happyblogger)

[org2jekyll](https://github.com/ardumont/org2jekyll)

[org-jekyll](https://github.com/juanre/org-jekyll)

[cheatsheet](https://emacsclub.github.io/html/org_tutorial.html)

[CSS for Org-exported HTML example/walkthrough](http://gongzhitaao.org/orgcss/)


### "publishing projects" examples

    (require 'ox-publish)
    (setq org-publish-project-alist
          '(
    
            ("org-notes"
             :base-directory "`/scratch/org-test/org/"
             :base-extension "org"
             :publishing-directory "`/scratch/org-test/public_html/"
             :recursive t
             :publishing-function org-html-publish-to-html
             :headline-levels 4             ; Just the default for this project.
             :auto-preamble t
             )
    
    
            ("org-static"
             :base-directory "`/scratch/org-test/org/"
             :base-extension "css\\|js\\|png\\|jpg\\|gif\\|pdf\\|mp3\\|ogg\\|swf"
             :publishing-directory "`/scratch/org-test/public_html/"
             :recursive t
             :publishing-function org-publish-attachment
             )
    
            ("org" :components ("org-notes" "org-static"))
    
            ))


## links

[examples and cookbook](http://ehneilsen.net/notebook/orgExamples/org-examples.html)

[cheatsheet](https://emacsclub.github.io/html/org_tutorial.html#sec-8-1)


## misc

Control visibility on startup:

    #+STARTUP: showeverything
    
    ;; or
    
    (setq org-startup-folded nil)


# helm and helm-projectile


## helm projectile project

|||
|-|-|
| `SPC p I` | `projectile-invalidate-cache` | empty `projectile-projects-cache` |
| `C-d`     | jump to dired                 |                                   |


## helm ag

|||
|-|-|
| `C-x C-s`        | Save ag results to buffer (Ask save buffer name if prefix key is specified) |
| `C-c C-f`        | Enable helm-follow-mode                                                     |
| `C-c >`, `right` | Move to next file                                                           |
| `C-c <`, `left`  | Move to previous file                                                       |
| `C-c C-e`        | Switch to edit mode                                                         |


## helm misc

|||
|-|-|
| `SPC s w g` | google suggest                       |
| `SPC s w w` | wikipedia suggest                    |
| `f2`        | [in file & projectile] jump to dired |


## error buffer

|||
|-|-|
| `SPC e n`, `SPC e p` | next/previous         |
| `SPC e`              | error transient state |

    (setq powerline-default-separator 'utf-8)
    (setq powerline-default-separator 'zigzag)

|||
|-|-|
| `*dired`  | filter major-mode dired         |
| `*!dired` | filter exclude major-mode dired |


# company

|||
|-|-|
| `M-h`          | [company is active] show help popup/tooltip |
| `pos-tip-hide` | hide the popup/tooltip                      |


# yasnippet

Spacelayers' `auto-completion` mode add `indent-for-tab-command` to TAB (`(kbd "C-i")`). Yasnippet expand is `M-/`, `C-p`: `hippie-expand`.

|||
|-|-|
| `SPC i s v` | `helm-yas-visit-snippet-file` |                     |
| `SPC i s n` | `yas-new-snippet`             |                     |
| `SPC i s h` | `spacemacs/helm-yas`          | major mode snippets |


# magit / git

[manual](<https://magit.vc/manual/magit.html>)


## general

|||
|-|-|
| `]h`, `[h`  | next/prev hunk            |                                                |
| `SPC g f f` | `magit-find-file`         | open revision                                  |
| `SPC g f h` | `magit-log-buffer-file`   | history/log for current buffer                 |
| `SPC g d w` | `magit-diff-working-tree` | all changes - quickly check if branch is clean |


## from status

|||
|-|-|
| `C-u s`                    | [point at untracked file] track without staging ("git add --intent-to-add") |                                                    |
| `M-1`, `M-2`, `M-3`, `M-4` | outline expansion                                                           |                                                    |
| `^`                        | up                                                                          |                                                    |
| `M-w`                      | copy (kill) hash/revision                                                   |                                                    |
| `d`                        | diff options (e.g. whitespace)                                              |                                                    |
| `d s`                      | `magit-diff-staged`                                                         | see everything that would commit                   |
| `E i`                      | `magit-ediff-show-staged`                                                   | ediff a file that has staged changes (`SPC g e s`) |
| `=`                        | split file's hunks into more/smaller hunks                                  |                                                    |
| `+`                        | split file's hunks into fewer/larger hunks                                  |                                                    |
| `0`                        | reset file's hunk qty/size                                                  |                                                    |


## from log

|||
|-|-|
| `O` | [in log] reset popup |


## from commit

|||
|-|-|
| `M-p` | [in commit window] pull up previously used commit messages |


## from popup

|||
|-|-|
| `?`   | describe key    |
| `C-t` | show popup menu |


## misc

[reddit workflows](https://www.reddit.com/r/emacs/comments/2n9tj8/anyone_care_to_share_their_magit_workflow/)

[infix arguements and suffix commands](https://github.com/magit/magit/wiki/Additional-proposed-infix-arguments-and-suffix-commands)

[macOS - use emacs-plus to reduce sluggishness](https://magit.vc/manual/magit/MacOS-Performance.html)

    (magit-define-popup-switch 'magit-log-popup ?m "Omit merge commits" "--no-merges")

|||
|-|-|
| `C-x C-o` | `delete-blank-lines` |


# JS

[rjxs-mode](https://github.com/felipeochoa/rjsx-mode)


## js2-mode

|||
|-|-|
| `SPC m w` | `js2-mode-toggle-warnings-and-errors` | toggle errors (e.g. underline missing semicolons |

see [emacs stack exchange](https://emacs.stackexchange.com/questions/26949/can-i-turn-off-or-switch-the-syntax-checker-for-js2-mode)


## JSX-IDE mode

|||
|-|-|
| `C-c C-o`                | toggle element                   |                 |
| `C-c C-f`                | toggle all funtions              |                 |
| `C-c @ C-c`              | `hs-toggle-hiding`               | toggle block    |
| `C-c @ C-h`, `C-c @ C-s` | `hs-hide-block`, `hs-show-block` | hide/show block |


## React

prevent/don't auto-add quotes/quotation marks after typing \`=\` in JSX attributes

|||
|-|-|
| `(setq-local web-mode-enable-auto-quoting nil)` |

[Spacemacs Advanced Kit](<http://oss.io/p/trishume/spacemacs>)

[Org Cheat Sheet](<https://emacsclub.github.io/html/org_tutorial.html#sec-8-1>)


# other configs

[r-darwish](https://github.com/r-darwish/dcp/blob/000856dc0622e70b576cceb87322c45d37b7d73f/.spacemacs)


# misc

|||
|-|-|
| `SPC t C-d`, `SPC T f`        | toggle fringe                                                                |
| `SPC , i`                     | [custom] helm imenu                                                          |
| `C-s )`                       | (in insert mode) insert literal parenthesis (don't allow smart entry)        |
| `SPC u SPC b d`               | close window along with buffer delete                                        |
| `SPC u SPC w d`               | delete buffer along with close window                                        |
| `SPC b e`                     | erase buffer contents                                                        |
| `SPC b P`                     | paste clipbaord contents over all buffer content                             |
| `SPC b Y`                     | copy entire/full buffer to clipboard                                         |
| `SPC o` and `SPC m o`         | reserved for the user                                                        |
| `SPC j u`                     | jump to URL                                                                  |
| `-*-`                         | use to surround a (commented) first line in a file to specify file variables |
| `; -*- mode: Emacs-Lisp; -*-` | specify major mode in first line of a file                                   |
| `SPC u SPC !`                 | shell command into current buffer                                            |


## Local variables

    # local variables:
    # org-attach-directory: "./data"
    # org-id-method: uuid
    # end:


## lisp state

|||
|-|-|
| `SPC k .` | enter lisp state |
| `j` `k`   | navigate         |
| `C-[`     | exit             |


## toggles / display

|||
|-|-|
| `SPC t n` | toggle line numbers          |
| `SPC t r` | toggle relative line numbers |
| `SPC t l` | toggle line wrap             |
| `SPC t W` | [custom] toggle word wrap    |

|||
|-|-|
| `audo-mode-alist` | list of regex file extensions to determine the major mode |


## TRAMP

Fix remote zsh prompt to permit TRAMP (from [github](<https://github.com/syl20bnr/spacemacs/issues/1945>)):

`[[ $TERM == "dumb" ]] && unsetopt zle && PS1='$ ' && return`

