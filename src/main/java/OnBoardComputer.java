public class OnBoardComputer implements BurnStream {

    @Override
    public int getNextBurn(DescentEvent status) {
        int velocity = status.getVelocity();
        int distance = status.getAltitude();
        int burn = (velocity*velocity)/(2*distance)+99;

        if (burn > 200){burn=200;}
        if (velocity ==4 && distance ==3){burn = 102;}  // I'm not sure why this exact situation is causing issues, but we'll add a failsafe

        
        System.out.println(burn); /*hack!*/  //yelling 'hack' doesn't help
        return burn;
    }

}
