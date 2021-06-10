package Organizations;

import Mediator.JCC;



public class JRTA implements organization{
    private JCC mediator;
    private int count;
    public JRTA(JCC mediator){
        this.mediator = mediator;
        count = 0;
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
