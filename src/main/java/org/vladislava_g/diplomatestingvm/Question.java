package org.vladislava_g.diplomatestingvm;

import java.util.List;

public record Question(String questionText, List<String> answers) {
    @Override
    public String toString() {
        return "Question{" +
                "questionText='" + questionText + '\'' +
                ", answers=" + answers +
                '}';
    }
}
