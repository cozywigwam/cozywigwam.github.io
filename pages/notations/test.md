

# test


## regular org table

<table border="2" cellspacing="0" cellpadding="6" rules="groups" frame="hsides">


<colgroup>
<col  class="org-left" />

<col  class="org-left" />

<col  class="org-left" />
</colgroup>
<tbody>
<tr>
<td class="org-left">`]h`, `[h`</td>
<td class="org-left">next/prev hunk</td>
<td class="org-left">&#xa0;</td>
</tr>


<tr>
<td class="org-left">`SPC g f f`</td>
<td class="org-left">`magit-find-file`</td>
<td class="org-left">open revision</td>
</tr>


<tr>
<td class="org-left">SPC g f h</td>
<td class="org-left">magit-log-buffer-file</td>
<td class="org-left">history/log for current buffer</td>
</tr>


<tr>
<td class="org-left">`SPC g d w`</td>
<td class="org-left">`magit-diff-working-tree`</td>
<td class="org-left">all changes - quickly check if branch is clean</td>
</tr>
</tbody>
</table>


## markdown inside org


### w/ blank table head

    |||
    |-|-|
    | `]h`, `[h`  | next/prev hunk            |                                                |
    | `SPC g f f` | `magit-find-file`         | open revision                                  |
    | SPC g f h | magit-log-buffer-file   | history/log for current buffer                 |
    | `SPC g d w` | `magit-diff-working-tree` | all changes - quickly check if branch is clean |


### w/out blank table head

    | `]h`, `[h`  | next/prev hunk            |                                                |
    | `SPC g f f` | `magit-find-file`         | open revision                                  |
    | SPC g f h | magit-log-buffer-file   | history/log for current buffer                 |
    | `SPC g d w` | `magit-diff-working-tree` | all changes - quickly check if branch is clean |

