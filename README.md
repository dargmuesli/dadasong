# dadasong
Generator for dadaistic song texts.

The program creates a Markdown file containing a *Dadasong*, which is a song text consisting of two verses, two occurrences of a refrain and a bridge.
What makes this concept special is that the text body is generated randomly, but similar to German words.
Each word is created letter by letter with each next letter being the chosen by the probability of said letter to follow the previous one as seen in regular German words.
An example output can be found under [target/dadasong.md](target/dadasong.md).

This proof of concept came into being as the first part of a project for my music lessons just before my high school graduation at [Friedrichsgymnasium Kassel](http://www.fg-kassel.de/).
At the time, we studied [Dada](https://en.wikipedia.org/wiki/Dada) sound media and literature.
I held a short presentation about this program in front of classmates and parents at the end of this project.
It was a quite unusual idea for a school project and many listeners were interested in the idea of connecting the creation of music with software engineering. 

Of course there is room for improvements.
For example, the output contains no very short words, but typical sentences in German contain many of those.
The underlying data does not take into consideration the commonness of word *usage*.

See [dargmuesli/dadamus](https://github.com/dargmuesli/dadamus/) for this school project's second part.