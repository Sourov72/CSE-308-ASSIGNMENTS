package Organizations;

import Mediator.JCC;


public class JPDC implements organization{
    private JCC mediator;
    private int count = 0;
    public JPDC(JCC mediator){
        this.mediator = mediator;

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
