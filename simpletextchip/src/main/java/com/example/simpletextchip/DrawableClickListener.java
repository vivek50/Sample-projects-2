package com.example.simpletextchip;

/**
 * Created by vivek50 on 26/12/16.
 */
interface DrawableClickListener {

    enum DrawablePosition { TOP, BOTTOM, LEFT, RIGHT }
    void onClick(DrawablePosition target);
}
