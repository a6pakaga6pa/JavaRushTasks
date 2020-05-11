package com.javarush.task.task25.task2515;
/*
* И еще немного:

Напиши метод createUfo():
Если список НЛО пуст - создай один корабль в центре сверху.

Напиши метод checkBombs():
Надо проверить - не пересеклись между собой какая-нибудь бомба и корабль.
Если пересеклись - корабль и бомба умирают - die().
Если бомба упала за границу экрана y > height бомба тоже умирает.

Напиши метод checkRockets():
Надо проверить - не пересеклись между собой какая-нибудь ракета и НЛО.
Если пересеклись - ракета и нло умирают - die().
Если ракета улетела за границу экрана y < 0, ракета тоже умирает.

Напиши метод removeDead():
В этом методе удали из списков ufos, rockets, bombs все мертвые объекты (isAlive() == false).*/

/**
 * Класс для НЛО
 */
public class Ufo extends BaseObject {
    //картинка для отрисовки
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0},
    };

    public Ufo(double x, double y) {
        super(x, y, 3);
    }

    /**
     * Метод рисует свой объект на "канвасе".
     */
    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y - radius + 1, matrix, 'U');
    }

    /**
     * Двигаем себя на один ход в случайном направлении.
     */
    @Override
    public void move() {
        double dx = Math.random() * 2 - 1;
        double dy = Math.random() * 2 - 1;

        x += dx;
        y += dy;

        checkBorders(radius, Space.game.getWidth() - radius + 1, radius - 1, Space.game.getHeight() / 2 - 1);

        int random10 = (int) (Math.random() * 10);
        if (random10 == 0)
            fire();
    }

    /**
     * Стреляем.
     * Сбрасываем(создаем) одну бомбу прямо под собой.
     */
    public void fire() {
        Space.game.getBombs().add(new Bomb(x, y + 3));
    }


}
