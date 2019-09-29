package engine.uiBehavior;

import engine.ui.Element;

import java.util.Objects;

public class Action {

    private Element element;
    private int id = -1;
    private static int uuid = 0;

    public int getId() {
        uuid++;
        return uuid;
    }

    public void setId() {
        if (id == -1) {
            id = getId();
        }
    }

    public Action() {
        setId();
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Element getElement() {
        return element;
    }

    public void run() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Action)) return false;
        Action action = (Action) o;
        return id == action.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
