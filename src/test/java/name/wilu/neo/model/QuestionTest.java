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

    @Test public void shouldProduceAnswers() throws Exception {
        Question q = Question.about("some stuff");
        Answer answer = q.newAnswer("foo");
        assertThat(answer.is(), is("foo"));
        assertThat(answer.to(), is(q));
        assertThat(q.countAnswers(), is(1));
        q.newAnswer("bar");
        assertThat(q.countAnswers(), is(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenAnswerIsNull() throws Exception {
        Question.about("other stuff").newAnswer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenAnswerIsBlank() throws Exception {
        Question.about("other stuff").newAnswer("  ");
    }
}