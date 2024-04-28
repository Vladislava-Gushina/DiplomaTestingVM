package org.vladislava_g.diplomatestingvm;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuestionsParser {
    public List<Question> parseQuestions(String filePath) {
        //Создаем document, который будет хранить весь html-код теста
        try {
            File htmlFile = new File(filePath);
            Document document = Jsoup.parse(htmlFile);

            //Список со всеми вопросами
            List<Question> questions = new ArrayList<>();

            //Берем все элементы класса question, ведь именно в них находятся вопросы
            Elements allQuestionsElements = document.getElementsByClass("question");
            allQuestionsElements.forEach(element -> questions.add(new Question(parseQuestionTitle(element), parseAnswers(element))));

            return questions;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private String parseQuestionTitle(Element element){
        //Из элемента с классом question ищем все элементы с тегом b, но берем самый первый, ведь именно он и есть текст вопроса
        return element.getElementsByTag("b").get(0).text();
    }

    private List<String> parseAnswers(Element element){
        List<String> answers = new ArrayList<>();

        //Берем все радио-кнопки и элемент тега b за ним
        Elements preAnswersElement = element.select("input[type=radio] + b");

        //После элемента b получаем следующий Node, он и есть вариант ответа. Добавляем его в список
        preAnswersElement.forEach(preAnswerElement ->
                answers.add(Objects.requireNonNull(preAnswerElement.nextSibling()).toString()));

        return answers;
    }
}
