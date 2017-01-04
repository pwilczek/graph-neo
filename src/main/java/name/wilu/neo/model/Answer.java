package name.wilu.neo.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Answer {

    private @GraphId Long id;
    String content;
    //
    private Question question;

    public Answer(Question question) {
        this.question = question;
    }

    public String is() {
        return content;
    }

    public Question to() {
        return question;
    }

    @Override public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Answer)) return false;
        Answer o = (Answer) other;
        return StringUtils.equals(content, o.content) && question.equals(o.question);
    }

    @Override public int hashCode() {
        return new HashCodeBuilder().append(content).append(question).toHashCode();
    }
}
