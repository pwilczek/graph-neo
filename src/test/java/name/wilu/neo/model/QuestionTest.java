package name.wilu.neo.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class QuestionTest {

    @Test public void shouldProvideNotNullQuestionWithCorrectTopic(){
        String topic = "What your size?";
        Question question = Question.about(topic);
        assertThat(question, not(nullValue()));
        assertThat(question.topic(), is(topic));
    }

}