package com.javarush.task.task13.task1328;

public class Robot extends AbstractRobot implements Attackable, Defensable {

    private String name;
    private int hitCount;

    public BodyPart attack() {

        BodyPart attackedBodyPart = null;
        hitCount = 1 + (int)(Math.random()*4);

        if (hitCount == 1) {
            attackedBodyPart = BodyPart.ARM;

        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;

        } else if (hitCount == 3) {

            attackedBodyPart = BodyPart.LEG;
        } else if (hitCount >= 4) {
            attackedBodyPart = BodyPart.CHEST;

        }
        return attackedBodyPart;
    }

    public BodyPart defense() {
        BodyPart defendedBodyPart = null;
        hitCount = 1 + (int)(Math.random()*4);

        if (hitCount == 1) {
            defendedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {
            defendedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
         //   hitCount = 0;
            defendedBodyPart = BodyPart.ARM;
        } else if (hitCount >= 4) {
            defendedBodyPart = BodyPart.CHEST;
        }
        return defendedBodyPart;
    }

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


  /*  @Override
    public BodyPart attack() {
        return null;
    }

    @Override
    public BodyPart defense() {
        return null;
    }*/
}
