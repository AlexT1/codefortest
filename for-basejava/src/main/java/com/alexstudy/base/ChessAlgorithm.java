package com.alexstudy.base;

/**
 * @ClassName ChessAlgorithm
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2019/1/3
 */
public class ChessAlgorithm {
    enum ChessPlayer { WHITE, BLACK }

    final ChessPlayer getFirstPlayer() {
        return ChessPlayer.WHITE;
    }
}
