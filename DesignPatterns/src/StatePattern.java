//class TVRemoteBasic {
//
//    private String state="";
//
//    public void setState(String state){
//        this.state=state;
//    }
//
//    public void doAction(){
//        if(state.equalsIgnoreCase("ON")){
//            System.out.println("TV is turned ON");
//        }else if(state.equalsIgnoreCase("OFF")){
//            System.out.println("TV is turned OFF");
//        }
//    }
//
//    public static void main(String args[]){
//        TVRemoteBasic remote = new TVRemoteBasic();
//
//        remote.setState("ON");
//        remote.doAction();
//
//        remote.setState("OFF");
//        remote.doAction();
//    }
//
//}

interface State {

    public void doAction();
}

class TVStartState implements State {

    @Override
    public void doAction() {
        System.out.println("TV is turned ON");
    }

}


class TVStopState implements State {

    @Override
    public void doAction() {
        System.out.println("TV is turned OFF");
    }

}

class TVContext implements State {

    private State tvState;

    public void setState(State state) {
        this.tvState=state;
    }

    public State getState() {
        return this.tvState;
    }

    @Override
    public void doAction() {
        this.tvState.doAction();
    }

}

class StatePattern {

    public static void main(String[] args) {
        TVContext context = new TVContext();
        State tvStartState = new TVStartState();
        State tvStopState = new TVStopState();

        context.setState(tvStartState);
        context.doAction();


        context.setState(tvStopState);
        context.doAction();

    }

}