package de.jonas_thelemann.dadasong;

import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;

import java.util.stream.IntStream;

/**
 * Creates dadaistic, linguistic structures like words and sentences.
 */
public class DadaLinguistic {

    /**
     * Constructs a whole Dada song text, following the pattern:
     * <p>
     * [verse 1]
     * [refrain]
     * [verse 2]
     * [bridge]
     * [refrain]
     *
     * @param sentenceCount     The count of sentences.
     * @param sentenceWordCount The count of words in each sentence.
     * @return A dadaistic song text.
     */
    static String getDadaSong(int sentenceCount, int sentenceWordCount) {

        // Create (only) one refrain.
        String refrain = "\n\n## Refrain\n\n" + getDadaParagraph(sentenceCount, sentenceWordCount);

        return "# Dadasong" +
                "\n\n## Verse\n\n" +
                getDadaParagraph(sentenceCount, sentenceWordCount) +
                refrain +
                "\n\n## Verse\n\n" +
                getDadaParagraph(sentenceCount, sentenceWordCount) +
                "\n\n## Bridge\n\n" +
                getDadaParagraph(sentenceCount, sentenceWordCount) +
                refrain;
    }

    /**
     * Creates a paragraph made of random words.
     *
     * @param sentenceCount     The count of sentences.
     * @param sentenceWordCount The count of words in each sentence.
     * @return A dadaistic paragraph.
     */
    static String getDadaParagraph(int sentenceCount, int sentenceWordCount) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < sentenceCount; i++) {
            result.append(getDadaSentence(sentenceWordCount));

            if (i != sentenceCount - 1) {
                result.append(",<br>");
            } else {
                result.append(".");
            }

            result.append("\n");
        }

        return result.toString();
    }

    /**
     * Create a sentence made of random words.
     *
     * @param wordCount The count of words the returned sentence consists of.
     * @return A dadaistic sentence.
     */
    private static String getDadaSentence(int wordCount) {

        // Start with a random word.
        StringBuilder result = new StringBuilder(getDistributedWord());

        // Capitalize first letter.
        result = new StringBuilder(result.substring(0, 1).toUpperCase() + result.substring(1));

        // Append the other random word.
        for (int i = 1; i < wordCount; i++) {
            result.append(" ").append(getDistributedWord());
        }

        return result.toString();
    }

    /**
     * Source: http://www.ravi.io/language-word-lengths
     *
     * @return A word of random letters and random, but plausible length.
     */
    static String getDistributedWord() {
        EnumeratedIntegerDistribution e = new EnumeratedIntegerDistribution(
                IntStream.range(1, 26).toArray(),
                new double[]{0, 0, 0, 0.001, 0.008, 0.02, 0.036, 0.052, 0.073, 0.098, 0.114, 0.119, 0.111, 0.093, 0.075, 0.058, 0.043, 0.032, 0.022, 0.015, 0.01, 0.007, 0.005, 0.003, 0.002});
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < e.sample(); i++) {
            sb.append(LetterLinguistic.getNextDistributedLetter());
        }

        LetterLinguistic.lastChar = '?';

        return sb.toString();
    }
}
