package cn.feng.thinkInJava.a6_1_多态;

public class DuoTai {

    public static void main(String args[]) {
        Stage stage = new Stage();
        stage.perfom();
        stage.change();
        stage.perfom();
    }
}

class Stage {

    private Actor actor = new HappyActor();
    public void change() {
        actor = new SadActor();
    }
    public void perfom() {
        actor.actor();
    }
}

class Actor {

    public Actor() {
        System.out.println("Actor");

    }
    public void actor() {
        System.out.println("actor");
    }

}

class HappyActor extends Actor {

    public HappyActor() {
        super();
        System.out.println("HapperActor");

    }

    @Override
    public void actor() {
        System.out.println("happy actor");
    }


}

class SadActor extends Actor {

    public SadActor() {
        System.out.println("SadActor");

    }

    @Override
    public void actor() {
        System.out.println("sad actor");
    }
}
