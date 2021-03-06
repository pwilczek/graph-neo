package name.wilu.neo.model;

import org.apache.commons.lang3.StringUtils;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.isBlank;

@NodeEntity
public class Question {

    private static final String HAS_ANSWER = "HAS_ANSWER";
    //
    private @GraphId Long id;
    private String content;
    //
    @Relationship(type = HAS_ANSWER, direction = Relationship.OUTGOING)
    private Set<Answer> answers = new HashSet<>();

    private Question() { }

    public static Question about(String content) {
        if (isBlank(content)) throw new IllegalArgumentException("Question content cannot be missing!");
        Question q = new Question();
        q.content = content;
        return q;
    }

    public String topic() {
        return content;
    }

    public Answer newAnswer(String content) {
        if (isBlank(content)) throw new IllegalArgumentException("Answer cannot be null or blank!");
        Answer answer = new Answer(this);
        answer.content = content;
        answers.add(answer);
        return answer;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Question)) return false;
        return StringUtils.equals(((Question) other).content, content);
    }

    @Override public int hashCode() {
        return content.hashCode();
    }

    int countAnswers() {
        return answers.size();
    }
}
