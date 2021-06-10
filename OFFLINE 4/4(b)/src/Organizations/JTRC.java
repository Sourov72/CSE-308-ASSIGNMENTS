package Organizations;

import Mediator.JCC;



public class JTRC implements organization{
    private JCC mediator;
    private int count;
    public JTRC(JCC mediator){
        this.mediator = mediator;
        count++;
    }


    @Override
    public void request(String type) {
        mediator.notifyy(type, this);
    }

    @Override
    public void serve() {
        mediator.serve(this);
    }


}
