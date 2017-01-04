package name.wilu.neo.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class QuestionTest {

    @Test public void shouldProvideNotNullQuestionWithCorrectTopic() {
        String topic = "What your size?";
        Question question = Question.about(topic);
        assertThat(question, not(nullValue()));
        assertThat(question.topic(), is(topic));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailOnNullQuestion() throws Exception {
        Question.about(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailOnEmptyQuestion() throws Exception {
        Question.about("  ");
    }
}