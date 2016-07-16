---
layout: post
title: "Markdown Shenanigans"
categories: markdown
---

![image alt text]

[image alt text]: /assets/images/pilot-toss-cat.jpg "title text"

Are we [legitimate]? Let's try a quick test. `$ Oh, shall we?` Yes, we shall!

[legitimate]: http://info.cern.ch/hypertext/WWW/TheProject.html "World Wide Web"

    takePicture() {
        // make it happen
    }
    tossCat() {
        takePicture();
    }
    flyPlane() {
        tossCat();
    }
    
The `// make it happen` part always seems easy from the brainstorming couch. (Especially if the brainstormer isn't a doer, as I once overheard.)

## H2 - 80 char test

``` bash
# 80 char fixed-width test
12345678902234567890323456789042345678905234567890623456789072345678908234567890
```

### H3 - code markdown results

This is using the indent format:

    # output: <?> 119082, Hex 0001d12a, Octal 35045
    
In the IDE, this indent style is written like this:

        # output: <?> 119082, Hex 0001d12a, Octal 35045

Resulting HTML:

    <div class="highlighter-rouge"><pre class="highlight"><code># output: &lt;?&gt; 119082, Hex 0001d12a, Octal 35045
    </code></pre>
    </div>

This is using the backtick format:

``` bash
This is using the backtick format that looks like this
```

In the IDE, it looks like:

    ``` bash
    # output: <?> 119082, Hex 0001d12a, Octal 350452
    ```

Its resulting HTML is the same:

    <div class="highlighter-rouge"><pre class="highlight"><code>This is using the backtick format that looks like this
    </code></pre>
    </div>
    

This is using Liquid:

{% highlight bash %}
# output: <?> 119082, Hex 0001d12a, Octal 350452
{% endhighlight %}

In the IDE:

    {% highlight bash %}
    # output: <?> 119082, Hex 0001d12a, Octal 350452
    {% endhighlight %}

Reulting HTML:

    <figure class="highlight"><pre><code class="language-bash" data-lang="bash"><span class="c"># output: &lt;?&gt; 119082, Hex 0001d12a, Octal 350452</span></code></pre></figure>

#### h4 whatever

While we’re at it, we might as well kick the tires on a list.

- Extraordinary
- Plain
- Semantics
- Over-thinking, or is it under-thinking? And supposing there was a final judgement of some sort, who would adjudicate? Regardless, I just wanted enough copy to wrap these here lines
- Ambivalence

Let’s not spoil the list with ungraceul exit spacing. Like $laptop, this makes me think of another term I found from Jekyll: “vertical-rhythm.”

# zomg h1

It's a heading round-up.

## Terrible twos

Dumb paragraphs always gettin' in the way.

### Third Time is a Whatever

#### Fore

##### Hit Me a Five Spot

###### Asterisk Melee

Well that was anticlimactic.
