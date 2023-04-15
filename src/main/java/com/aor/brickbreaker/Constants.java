package com.aor.brickbreaker;

public class Constants {

        public static final int WIDTH = 60;
        public static final int HEIGHT = 40;
        public static final int BORDER_LEFT = 1;
        public static final int BORDER_RIGHT = WIDTH - BORDER_LEFT;
        public static final int BORDER_TOP = 1;
        public static final int BORDER_BOTTOM = HEIGHT - BORDER_TOP;

        public static final int PLATFORM_X = WIDTH / 2;
        public static final int PLATFORM_Y = HEIGHT - 5;
        public static final int MAX_PLATFORM_SIZE = WIDTH / 2;
        public static final int PLATFORM_SIZE_BOOSTER = 5;
        public static final int PLATFORM_WIDTH = 8;
        public static final int PLATFORM_HEIGHT = 1;

        public static final int MAX_LIVES = 3;
        public static final int MIN_HITS_TO_DESTROY = 3;
        public static final int N_POINTS_TO_DROP_BOOSTER = 5;
        public static final int BRICK_WIDTH = 8;
        public static final int BRICK_HEIGHT = 1;

        public static final int BALL_X = PLATFORM_X;
        public static final int BALL_Y = PLATFORM_Y - PLATFORM_HEIGHT;

        public static final int MIN_POINTS = 3;
        public static final int MAX_POINTS = 9;

        public static final String RED = "#FF6347";
        public static final String WHITE = "#F8F8FF";
        public static final String GREEN = "#7CFC00";
        public static final String YELLOW = "#f9ff3a";
        public static final String BLUE = "#191970";
}