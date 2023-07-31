public class OnBoardComputer implements BurnStream {

    @Override
    public int getNextBurn(DescentEvent status) {
        int velocity = status.getVelocity();
        int distance = status.getAltitude();
        int burn = (velocity*velocity)/(2*distance)+99;
        
        System.out.println(burn); /*hack!*/  //yelling 'hack' doesn't help
        return burn;
    }

}
